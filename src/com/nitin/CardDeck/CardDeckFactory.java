package com.nitin.CardDeck;

public class CardDeckFactory {
    private String[] availableDecks = {"DeckOf52"};

    public CardDeck getCardDeck(String deckType) {
        switch (deckType) {
            case "DeckOf52":
                return new DeckOf52();
            default:
                return null;
        }
    }

    public String[] getAvailableDecks() {
        return this.availableDecks;
    }
}
