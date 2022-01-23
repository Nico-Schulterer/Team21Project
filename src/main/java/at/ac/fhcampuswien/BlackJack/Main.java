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
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Main extends Application implements Initializable {
    private Dealer deck = new Dealer();
    //Creates a new Dealer deck with 52 cards
    private Hand player, dealer;
    //Creates a Hand for the player and dealer
    private boolean isActive = false;
    //A variable to check if the game is currently being played or not
    private int betValueNumber;
    //How much money you can bet
    private int moneyInPlay;
    //How much money is in play to be won or lost


    @FXML
    public HBox playerZone;
    public HBox dealerZone;
    //the zones in which the player and dealer cards will be created
    public Button resetButton;
    //A button that resets the game if you don't like your cards (Not applicable in real life)
    public Button playButton;
    //Button that begins the game
    public Button hitButton;
    public Button standButton;
    public Label dealerValue;
    public AnchorPane playingZone;
    public Label playerValue;
    public Label gameOver;
    public Label winnerLabel;
    public Label betMoney;
    public Button betButton;
    public TextField betValue;
    public Label betThisRound;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createGame();
    }

    private void createGame() {
        //Creates the contents and things needed for the game
        dealer = new Hand(dealerZone.getChildren());
        player = new Hand(playerZone.getChildren());
        //Sets each hand to its assigned zone

        playButton.setOnAction(event -> startGame());
        //When pressed starts the game
        resetButton.setDisable(!isActive);
        resetButton.setOnAction(event -> resetGame());
        hitButton.setDisable(!isActive);
        hitButton.setOnAction(event -> hitUpdate());
        standButton.setDisable(!isActive);
        standButton.setOnAction(event -> standUpdate());
        betButton.setOnAction(event -> betPressed());
        betValueNumber = 500;
        //The money you get at the beginning of a game to bet
        moneyInPlay = 0;
        //The game hasn't started yet so the money in play is none
        betMoney.textProperty().bind(new SimpleStringProperty("Your bet money: $").concat(betValueNumber));

        dealer.worthProperty().addListener(((observable, oldValue, newValue) -> {
            //Listens if the Hand of the player or dealer has a worth/value of more than 21, if it isn't
            // nothing happens if it is the game ends
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
        //creates the scene based on the scene.fxml file
        scene.getStylesheets().add(this.getClass().getResource("/style.css").toExternalForm());

        stage.setTitle("Blackjack - Team21");
        stage.setScene(scene);
        stage.setResizable(false);
        //You can't make the window bigger or smaller
        stage.show();

    }
//startGame method starts the game
    public void startGame() {
        isActive = true;
        //game is set as "active"/"playable"
        gameOver.setText("");
        winnerLabel.setText("");
        playButton.setDisable(isActive);
        //Play button is disable, so we can't click it again
        betButton.setDisable(isActive);
        betValue.setDisable(isActive);
        resetButton.setDisable(!isActive);
        hitButton.setDisable(!isActive);
        standButton.setDisable(!isActive);
        deck.refill();
        //The deck is refilled
        dealerValue.textProperty().bind(new SimpleStringProperty("Dealer Value: ").concat(dealer.worthProperty().asString()));
        playerValue.textProperty().bind(new SimpleStringProperty("Player Value: ").concat(player.worthProperty().asString()));
        //Shows how much worth each hand has

        dealer.reset();
        player.reset();
        //Both hands are reset

        dealer.addCard(deck.takeCard());
        player.addCard(deck.takeCard());
        dealer.addCard(deck.takeCard());
        player.addCard(deck.takeCard());
        //Both the player and dealer receive 2 cards each at the beginning
    }

    public void resetGame() {
        startGame();
        //Resets the game
    }

    public void hitUpdate() {
        //When the player presses the hit button a card gets added to their hand and their worthProperty gets called to update the label
        player.addCard(deck.takeCard());
        dealerValue.textProperty().bind(new SimpleStringProperty("Dealer Value: ").concat(dealer.worthProperty().asString()));
        playerValue.textProperty().bind(new SimpleStringProperty("Player Value: ").concat(player.worthProperty().asString()));
    }

    public void standUpdate() {
        //When the player presses the stand button, the dealer starts becoming cards until it either wins or loses.
        while (dealer.worthProperty().get() <= player.worthProperty().get()) {
            dealer.addCard(deck.takeCard());
            dealerValue.textProperty().bind(new SimpleStringProperty("Dealer Value: ").concat(dealer.worthProperty().asString()));
        }
        endGame();
    }

    public void betPressed(){
        //When the bet button is pressed, this method checks if there is any money typed into the TextField if so it reduces it from the players bet money
        int betInputNumber = Integer.parseInt(betValue.getText());
        betValueNumber -= betInputNumber;
        moneyInPlay += betInputNumber;
        //Adds the money the player bet into the money in play variable
        betMoney.textProperty().bind(new SimpleStringProperty("Your bet money: $").concat(betValueNumber));
        betThisRound.textProperty().bind(new SimpleStringProperty("Money bet this round: $").concat(moneyInPlay));
        betValue.clear();
    }

    public void endGame() {
        //Ends the game
        isActive = false;
        //The game is no longer being played
        int dealerEndValue = dealer.worthProperty().get();
        int playerEndValue = player.worthProperty().get();
        //Fetches the end value of each hand
        String winner = "";

        if (dealerEndValue == 21 || playerEndValue > 21 || (dealerEndValue < 21 && dealerEndValue > playerEndValue)) {
            //if the value of the players hand is lower than the dealers when they press stand or is higher than 21 then the player loses
            winner = "Dealer Won";
        } else if (playerEndValue == 21 || dealerEndValue > 21 || playerEndValue > dealerEndValue) {
            //if the value of the dealer is bigger than 21 or if lower than that of the player's then the player wins
            winner = "Player Won";
            betValueNumber += (moneyInPlay * 2);
            //Player receives winnings
        } else {
            //if both of them have the same worth then this is a tie or "push"
            winner = "Push (Tie)";
            //you get back the money you bet
            betValueNumber += moneyInPlay;
        }
        moneyInPlay = 0;
        //The round is over so the money in play is none
        betThisRound.textProperty().bind(new SimpleStringProperty("Money bet this round: $").concat(moneyInPlay));
        betMoney.textProperty().bind(new SimpleStringProperty("Your bet money: $").concat(betValueNumber));
        gameOver.setText("GAME OVER");
        //Label appears with game over
        winnerLabel.setText(winner);
        playButton.setDisable(isActive);
        betButton.setDisable(isActive);
        betValue.setDisable(isActive);
        resetButton.setDisable(!isActive);
        hitButton.setDisable(!isActive);
        standButton.setDisable(!isActive);
        //Gets ready for the next game

    }

    public static void main(String[] args) {
        launch(args);


    }

}

