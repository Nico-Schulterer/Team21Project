package at.ac.fhcampuswien.BlackJack;

import at.ac.fhcampuswien.BlackJack.Card.Number;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Hand {

    private ObservableList<Node> deck;
    private SimpleIntegerProperty worth = new SimpleIntegerProperty(0);
    //The worth that the Hand has based on the card's number
    private int cardCount;
    private int aces = 0;

    public Hand(ObservableList<Node> deck) {
        this.deck = deck;
    }

    public void addCard(Card card) {

        deck.add(card);
        //Adds a card to your hand/deck

        if (card.number == Number.Ace) {
            aces++;
            //If the card we get is an ace then the every following ace is 1
        }

        if (worth.get() + card.worth > 21 && aces > 0 && card.number == Number.Ace) {
            //If the worth of our hand with 2 cards plus the ace card we received is bigger than 21 then our worth
            //is reduced by 10 to set our ace as "1"
            worth.set(worth.get() + card.worth - 10);
            aces--;
            cardCount++;

        } else {

            cardCount++;
            worth.set(worth.get() + card.worth);
            //If the card isn't an ace then the normal happens and that card's worth gets added to the hand's worth

        }
    }

    public void reset() {
        //Our hand gets reset, if we want to start a new game for example.
        deck.clear();
        worth.set(0);
        aces = 0;
    }

    public SimpleIntegerProperty worthProperty() {
        return worth;
        //Returns the current worth of this hand
    }

    public int getCardCount() {
        return cardCount;
        //Returns how many cards are in play
    }

}