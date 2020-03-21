/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.controller;

import com.lds.flooringcompany.dao.FlooringCompanyFileNotFoundException;
import com.lds.flooringcompany.dao.FlooringCompanyPersistenceException;
import com.lds.flooringcompany.dto.DelimiterInclusionException;
import com.lds.flooringcompany.dto.Order;
import com.lds.flooringcompany.service.DateDiscrepencyException;
import com.lds.flooringcompany.service.FlooringCompanyServiceLayer;
import com.lds.flooringcompany.service.InvalidChoiceException;
import com.lds.flooringcompany.service.RequiredDataException;
import com.lds.flooringcompany.ui.FlooringCompanyView;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lydia
 */
public class FlooringCompanyController {

    FlooringCompanyView view;
    FlooringCompanyServiceLayer service;

    private boolean prod;

    public FlooringCompanyController(FlooringCompanyServiceLayer service, FlooringCompanyView view, boolean prod) {
        this.service = service;
        this.view = view;
        this.prod = prod;
    }

    public void run() throws DateDiscrepencyException {
        boolean keepGoing = true;
        String menuSelection;

        displayMode();

        try {
            service.loadData();

            while (keepGoing) {

                menuSelection = view.printMenuAndGetSelection();

                switch (menuSelection) {
                    case "1":
                        displayOrders();
                        break;
                    case "2":
                        addOrder();
                        break;
                    case "3":
                        editOrder();
                        break;
                    case "4":
                        removeOrder();
                        break;
                    case "5":
                        if (prod) {
                            saveChanges();
                        } else {
                            view.displayCommandUnsuccessful();
                        }
                        break;
                    case "6":
                        keepGoing = false;
                        break;
                    default:
                        view.displayUnknownCommand();
                }
            }
            if (prod) {
                if (view.offerToSave()) {
                    saveChanges();
                }
            }
            view.displayExitMessage();
        } catch (FlooringCompanyFileNotFoundException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void displayMode() {
        if (prod) {
            view.displayProdMode();
        } else {
            view.displayTrainingMode();
        }
    }

    private void displayOrders() {
        try {
            LocalDate date = view.getDate();
            List<Order> orderList = service.listOrdersForDate(date);
            view.displayOrderList(orderList);
        } catch (InvalidChoiceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void addOrder() {

        try {
            List<Order> orderList = service.listOrders();
            Order newOrder = view.getNewOrderInfo(orderList);

            service.validateOrder(newOrder);

            view.displayOrder(newOrder);

            if (view.confirmCommand("add")) {
                service.addOrder(newOrder.getOrderNum(), newOrder);
                view.displayAddSuccessful();
            } else {
                view.displayAddAborted();
            }
        } catch (RequiredDataException | InvalidChoiceException | DelimiterInclusionException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void editOrder() {
        try {
            LocalDate date = view.getDate();
            int orderNum = view.getOrderNum();
            Order order = service.getOrder(date, orderNum);
            Order editedOrder = view.editOrder(order);
            service.validateOrder(editedOrder);
            service.editOrder(editedOrder, order);
            view.displayEditSuccessful();
        } catch (InvalidChoiceException | DateDiscrepencyException | 
                RequiredDataException | DelimiterInclusionException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void removeOrder() {

        try {
            LocalDate date = view.getDate();
            int orderNum = view.getOrderNum();
            Order order = service.getOrder(date, orderNum);
            view.displayOrder(order);

            if (view.confirmCommand("delete")) {
                service.removeOrder(date, orderNum);
                view.displayRemoveSuccessful();
            } else {
                view.displayDeleteAborted();
            }
        } catch (InvalidChoiceException | DateDiscrepencyException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void saveChanges() {
        try {
            service.saveEdits();
            view.displaySaveSuccessful();
        } catch (FlooringCompanyPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

}
