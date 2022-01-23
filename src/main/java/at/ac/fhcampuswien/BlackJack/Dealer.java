package at.ac.fhcampuswien.BlackJack;

public class Dealer {

    private Card[] deck = new Card[52];
    //Array of the class Card, there is 52 individual cards


    public Card takeCard() {
        Card card = null;
        //Card has no value yet
        while (card == null) {
            int i = (int) (Math.random() * deck.length);
            //Picks a random spot in the array and the card gets a value
            card = deck[i];
            deck[i] = null;
            //then that spot gets set to null to prevent a repetition of the card
        }
        return card;
        //Returns card
    }

    public Dealer() {
        refill();
    }

    public final void refill() {
        //Refills the deck, all the cards that were set to "null" get a new value
        int i = 0;
        //It runs through the whole deck and finds the cards that are missing and sets them
        for (Card.Suit suit :
                Card.Suit.values()) {
            for (Card.Number number :
                    Card.Number.values()) {
                deck[i++] = new Card(suit, number);
            }
        }
    }
}
