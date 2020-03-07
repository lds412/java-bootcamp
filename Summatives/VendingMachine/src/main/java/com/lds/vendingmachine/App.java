/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine;

import com.lds.vendingmachine.controller.VendingMachineController;
import com.lds.vendingmachine.dao.VendingMachineAuditDao;
import com.lds.vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import com.lds.vendingmachine.dao.VendingMachineDao;
import com.lds.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.lds.vendingmachine.service.VendingMachineServiceLayer;
import com.lds.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.lds.vendingmachine.ui.UserIO;
import com.lds.vendingmachine.ui.UserIOConsoleImpl;
import com.lds.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author lydia
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        VendingMachineView myView = new VendingMachineView(myIo);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
        VendingMachineController controller = new VendingMachineController(myService, myView);
        controller.run();
    }
}
