/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.service;

import com.lds.vendingmachine.dao.VendingMachinePersistenceException;
import com.lds.vendingmachine.dto.FoodItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author lydia
 */
public interface VendingMachineServiceLayer {
    
    List<FoodItem> getAllItems() throws 
            VendingMachinePersistenceException;
    
    FoodItem getFoodItem(String letter) throws 
            VendingMachinePersistenceException, 
            NoItemInInventoryException,
            InvalidChoiceException;
    
    void subtractQtyAndLog(FoodItem foodItem) throws 
            VendingMachinePersistenceException;
    
    void enoughMoney(BigDecimal money, BigDecimal price) throws
            InsufficientFundsException;
    
    Change makeChange(BigDecimal money);
    
    int[] returnChange(BigDecimal money);
}
