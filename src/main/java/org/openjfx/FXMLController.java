package org.openjfx;

import java.net.URL;
import java.util.ResourceBundle;

import at.ac.fhcampuswien.BlackJack.Card;
import at.ac.fhcampuswien.BlackJack.Card.Suit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

public class FXMLController implements Initializable {
    Card card = new Card(Suit.Heart, Card.Number.Eight);
    Card card1 = new Card(Suit.Heart, Card.Number.Eight);
    Card card2 = new Card(Suit.Heart, Card.Number.Eight);
    @FXML
    public HBox playerzone;
    public HBox dealerzone;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerzone.getChildren().add(card);
        playerzone.getChildren().add(card2);
        dealerzone.getChildren().add(card1);
    }
}