package com.nitin.CardDeck;

public class CardDeckFactory {
    public CardDeck getCardDeck(String deckType) {
        switch (deckType) {
            case "DeckOf52":
                return new DeckOf52();
            default:
                return null;

        }
    }
}
