package at.ac.fhcampuswien.BlackJack;

import at.ac.fhcampuswien.BlackJack.Card.Number;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Hand {

    private ObservableList<Node> deck;
    private SimpleIntegerProperty worth = new SimpleIntegerProperty(0);
    private int cardCount;
    private int aces = 0;

    public Hand(ObservableList<Node> deck) {
        this.deck = deck;
    }

    public void addCard(Card card) {

        deck.add(card);

        if(card.number == Number.Ace) {
            aces++;
        }

        if(worth.get() + card.worth > 21 && aces > 0) {

            worth.set(worth.get() + card.worth - 10);
            aces--;
            cardCount++;

        } else {

            cardCount++;
            worth.set(worth.get() + card.worth);

        }
    }

    public void reset() {
        deck.clear();
        worth.set(0);
        aces = 0;
    }

    public SimpleIntegerProperty worthProperty() {
        return worth;
    }

    public int getCardCount(){
        return cardCount;
    }

}