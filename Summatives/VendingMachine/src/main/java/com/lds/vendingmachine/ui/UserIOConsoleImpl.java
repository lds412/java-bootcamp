/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author lydia
 */
public class UserIOConsoleImpl implements UserIO {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, int scale, RoundingMode r) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        String num = s.nextLine();
        do {
            try {
                BigDecimal bD = new BigDecimal(num);
                bD = bD.setScale(scale, r);
                return bD;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        } while (true);
    }

    @Override
    public double readDouble(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        double d = s.nextDouble();
        return d;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        Scanner s = new Scanner(System.in);
        boolean valid = false;
        double d = 0;
        while (!valid) {
            System.out.print(prompt);
            d = s.nextDouble();
            if (d < min || d > max) {
                System.out.println("That number is outside the range. Please try again.");
            } else {
                valid = true;
            }
        }
        return d;
    }

    @Override
    public float readFloat(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        float f = s.nextFloat();
        return f;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        Scanner s = new Scanner(System.in);
        boolean valid = false;
        float f = 0;
        while (!valid) {
            System.out.print(prompt);
            f = s.nextFloat();
            if (f < min || f > max) {
                System.out.println("That number is outside the range. Please try again.");
            } else {
                valid = true;
            }
        }
        return f;
    }

    @Override
    public int readInt(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        String num = s.nextLine();
        do {
            try {
                int integer = Integer.parseInt(num);
                return integer;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        } while (true);
    }

    //MAKE SURE THE TRY/CATCH BLOCK WORKS (esp the boolean variable)
    @Override
    public int readInt(String prompt, int min, int max) {
        Scanner s = new Scanner(System.in);
        boolean valid = false;
        int integer = 0;
        do {
            System.out.print(prompt);
            String num = s.nextLine();
            while (!valid) {
                try {
                    integer = Integer.parseInt(num);
                    valid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                }
            }
            if (integer < min || integer > max) {
                System.out.println("That number is outside the range. Please try again.");
            } else {
                return integer;
            }
        } while (true);
    }

    @Override
    public long readLong(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String readString(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        String ans = s.nextLine();
        if (ans.equals("")) {
            return "N/A";
        } else {
            return ans;
        }
    }

    @Override
    public LocalDate readLocalDate(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        String date = s.nextLine();
        do {
            try {
                LocalDate ld = LocalDate.parse(date);
                return ld;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date");
            }
        } while (true);
    }

}
