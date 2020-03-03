package com.nitin.CardDeck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

//Deck of 52 cards is a type of deck containing 13 cards for each suit (SPADES,HEART,CLUB,DIAMOND)
public class DeckOf52 implements CardDeck {
    //list containing 52 cards
    private List<Card> cards;

    //initializing cards list and adding 13 cards of each suit
    public DeckOf52() {
        this.cards = new ArrayList<Card>(52);

        for (Suits suit : Suits.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    //Method to shuffle card deck
    //It simply iterates over list and swap current card with random index in list.
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

    //Method to draw cards from deck, used when player wants to draw num of cards.
    //It accepts integer 'numOfCards' which is no of cards to draw and return List containing cards drawn
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

    //Method to add cards at the end of current deck.
    //It accepts List of cards to be returned.
    @Override
    public void returnCardsToDeck(List<Card> cardsToReturn) {
        if (cardsToReturn == null) {
            return;
        }
        Iterator<Card> cardIterator = cardsToReturn.iterator();
        while (cardIterator.hasNext()) {
            this.cards.add(cardIterator.next());
        }
    }

    //Method to print all cards in current deck.
    @Override
    public void printCardsInDeck() {
        System.out.println("\n#### Printing Current Deck ####\n");
        Iterator<Card> cardItr = this.cards.iterator();
        while (cardItr.hasNext()) {
            System.out.println(cardItr.next());
        }
    }
}
