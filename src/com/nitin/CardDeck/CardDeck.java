package com.nitin.CardDeck;

import java.util.List;

//A CardDeck interface containing common methods that all types of deck should have.
public interface CardDeck {

    public void shuffle();

    public List<Card> drawCardFromDeck(int num);

    public void returnCardsToDeck(List<Card> cardsToReturn);

    public void printCardsInDeck();
}
