/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.myinheritance;

/**
 *
 * @author lydia
 */
public class Contractor extends Person implements Payable{
    private boolean permanent;
    private double hourlyRate;
    
    //This is for testing 
    public static void main(String[] args) {
        Address a1 = new Address("1313 Como Ave SE", "Minneapolis", "55414");
        Contractor c1 = new Contractor("Lydia", 28, a1, true, 28);
        
        System.out.println(c1);
    }
    
    public Contractor(String name, int age, Address address, boolean permanent, double hourlyRate){
        super(name, age, address);
        this.permanent = permanent;
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nPermanent: "+permanent+"\nHourly Rate: $"+hourlyRate;
    }

    @Override
    public double calculateWeeklyPay() {
        return hourlyRate*40;
    }
}
