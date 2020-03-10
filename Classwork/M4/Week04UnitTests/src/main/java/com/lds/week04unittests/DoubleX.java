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
public class DoubleX {

    // Given a String, return true if the first instance 
    // of "x" in the String is immediately followed by 
    // another "x". 
    //
    // doubleX("axxbb") -> true
    // doubleX("axaxxax") -> false
    // doubleX("xxxxx") -> true
    public boolean doubleX(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                return str.charAt(i + 1) == 'x';
            }
        }
        return false;
    }
}
