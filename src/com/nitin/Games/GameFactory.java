package com.nitin.Games;

import com.nitin.ConsoleInput;

import java.io.BufferedReader;

public class GameFactory {
    private String[] availableGames = {"EkPatti"};

    public Game getGame(String deckType, ConsoleInput consoleInput) {
        switch (deckType) {
            case "EkPatti":
                return new EkPatti(consoleInput);
            default:
                return null;
        }
    }

    public String[] getAvailableGames() {
        return this.availableGames;
    }
}
