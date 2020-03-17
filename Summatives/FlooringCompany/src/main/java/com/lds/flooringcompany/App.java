/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany;

import com.lds.flooringcompany.controller.FlooringCompanyController;
import com.lds.flooringcompany.dao.FlooringCompanyDao;
import com.lds.flooringcompany.dao.FlooringCompanyDaoFileImpl;
import com.lds.flooringcompany.service.FlooringCompanyServiceLayer;
import com.lds.flooringcompany.service.FlooringCompanyServiceLayerImpl;
import com.lds.flooringcompany.ui.FlooringCompanyView;
import com.lds.flooringcompany.ui.UserIO;
import com.lds.flooringcompany.ui.UserIOConsoleImpl;

/**
 *
 * @author lydia
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        FlooringCompanyView myView = new FlooringCompanyView(myIo);
        FlooringCompanyDao myDao = new FlooringCompanyDaoFileImpl();
        FlooringCompanyServiceLayer myService = new FlooringCompanyServiceLayerImpl(myDao);
        FlooringCompanyController controller = new FlooringCompanyController(myService, myView);

        controller.run();
       
    }
}
