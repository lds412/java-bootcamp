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
import java.util.List;

/**
 *
 * @author lydia
 */
public interface FlooringCompanyDao {
    
    public void loadData() 
            throws FlooringCompanyFileNotFoundException, DelimiterInclusionException;
    
    public List<Order> listOrders();
    
    public List<Order> listOrdersForDate(LocalDate date);
    
    public Order addOrder(int orderNum, Order order);
    
    public Order getOrder(int orderNum);
    
    public Order removeOrder(int orderNum);
    
    public void saveEdits() throws FlooringCompanyPersistenceException;
    
    public int getOrderNum();
    
    public BigDecimal getTaxRate(String state);
    
    public BigDecimal getProductRate(String product);
    
    public BigDecimal getLaborRate(String product);
}
