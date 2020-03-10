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
public class ParrotTrouble {
    // We have a loud talking parrot. The "hour" parameter is the 
    // current hour time in the range 0..23. We are in trouble if 
    // the parrot is talking and the hour is before 7 or after 20. 
    // Return true if we are in trouble. 
    //
    // parrotTrouble(true, 6) -> true
    // parrotTrouble(true, 7) -> false
    // parrotTrouble(false, 6) -> false
    // parrotTrouble(true, 21) -> true
    public boolean parrotTrouble(boolean isTalking, int hour) {
        return isTalking && (hour < 7 || hour > 20);
    }
}
