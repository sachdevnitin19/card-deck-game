package com.nitin.CardDeck;

import java.util.List;

//CardDeck interface containing common methods that all types of deck should have.
public interface CardDeck {

    void shuffle();

    List<Card> drawCardFromDeck(int num);

    void returnCardsToDeck(List<Card> cardsToReturn);

    void printCardsInDeck();
}
