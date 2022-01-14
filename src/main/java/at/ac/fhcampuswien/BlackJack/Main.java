package at.ac.fhcampuswien.BlackJack;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Main extends Application implements Initializable {
    private Dealer deck = new Dealer();
    private Hand player, dealer;
    private boolean isActive = false;


    @FXML
    public HBox playerZone;
    public HBox dealerZone;
    public Button resetButton;
    public Button playButton;
    public Button hitButton;
    public Button standButton;
    public Label dealerValue;
    public AnchorPane playingZone;
    public Label playerValue;
    public Label gameOver;
    public Label winnerLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createGame();
    }

    private void createGame() {
        dealer = new Hand(dealerZone.getChildren());
        player = new Hand(playerZone.getChildren());

        playButton.setOnAction(event -> startGame());
        resetButton.setDisable(!isActive);
        resetButton.setOnAction(event -> resetGame());
        hitButton.setDisable(!isActive);
        hitButton.setOnAction(event -> hitUpdate());
        standButton.setDisable(!isActive);
        standButton.setOnAction(event -> standUpdate());

        dealer.worthProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue.intValue() >= 21) {
                endGame();
            }
        }));
        player.worthProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue.intValue() >= 21) {
                endGame();
            }
        }));

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("/scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("/style.css").toExternalForm());

        stage.setTitle("Blackjack - Team21");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public void startGame() {
        isActive = true;
        gameOver.setText("");
        winnerLabel.setText("");
        playButton.setDisable(isActive);
        resetButton.setDisable(!isActive);
        hitButton.setDisable(!isActive);
        standButton.setDisable(!isActive);
        deck.refill();
        dealerValue.textProperty().bind(new SimpleStringProperty("Dealer Value: ").concat(dealer.worthProperty().asString()));
        playerValue.textProperty().bind(new SimpleStringProperty("Player Value: ").concat(player.worthProperty().asString()));

        dealer.reset();
        player.reset();

        dealer.addCard(deck.takeCard());
        player.addCard(deck.takeCard());
        dealer.addCard(deck.takeCard());
        player.addCard(deck.takeCard());
    }

    public void resetGame() {
        startGame();
    }

    public void hitUpdate() {
        player.addCard(deck.takeCard());
        dealerValue.textProperty().bind(new SimpleStringProperty("Dealer Value: ").concat(dealer.worthProperty().asString()));
        playerValue.textProperty().bind(new SimpleStringProperty("Player Value: ").concat(player.worthProperty().asString()));
    }

    public void standUpdate() {
        while (dealer.worthProperty().get() <= player.worthProperty().get()) {
            dealer.addCard(deck.takeCard());
            dealerValue.textProperty().bind(new SimpleStringProperty("Dealer Value: ").concat(dealer.worthProperty().asString()));
        }
        endGame();
    }

    public void endGame() {
        isActive = false;
        int dealerEndValue = dealer.worthProperty().get();
        int playerEndValue = player.worthProperty().get();
        String winner = "";

        if (dealerEndValue == 21 || playerEndValue > 21 || (dealerEndValue < 21 && dealerEndValue > playerEndValue)) {
            winner = "Dealer Won";
        } else if (playerEndValue == 21 || dealerEndValue > 21 || playerEndValue > dealerEndValue) {
            winner = "Player Won";
        } else {
            winner = "Push (Tie)";
        }
        gameOver.setText("GAME OVER");
        winnerLabel.setText(winner);
        playButton.setDisable(isActive);
        resetButton.setDisable(!isActive);
        hitButton.setDisable(!isActive);
        standButton.setDisable(!isActive);

    }

    public static void main(String[] args) {
        launch(args);


    }

}

