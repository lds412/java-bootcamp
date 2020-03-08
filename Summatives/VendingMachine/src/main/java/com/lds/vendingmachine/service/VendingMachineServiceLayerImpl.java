/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.service;

import com.lds.vendingmachine.dao.VendingMachineAuditDao;
import com.lds.vendingmachine.dao.VendingMachineDao;
import com.lds.vendingmachine.dao.VendingMachinePersistenceException;
import com.lds.vendingmachine.dto.FoodItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author lydia
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public List<FoodItem> getAllItems() throws
            VendingMachinePersistenceException {

        return dao.getAllFoodItems();
    }

    @Override
    public FoodItem getFoodItem(String letter) throws
            VendingMachinePersistenceException,
            NoItemInInventoryException,
            InvalidChoiceException {

        try {
            FoodItem item = dao.getFoodItem(letter);
            int amt = item.getFoodQty();
            
            if (amt <= 0) {
                throw new NoItemInInventoryException("Item out of stock");
            }
            return item;

        } catch (NullPointerException e) {
            throw new InvalidChoiceException("Invalid option", e);
        }
    }

    @Override
    public void subtractQtyAndLog(FoodItem foodItem) throws
            VendingMachinePersistenceException {

        dao.subtractQty(foodItem);
        auditDao.writeAuditEntry(foodItem.getFoodName() + " Purchased");
    }

    @Override
    public void enoughMoney(BigDecimal money, BigDecimal price) throws
            InsufficientFundsException {
        
        if (money.compareTo(price) < 0) {
            throw new InsufficientFundsException("Insufficient funds");
        }
    }

    @Override
    public Change makeChange(BigDecimal money) {

        BigDecimal q = new BigDecimal("0.25");
        BigDecimal diffQ = money.subtract(q);
        BigDecimal d = new BigDecimal("0.10");
        BigDecimal diffD = money.subtract(d);
        BigDecimal n = new BigDecimal("0.05");
        BigDecimal diffN = money.subtract(n);

        if (diffQ.compareTo(BigDecimal.ZERO) >= 0) {
            return Change.Q;
        } else if (diffD.compareTo(BigDecimal.ZERO) >= 0) {
            return Change.D;
        } else if (diffN.compareTo(BigDecimal.ZERO) >= 0) {
            return Change.N;
        } else {
            return Change.P;
        }
    }
    
    @Override
    public int[] returnChange(BigDecimal money) {
        int q = 0;
        int d = 0;
        int n = 0;
        int p = 0;

        BigDecimal quart = new BigDecimal("0.25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nick = new BigDecimal("0.05");
        BigDecimal pen = new BigDecimal("0.01");

        while (money.compareTo(BigDecimal.ZERO) > 0) {
            Change coin = makeChange(money);
            switch (coin) {
                case Q:
                    q++;
                    money = money.subtract(quart);
                    break;
                case D:
                    d++;
                    money = money.subtract(dime);
                    break;
                case N:
                    n++;
                    money = money.subtract(nick);
                    break;
                default:
                    p++;
                    money = money.subtract(pen);
            }
        }
        int[] coins = {q, d, n, p};
        return coins;
    }
}
