package com.nitin.CardDeck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DeckOf52 implements CardDeck {

    private List<Card> cards;

    public DeckOf52() {
        this.cards = new ArrayList<Card>(52);

        for (Suits suit : Suits.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    @Override
    public void shuffle() {
        Random rnd = new Random();
        for (int i = 0; i < 52; i++) {
            int randomSwapIndex = rnd.nextInt(52);
            Card tempSwapCard = this.cards.get(i);
            this.cards.set(i, this.cards.get(randomSwapIndex));
            this.cards.set(randomSwapIndex, tempSwapCard);
        }
    }

    @Override
    public List<Card> drawCardFromDeck(int numOfCards) {
        int currentDeckSize = this.cards.size();
        if (numOfCards > currentDeckSize) {
            return null;
        }
        List<Card> cardsToReturn = new ArrayList<Card>(numOfCards);
        while (numOfCards-- > 0) {
            cardsToReturn.add(this.cards.get(0));
            this.cards.remove(0);
        }
        return cardsToReturn;
    }

    @Override
    public void returnCardsToDeck(ArrayList<Card> cardsToReturn) {
        if (cardsToReturn == null) {
            return;
        }
        Iterator<Card> cardIterator = cardsToReturn.iterator();
        while (cardIterator.hasNext()) {
            this.cards.add(cardIterator.next());
        }
    }

    @Override
    public void printCardsInDeck() {
        System.out.println("\n#### Printing Current Deck ####\n");
        Iterator<Card> cardItr = this.cards.iterator();
        while (cardItr.hasNext()) {
            System.out.println(cardItr.next());
        }
    }
}
