/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.userio;

/**
 *
 * @author lydia
 */
public class App {
    public static void main(String[] args) {
        
        IO io = new IO(); 
        
        int int1 = io.readInt("Enter an integer: ");
        int int2 = io.readInt("Enter another integer (within range): ", 3, 10);
        System.out.println("You choose "+int1+" and "+int2);
        
        String msg = io.readString("Enter a message: ");
        System.out.println("Your message was: "+msg);
        
        float f1 = io.readFloat("Enter a number: ");
        float f2 = io.readFloat("Enter another number: ", 1.2f, 9.8f);
        System.out.println("You choose "+f1+" and "+f2);
        
        double d1 = io.readDouble("Enter a number: ");
        double d2 = io.readDouble("Enter another number: ", 2.5, 5.7);
        System.out.println("You choose "+d1+" and "+d2);
        
        io.print("Good job!");
    }
}
