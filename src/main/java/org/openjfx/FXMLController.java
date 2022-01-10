package org.openjfx;

import java.net.URL;
import java.util.ResourceBundle;

import at.ac.fhcampuswien.BlackJack.Cards;
import at.ac.fhcampuswien.BlackJack.Cards.Suit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class FXMLController implements Initializable {
    Cards card = new Cards(Suit.Heart, Cards.Number.Eight);
    Cards card1 = new Cards(Suit.Heart, Cards.Number.Eight);
    Cards card2 = new Cards(Suit.Heart, Cards.Number.Eight);
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