/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.addressbook.dao;

import com.lds.addressbook.dto.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lydia
 */
public class AddressBookDaoFileImpl implements AddressBookDao {

    private Map<String, Address> addresses = new HashMap<>();

    @Override
    public Address addAddress(String lastName, Address address) {
        Address newAddress = addresses.put(lastName, address);
        return newAddress;
    }

    @Override
    public Address removeAddress(String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int checkBookLength() {
        return addresses.size();
    }

    @Override
    public List<Address> listAllAddresses() {
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public Address findAddress(String lastName) {
        return addresses.get(lastName);
    }

}
