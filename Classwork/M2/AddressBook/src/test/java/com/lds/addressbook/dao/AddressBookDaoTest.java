/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.addressbook.dao;

import com.lds.addressbook.dto.Address;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lydia
 */
public class AddressBookDaoTest {

    private AddressBookDao dao = new AddressBookDaoFileImpl();

    public AddressBookDaoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        List<Address> addressList = dao.listAllAddresses();
        for (Address address : addressList) {
            dao.removeAddress(address.getLastName());
        }
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addAddress method, of class AddressBookDao.
     */
    @Test
    public void testAddGetAddress() throws Exception {
        Address address = new Address("Smith");
        address.setFirstName("Jane");
        address.setStreetAddress("123 Pleasant Rd");
        address.setCity("Minneapolis");
        address.setState("MN");
        address.setZip("55414");

        dao.addAddress(address.getLastName(), address);

        Address fromDao = dao.findAddress(address.getLastName());

        assertEquals(address, fromDao);
    }

    /**
     * Test of removeAddress method, of class AddressBookDao.
     */
    @Test
    public void testRemoveAddress() throws Exception {
        Address address1 = new Address("Smith");
        address1.setFirstName("Jane");
        address1.setStreetAddress("123 Pleasant Rd");
        address1.setCity("Minneapolis");
        address1.setState("MN");
        address1.setZip("55414");

        dao.addAddress(address1.getLastName(), address1);

        Address address2 = new Address("Doe");
        address2.setFirstName("Jen");
        address2.setStreetAddress("345 Honest Rd");
        address2.setCity("Minneapolis");
        address2.setState("MN");
        address2.setZip("55413");

        dao.addAddress(address2.getLastName(), address2);

        dao.removeAddress(address1.getLastName());
        assertEquals(1, dao.listAllAddresses().size());
        assertNull(dao.findAddress(address1.getLastName()));

        dao.removeAddress(address2.getLastName());
        assertEquals(0, dao.listAllAddresses().size());
        assertNull(dao.findAddress(address2.getLastName()));
    }

    /**
     * Test of checkBookLength method, of class AddressBookDao.
     */
    @Test
    public void testCheckBookLength() throws Exception {
        Address address1 = new Address("Smith");
        address1.setFirstName("Jane");
        address1.setStreetAddress("123 Pleasant Rd");
        address1.setCity("Minneapolis");
        address1.setState("MN");
        address1.setZip("55414");

        dao.addAddress(address1.getLastName(), address1);
        
        assertEquals(1, dao.checkBookLength());

        Address address2 = new Address("Doe");
        address2.setFirstName("Jen");
        address2.setStreetAddress("345 Honest Rd");
        address2.setCity("Minneapolis");
        address2.setState("MN");
        address2.setZip("55413");

        dao.addAddress(address2.getLastName(), address2);
        
        assertEquals(2, dao.checkBookLength());
    }

    /**
     * Test of listAllAddresses method, of class AddressBookDao.
     */
    @Test
    public void testListAllAddresses() throws Exception {
        Address address1 = new Address("Smith");
        address1.setFirstName("Jane");
        address1.setStreetAddress("123 Pleasant Rd");
        address1.setCity("Minneapolis");
        address1.setState("MN");
        address1.setZip("55414");

        dao.addAddress(address1.getLastName(), address1);

        Address address2 = new Address("Doe");
        address2.setFirstName("Jen");
        address2.setStreetAddress("345 Honest Rd");
        address2.setCity("Minneapolis");
        address2.setState("MN");
        address2.setZip("55413");

        dao.addAddress(address2.getLastName(), address2);

        assertEquals(2, dao.listAllAddresses().size());
    }

}
