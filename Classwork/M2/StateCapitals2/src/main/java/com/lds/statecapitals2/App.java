/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.statecapitals2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author lydia
 */
public class App {
    public static void main(String[] args) {
        HashMap<String, Capital> capitals = new HashMap<>();
        
        capitals.put("Alabama", new Capital("Montgomery",205000,156));
        capitals.put("Alaska", new Capital("Juneau",31000,3255));
        capitals.put("Arizona", new Capital("Phoenix",1445000,517));
        capitals.put("Arkansas", new Capital("Little Rock",193000,116));
        
        System.out.println("STATE/CAPITAL PAIRS:");
        System.out.println("====================");
        
        Set<String> keys = capitals.keySet();
        
        for (String k : keys){
            System.out.println(k+" - "+capitals.get(k).getName()+" | Pop: "+
                    capitals.get(k).getPopulation()+" | Area: "+
                    capitals.get(k).getArea()+" sq mi");
        }
        
        Scanner s = new Scanner(System.in);
        System.out.print("\nPlease enter the lower limit for capital city population: ");
        int min = s.nextInt();
        
        System.out.println("\nLISTING CAPITALS WITH POPULATIONS GREATER THAN "+min+":\n");
        
        for (String k : keys){
            if (capitals.get(k).getPopulation()> min){
                System.out.println(k+" - "+capitals.get(k).getName()+" | Pop: "+
                    capitals.get(k).getPopulation()+" | Area: "+
                    capitals.get(k).getArea()+" sq mi");
            }
        }
    }
}
