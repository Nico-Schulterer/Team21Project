package at.ac.fhcampuswien.BlackJack;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class Card extends Parent {

    //Enumeration is the simplest way to set the suit and number of a card
    public enum Suit {
        Heart, Diamond, Club, Spade
    }

    public enum Number {
        Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8),
        Nine(9), Ten(10), Jack(10), Queen(10), King(10), Ace(11);
        final int worth;
        //Worth is later used to calculate the value of the dealers and players hand

        Number(int worth) {
            this.worth = worth;
        }
    }

    public final Suit suit;
    public final Number number;
    public final int worth;

//Constructor to create a card
    public Card(Suit suit, Number number){

        this.suit = suit;
        this.number = number;
        this.worth = number.worth;

        Rectangle card = new Rectangle(100, 150);
        card.setFill(Color.WHITE);
        card.setArcHeight(15);
        card.setArcWidth(15);
        //Makes white rectangle

        Text text = new Text(toString());
        //In case ImageView fails we can still tell what card it is

        ImageView imageView = new ImageView(cardImage());
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);
        //It sets the image for each individual card

        getChildren().add(new StackPane(card, text, imageView));
        //Creates the visual card on the scene of the program

    }

    public String toString() {
        return this.suit.toString() + " " + this.number.toString();
    }

    public Image cardImage(){
        if(this.suit == Suit.Heart){
            if(this.number == Number.Two){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/2%20of%20Hearts.png");
            }else if(this.number == Number.Three){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/3%20of%20Hearts.png");
            }else if(this.number == Number.Four){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/4%20of%20Hearts.png");
            }else if (this.number == Number.Five){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/5%20of%20Hearts.png");
            }else if (this.number == Number.Six){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/6%20of%20Hearts.png");
            }else if (this.number == Number.Seven) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/7%20of%20Hearts.png");
            }else if (this.number == Number.Eight) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/8%20of%20Hearts.png");
            }else if (this.number == Number.Nine) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/9%20of%20Hearts.png");
            }else if (this.number == Number.Ten) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/10%20of%20Hearts.png");
            }else if (this.number == Number.Jack) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/Jack%20of%20Hearts.png");
            }else if (this.number == Number.Queen) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/Queen%20of%20Hearts.png");
            }else if (this.number == Number.King) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/King%20of%20Hearts.png");
            }else if (this.number == Number.Ace) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Hearts/Ace%20of%20Hearts.png");
            }
        }else if(this.suit == Suit.Diamond){
            if(this.number == Number.Two){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/2%20of%20Diamonds.png");
            }else if(this.number == Number.Three){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/3%20of%20Diamonds.png");
            }else if(this.number == Number.Four){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/4%20of%20Diamonds.png");
            }else if (this.number == Number.Five){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/5%20of%20Diamonds.png");
            }else if (this.number == Number.Six){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/6%20of%20Diamonds.png");
            }else if (this.number == Number.Seven) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/7%20of%20Diamonds.png");
            }else if (this.number == Number.Eight) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/8%20of%20Diamonds.png");
            }else if (this.number == Number.Nine) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/9%20of%20Diamonds.png");
            }else if (this.number == Number.Ten) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/10%20of%20Diamonds.png");
            }else if (this.number == Number.Jack) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/Jack%20of%20Diamonds.png");
            }else if (this.number == Number.Queen) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/Queen%20of%20Diamonds.png");
            }else if (this.number == Number.King) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/King%20of%20Diamonds.png");
            }else if (this.number == Number.Ace) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Diamonds/Ace%20of%20Diamonds.png");
            }
        }else if(this.suit == Suit.Club){
            if (this.number == Number.Two){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/2%20of%20Clubs.png");
            }else if (this.number == Number.Three){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/3%20of%20Clubs.png");
            }if(this.number == Number.Four){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/4%20of%20Clubs.png");
            }else if (this.number == Number.Five){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/5%20of%20Clubs.png");
            }else if (this.number == Number.Six){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/6%20of%20Clubs.png");
            }else if (this.number == Number.Seven) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/7%20of%20Clubs.png");
            }else if (this.number == Number.Eight) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/8%20of%20Clubs.png");
            }else if (this.number == Number.Nine) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/9%20of%20Clubs.png");
            }else if (this.number == Number.Ten) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/10%20of%20Clubs.png");
            }else if (this.number == Number.Jack) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/Jack%20of%20Clubs.png");
            }else if (this.number == Number.Queen) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/Queen%20of%20Clubs.png");
            }else if (this.number == Number.King) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/King%20of%20Clubs.png");
            }else if (this.number == Number.Ace) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Clubs/Ace%20of%20Clubs.png");
            }
        }else if (this.suit == Suit.Spade){
            if (this.number == Number.Two){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/2%20of%20Spades.png");
            }else if (this.number == Number.Three){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/3%20of%20Spades.png");
            }else if(this.number == Number.Four){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/4%20of%20Spades.png");
            }else if (this.number == Number.Five){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/5%20of%20Spades.png");
            }else if (this.number == Number.Six){
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/6%20of%20Spades.png");
            }else if (this.number == Number.Seven) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/7%20of%20Spades.png");
            }else if (this.number == Number.Eight) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/8%20of%20Spades.png");
            }else if (this.number == Number.Nine) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/9%20of%20Spades.png");
            }else if (this.number == Number.Ten) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/10%20of%20Spades.png");
            }else if (this.number == Number.Jack) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/Jack%20of%20Spades.png");
            }else if (this.number == Number.Queen) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/Queen%20of%20Spades.png");
            }else if (this.number == Number.King) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/King%20of%20Spades.png");
            }else if (this.number == Number.Ace) {
                return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/Spades/Ace%20of%20Spades%E2%89%A1%C6%92%C3%B1%C3%BF.png");
            }
        }
        return new Image("https://raw.githubusercontent.com/Nico-Schulterer/Team21Project/master/src/main/images/Cards/%23%20Card%20Back%20Side.png");
    }
    //Checks the suit and number of the card, then a return value with the correct image is returned to the ImageView
    // so that it can set it

}

