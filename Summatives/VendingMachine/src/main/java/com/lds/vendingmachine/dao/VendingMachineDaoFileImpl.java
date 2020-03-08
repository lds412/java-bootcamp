/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.dao;

import com.lds.vendingmachine.dto.FoodItem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lydia
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    public static final String FOOD_FILE = "fooditems.txt";
    public static final String DELIMITER = "::";

    private Map<String, FoodItem> items = new HashMap<>();

    @Override 
    public List<FoodItem> getAllFoodItems() 
            throws VendingMachinePersistenceException{
        
        loadFoodItems();
        return new ArrayList<FoodItem>(items.values());
    }

    @Override 
    public FoodItem getFoodItem(String letter) throws 
            VendingMachinePersistenceException {
        
        loadFoodItems();
        FoodItem item = items.get(letter.toUpperCase());
        return item;
    }

    @Override
    public void subtractQty(FoodItem foodItem) throws 
            VendingMachinePersistenceException{
        
        int amt = foodItem.getFoodQty();
        foodItem.setFoodQty(amt - 1);
        writeItems();
    }

    private FoodItem unmarshallFood(String itemAsText) {
        String[] foodTokens = itemAsText.split(DELIMITER);
        String letter = foodTokens[0];
        FoodItem itemFromFile = new FoodItem(letter);

        itemFromFile.setFoodName(foodTokens[1]);
        BigDecimal price = new BigDecimal(foodTokens[2]);
        itemFromFile.setFoodPrice(price);
        itemFromFile.setFoodQty(Integer.parseInt(foodTokens[3]));

        return itemFromFile;
    }

    private void loadFoodItems() throws VendingMachinePersistenceException {
        
        Scanner s;

        try {
            s = new Scanner(new BufferedReader(new FileReader(FOOD_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("-_- Could not load"
                    + " vending machine data into memory.", e);
        }

        String currentLine;
        FoodItem currentItem;

        while (s.hasNextLine()) {
            currentLine = s.nextLine();
            currentItem = unmarshallFood(currentLine);
            items.put(currentItem.getFoodLetter().toUpperCase(), currentItem);
        }
        s.close();
    }

    private String marshallItem(FoodItem anItem) {

        String foodAsText = anItem.getFoodLetter() + DELIMITER;
        foodAsText += anItem.getFoodName() + DELIMITER;
        foodAsText += anItem.getFoodPrice() + DELIMITER;
        foodAsText += anItem.getFoodQty();

        return foodAsText;
    }

    private void writeItems() throws VendingMachinePersistenceException {
        
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(FOOD_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not save "
                    + "vending machine data.", e);
        }

        String foodAsText;
        List<FoodItem> foodList = this.getAllFoodItems();
        for (FoodItem currentItem : foodList) {
            foodAsText = marshallItem(currentItem);
            out.println(foodAsText);
            out.flush();
        }
        out.close();
    }

}
