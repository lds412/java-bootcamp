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
public class CarInventory {
    
    //This is for testing
    public static void main(String[] args) {
        CarInventory car = new CarInventory("1HGBH41JXMN109186", false);
        System.out.println("Is this car used? "+car.isUsed); //This works because we are in the same class. 
        System.out.println("I'm going to buy it!");
        car.setUsedStatus(true);
        System.out.println("One year later . . .");
        System.out.println("Is this car used? "+ car.getUsedStatus());
        
    }

    private String vin;
    private boolean isUsed;

    public CarInventory(String vin, boolean isUsed) {
        this.vin = vin;
        this.isUsed = isUsed;
    }

    public String getVin() {
        return vin;
    }
    
    public boolean getUsedStatus(){
        return isUsed;
    }
    
    public void setVin(String vin){
        this.vin = vin;
    }
    
    public void setUsedStatus(boolean isUsed){
        this.isUsed = isUsed;
    }
}
