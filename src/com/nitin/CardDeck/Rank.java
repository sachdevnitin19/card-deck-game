package com.nitin.CardDeck;

//Rank of card enum definition with their priority used for comparing cards.
public enum Rank {
    ACE("ACE", 1),
    TWO("TWO", 2),
    THREE("THREE", 3),
    FOUR("FOUR", 4),
    FIVE("FIVE", 5),
    SIX("SIX", 6),
    SEVEN("SEVEN", 7),
    EIGHT("EIGHT", 8),
    NINE("NINE", 9),
    TEN("TEN", 10),
    JACK("JACK", 11),
    QUEEN("QUEEN", 12),
    KING("KING", 13);

    private final String name;
    private final int priority;

    Rank(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }
}
