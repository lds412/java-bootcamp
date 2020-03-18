/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.service;

import com.lds.flooringcompany.dao.FlooringCompanyDao;
import com.lds.flooringcompany.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lydia
 */
public class FlooringCompanyServiceLayerImpl implements FlooringCompanyServiceLayer{
    
    FlooringCompanyDao dao;
    
    public FlooringCompanyServiceLayerImpl(FlooringCompanyDao dao){
        this.dao = dao;
    }
    
    @Override
    public void loadData(){
        dao.loadData();
    }

    @Override
    public List<Order> listOrders() {
        return dao.listOrders();
    }

    @Override
    public List<Order> listOrdersForDate(LocalDate date) {
        return dao.listOrdersForDate(date);
    }

    @Override
    public Order createOrder(Order order) {
        String state = order.getState();
        String product = order.getProductType();
        
        order.setTaxRate(dao.getTaxRate(state));
        order.setCostPerSqFt(dao.getProductRate(product));
        order.setLaborCostPerSqFt(dao.getLaborRate(product));
        
        return order;
    }
    
    @Override
    public Order addOrder(int orderNum, Order order) {
        return dao.addOrder(order.getOrderNum(), order);
    }

    @Override
    public Order getOrder(LocalDate date, int orderNum) {
        return dao.getOrder(date, orderNum);
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNum) {
        return dao.removeOrder(date, orderNum);
    }

    @Override
    public void saveEdits() {
        dao.saveEdits();
    }

}
