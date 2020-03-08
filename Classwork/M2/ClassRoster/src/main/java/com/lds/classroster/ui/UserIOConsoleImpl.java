/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.classroster.ui;

import java.util.Scanner;

/**
 *
 * @author lydia
 */
public class UserIOConsoleImpl implements UserIO{
    @Override
    public void print(String message) {
        System.out.println(message);
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
            }else{
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
            }else{
                valid = true;
            }
        }
        return f;
    }

    @Override
    public int readInt(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        int integer = s.nextInt();
        return integer;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        Scanner s = new Scanner(System.in);
        boolean valid = false;
        int integer = 0;
        while (!valid) {
            System.out.print(prompt);
            integer = s.nextInt();
            if (integer < min || integer > max) {
                System.out.println("That number is outside the range. Please try again.");
            }else{
                valid = true;
            }
        }
        return integer;
    }

    @Override
    public long readLong(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String readString(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        return s.nextLine();
    }
}
