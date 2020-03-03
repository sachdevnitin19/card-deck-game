package com.nitin;

import com.nitin.Games.Game;
import com.nitin.Games.GameFactory;


public class Main {

    public static void main(String[] args) {
        int userChoice = -1;
        ConsoleInput consoleInput = new ConsoleInput();
        GameFactory gameFactory = new GameFactory();
        System.out.println("$$$$ Welcome $$$$");

        while (userChoice != 0) {
            System.out.println("#### Main Menu ####");
            System.out.println("\nChoose a game to play");
            String[] availableGames = gameFactory.getAvailableGames();
            for (int i = 0; i < availableGames.length; i++) {
                System.out.println(i + 1 + ". " + availableGames[i]);
            }
            System.out.println("More coming soon");
            System.out.println("\nEnter 0 to exit.");
            userChoice = consoleInput.getUserChoice(0, availableGames.length);

            if (userChoice == 0) {
                System.out.println("$$$$ Thanks for playing. Good bye ;) $$$$");
                break;
            } else {
                Game gameToPlay = gameFactory.getGame(availableGames[userChoice - 1], consoleInput);
                gameToPlay.start();
            }
        }


    }
}
