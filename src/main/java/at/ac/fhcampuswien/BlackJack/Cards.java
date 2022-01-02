package at.ac.fhcampuswien.BlackJack;

public class Cards {

    enum Suit{
        Heart, Diamond, Clover, Spade
    }

    enum Number {
        Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8),
        Nine(9), Ten(10), Jack(10), Queen(11), King(12);
        final int worth;
        Number(int worth) {
            this.worth = worth;
        }
    }


    public Cards(Suit suit, Number number){

    }
}
