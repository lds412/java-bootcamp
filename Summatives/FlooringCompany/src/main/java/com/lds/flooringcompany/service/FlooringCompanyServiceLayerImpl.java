/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.service;

import com.lds.flooringcompany.dao.FlooringCompanyDao;
import com.lds.flooringcompany.dao.FlooringCompanyFileNotFoundException;
import com.lds.flooringcompany.dao.FlooringCompanyPersistenceException;
import com.lds.flooringcompany.dto.DelimiterInclusionException;
import com.lds.flooringcompany.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lydia
 */
public class FlooringCompanyServiceLayerImpl implements FlooringCompanyServiceLayer {

    FlooringCompanyDao dao;

    public FlooringCompanyServiceLayerImpl(FlooringCompanyDao dao) {
        this.dao = dao;
    }

    @Override
    public void loadData() 
            throws FlooringCompanyFileNotFoundException, DelimiterInclusionException {

            dao.loadData();
    }

    @Override
    public List<Order> listOrders() {
        return dao.listOrders();
    }

    @Override
    public List<Order> listOrdersForDate(LocalDate date)
            throws InvalidChoiceException {

        if (dao.listOrdersForDate(date).isEmpty()) {
            throw new InvalidChoiceException("No orders placed on this date");
        }

        return dao.listOrdersForDate(date);
    }

    //Change return type to void??
    @Override
    public Order validateOrder(Order order)
            throws RequiredDataException, InvalidChoiceException {

        if (order.getCustomerName().equalsIgnoreCase("N/A")) {
            throw new RequiredDataException("Customer name is required");
        }

        String state = order.getState();
        String product = order.getProductType();

        BigDecimal taxRate = dao.getTaxRate(state);
        BigDecimal productRate = dao.getProductRate(product);
        BigDecimal laborRate = dao.getLaborRate(product);

        if (taxRate == null) {
            throw new InvalidChoiceException("Invalid state entered");
        }

        if (productRate == null || laborRate == null) {
            throw new InvalidChoiceException("Invalid product type");
        }

        order.setTaxRate(taxRate);
        order.setCostPerSqFt(productRate);
        order.setLaborCostPerSqFt(laborRate);

        return order;
    }

    @Override
    public void editOrder(Order editedOrder, Order order) 
            throws DelimiterInclusionException {
        order.setCustomerName(editedOrder.getCustomerName());
        order.setState(editedOrder.getState());
        order.setTaxRate(editedOrder.getTaxRate());
        order.setProductType(editedOrder.getProductType());
        order.setCostPerSqFt(editedOrder.getCostPerSqFt());
        order.setLaborCostPerSqFt(editedOrder.getLaborCostPerSqFt());
        order.setArea(editedOrder.getArea());
    }
    
    @Override
    public Order addOrder(int orderNum, Order order) {
        return dao.addOrder(order.getOrderNum(), order);
    }

    @Override
    public Order getOrder(LocalDate givenDate, int orderNum)
            throws InvalidChoiceException, DateDiscrepencyException {

        if (dao.listOrdersForDate(givenDate).isEmpty()) {
            throw new InvalidChoiceException("No orders placed on this date");
        }

        try {
            Order order = dao.getOrder(orderNum);
            LocalDate orderDate = order.getOrderDate();

            if (givenDate.equals(orderDate)) {
                return order;
            } else {
                throw new DateDiscrepencyException("No such order number on given date");
            }
            
        } catch (NullPointerException e) {
            throw new InvalidChoiceException("Order number does not exist");
        }
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNum) {
        return dao.removeOrder(orderNum);
    }

    @Override
    public void saveEdits() throws FlooringCompanyPersistenceException {
        dao.saveEdits();
    }

    @Override
    public int getOrderNum(){
        return dao.getOrderNum();
    }
    
}
