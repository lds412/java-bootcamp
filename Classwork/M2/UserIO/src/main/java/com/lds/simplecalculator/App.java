/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.simplecalculator;

import java.util.Scanner;

/**
 *
 * @author lydia
 */
public class App {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            String operation = "+";
            boolean valid = false;
            while (!valid) {
                System.out.println("What would you like to do?");
                System.out.println("Add (+)");
                System.out.println("Subtract (-)");
                System.out.println("Multiply (*)");
                System.out.println("Divide (/)");
                System.out.println("Quit (q)");
                operation = s.nextLine();

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
            }
            
            if(quit){
                break;
            }

            System.out.print("First operand: ");
            String input1 = s.nextLine();
            double op1 = Double.parseDouble(input1);
                    
            System.out.print("Second operand: ");
            String input2 = s.nextLine();
            double op2 = Double.parseDouble(input2);

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
            System.out.println("Answer: "+ans+"\n");
        }
        System.out.println("\nThank you. Goodbye!");
    }
}
