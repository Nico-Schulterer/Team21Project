package at.ac.fhcampuswien.BlackJack;

import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Hand {

    private ObservableList<Node> cards;
    private SimpleIntegerProperty worth = new SimpleIntegerProperty(0);
    private int cardCount;
    private int aces = 0;

    public Hand(ObservableList<Node> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        //if sum > 21 then Ace worth 1 instead of 11
        //else
        cardCount++;
        worth.set(worth.get() + card.worth);
    }

    public void reset() {
        cards.clear();
        worth.set(0);
    }

    public SimpleIntegerProperty worthProperty() {
        return worth;
    }
}