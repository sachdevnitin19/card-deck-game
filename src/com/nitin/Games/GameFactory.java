package com.nitin.Games;

import com.nitin.ConsoleInput;

//Implementing "Factory" design pattern for flexibility of adding new types of card games in future.
public class GameFactory {
    private String[] availableGames = {"EkPatti"};

    //method to get Game instance based on string parameter provided
    public Game getGame(String deckType, ConsoleInput consoleInput) {
        switch (deckType) {
            case "EkPatti":
                return new EkPatti(consoleInput);
            default:
                return null;
        }
    }

    //method to get array of all available games.
    public String[] getAvailableGames() {
        return this.availableGames;
    }
}
