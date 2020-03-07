/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.service;

import com.lds.vendingmachine.dao.VendingMachineAuditDao;
import com.lds.vendingmachine.dao.VendingMachineDao;
import com.lds.vendingmachine.dto.FoodItem;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author lydia
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{

    VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;
    
    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    public List<FoodItem> getAllItems() {
        return dao.getAllFoodItems(); 
    }

    @Override
    public FoodItem getFoodItem(String letter) {
        return dao.getFoodItem(letter);
    }
    
    @Override
    public Change makeChange(BigDecimal money){
        
        BigDecimal q = new BigDecimal("0.25");
        BigDecimal diffQ = money.subtract(q);
        BigDecimal d = new BigDecimal("0.10");
        BigDecimal diffD = money.subtract(q);
        BigDecimal n = new BigDecimal("0.05");
        BigDecimal diffN = money.subtract(q);
    
        if(diffQ.compareTo(BigDecimal.ZERO) >= 0){
            return Change.Q;
        } else if(diffD.compareTo(BigDecimal.ZERO) >= 0){
            return Change.D;
        } else if(diffN.compareTo(BigDecimal.ZERO) >= 0){
            return Change.N;
        } else {
            return Change.P;
        }
    }
}
