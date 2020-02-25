/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.userio;

import com.lds.simplecalculator.SimpleCalculator;

/**
 *
 * @author lydia
 */
public class SimpleCalculatorApp {

    public static void main(String[] args) {

        IO io = new IO();

        boolean quit = false;

        while (!quit) {
            String operation;  // = "+";
            boolean valid = false;

            while (!valid) {
                io.print("What would you like to do?");
                io.print("Add (+)");
                io.print("Subtract (-)");
                io.print("Multiply (*)");
                io.print("Divide (/)");
                io.print("Quit (q)");

                operation = io.readString("Enter here: ");

                switch (operation) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        valid = true;
                        break;
                    case "q":
                        valid = true;
                        quit = true;
                        break;
                    default:
                        System.out.println("\nThat was not a valid operation. Try again.\n");
                }

                if (quit) {
                    break;
                }

                double op1 = io.readDouble("First operand: ");
                double op2 = io.readDouble("Second operand: ");

                double ans;

                switch (operation) {
                    case "+":
                        ans = SimpleCalculator.add(op1, op2);
                        break;
                    case "-":
                        ans = SimpleCalculator.sub(op1, op2);
                        break;
                    case "*":
                        ans = SimpleCalculator.mult(op1, op2);
                        break;
                    default:
                        ans = SimpleCalculator.div(op1, op2);
                }
                io.print("Answer: " + ans + "\n");
            }
        }
        io.print("\nThank you. Goodbye!");
    }
}
