/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vendingmachine.service;

import com.lds.vendingmachine.dao.VendingMachineAuditDao;
import com.lds.vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import com.lds.vendingmachine.dao.VendingMachineDao;
import com.lds.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.lds.vendingmachine.dao.VendingMachinePersistenceException;
import com.lds.vendingmachine.dto.FoodItem;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lydia
 */
public class VendingMachineServiceLayerTest {

    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerTest() {
        //FileImpl vs. StubImpl
//        VendingMachineDao dao = new VendingMachineDaoFileImpl();
//        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoFileImpl();
//
//        service = new VendingMachineServiceLayerImpl(dao, auditDao);

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        service
                = ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetAllItems() throws Exception {
    }

    /**
     * Test of getFoodItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetFoodItem() throws Exception {
    }

    /**
     * Test of subtractQtyAndLog method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testSubtractQtyAndLog() throws Exception {
    }

    /**
     * Test of enoughMoney method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testEnoughMoney() throws Exception {
    }

    /**
     * Test of makeChange method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testMakeChange25() {
        BigDecimal q = new BigDecimal("0.25");
        assertEquals(Change.Q, service.makeChange(q));
    }

    @Test
    public void testMakeChange24() {
        BigDecimal dHigh = new BigDecimal("0.24");
        assertEquals(Change.D, service.makeChange(dHigh));
    }

    @Test
    public void testMakeChange10() {
        BigDecimal d = new BigDecimal("0.10");
        assertEquals(Change.D, service.makeChange(d));
    }

    @Test
    public void testMakeChange9() {
        BigDecimal nHigh = new BigDecimal("0.09");
        assertEquals(Change.N, service.makeChange(nHigh));
    }

    @Test
    public void testMakeChange5() {
        BigDecimal n = new BigDecimal("0.05");
        assertEquals(Change.N, service.makeChange(n));
    }

    @Test
    public void testMakeChange4() {
        BigDecimal pHigh = new BigDecimal("0.04");
        assertEquals(Change.P, service.makeChange(pHigh));
    }

    @Test
    public void testReturnChange41() {
        BigDecimal oneEach = new BigDecimal("0.41");
        int[] exp = {1, 1, 1, 1};
        int[] actual = service.returnChange(oneEach);
        for (int i = 0; i < exp.length; i++) {
            assertEquals(actual[i], exp[i]);
        }
    }
}
