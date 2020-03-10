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
public class SpringSplosion {
    // Given a non-empty String like "Code" return a String like 
    // “CCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
    public String stringSplosion(String str) {
        String newStr = "";
        for(int i = 0; i <= str.length(); i++){
            String sub = str.substring(0,i);
            newStr += sub;
        }
        return newStr;
    }
}
