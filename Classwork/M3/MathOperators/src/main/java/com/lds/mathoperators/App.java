/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.mathoperators;

import java.util.Scanner;

/**
 *
 * @author lydia
 */
public class App {
    public static void main(String[] args) {
        IntMath intMath = new IntMath();
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Please enter operand 1: ");
        String input1 = s.nextLine();
        int op1 = Integer.parseInt(input1);
        
        System.out.print("Please enter operand 2: ");
        String input2 = s.nextLine();
        int op2 = Integer.parseInt(input2);
        
        System.out.println(intMath.calculate(MathOperator.PLUS, op1, op2));
        System.out.println(intMath.calculate(MathOperator.MINUS, op1, op2));
        System.out.println(intMath.calculate(MathOperator.MULTIPLY, op1, op2));
        System.out.println(intMath.calculate(MathOperator.DIVIDE, op1, op2));
    }
}
