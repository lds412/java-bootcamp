/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.week04unittests;

/**
 *
 * @author lydia
 */
public class RotateLeft {
    // Given an array of ints, return an array with the elements 
    // “rotated left" so {1, 2, 3} yields {2, 3, 1}. 
    //
    // rotateLeft({1, 2, 3}) -> {2, 3, 1}
    // rotateLeft({5, 11, 9}) -> {11, 9, 5}
    // rotateLeft({7, 0, 0}) -> {0, 0, 7}
    public int[] rotateLeft(int[] numbers) {
        int temp = 0;
        for(int i = 0; i < numbers.length; i++){
            if(i == 0){
                temp = numbers[i];
            } else{
                numbers[i-1] = numbers[i];
            }
        }
        numbers[numbers.length-1] = temp;
        return numbers;
    }
}
