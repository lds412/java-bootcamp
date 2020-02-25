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
public class Person implements Comparable{
    protected String name;
    protected int age;
    protected Address address;

    //This is for testing 
    public static void main(String[] args) {
        Address a1 = new Address("1313 Como Ave SE", "Minneapolis", "55414");
        Person p1 = new Person("Lydia", 28, a1);

        System.out.println(p1);
    }

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", " + age + "\n" + address;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        if (this.getAge() > p.getAge()) {
            return 1;
        } else if (this.getAge() < p.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}
