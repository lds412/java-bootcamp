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
            io.print(currentItem.getFoodLetter() + ". "
                    + currentItem.getFoodName() + ": $"
                    + currentItem.getFoodPrice());
        }
    }

    public String askExitOrContinue(BigDecimal money) {
        io.print("\nCurrent balance: $"+money);
        io.print("\nPress q to quit (your current balance will be refunded)");
        return io.readString("Press any other key to continue. ");
    }

    public BigDecimal getMoney() {
        //io.print("Current balance: $"+money);
        return io.readBigDecimal("\nEnter additional cash: ", 2, RoundingMode.HALF_UP);
    }

    public String getSelection(BigDecimal money) {
        io.print("Current balance: $"+money);
        return io.readString("\nPlease select from the options above: ");
    }
    
    public void displayFoodItem(FoodItem foodItem, BigDecimal money) {
        io.print("You chose: "+ foodItem.getFoodName()+"");
        io.print("Amount left: "+foodItem.getFoodQty());
        //io.print("Current balance: $"+money+"\n");
    }
    
    public void displayNotEnoughMoneyMessage(){
        io.print("\nInsufficient funds\n");
        //io.print("Current balance: $"+money+"\n");
    }
    
    public void depositChange(int q, int d, int n, int p){
        io.print("Please collect your change: ");
        if(q > 0){
            io.print(q + " quarters");
        }
        if(d > 0){
            io.print(d + " dimes");
        }
        if(n > 0){
            io.print(n + " nickels");
        }
        if(p > 0){
            io.print(p + " pennies");
        }
        io.print("");
    }
    
    public void displayExitMessage() {
        io.print("\nGood Bye!!!");
    }
}
