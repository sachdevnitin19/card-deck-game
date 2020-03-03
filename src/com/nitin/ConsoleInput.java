package com.nitin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Common input utility for getting user input from console
public class ConsoleInput {
    private BufferedReader br;

    public ConsoleInput() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    //utility method to record user input from console for menu selection
    //user can only enter no between "minChoiceNumber" & "maxChoiceNumber"
    public int getUserChoice(int minChoiceNumber, int maxChoiceNumber) {
        int userChoice = -1;
        while (userChoice == -1 || userChoice < minChoiceNumber || userChoice > maxChoiceNumber) {
            try {
                userChoice = Integer.parseInt(this.br.readLine());
                if (userChoice == -1 || userChoice < minChoiceNumber || userChoice > maxChoiceNumber) {
                    System.out.println("Please enter correct choice");
                }
            } catch (Exception e) {
                //Handling IOException here
                System.out.println("Invalid input. Please try again.");
            }

        }
        return userChoice;
    }
}
