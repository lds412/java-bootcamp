/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.dao;

import com.lds.vendingmachine.dto.FoodItem;
import java.util.List;

/**
 *
 * @author lydia
 */
public interface VendingMachineDao {

    /**
     * Returns a String array containing the letters of all items in the vending
     * machine.
     *
     * @return String array containing the letters of all the items in the
     * vending machine
     * @throws com.lds.vendingmachine.dao.VendingMachinePersistenceException
     */
    List<FoodItem> getAllFoodItems() throws 
            VendingMachinePersistenceException;

    /**
     * Returns the food object associated with the given letter.
     *
     * @param letter of the item to retrieve
     * @return the FoodItem object associated with the given letter
     * @throws com.lds.vendingmachine.dao.VendingMachinePersistenceException
     */
    FoodItem getFoodItem(String letter) throws 
            VendingMachinePersistenceException;
    
    void subtractQty(FoodItem foodItem) throws 
            VendingMachinePersistenceException;
}
