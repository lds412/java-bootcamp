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
public class PayableTest {

    public static void main(String[] args) {

        Address a2 = new Address("28 Paget Rd", "Madison", "53704");
        Employee e1 = new Employee("Jane", 14, a2, 60000);

        Address a3 = new Address("323 E Johnson St", "Madison", "53703");
        Contractor c1 = new Contractor("Bob", 34, a3, true, 28);

        Payable[] payableArray = {e1, c1};
        
        printPayables(payableArray);
        
    }
    public static void printPayables(Payable[] PA) {
        for (Payable p : PA) {
            System.out.println("$"+p.calculateWeeklyPay());
        }
    }
}
