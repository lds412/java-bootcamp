/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.controller;

import com.lds.flooringcompany.dto.Order;
import com.lds.flooringcompany.service.FlooringCompanyServiceLayer;
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

    public FlooringCompanyController(FlooringCompanyServiceLayer service, FlooringCompanyView view) {
        this.service = service;
        this.view = view;
    }

    //Change strings to ints??
    public void run() {
        boolean keepGoing = true;
        String menuSelection;
        service.loadData();
        //try {
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
                    service.saveEdits();
                    break;
                case "6":
                    keepGoing = false;
                    break;
                default:
                    view.displayUnknownCommand();
            }
        }
        if(view.offerToSave()){
            service.saveEdits();
        }
        view.displayExitMessage();
//        } catch (DvdLibraryDaoException e) {
//            view.displayErrorMessage(e.getMessage());
//        }
    }

    private void displayOrders() {
        LocalDate date = view.getDate();
        List<Order> orderList = service.listOrdersForDate(date);
        view.displayOrderList(orderList);
    }

    private void addOrder() {
        List<Order> orderList = service.listOrders();
        Order newOrder = view.getNewOrderInfo(orderList);
        
        service.createOrder(newOrder);
        
        view.displayOrder(newOrder);
        
        if (view.confirmCommand("add")) {
            service.addOrder(newOrder.getOrderNum(), newOrder);
            view.displayAddSuccessful();
        } else {
            view.displayAddAborted();
        }
    }

    private void editOrder() {
        LocalDate date = view.getDate();
        int orderNum = view.getOrderNum();
        Order order = service.getOrder(date, orderNum);
        view.editOrder(order);
    }

    private void removeOrder() {

        LocalDate date = view.getDate();
        int orderNum = view.getOrderNum();
        Order order = service.getOrder(date, orderNum);
        view.displayOrder(order);

        if (order == null) {
            //view.displayContinueMessage();
        } else {
            if (view.confirmCommand("delete")) {
                service.removeOrder(date, orderNum);
                view.displayRemoveSuccessful();
            } else {
                view.displayDeleteAborted();
            }
        }
    }

}
