/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.refactoring;

import java.util.Scanner;

/**
 *
 * @author lydia
 */
public class ReFactorizer {
    public void factorNum(){
        Scanner sc = new Scanner(System.in);

        System.out.print("What number would you like to factor? ");
        int num = sc.nextInt();

        System.out.println("The factors of " + num + " are: ");

        int factorSum = 0;
        int numFactors = 1; //Starting at one to include number itself

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                System.out.println(i);
                factorSum += i;
                numFactors++;
            }
        }
        
        //This is if you want to include the number as a factor of itself.
        System.out.println("(and "+num+")"); 

        if (factorSum == num) {
            System.out.println(num + " is a perfect number.");
        } else {
            System.out.println(num + " is not a perfect number.");
        }

        if (numFactors == 2) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
