/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.connectfour;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lydia
 */
public class ConnectFour {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Random r = new Random();

        boolean playAgain = true;

        while (playAgain) {
            boolean boardInPlay = true;
            boolean isX = true;

            String p1 = getName(s, 1);
            String p2 = getName(s, 2);

            boolean p1Turn = r.nextBoolean();
            declareFirst(p1, p2, p1Turn);

            String[][] board = initializeBoard();
            printBoard(board);

            while (boardInPlay) {
                boolean invalidMove = true;
                int move;
                do {
                    move = chooseColumn(s, p1, p2, p1Turn);
                    invalidMove = checkMove(board, move, invalidMove);
                } while (invalidMove);
                board = makeMove(board, move, isX);
                printBoard(board);
                p1Turn = !p1Turn;
                isX = !isX;
                boolean fourAcross = checkRows(board);
                boolean fourDown = checkCols(board);
                boolean fourDiag = checkDiags(board);
                if (fourAcross || fourDown || fourDiag) {
                    boardInPlay = false;
                }
            }

            if (p1Turn) {
                System.out.println(p2 + " wins!\n");
            } else {
                System.out.println(p1 + " wins!\n");
            }

            boolean invalidAns = true;

            while (invalidAns) {
                System.out.print("Play again? [y/n]: ");
                String ans = s.nextLine();
                switch (ans) {
                    case "y":
                        playAgain = true;
                        invalidAns = false;
                        break;
                    case "n":
                        playAgain = false;
                        invalidAns = false;
                        break;
                    default:
                        System.out.println("\nThat is not a valid answer. Try again.\n");
                }
            }
        }
        System.out.println("\nThanks for playing!");
    }

    public static String getName(Scanner s, int playerNum) {
        System.out.print("Player #" + playerNum + ", enter your name: ");
        String name = s.nextLine();
        System.out.println("Hello, " + name + "\n");
        return name;
    }

    public static int chooseColumn(Scanner s, String p1, String p2, boolean p1Turn) {
        String playerNam;
        if (p1Turn) {
            playerNam = p1;
        } else {
            playerNam = p2;
        }
        boolean invalid = true;
        int col;
        do {
            System.out.print(playerNam + ", choose a column: ");
            String input = s.nextLine();
            col = Integer.parseInt(input); //Still can only enter integer
            if (col < 1 || col > 7) {
                System.out.println("That's not a valid column.\n");
            } else {
                invalid = false;
            }
        } while (invalid);
        return col;
    }

    public static void declareFirst(String p1, String p2, boolean p1Turn) {
        System.out.println("(Randomizing...)");
        String someone = p2;
        if (p1Turn) {
            someone = p1;
        }
        System.out.println("It's " + someone + "'s turn.");
    }

    public static String[][] initializeBoard() {
        String[][] board = new String[6][7];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = "- ";
            }
        }
        return board;
    }

    public static void printBoard(String board[][]) {
        System.out.println("");
        for (int i = 1; i <= 7; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");

        for (String[] row : board) {
            for (String ele : row) {
                System.out.print(ele);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static boolean checkMove(String board[][], int col, boolean invalidMove) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][col - 1].equals("- ")) {
                invalidMove = false;
                break;
            }
        }
        if (invalidMove) {
            System.out.println("Invalid move. Try again.");
            System.out.println("");
        }
        return invalidMove;
    }

    public static String[][] makeMove(String board[][], int col, boolean isX) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][col - 1].equals("- ")) {
                if (isX) {
                    board[row][col - 1] = "X ";
                } else {
                    board[row][col - 1] = "O ";
                }
                break;
            }
        }
        return board;
    }

    public static boolean checkRows(String[][] board) {
        int Xmatch;
        int Omatch;

        for (int row = 0; row < board.length; row++) {
            Xmatch = 0;
            Omatch = 0;
            for (int col = 0; col < (board[row].length - 1); col++) {
                if (board[row][col].equals(board[row][col + 1])) {
                    if (board[row][col].equals("X ")) {
                        Xmatch++;
                        if (Xmatch > 2) {
                            return true;
                        }
                    }
                    if (board[row][col].equals("O ")) {
                        Omatch++;
                        if (Omatch > 2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkCols(String[][] board) {
        int Xmatch;
        int Omatch;

        for (int col = 0; col < board[0].length; col++) {
            Xmatch = 0;
            Omatch = 0;
            for (int row = 0; row < board.length - 1; row++) {
                if (board[row][col].equals(board[row + 1][col])) {
                    if (board[row][col].equals("X ")) {
                        Xmatch++;
                        if (Xmatch > 2) {
                            return true;
                        }
                    }
                    if (board[row][col].equals("O ")) {
                        Omatch++;
                        if (Omatch > 2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkDiags(String[][] board) {

        for (int c = 0; c < board[0].length - 3; c++) {
            for (int r = 0; r < board.length - 3; r++) {
                if (board[r][c].equals(board[r + 1][c + 1])
                        && board[r][c].equals(board[r + 2][c + 2])
                        && board[r][c].equals(board[r + 3][c + 3])
                        && !board[r][c].equals("- ")) {
                    return true;
                }
            }
        }

        for (int c = 0; c < board[0].length - 3; c++) {
            for (int r = board.length - 1; r > board.length - 4; r--) {
                if (board[r][c].equals(board[r - 1][c + 1])
                        && board[r][c].equals(board[r - 2][c + 2])
                        && board[r][c].equals(board[r - 3][c + 3])
                        && !board[r][c].equals("- ")) {
                    return true;
                }
            }
        }

        return false;
    }
}
