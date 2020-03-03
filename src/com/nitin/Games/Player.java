package com.nitin.Games;

import com.nitin.CardDeck.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player {
    //list containing all cards held by a player in a game.
    private List<Card> currentHand;

    public Player() {
        this.currentHand = new ArrayList<>();
    }

    //Method to add list of cards to the current hand.
    public void addCardsToCurrentHand(List<Card> cards) {
        this.currentHand.addAll(cards);
    }

    //method to get copy of list of cards held currently by player.
    public List<Card> getCurrentHand() {
        return new ArrayList<>(this.currentHand);
    }

    //method to print current cards held by player.
    public void printCurrentHand() {
        Iterator<Card> cardIterator = currentHand.iterator();
        while (cardIterator.hasNext()) {
            System.out.println(cardIterator.next());
        }
    }
}
