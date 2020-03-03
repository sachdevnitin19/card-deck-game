package com.nitin.Games;

import com.nitin.CardDeck.Card;
import com.nitin.CardDeck.CardDeck;
import com.nitin.CardDeck.CardDeckFactory;
import com.nitin.ConsoleInput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EkPatti implements Game {
    private CardDeck cardDeckToPlay;
    private List<Player> playersList;
    private CardDeckFactory cardDeckFactory;
    ConsoleInput consoleInput;

    String startMsg = "\n" +
            "$$$$ Welcome to EkPatti $$$$\n" +
            "Rules:-\n" +
            "1. Game starts with each player getting one card from the deck.\n" +
            "2. Winner is decided based on the value of the card that he/she is holding. If players have\n" +
            "same value cards, winner should be decided based on this priority :\n" +
            "SPADES>HEART>CLUB>DIAMONDS";
    String gameMenu = "#### Ek Patti Game Menu ####\n" +
            "Choose your option:-\n" +
            "1. Add players\n" +
            "2. Print cards in deck\n" +
            "3. Shuffle deck\n" +
            "4. Find winner\n" +
            "0. Return to main menu";


    public EkPatti(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
        this.cardDeckFactory = new CardDeckFactory();
        this.playersList = new ArrayList<Player>();
    }

    @Override
    public void start() {
        int userChoice;
        System.out.println(startMsg);
        //choosing card deck
        System.out.println("\nChoose your deck");
        String[] availableDeck = this.cardDeckFactory.getAvailableDecks();
        for (int i = 0; i < availableDeck.length; i++) {
            System.out.println(i + 1 + ". " + availableDeck[i]);
        }
        userChoice = this.consoleInput.getUserChoice(1, availableDeck.length);
        this.cardDeckToPlay = this.cardDeckFactory.getCardDeck(availableDeck[userChoice - 1]);

        System.out.println("\nShuffling Card Deck\n");
        this.cardDeckToPlay.shuffle();


        this.addPlayers();

        userChoice = -1;
        System.out.println(this.gameMenu);
        while (userChoice != 0) {
            userChoice = this.consoleInput.getUserChoice(0, 4);
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
            }
            if (userChoice != 0) {
                System.out.println(this.gameMenu);
            } else {
                System.out.println("\n#### Thanks for playing Ek Patti ####");
            }

        }

    }


    @Override
    public void addPlayers() {
        System.out.println("Enter no of players (min 2, max 5):- ");
        int numOfPlayers = this.consoleInput.getUserChoice(2, 5);
        System.out.println("\n Adding " + numOfPlayers + " players and dealing cards \n");
        for (int i = 0; i < numOfPlayers; i++) {
            Player currPlayer = new Player();
            currPlayer.addCardsToCurrentHand(this.cardDeckToPlay.drawCardFromDeck(1));
            this.playersList.add(currPlayer);
        }
    }

    @Override
    public void findWinner() {
        Player winningPlayer = this.playersList.get(0);
        Card winningPlayerCard = winningPlayer.getCurrentHand().get(0);
        int winningPlayerIndex = 0;
        for (int i = 1; i < this.playersList.size(); i++) {
            Player currPlayer = this.playersList.get(i);
            Card currPlayerCard = currPlayer.getCurrentHand().get(0);

            if (currPlayerCard.getRank().getPriority() > winningPlayerCard.getRank().getPriority()) {
                winningPlayer = currPlayer;
                winningPlayerCard = currPlayerCard;
                winningPlayerIndex = i;
            } else if (currPlayerCard.getRank().getPriority() == winningPlayerCard.getRank().getPriority()) {
                if (currPlayerCard.getSuit().getPriority() > winningPlayerCard.getSuit().getPriority()) {
                    winningPlayer = currPlayer;
                    winningPlayerCard = currPlayerCard;
                    winningPlayerIndex = i;
                }
            }
        }

        System.out.println("\nWinning Player is 'Player " + (winningPlayerIndex + 1) + "' having " + winningPlayerCard);
    }
}