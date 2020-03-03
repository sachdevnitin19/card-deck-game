package com.nitin.CardDeck;

//Suit of a card enum definition with their priority used for comparing cards.
public enum Suits {
    SPADES("SPADES", 4),
    HEART("HEART", 3),
    CLUB("CLUB", 2),
    DIAMONDS("DIAMONDS", 1);

    private final String suitName;
    private final int priority;

    Suits(String suitName, int priority) {
        this.suitName = suitName;
        this.priority = priority;
    }

    public String getSuitName() {
        return suitName;
    }

    public int getPriority() {
        return priority;
    }
}
