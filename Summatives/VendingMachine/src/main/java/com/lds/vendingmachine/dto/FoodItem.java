/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author lydia
 */
public class FoodItem {
    
    private String foodLetter;
    private String foodName;
    private BigDecimal foodPrice;
    private int foodQty;

    public FoodItem(String foodLetter) {
        this.foodLetter = foodLetter;
    }

    public String getFoodLetter() {
        return foodLetter;
    }

    public String getFoodName() {
        return foodName;
    }

    public BigDecimal getFoodPrice() {
        return foodPrice;
    }

    public int getFoodQty() {
        return foodQty;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodPrice(BigDecimal foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setFoodQty(int foodQty) {
        this.foodQty = foodQty;
    }
    
}
