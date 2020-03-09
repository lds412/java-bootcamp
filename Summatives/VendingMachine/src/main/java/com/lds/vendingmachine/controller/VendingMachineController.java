/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.controller;

import com.lds.vendingmachine.dao.VendingMachinePersistenceException;
import com.lds.vendingmachine.dto.FoodItem;
import com.lds.vendingmachine.service.InsufficientFundsException;
import com.lds.vendingmachine.service.InvalidChoiceException;
import com.lds.vendingmachine.service.NoItemInInventoryException;
import com.lds.vendingmachine.service.VendingMachineServiceLayer;
import com.lds.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author lydia
 */
public class VendingMachineController {

    VendingMachineView view;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        BigDecimal money = new BigDecimal("0");
        try {
            while (keepGoing) {
                boolean exit = false;
                do {
                    List<FoodItem> foodList = service.getAllItems();
                    view.displayFoodItems(foodList);
                    String exitOrContinue = view.askExitOrContinue(money);

                    if (exitOrContinue.equalsIgnoreCase("q")) {

                        keepGoing = false;
                        exit = true;

                    } else {
                        try {
                            money = money.add(view.getMoney());
                            String menuSelection = view.getSelection(money);
                            FoodItem foodItem = service.getFoodItem(menuSelection);
                            try {
                                service.enoughMoney(money, foodItem.getFoodPrice());
                                money = money.subtract(foodItem.getFoodPrice());
                                service.subtractQtyAndLog(foodItem);
                                view.displayFoodItem(foodItem, money);
                                exit = true;
                            } catch (InsufficientFundsException e) {
                                view.displayErrorMessage(e.getMessage());
                            }
                        } catch (InvalidChoiceException | NoItemInInventoryException e) {
                            view.displayErrorMessage(e.getMessage());
                        }
                    }
                } while (!exit);
                if (money.compareTo(BigDecimal.ZERO) > 0) {
                    returnChange(money);
                    money = BigDecimal.ZERO;
                }
            }
            view.displayExitMessage();
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void returnChange(BigDecimal money) {
        int[] coins = service.returnChange(money);
        view.depositChange(coins[0], coins[1], coins[2], coins[3]);
    }

}
