package com.nitin.CardDeck;

import java.util.ArrayList;
import java.util.List;

public interface CardDeck {

    public void shuffle();

    public List<Card> drawCardFromDeck(int num);

    public void returnCardsToDeck(ArrayList<Card> cardsToReturn);

    public void printCardsInDeck();
}
