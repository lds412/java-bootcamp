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
public class CarVR {
    //This is for testing
    public static void main(String[] args) {
        CarVR fastCar = new CarVR("red", "Honda");
        System.out.println("You have chosen a "+fastCar.getColor()+" "+fastCar.getType());
        fastCar.accelorate();
    }
    
    private String color;
    private String type;
    
    public CarVR(String carColor, String carType){
        this.color = carColor;
        this.type = carType;
    }
    
    public String getColor(){
        return color;
    }
    
    public String getType(){
        return type;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public void accelorate(){
        System.out.println("VROOOOOOOOOOOOOOOM");
    }
}
