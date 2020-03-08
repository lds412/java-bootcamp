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
public class StringTimes {
    // Given a String and a non-negative int n, return a larger String 
    // that is n copies of the original String. 
    //
    // stringTimes("Hi", 2) -> "HiHi"
    // stringTimes("Hi", 3) -> "HiHiHi"
    // stringTimes("Hi", 1) -> "Hi"
    public String stringTimes(String str, int n) {
        String newStr = "";
        
        for (int i = 1; i <= n; i++){
            newStr += str;
        }
        
        return newStr;
    }
}
