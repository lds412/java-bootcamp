/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.addressbook.dao;

import com.lds.addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lydia
 */
public class AddressBookDaoFileImpl implements AddressBookDao {

    public static final String ADDRESS_FILE = "addresses.txt";
    public static final String DELIMITER = "::";

    private Map<String, Address> addresses = new HashMap<>();

    @Override
    public Address addAddress(String lastName, Address address)
            throws AddressBookDaoException {
        loadAddresses();
        Address newAddress = addresses.put(lastName, address);
        writeAddresses();
        return newAddress;
    }

    @Override
    public Address removeAddress(String lastName) throws AddressBookDaoException {
        loadAddresses();
        Address removedAddress = addresses.remove(lastName);
        writeAddresses();
        return removedAddress;
    }

    @Override
    public int checkBookLength() throws AddressBookDaoException {
        loadAddresses();
        return addresses.size();
    }

    @Override
    public List<Address> listAllAddresses() throws AddressBookDaoException {
        loadAddresses();
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public Address findAddress(String lastName) throws AddressBookDaoException {
        loadAddresses();
        return addresses.get(lastName);
    }

    private Address unmarshallAddress(String addressAsText) {
        String[] addressTokens = addressAsText.split(DELIMITER);
        String lastName = addressTokens[0];
        Address addressFromFile = new Address(lastName);

        // Index 1 - FirstName
        addressFromFile.setFirstName(addressTokens[1]);

        // Index 2 - streetAddress
        addressFromFile.setStreetAddress(addressTokens[2]);

        // Index 3 - city
        addressFromFile.setCity(addressTokens[3]);

        //Index 4 - state
        addressFromFile.setState(addressTokens[4]);

        //Index 5 - zip
        addressFromFile.setZip(addressTokens[5]);

        // We have now created a student! Return it!
        return addressFromFile;
    }

    private void loadAddresses() throws AddressBookDaoException {
        Scanner s;

        try {
            s = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException(
                    "-_- Could not load address book into memory.", e);
        }

        String currentLine;
        Address currentAddress;

        while (s.hasNextLine()) {
            // get the next line in the file
            currentLine = s.nextLine();
            // unmarshall the line into a Student
            currentAddress = unmarshallAddress(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            addresses.put(currentAddress.getLastName(), currentAddress);
        }
        // close scanner
        s.close();
    }

    private String marshallAddress(Address anAddress) {

        String addressAsText = anAddress.getLastName() + DELIMITER;
        addressAsText += anAddress.getFirstName() + DELIMITER;
        addressAsText += anAddress.getStreetAddress() + DELIMITER;
        addressAsText += anAddress.getCity() + DELIMITER;
        addressAsText += anAddress.getState() + DELIMITER;
        addressAsText += anAddress.getZip();
        return addressAsText;
    }

    /**
     * Writes all addresses in book out to an ADDRESS_FILE. See loadAddresses
     * for file format.
     *
     * @throws AddressBookDaoException if an error occurs writing to the file
     */
    private void writeAddresses() throws AddressBookDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new AddressBookDaoException(
                    "Could not save address data.", e);
        }

        String addressAsText;
        List<Address> addressList = this.listAllAddresses();
        for (Address currentAddress : addressList) {
            addressAsText = marshallAddress(currentAddress);
            out.println(addressAsText);
            out.flush();
        }
        out.close();
    }

}
