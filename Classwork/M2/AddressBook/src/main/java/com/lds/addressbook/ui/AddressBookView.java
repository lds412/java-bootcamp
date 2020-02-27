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

    UserIO io = new UserIOConsoleImpl();

//    public AddressBookView(UserIO io) {
//        this.io = io;
//    }

    public int printMenuAndGetSelection() {
        io.print("Initial Menu:");
        io.print("\t1. Add Address");
        io.print("\t2. Delete Address");
        io.print("\t3. Find Address");
        io.print("\t4. Display Address Count");
        io.print("\t5. List All Addresses");
        io.print("\t6. Exit"); //Take this out??

        return io.readInt("Please select from the above choices: ", 1, 6);
    }

    public Address getNewAddressInfo() {
        io.print("Add Address Menu:");
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

//    public void displayAddAddressBanner() {
//        io.print("=== Add Address ===");
//    }
    public void displayAddSuccessBanner() {
        io.readString(
                "\tAddress added. Press 1 to go to Main Menu. ");
    }

    public void displayAddressList(List<Address> addressList) {
        io.print("List Addresses Menu:");
        for (Address currentAddress : addressList) {
            io.print(currentAddress.getFirstName() + " "
                    + currentAddress.getLastName());
            io.print(currentAddress.getStreetAddress());
            io.print(currentAddress.getCity() + ", "
                    + currentAddress.getState() + " "
                    + currentAddress.getZip() + "\n");
        }
        io.readString("Press 1 to go to Main Menu. ");
    }

//    public void displayDisplayAllBanner() {
//        io.print("=== Display All Students ===");
//    }

    public String getLastNameChoice() {
        return io.readString("Please enter last name of address to find: ");
    }

    public void displayAddress(Address address) {
        if (address != null) {
            io.print(address.getFirstName() + " "
                    + address.getLastName());
            io.print(address.getStreetAddress());
            io.print(address.getCity() + ", "
                    + address.getState() + " "
                    + address.getZip() + "\n");
        } else {
            io.print("No such address.");
        }
        io.readString("Press 1 to go to Main Menu. ");
    }

    public void displayRemoveAddressBanner() {
        io.print("=== Remove Address ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Address Deleted. Press 1 to go to Main Menu. ");
    }

    public void displayAddressCount(int length){
        io.print("List Address Count Menu:");
        io.readString("\t There are " + length
                + " addresses in the book. Press 1 to go to Main Menu. ");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
