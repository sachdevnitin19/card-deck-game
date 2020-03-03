package com.nitin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
    private BufferedReader br;

    public ConsoleInput() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getUserChoice(int minChoiceNumber, int maxChoiceNumber) {
        int userChoice = -1;
        while (userChoice == -1 || userChoice < minChoiceNumber || userChoice > maxChoiceNumber) {
            try{
                userChoice = Integer.parseInt(this.br.readLine());
                if (userChoice == -1 || userChoice < minChoiceNumber || userChoice > maxChoiceNumber) {
                    System.out.println("Please enter correct choice");
                }
            }catch(Exception e){
                System.out.println("Invalid input");
            }

        }
        return userChoice;
    }
}
