package at.ac.fhcampuswien.BlackJack;

public class Dealer {

    private Card[] deck = new Card[52];


    public Card takeCard(){
        Card card = null;
        while(card == null) {
            int i = (int)(Math.random() * deck.length);
            card = deck[i];
            deck[i] = null;
        }
        return card;
    }

    public Dealer(){
        refill();
    }

    public final void refill(){
        int i = 0;
        for (Card.Suit suit :
                Card.Suit.values()) {
            for (Card.Number number:
                    Card.Number.values()) {
                deck[i++] = new Card(suit, number);
            }
        }
    }
}
