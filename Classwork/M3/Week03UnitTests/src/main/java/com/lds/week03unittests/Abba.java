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
public class Abba {
    // Given two Strings, a and b, return the result of putting 
    // them together in the order abba, e.g. "Hi" and "Bye" 
    // returns "HiByeByeHi". 
    //
    // abba("Hi", "Bye") -> "HiByeByeHi"
    // abba("Yo", "Alice") -> "YoAliceAliceYo"
    // abba("What", "Up") -> "WhatUpUpWhat"
    public String abba(String a, String b) {
        return a+b+b+a;
    }
}
