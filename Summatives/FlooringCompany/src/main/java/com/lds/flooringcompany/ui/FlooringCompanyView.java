/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.ui;

import com.lds.flooringcompany.dto.DelimiterInclusionException;
import com.lds.flooringcompany.dto.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lydia
 */
public class FlooringCompanyView {

    UserIO io;

    public FlooringCompanyView(UserIO io) {
        this.io = io;
    }

    public void displayTrainingMode() {
        //io.print("    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        io.print("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        //io.print("    *");
        io.print("    * TRAINING MODE");
        io.print("    * Any new or modified data will NOT be saved upon exiting the program.");
        //io.print("    *");
    }

    public void displayProdMode() {
        //io.print("    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        io.print("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        io.print("    * PROD MODE");
        io.print("    * Any new or modified data that has been saved will persist "
                + "upon exiting the program.");
        //io.print("    *");
    }

    public String printMenuAndGetSelection() {
        io.print("    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        io.print("* * * *");
        io.print("    *  <<Flooring Program>>");
        io.print("    * 1. Display Orders");
        io.print("    * 2. Add an Order");
        io.print("    * 3. Edit an Order");
        io.print("    * 4. Remove an Order");
        io.print("    * 5. Save Current Work");
        io.print("    * 6. Quit");
        io.print("    *");
        io.print("    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        io.print("* * * *");

        //Change to io.readInt??
        return io.readString("Please select from the above choices: ");
    }

    public Order getNewOrderInfo(List<Order> orderList) throws DelimiterInclusionException {
        io.print("\nAdd Order:");

        Order currentOrder = new Order(orderList.size() + 1);
        currentOrder.setOrderDate();

        String name = io.readString("Please enter customer name: ");
        currentOrder.setCustomerName(name);

        String state = io.readString("Please enter state (abbr): ");
        currentOrder.setState(state);

        String product = io.readString("Please enter product type: ");
        currentOrder.setProductType(product);

        BigDecimal area = io.readBigDecimal("Please enter area: ", 2, RoundingMode.HALF_UP);
        currentOrder.setArea(area);

        //THIS CODE MAKES SURE A VALUE IS ENTERED
//        boolean valid = false;
//        while (!valid) {
//            if (title.equals("N/A")) {
//                io.print("\t Please enter a value.");
//                title = io.readString("\tTitle: ");
//            } else {
//                valid = true;
//            }
//        }
        return currentOrder;

    }

    public boolean confirmCommand(String command) {
        while (true) {
            String ans = io.readString("Are you sure you would like to "
                    + command + " this order (y/n)? ");
            if (ans.equalsIgnoreCase("y")) {
                return true;
            } else if (ans.equalsIgnoreCase("n")) {
                return false;
            } else {
                displayUnknownCommand();
            }
        }
    }

    public Order editOrder(Order order) throws DelimiterInclusionException {

        Order editedOrder = new Order(0);

        editedOrder.setOrderDate(order.getOrderDate());

        String name = order.getCustomerName();
        String state = order.getState();
        String product = order.getProductType();
        BigDecimal area = order.getArea();

        io.print("Enter the information requested "
                + "or hit enter if the given information is correct.");

        String userName = io.readString("Enter customer name (" + name + "): ");
        if (userName.equalsIgnoreCase("N/A")) {
            //order.setCustomerName(userName);
            editedOrder.setCustomerName(name);
        } else {
            editedOrder.setCustomerName(userName);
        }
        String userState = io.readString("Enter state (" + state + "): ");
        if (userState.equalsIgnoreCase("N/A")) {
            //order.setState(userState);
            editedOrder.setState(state);
        } else {
            editedOrder.setState(userState);
        }
        String userProduct = io.readString("Enter product type (" + product + "): ");
        if (userProduct.equalsIgnoreCase("N/A")) {
            //order.setProductType(userProduct);
            editedOrder.setProductType(product);
        } else {
            editedOrder.setProductType(userProduct);
        }

        boolean validBD = false;
        while (!validBD) {
            String userArea = io.readString("Enter area (" + area + "): ");
            if (!userArea.equalsIgnoreCase("N/A")) {
                try {
                    BigDecimal bD = new BigDecimal(userArea);
                    bD = bD.setScale(2, RoundingMode.HALF_UP);
                    if (bD.compareTo(BigDecimal.ZERO) > 0) {
                        validBD = true;
                        editedOrder.setArea(bD);
                    } else {
                        displayErrorMessage("Invalid input");
                    }
                } catch (NumberFormatException e) {
                    displayErrorMessage("Invalid input");
                }
            } else {
                editedOrder.setArea(area);
                validBD = true;
            }
        }
        //io.print("");
        return editedOrder;
    }

    public LocalDate getDate() {
        return io.readLocalDate("Please enter date (MM/dd/yyyy): ");
    }

    public int getOrderNum() {
        return io.readInt("Please enter order number: ");
    }

    public void displayOrderList(List<Order> orderList) {
        //Format?? io.print(order.getOrderDate().format(DateTimeFormatter.ISO_DATE));
        //String date = orderList.get(0).getOrderDate().toString();
        //io.print(date);
        //PRINTING DATE AT THE TOP SEEMS UNNECESSARY
        for (Order currentOrder : orderList) {
            displayOrder(currentOrder);
        }
    }

    public void displayOrder(Order order) {
        io.print("\nOrder #" + order.getOrderNum());
        io.print("---------");
        io.print("Customer: " + order.getCustomerName());
        io.print("State: " + order.getState());
        io.print("Tax rate: " + order.getTaxRate() + "%");
        io.print("Product: " + order.getProductType());
        io.print("Material cost per sq ft: $" + order.getCostPerSqFt());
        io.print("Labor cost per sq ft: $" + order.getLaborCostPerSqFt());
        io.print("Area: " + order.getArea());
        io.print("Material cost: $" + order.getMaterialCost());
        io.print("Labor cost: $" + order.getLaborCost());
        io.print("Tax: $" + order.getTax());
        io.print("Total: $" + order.getTotal() + "\n");
    }

    public void displayAddAborted() {
        io.print("\nAdd aborted.\n");
    }

    public void displayDeleteAborted() {
        io.print("\nDelete aborted.\n");
    }

    public void displayAddSuccessful() {
        io.print("\nOrder added.\n");
    }

    public void displayEditSuccessful() {
        io.print("\nOrder edited.\n");
    }

    public void displayRemoveSuccessful() {
        io.print("\nOrder removed.\n");
    }

    public void displaySaveSuccessful() {
        io.print("\nYour changes have been saved.\n");
    }

    public void displayCommandUnsuccessful() {
        io.print("\nCommand cannot be completed at this time.\n");
    }

    public void displayUnknownCommand() {
        io.print("\nUnknown Command!!!\n");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("\n===== ERROR =====");
        io.print(errorMsg + "\n");
    }

    public boolean offerToSave() {
        String ans = io.readString("\nEnter s if you have not yet saved your changes"
                + " and would like to. Otherwise hit enter. ");
        if (ans.equalsIgnoreCase("s")) {
            return true;
        } else {
            return false;
        }
    }

    public void displayExitMessage() {
        io.print("\nGood Bye!!!");
    }
}
