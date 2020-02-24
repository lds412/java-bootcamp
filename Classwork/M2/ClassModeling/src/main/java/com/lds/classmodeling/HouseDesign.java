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
public class HouseDesign {
    
    //This is for testing
    public static void main(String[] args) {
        HouseDesign h = new HouseDesign(100, 2, 7);
        h.houseSize();
        h.setStories(4);
        h.houseSize();
        h.setRooms(4);
        h.houseSize();
    }

    private int sqFeet;
    private int numStories;
    private int numRooms;

    public HouseDesign(int sqFt, int stories, int rooms) {
        this.sqFeet = sqFt;
        this.numStories = stories;
        this.numRooms = rooms;
    }
    
    public int getFt(){
        return sqFeet;
    }
    
    public int getStories(){
        return numStories;
    }
    
    public int getRooms(){
        return numRooms;
    }
    
    public void setFt(int ft){
        this.sqFeet = ft;
    }
    
    public void setStories(int stories){
        this.numStories = stories;
    }
        
    public void setRooms(int rooms){
        this.numRooms = rooms;
    }
    
    public void houseSize(){
        boolean tallHouse = false;
        if (numStories > 2){
            System.out.println("That is a tall house!");
            tallHouse = true;
        }
        if(numRooms < 5 || sqFeet < 30){
            System.out.println("That is a pretty small house.");
        } else if (!tallHouse){
            System.out.println("Seems like an average-sized house.");
        }
    }

}
