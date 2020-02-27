/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.addressbook.controller;

import com.lds.addressbook.dao.AddressBookDao;
import com.lds.addressbook.dao.AddressBookDaoFileImpl;
import com.lds.addressbook.dto.Address;
import com.lds.addressbook.ui.AddressBookView;
import java.util.List;

/**
 *
 * @author lydia
 */
public class AddressBookController {
    
    AddressBookView view = new AddressBookView();
    AddressBookDao dao = new AddressBookDaoFileImpl();
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        while(keepGoing){
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                    case 1:
                        addAddress();
                        break;
                    case 2:
                        removeAddress();
                        break;
                    case 3:
                        findAddress();
                        break;
                    case 4:
                        displayAddressCount();
                        break;
                    case 5:
                        listAddresses();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void addAddress() {
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayAddSuccessBanner();
    }

    private void listAddresses() {
        //view.displayDisplayAllBanner();
        List<Address> addressList = dao.listAllAddresses();
        view.displayAddressList(addressList);
    }

    private void findAddress() {
        String lastName = view.getLastNameChoice();
        Address address = dao.findAddress(lastName);
        view.displayAddress(address);
    }

    private void removeAddress() {
        view.displayRemoveAddressBanner();
        String lastName = view.getLastNameChoice();
        dao.removeAddress(lastName);
        view.displayRemoveSuccessBanner();
    }
    
    private void displayAddressCount(){
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
