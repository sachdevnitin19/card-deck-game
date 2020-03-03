package com.nitin.Games;

import com.nitin.CardDeck.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player {
    private List<Card> currentHand;

    public Player() {
        this.currentHand = new ArrayList<Card>();
    }

    public void addCardsToCurrentHand(List<Card> cards) {
        this.currentHand.addAll(cards);
    }

    public List<Card> getCurrentHand() {
        return new ArrayList<Card>(this.currentHand);
    }

    public void printCurrentHand() {
        Iterator<Card> cardIterator = currentHand.iterator();
        while (cardIterator.hasNext()) {
            System.out.println(cardIterator.next());
        }
    }
}
