/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.service;

import com.lds.vendingmachine.dto.FoodItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author lydia
 */
public interface VendingMachineServiceLayer {
    
    List<FoodItem> getAllItems();
    
    FoodItem getFoodItem(String letter);
    
    Change makeChange(BigDecimal money);
}
