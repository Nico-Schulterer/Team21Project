package at.ac.fhcampuswien.BlackJack;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;


public class Card extends Parent {

    public enum Suit {
        Heart, Diamond, Club, Spade
    }

    public enum Number {
        Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8),
        Nine(9), Ten(10), Jack(10), Queen(10), King(10), Ace(11);
        final int worth;

        Number(int worth) {
            this.worth = worth;
        }
    }

    public final Suit suit;
    public final Number number;
    public final int worth;


    public Card(Suit suit, Number number) {

        this.suit = suit;
        this.number = number;
        this.worth = number.worth;

        Rectangle card = new Rectangle(100, 150);
        card.setFill(Color.WHITE);
        card.setArcHeight(15);
        card.setArcWidth(15);

        Text text = new Text(toString());

        getChildren().add(new StackPane(card, text));

    }

    public String toString() {
        return this.suit.toString() + " " + this.number.toString();
    }
}
