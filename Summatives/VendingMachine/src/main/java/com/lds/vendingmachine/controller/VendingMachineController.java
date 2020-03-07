/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.controller;

import com.lds.vendingmachine.dto.FoodItem;
import com.lds.vendingmachine.service.Change;
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
        while (keepGoing) {

            List<FoodItem> foodList = service.getAllItems();

            view.displayFoodItems(foodList);

            String exitOrContinue = view.askExitOrContinue(money);

            if (exitOrContinue.equalsIgnoreCase("q")) {

                keepGoing = false;

            } else {
                money = money.add(view.getMoney());
                //view.displayFoodItems(foodList);
                String menuSelection = view.getSelection(money);
                FoodItem foodItem = service.getFoodItem(menuSelection);
                if (enoughMoney(money, foodItem.getFoodPrice())) {
                    money = money.subtract(foodItem.getFoodPrice());
                    view.displayFoodItem(foodItem, money);
                    //update inventory and log?
                } else {
                    view.displayNotEnoughMoneyMessage();
                }
            }
            if(money.compareTo(BigDecimal.ZERO) > 0){ 
                returnChange(money);
                money = BigDecimal.ZERO;
            }
        }
        view.displayExitMessage();
    }

    private boolean enoughMoney(BigDecimal money, BigDecimal price) {
        return money.compareTo(price) >= 0;
    }
    
    private void returnChange(BigDecimal money){
        int q = 0; 
        int d = 0; 
        int n = 0; 
        int p = 0;
        
        BigDecimal quart = new BigDecimal("0.25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nick = new BigDecimal("0.05");
        BigDecimal pen = new BigDecimal("0.01");
        
        while(money.compareTo(BigDecimal.ZERO) > 0){
            Change coin = service.makeChange(money);
            switch(coin){
                case Q:
                    q++;
                    money = money.subtract(quart);
                    break;
                case D:
                    d++;
                    money = money.subtract(dime);
                    break;
                case N:
                    n++;
                    money = money.subtract(nick);
                    break;
                default:
                    p++;
                    money = money.subtract(pen);
            }
        }
        
        view.depositChange(q, d, n, p);
    }
}
