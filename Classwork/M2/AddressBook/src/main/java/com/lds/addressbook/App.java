/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.addressbook;

import com.lds.addressbook.controller.AddressBookController;
import com.lds.addressbook.dao.AddressBookDao;
import com.lds.addressbook.dao.AddressBookDaoFileImpl;
import com.lds.addressbook.ui.AddressBookView;
import com.lds.addressbook.ui.UserIO;
import com.lds.addressbook.ui.UserIOConsoleImpl;

/**
 *
 * @author lydia
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao = new AddressBookDaoFileImpl();
        AddressBookController controller = new AddressBookController(myView, myDao);
        controller.run();
    }
}
