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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author lydia
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    public static final String FOOD_FILE = "fooditems.txt";
    public static final String DELIMITER = "::";

    private Map<String, FoodItem> items = new HashMap<>();

    @Override //Eventually get rid of try-catch
    public List<FoodItem> getAllFoodItems() {
        try {
            loadFoodItems();
        } catch (FileNotFoundException ex) {
            
        }
        //return new ArrayList<FoodItem>(items.values());
        return items.values()
                .stream()
                .filter(f -> f.getFoodQty() > 0)
                .collect(Collectors.toList());
    }

    @Override //Eventually get rid of try-catch
    public FoodItem getFoodItem(String letter) {
        try {
            loadFoodItems();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        }
        FoodItem item = items.get(letter.toUpperCase());
        int amt = item.getFoodQty();
        //if(amt > 0){
            item.setFoodQty(amt - 1);
        try {
            writeItems();
        } catch (IOException ex) {
            System.out.println("IO Exception");
        }
            return item;
        //} else{
        //    return null;
        //}
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

    //EXCEPTION??? (remember try-catch
    private void loadFoodItems() throws FileNotFoundException{
        Scanner s;

        s = new Scanner(new BufferedReader(new FileReader(FOOD_FILE)));

        String currentLine;
        FoodItem currentItem;

        while (s.hasNextLine()) {
            // get the next line in the file
            currentLine = s.nextLine();
            // unmarshall the line into a Student
            currentItem = unmarshallFood(currentLine);

            // We are going to use the title as the map key for our dvd object.
            // Put currentDvd into the map using title as the key
            items.put(currentItem.getFoodLetter().toUpperCase(), currentItem);
        }
        // close scanner
        s.close();
    }

    private String marshallItem(FoodItem anItem) {

        String foodAsText = anItem.getFoodLetter() + DELIMITER;
        foodAsText += anItem.getFoodName() + DELIMITER;
        foodAsText += anItem.getFoodPrice() + DELIMITER;
        foodAsText += anItem.getFoodQty();
        
        return foodAsText;
    }

    /**
     * Writes all items in library out to a FOOD_FILE. See loadItems for file
     * format.
     *
     */
    private void writeItems() throws IOException {
        PrintWriter out;

        out = new PrintWriter(new FileWriter(FOOD_FILE));

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
