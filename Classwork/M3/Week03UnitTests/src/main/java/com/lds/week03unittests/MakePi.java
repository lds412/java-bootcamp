/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.week03unittests;

/**
 *
 * @author lydia
 */
public class MakePi {
    // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3, 1, 4}

    public int[] makePi(int n) {
        int[] arr = new int[n];
        String p = Double.toString(Math.PI);
        if (arr.length >= 1) {
            arr[0] = 3;
            for (int i = 1; i < arr.length; i++) {
                int num = Integer.parseInt(String.valueOf(p.charAt(i + 1)));
                arr[i] = num;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        MakePi p = new MakePi();
        int[] array1 = p.makePi(1);
        for (int ele : array1) {
            System.out.println(ele);
        }
    }
}
