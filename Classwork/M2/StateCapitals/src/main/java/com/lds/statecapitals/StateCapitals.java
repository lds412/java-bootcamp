/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author lydia
 */
public class StateCapitals {

    public static void main(String[] args) {
        HashMap<String, String> capitals = new HashMap<>();

        capitals.put("Alabama", "Montgomery");
        capitals.put("Alaska", "Juneau");
        capitals.put("Arizona", "Phoenix");
        capitals.put("Arkansas", "Little Rock");
        capitals.put("Minnesota", "St. Paul");
        capitals.put("Wisconsin", "Madison");

        System.out.println("STATES:");
        System.out.println("=======");

        Set<String> keys = capitals.keySet();

        for (String k : keys) {
            System.out.println(k);
        }
        
        System.out.println("");
        System.out.println("CAPITALS:");
        System.out.println("=========");
        
        Collection<String> values = capitals.values();
        
        for (String v : values){
            System.out.println(v);
        }
        
        System.out.println("");
        System.out.println("STATE/CAPITAL PAIRS:");
        System.out.println("====================");
        
        for (String k : keys){
            System.out.println(k+" - "+capitals.get(k));
        }
    }

}
