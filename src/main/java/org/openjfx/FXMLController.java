package org.openjfx;

import at.ac.fhcampuswien.BlackJack.Card;
import at.ac.fhcampuswien.BlackJack.Card.Suit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    Card card = new Card(Card.Suit.Heart, Card.Number.Eight);
    Card card1 = new Card(Suit.Club, Card.Number.Three);
    Card card2 = new Card(Suit.Diamond, Card.Number.Six);

    @FXML
    public HBox playerzone;
    public HBox dealerzone;
    public Button resetButton;
    public static Label dealerValue;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerzone.getChildren().add(card);
        playerzone.getChildren().add(card2);
        dealerzone.getChildren().add(card1);
        dealerValue.setText("Dealer Value: ");
    }
}