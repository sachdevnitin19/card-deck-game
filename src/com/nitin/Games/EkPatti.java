package com.nitin.Games;

import com.nitin.CardDeck.Card;
import com.nitin.CardDeck.CardDeck;
import com.nitin.CardDeck.CardDeckFactory;
import com.nitin.ConsoleInput;

import java.util.ArrayList;
import java.util.List;

//EkPatti is type of game where each player gets one card and the player has maximum number wins the game
public class EkPatti implements Game {
    private CardDeckFactory cardDeckFactory;
    private CardDeck cardDeckToPlay;//CardDeck for current game
    private List<Player> playersList;//List containing current game players
    ConsoleInput consoleInput;

    //Only 52 players can play this game at a time, deck contains 52 cards and each player can draw one card only
    private final int maxNoOfPlayers = 52;

    //Message string displayed at start of every game
    String startMsg = "\n$$$$ Welcome to EkPatti $$$$\n" +
            "Rules:-\n" +
            "1. Game starts with each player getting one card from the deck.\n" +
            "2. Winner is decided based on the value of the card that he/she is holding. If players have\n" +
            "same value cards, winner should be decided based on this priority :\n" +
            "SPADES>HEART>CLUB>DIAMONDS";
    //Game Menu options which chosen by user during game.
    String gameMenu = "#### Ek Patti Game Menu ####\n" +
            "Choose your option:-\n" +
            "1. Add players\n" +
            "2. Print cards in deck\n" +
            "3. Shuffle deck\n" +
            "4. Find winner\n" +
            "5. Print player card\n" +
            "0. Return to main menu";


    public EkPatti(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
        this.cardDeckFactory = new CardDeckFactory();
        this.playersList = new ArrayList<>();
    }

    //main entry point for the game
    @Override
    public void start() {
        int userChoice;
        System.out.println(startMsg);
        //printing all available card decks and asking user to choose type of deck
        System.out.println("\nChoose your deck");
        String[] availableDeck = this.cardDeckFactory.getAvailableDecks();
        for (int i = 0; i < availableDeck.length; i++) {
            System.out.println(i + 1 + ". " + availableDeck[i]);
        }
        userChoice = this.consoleInput.getUserChoice(1, availableDeck.length);
        this.cardDeckToPlay = this.cardDeckFactory.getCardDeck(availableDeck[userChoice - 1]);

        //shuffling the card at start of game
        System.out.println("\nShuffling Card Deck\n");
        this.cardDeckToPlay.shuffle();

        //adding players
        this.addPlayers();

        //looping and continuously showing game options to user unless user chooses to quit game.
        userChoice = -1;
        System.out.println(this.gameMenu);
        while (userChoice != 0) {
            userChoice = this.consoleInput.getUserChoice(0, 5);
            switch (userChoice) {
                case 0:
                    break;
                case 1:
                    this.addPlayers();
                    break;
                case 2:
                    this.cardDeckToPlay.printCardsInDeck();
                    break;
                case 3:
                    this.cardDeckToPlay.shuffle();
                    break;
                case 4:
                    this.findWinner();
                    userChoice = 0;
                    break;
                case 5:
                    this.printPlayerCard();
                    break;
            }
            if (userChoice == 0) {
                System.out.println("\n#### Thanks for playing Ek Patti ####");
                break;
            }

            System.out.println(this.gameMenu);
        }

    }

    //method to add players to current game
    @Override
    public void addPlayers() {
        if (this.playersList.size() == this.maxNoOfPlayers) {
            System.out.println("\nCannot add new players, max limit reached !!!!\n");
            return;
        }
        int maxLimit = maxNoOfPlayers - this.playersList.size(),
                minLimit = maxLimit >= 2 ? 2 : maxLimit;

        System.out.println("Enter no of players (min " + minLimit + ", max " + (maxLimit) + "):- ");
        int numOfPlayers = this.consoleInput.getUserChoice(minLimit, maxNoOfPlayers - this.playersList.size());
        System.out.println("\nAdding " + numOfPlayers + " players and dealing cards \n");
        for (int i = 0; i < numOfPlayers; i++) {
            Player currPlayer = new Player();
            currPlayer.addCardsToCurrentHand(this.cardDeckToPlay.drawCardFromDeck(1));
            this.playersList.add(currPlayer);
        }
    }

    //Method to find and print the winning player.
    @Override
    public void findWinner() {
        Card winningPlayerCard = this.playersList.get(0).getCurrentHand().get(0);
        int winningPlayerIndex = 0;
        //iterates over players and compares cards.
        for (int i = 1; i < this.playersList.size(); i++) {
            Card currPlayerCard = this.playersList.get(i).getCurrentHand().get(0);

            if (currPlayerCard.getRank().getPriority() > winningPlayerCard.getRank().getPriority()) {
                winningPlayerCard = currPlayerCard;
                winningPlayerIndex = i;
            } else if (currPlayerCard.getRank().getPriority() == winningPlayerCard.getRank().getPriority()) {
                if (currPlayerCard.getSuit().getPriority() > winningPlayerCard.getSuit().getPriority()) {
                    winningPlayerCard = currPlayerCard;
                    winningPlayerIndex = i;
                }
            }
        }

        System.out.println("\nWinning Player is 'Player " + (winningPlayerIndex + 1) + "' having " + winningPlayerCard);
    }

    //Print player's current hand
    public void printPlayerCard() {
        System.out.println("\nEnter Player no. whose card you wanna print (min 1, max " + this.playersList.size() + "):- ");
        int userChoice = this.consoleInput.getUserChoice(1, this.playersList.size());
        this.playersList.get(userChoice - 1).printCurrentHand();
    }
}
