package com.nitin.CardDeck;

public enum Suits {
    SPADES("SPADES", 1),
    HEART("HEART", 2),
    CLUB("CLUB", 3),
    DIAMONDS("DIAMONDS", 4);

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
