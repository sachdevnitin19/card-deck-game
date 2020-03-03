package com.nitin.CardDeck;
//Implementing "Factory" design pattern for flexibility of adding new types of card decks in future.
public class CardDeckFactory {
    private String[] availableDecks = {"DeckOf52"};

    //method to get CardDeck instance based on string parameter provided
    public CardDeck getCardDeck(String deckType) {
        switch (deckType) {
            case "DeckOf52":
                return new DeckOf52();
            default:
                return null;
        }
    }
    //method to get array of all available card decks.
    public String[] getAvailableDecks() {
        return this.availableDecks;
    }
}
