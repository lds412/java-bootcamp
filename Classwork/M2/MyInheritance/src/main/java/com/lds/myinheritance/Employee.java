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
public class Employee extends Person {

    private double salary;

    //This is for testing 
    public static void main(String[] args) {
        Address a1 = new Address("1313 Como Ave SE", "Minneapolis", "55414");
        Employee e1 = new Employee("Lydia", 28, a1, 60000);
        
        System.out.println(e1);
    }
    
    public Employee(String name, int age, Address address, double salary) {
        super(name, age, address);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return super.toString()+"\nSalary: $"+salary;
    }
}
