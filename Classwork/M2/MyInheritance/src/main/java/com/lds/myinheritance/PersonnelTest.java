/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.myinheritance;

import java.util.Arrays;

/**
 *
 * @author lydia
 */
public class PersonnelTest {

    public static void main(String[] args) {
        Address a1 = new Address("1313 Como Ave SE", "Minneapolis", "55414");
        Person p1 = new Person("Lydia", 28, a1);

        Address a2 = new Address("28 Paget Rd", "Madison", "53704");
        Employee e1 = new Employee("Jane", 14, a2, 60000);

        Address a3 = new Address("323 E Johnson St", "Madison", "53703");
        Contractor c1 = new Contractor("Bob", 34, a3, true, 28);

        Person[] PeopleArray = new Person[0];
        
        PeopleArray = add(PeopleArray, p1); //May want to rewrite this method??
        PeopleArray = add(PeopleArray, e1); //(So it works as method, not function)
        PeopleArray = add(PeopleArray, c1);
        
        printPerson(PeopleArray);
        
        Arrays.sort(PeopleArray);
        printPerson(PeopleArray);
    }

    public static Person[] add(Person[] PA, Person p) {
        int newLength = PA.length + 1;
        Person[] PA2 = new Person[newLength];
        int i = 0;
        for (Person ele : PA) {
            PA2[i] = ele;
            i++;
        }
        PA2[newLength - 1] = p;
        return PA2;
    }
    
    public static void printPerson(Person[] PA) {
        for (Person ele : PA) {
            System.out.println(ele);
            System.out.println("");
        }
    }
}
