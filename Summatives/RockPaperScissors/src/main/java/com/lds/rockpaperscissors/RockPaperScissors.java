/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lydia
 */
public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random ran = new Random();

        boolean playAgain = false;
        boolean invalidEntry = false;

        do {

            int rounds = chooseRounds(scan, invalidEntry);

            int wins = 0;
            int losses = 0;
            int draws = 0;

            for (int i = 0; i < rounds; i++) {
                int result = playRound(scan, ran);
                switch (result) {
                    case 1:
                        wins++;
                        break;
                    case 2:
                        draws++;
                        break;
                    default:
                        losses++;
                }
            }

            System.out.println("");
            System.out.println("User wins: " + wins);
            System.out.println("Computer wins: " + losses);
            System.out.println("Draws: " + draws);

            if (wins > losses) {
                System.out.println("You are the overall winner!!");
            } else if (losses > wins) {
                System.out.println("Looks like the computer got the best of you.");
            } else {
                System.out.println("Overall it was a tie.");
            }

            System.out.println("");

            do {
                System.out.print("Do you want to play again? (y/n) ");
                String yesOrNo = scan.next();
                System.out.println("");

                switch (yesOrNo) {
                    case "y":
                        playAgain = true;
                        invalidEntry = false;
                        break;
                    case "n":
                        playAgain = false;
                        invalidEntry = false;
                        System.out.println("Thanks for playing!");
                        break;
                    default:
                        invalidEntry = true;
                        System.out.println("That is not a valid entry. Try again. \n");
                }
            } while (invalidEntry);

        } while (playAgain);
    }

    public static int playRound(Scanner s, Random r) {
        int p1Num = 0;
        String p1Choice = "";
        while (p1Num == 0) {
            System.out.println("");
            System.out.print("Choose: rock, paper, or scissors? ");
            p1Choice = s.next();

            switch (p1Choice) {
                case "rock":
                    p1Num = 1;
                    break;
                case "paper":
                    p1Num = 2;
                    break;
                case "scissors":
                    p1Num = 3;
                    break;
                default:
                    System.out.println("That is not a valid entry. Try again.");
            }
        }

        int p2Num = r.nextInt(3) + 1;
        String p2Choice = "";

        switch (p2Num) {
            case 1:
                p2Choice = "rock";
                break;
            case 2:
                p2Choice = "paper";
                break;
            default:
                p2Choice = "scissors";
        }

        System.out.println("You chose " + p1Choice + " and player 2 chose " + p2Choice + ".");

        switch (p1Num - p2Num) {
            case -2:
            case 1:
                System.out.println("You win!!");
                return 1;
            case 0:
                System.out.println("It's a tie!");
                return 2;
            default:
                System.out.println("Sorry. You lose.");
                return 3;
        }
    }
    public static int chooseRounds(Scanner s, boolean invalidEntry){
        int rounds;
        
        do {
                System.out.print("How many rounds do you want to play? (Can play up to 10) ");
                rounds = s.nextInt(); //Write a method to take in, check, and return input

                if (rounds < 1 || rounds > 10) {
                    invalidEntry = true;
                    System.out.println("That is not a valid entry. Try again.\n");
                }else{
                    invalidEntry = false;
                }
                
            } while (invalidEntry);
        
        return rounds;
    }
}
