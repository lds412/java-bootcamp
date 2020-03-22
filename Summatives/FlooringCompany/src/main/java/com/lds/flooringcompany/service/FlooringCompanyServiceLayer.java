/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.service;

import com.lds.flooringcompany.dao.FlooringCompanyFileNotFoundException;
import com.lds.flooringcompany.dao.FlooringCompanyPersistenceException;
import com.lds.flooringcompany.dto.DelimiterInclusionException;
import com.lds.flooringcompany.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lydia
 */
public interface FlooringCompanyServiceLayer {
    
    public void loadData() 
            throws FlooringCompanyFileNotFoundException, DelimiterInclusionException;
    
    public List<Order> listOrders();
    
    public List<Order> listOrdersForDate(LocalDate date) 
            throws InvalidChoiceException;
    
    public Order validateOrder(Order order) 
            throws RequiredDataException, InvalidChoiceException;
    
    public Order addOrder(int orderNum, Order order);
    
    public Order getOrder(LocalDate date, int orderNum) 
            throws InvalidChoiceException, DateDiscrepencyException;
    
    public void editOrder(Order editedOrder, Order order) 
            throws DelimiterInclusionException;
    
    public Order removeOrder(LocalDate date, int orderNum);
    
    public void saveEdits() throws FlooringCompanyPersistenceException;
    
    public int getOrderNum();
}
