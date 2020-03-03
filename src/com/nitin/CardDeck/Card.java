package com.nitin.CardDeck;
//Single Card definition
public class Card {
    private final Suits suit;
    private final Rank rank;

    public Card(Suits suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suits getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }
    //overriding Object.toString method to get desired string representation of card.
    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }
}
