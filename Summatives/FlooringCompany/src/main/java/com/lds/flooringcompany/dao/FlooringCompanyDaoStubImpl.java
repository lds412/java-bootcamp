/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.dao;

import com.lds.flooringcompany.dto.DelimiterInclusionException;
import com.lds.flooringcompany.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author lydia
 */
public class FlooringCompanyDaoStubImpl implements FlooringCompanyDao {

    private Order onlyOrder;
    private List<Order> orderList = new ArrayList<>();

    public FlooringCompanyDaoStubImpl() throws DelimiterInclusionException {
        onlyOrder = new Order(1);
        onlyOrder.setOrderDate(LocalDate.of(2020, 03, 18));

        onlyOrder.setCustomerName("Jones");

        onlyOrder.setState("OH");
        onlyOrder.setTaxRate(new BigDecimal("6.25"));
        //onlyOrder.setTaxRate(dao.getTaxRate("OH"));

        onlyOrder.setProductType("Wood");
        onlyOrder.setCostPerSqFt(new BigDecimal("5.15"));
        //onlyOrder.setCostPerSqFt(dao.getProductRate("Wood"));
        onlyOrder.setLaborCostPerSqFt(new BigDecimal("4.75"));
        //onlyOrder.setLaborCostPerSqFt(dao.getLaborRate("Wood"));

        onlyOrder.setArea(new BigDecimal("100"));

        orderList.add(onlyOrder);
    }

    @Override
    public void loadData()
            throws FlooringCompanyFileNotFoundException, DelimiterInclusionException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Order> listOrders() {
        return orderList;
    }

    @Override
    public List<Order> listOrdersForDate(LocalDate date) {
        return orderList
                .stream()
                .filter(o -> o.getOrderDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public Order addOrder(int orderNum, Order order) {
        if (orderNum == onlyOrder.getOrderNum()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order getOrder(int orderNum) {
        if (orderNum == onlyOrder.getOrderNum()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order removeOrder(int orderNum) {
        if (orderNum == onlyOrder.getOrderNum()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public void saveEdits() throws FlooringCompanyPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BigDecimal getTaxRate(String state) {
        switch (state) {
            case "OH":
                return new BigDecimal("6.25");
            case "PA":
                return new BigDecimal("6.75");
            case "MI":
                return new BigDecimal("5.75");
            case "IN":
                return new BigDecimal("6.00");
            default:
                return null;
        }
    }

    @Override
    public BigDecimal getProductRate(String product) {
        switch (product) {
            case "Carpet":
                return new BigDecimal("2.25");
            case "Laminate":
                return new BigDecimal("1.75");
            case "Tile":
                return new BigDecimal("3.50");
            case "Wood":
                return new BigDecimal("5.15");
            default:
                return null;
        }
    }

    @Override
    public BigDecimal getLaborRate(String product) {
        switch (product) {
            case "Carpet":
                return new BigDecimal("2.10");
            case "Laminate":
                return new BigDecimal("2.10");
            case "Tile":
                return new BigDecimal("4.15");
            case "Wood":
                return new BigDecimal("4.75");
            default:
                return null;
        }
    }

}
