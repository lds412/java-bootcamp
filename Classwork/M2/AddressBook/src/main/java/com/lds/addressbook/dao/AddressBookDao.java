/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.addressbook.dao;

import com.lds.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author lydia
 */
public interface AddressBookDao {

    /**
     * Adds the given Address to the roster and associates it with the given
     * last name. If there is already an address associated with the given last
     * name it will return that address object, otherwise it will return null.
     *
     * @param lastName by which an address is identified
     * @param address address to be added to the book
     * @return the Address object previously associated with the given last
     * name if it exists, null otherwise
     */
    Address addAddress(String lastName, Address address);
    //throws AddressBookDaoException;
    
    /**
     * Removes from the roster the address associated with the given last name. 
     * Returns the address object that is being removed or null if there is no 
     * address associated with the given last name
     *
     * @param lastName last name of person to be removed from address book
     * @return Address object that was removed or null if no address was
     * associated with the given last name
     */
    Address removeAddress(String lastName); //throws AddressBookDaoException;
    
    /**
     * Returns an int representing the number of addresses in the address book
     *
     * @return int representing the number of addresses in the address book
     */
    int checkBookLength();
    
    /**
     * Returns a String array containing all the addresses in the address book.
     *
     * @return String array containing all the addresses in the address book
     */
    List<Address> listAllAddresses(); //throws AddressBookDaoException;
    
    /**
     * Returns the student object associated with the given student id. Returns 
     * null if no such student exists
     *
     * @param lastName last name associated with address to retrieve
     * @return the Address object associated with the given last name, null if
     * no such address exists
     */
    Address findAddress(String lastName); //throws AddressBookDaoException;
}
