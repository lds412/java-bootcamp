/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.service;

import com.lds.flooringcompany.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lydia
 */
public interface FlooringCompanyServiceLayer {
    
    public void loadData();
    
    public List<Order> listOrders();
    
    public List<Order> listOrdersForDate(LocalDate date);
    
    public Order createOrder(Order order);
    
    public Order addOrder(int orderNum, Order order);
    
    public Order getOrder(LocalDate date, int orderNum);
    
    public Order removeOrder(LocalDate date, int orderNum);
    
    public void saveEdits();
    
}
