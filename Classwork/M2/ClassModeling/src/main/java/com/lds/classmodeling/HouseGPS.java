/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.classmodeling;

/**
 *
 * @author lydia
 */
public class HouseGPS {
    //This is for testing
//    public static void main(String[] args) {
//        HouseGPS myPlace = new HouseGPS("Como Ave SE", 1313);
//        myPlace.printAddress();
//    }

    private String streetName;
    private int streetNum;
    
    public HouseGPS(String stName, int stNum){
        this.streetName = stName;
        this.streetNum = stNum;
    }
    
    public String getStreet(){
        return streetName;
    }
    
    public int getNum(){
        return streetNum;
    }
    
    public void setStreet(String street){
        this.streetName = street;
    }
    
    public void setNum(int num){
        this.streetNum = num;
    }
    
    public void printAddress(){
        System.out.println("This house is at "+streetNum+" "+streetName);
    }
}
