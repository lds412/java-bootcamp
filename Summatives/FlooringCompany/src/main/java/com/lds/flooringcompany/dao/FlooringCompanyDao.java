/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.dao;

import com.lds.flooringcompany.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lydia
 */
public interface FlooringCompanyDao {
    
    public void loadData();
    
    public List<Order> listOrders();
    
    public List<Order> listOrdersForDate(LocalDate date);
    
    public Order addOrder(int orderNum, Order order);
    
    public Order getOrder(LocalDate date, int orderNum);
    
    public Order removeOrder(LocalDate date, int orderNum);
    
    public void saveEdits();
    
    public BigDecimal getTaxRate(String state);
    
    public BigDecimal getProductRate(String product);
    
    public BigDecimal getLaborRate(String product);
}
