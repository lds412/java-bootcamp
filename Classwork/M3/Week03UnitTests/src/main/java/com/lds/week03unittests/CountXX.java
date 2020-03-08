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
public class CountXX {
    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    //
    // countXX("abcxx") -> 1
    // countXX("xxx") -> 2
    // countXX("xxxx") -> 3
    public int countXX(String str) {
        int count = 0;
        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                count++;
            }
        }
        return count;
    }
}
