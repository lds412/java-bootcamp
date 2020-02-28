/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.addressbook.controller;

import com.lds.addressbook.dao.AddressBookDao;
import com.lds.addressbook.dao.AddressBookDaoException;
import com.lds.addressbook.dao.AddressBookDaoFileImpl;
import com.lds.addressbook.dto.Address;
import com.lds.addressbook.ui.AddressBookView;
import java.util.List;

/**
 *
 * @author lydia
 */
public class AddressBookController {

    AddressBookView view;
    AddressBookDao dao;

    public AddressBookController(AddressBookView view, AddressBookDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        String menuSelection;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case "1":
                        addAddress();
                        break;
                    case "2":
                        removeAddress();
                        break;
                    case "3":
                        findAddress();
                        break;
                    case "4":
                        displayAddressCount();
                        break;
                    case "5":
                        listAddresses();
                        break;
                    case "6":
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private String getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addAddress() throws AddressBookDaoException {
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayAddSuccessBanner();
    }

    private void listAddresses() throws AddressBookDaoException {
        List<Address> addressList = dao.listAllAddresses();
        view.displayAddressList(addressList);
    }

    private void findAddress() throws AddressBookDaoException {
        String lastName = view.findAddressByLastName();
        Address address = dao.findAddress(lastName);
        view.displayAddress(address);
        view.genericEndMessage();
    }

    private void removeAddress() throws AddressBookDaoException {
        String lastName = view.removeAddressByLastName();
        Address address = dao.findAddress(lastName);
        view.displayAddress(address);
        if (view.reallyDelete()) {
            dao.removeAddress(lastName);
            view.displayRemoveSuccessBanner();
        } else {
            view.deleteAborted();
        }
    }

    private void displayAddressCount() throws AddressBookDaoException {
        int bookLength = dao.checkBookLength();
        view.displayAddressCount(bookLength);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
