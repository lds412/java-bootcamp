/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.addressbook.ui;

import com.lds.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author lydia
 */
public class AddressBookView {

    UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public String printMenuAndGetSelection() {
        io.print("\t==========");
        io.print("Initial Menu:");
        io.print("\t1. Add Address");
        io.print("\t2. Delete Address");
        io.print("\t3. Find Address");
        io.print("\t4. Display Address Count");
        io.print("\t5. List All Addresses");
        io.print("\t6. Exit"); //Take this out??

        //return io.readInt("Please select from the above choices: ", 1, 6);
        return io.readString("Please select from the above choices: ");
    }

    public Address getNewAddressInfo() {
        io.print("\nAdd Address Menu:");
        String firstName = io.readString("\tPlease enter First Name: ");
        String lastName = io.readString("\tPlease enter Last Name: ");
        String streetAddress = io.readString("\tPlease enter Street Address: ");
        String city = io.readString("\tPlease enter City: ");
        String state = io.readString("\tPlease enter State (abbr): ");
        String zip = io.readString("\tPlease enter Zip Code: ");
        Address currentAddress = new Address(lastName);
        currentAddress.setFirstName(firstName);
        currentAddress.setStreetAddress(streetAddress);
        currentAddress.setCity(city);
        currentAddress.setState(state);
        currentAddress.setZip(zip);
        return currentAddress;
    }

    public void displayAddSuccessBanner() {
        io.readString(
                "\tAddress added. Press 1 to go to Main Menu. ");
    }

    public void displayAddressList(List<Address> addressList) {
        io.print("\nList Addresses Menu:");
        for (Address currentAddress : addressList) {
            io.print("\t" + currentAddress.getFirstName() + " "
                    + currentAddress.getLastName());
            io.print("\t" + currentAddress.getStreetAddress());
            io.print("\t" + currentAddress.getCity() + ", "
                    + currentAddress.getState() + " "
                    + currentAddress.getZip() + "\n");
        }
        io.readString("\tPress 1 to go to Main Menu. ");
    }
    
    public void genericEndMessage(){
        io.readString("\tPress 1 to go to Main Menu. ");
    }

    public String findAddressByLastName() {
        io.print("\nFind Address Menu:");
        return io.readString("\tPlease enter last name of address to find: ");
    }

    public String removeAddressByLastName() {
        io.print("\nDelete Address Menu:");
        return io.readString("\tPlease enter last name of address to delete: ");
    }

    public boolean reallyDelete() {
        boolean valid = false;
        while (!valid) {
            String ans = io.readString("\tReally Delete? (y/n): ");
            if (ans.equals("y")) {
                return true;
            } else if (ans.equals("n")) {
                return false;
            } else {
                displayUnknownCommandBanner();
            }
        }
        return false; //Just to make IDE happy
    }
    
    public void deleteAborted(){
        io.readString("\tDelete Aborted. Press 1 to go to Main Menu. ");
    }

    public void displayAddress(Address address) {
        if (address != null) {
            io.print("\n\t" + address.getFirstName() + " "
                    + address.getLastName());
            io.print("\t" + address.getStreetAddress());
            io.print("\t" + address.getCity() + ", "
                    + address.getState() + " "
                    + address.getZip() + "\n");
        } else {
            io.print("\tNo such address.");
        }
    }

    public void displayRemoveSuccessBanner() {
        io.readString("\tAddress Deleted. Press 1 to go to Main Menu. ");
    }

    public void displayAddressCount(int length) {
        io.print("\nList Address Count Menu:");
        io.readString("\t There are " + length
                + " addresses in the book. Press 1 to go to Main Menu. ");
    }

    public void displayExitBanner() {
        io.print("\nGood Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
