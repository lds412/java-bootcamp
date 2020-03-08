/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.ui;

import com.lds.vendingmachine.dto.FoodItem;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author lydia
 */
public class VendingMachineView {

    UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void displayFoodItems(List<FoodItem> foodList) {
        io.print("=====Vending Machine=====");
        for (FoodItem currentItem : foodList) {
            if (currentItem.getFoodQty() > 0) {
                io.print(currentItem.getFoodLetter() + ". "
                        + currentItem.getFoodName() + ": $"
                        + currentItem.getFoodPrice());
            } else{
                io.print(currentItem.getFoodLetter() + ". [OUT OF STOCK]");
            }
        }
    }

    public String askExitOrContinue(BigDecimal money) {
        io.print("\nCurrent balance: $" + money);
        io.print("\nEnter q to quit (your current balance will be refunded)");
        return io.readString("Or hit enter to continue. ");
    }

    public BigDecimal getMoney() {
        io.print("\nEnter additional cash if necessary, 0 otherwise.");
        return io.readBigDecimal("Additional cash: ", 2, RoundingMode.HALF_UP);
    }

    public String getSelection(BigDecimal money) {
        io.print("Current balance: $" + money);
        return io.readString("\nPlease select from the options above: ");
    }

    public void displayFoodItem(FoodItem foodItem, BigDecimal money) {
        io.print("You chose: " + foodItem.getFoodName() + "");
    }
    
    public void depositChange(int q, int d, int n, int p) {
        io.print("Please collect your change: ");
        if (q > 0) {
            io.print(q + " quarters");
        }
        if (d > 0) {
            io.print(d + " dimes");
        }
        if (n > 0) {
            io.print(n + " nickel");
        }
        if (p > 0) {
            io.print(p + " pennies");
        }
        io.print("");
    }

    public void displayExitMessage() {
        io.print("\nGood Bye!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("\n==== ERROR ====");
        io.print(errorMsg+"\n");
    }
}
