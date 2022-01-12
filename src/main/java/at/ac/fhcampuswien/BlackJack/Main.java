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
import org.openjfx.FXMLController;

import java.net.URL;
import java.util.ResourceBundle;


public class Main extends Application implements Initializable {
    private Dealer deck = new Dealer();
    private Hand player, dealer;


    @FXML
    public HBox playerzone;
    public HBox dealerzone;
    public Button resetButton;
    public Button playButton;
    public Label dealerValue;
    public AnchorPane playingZone;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createGame();
        startGame();
    }

    private void createGame(){
        dealer = new Hand(dealerzone.getChildren());
        player = new Hand(playerzone.getChildren());
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

    public void startGame(){
        deck.refill();

        dealer.reset();
        player.reset();

        dealer.addCard(deck.takeCard());
        player.addCard(deck.takeCard());
        dealer.addCard(deck.takeCard());
        player.addCard(deck.takeCard());
    }

    public static void main(String[] args) {
        launch(args);



    }

}

