/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.weekonelabs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author lydia
 */
public class InterestCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BigDecimal annualRate = new BigDecimal("0");
        BigDecimal principal = new BigDecimal("0");
        BigDecimal years = new BigDecimal("0");

        boolean valid = false;
        while (!valid) {
        System.out.print("What is the annual interest rate? ");
        String rateInput = sc.nextLine();
            try {
                annualRate = new BigDecimal(rateInput);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }

        valid = false;
        while (!valid) {
        System.out.print("What is the initial amount of principal? ");
        String principalInput = sc.nextLine();
            try {
                principal = new BigDecimal(principalInput);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }

        //int years2 = Integer.parseInt(yearInput);
        valid = false;
        while (!valid) {
        System.out.print("How many years will the $$ stay in the fund? ");
        String yearInput = sc.nextLine();
            try {
                years = new BigDecimal(yearInput);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
        
        //int quarters = years * 4;
        BigDecimal qtrlyRate = annualRate.divide(new BigDecimal("4"),
                2, RoundingMode.HALF_UP);
        BigDecimal currentBalance = principal;
        BigDecimal interestEarned;

        for (int i = 1; i <= years.intValue(); i++) {
            System.out.println("Year: " + i);
            System.out.println("Balance at beginning of year: $"
                    + currentBalance.setScale(2, RoundingMode.HALF_UP));
            BigDecimal totalInterest = new BigDecimal("0");
            for (int j = 1; j <= 4; j++) {
                interestEarned = currentBalance.multiply(qtrlyRate.divide(
                        new BigDecimal("100"), 2, RoundingMode.HALF_UP));
                currentBalance = currentBalance.add(interestEarned);
                totalInterest = totalInterest.add(interestEarned);
            }
            System.out.println("Interest earned: $"
                    + totalInterest.setScale(2, RoundingMode.HALF_UP));
            System.out.println("Balance at year-end: $"
                    + currentBalance.setScale(2, RoundingMode.HALF_UP));
        }

    }
}
