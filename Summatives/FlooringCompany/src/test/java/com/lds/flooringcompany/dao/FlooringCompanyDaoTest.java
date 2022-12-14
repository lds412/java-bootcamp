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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lydia
 */
public class FlooringCompanyDaoTest {

    private FlooringCompanyDao dao = new FlooringCompanyDaoFileImpl();

    public FlooringCompanyDaoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    
        List<Order> orderList = dao.listOrders();
        for (Order order : orderList) {
            dao.removeOrder(order.getOrderNum());
        }
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of loadData method, of class FlooringCompanyDao.
     */
    @Test
    public void testLoadData() throws Exception {
    }

    /**
     * Test of listOrders method, of class FlooringCompanyDao.
     */
    @Test
    public void testListOrders() throws DelimiterInclusionException {
        setUp();
        
        Order order1 = new Order(1);

        order1.setOrderDate(LocalDate.of(2020, 03, 18));

        order1.setCustomerName("Jones");

        order1.setState("OH");
        order1.setTaxRate(dao.getTaxRate("OH"));

        order1.setProductType("Wood");
        order1.setCostPerSqFt(dao.getProductRate("Wood"));
        order1.setLaborCostPerSqFt(dao.getLaborRate("Wood"));

        order1.setArea(new BigDecimal("100"));

        dao.addOrder(order1.getOrderNum(), order1);

        Order order2 = new Order(2);

        order2.setOrderDate(LocalDate.of(2020, 03, 18));

        order2.setCustomerName("Smith");

        order2.setState("IN");
        order2.setTaxRate(dao.getTaxRate("IN"));

        order2.setProductType("Tile");
        order2.setCostPerSqFt(dao.getProductRate("Tile"));
        order2.setLaborCostPerSqFt(dao.getLaborRate("Tile"));

        order2.setArea(new BigDecimal("150"));

        dao.addOrder(order2.getOrderNum(), order2);

        assertEquals(2, dao.listOrders().size());
    }

    /**
     * Test of listOrdersForDate method, of class FlooringCompanyDao.
     */
    @Test
    public void testListOrdersForDate() throws DelimiterInclusionException {
        setUp();
        
        Order order1 = new Order(1);

        order1.setOrderDate(LocalDate.of(2020, 03, 18));

        order1.setCustomerName("Jones");

        order1.setState("OH");
        order1.setTaxRate(dao.getTaxRate("OH"));

        order1.setProductType("Wood");
        order1.setCostPerSqFt(dao.getProductRate("Wood"));
        order1.setLaborCostPerSqFt(dao.getLaborRate("Wood"));

        order1.setArea(new BigDecimal("100"));

        dao.addOrder(order1.getOrderNum(), order1);

        Order order2 = new Order(2);

        order2.setOrderDate(LocalDate.of(2020, 03, 19));

        order2.setCustomerName("Smith");

        order2.setState("IN");
        order2.setTaxRate(dao.getTaxRate("IN"));

        order2.setProductType("Tile");
        order2.setCostPerSqFt(dao.getProductRate("Tile"));
        order2.setLaborCostPerSqFt(dao.getLaborRate("Tile"));

        order2.setArea(new BigDecimal("150"));

        dao.addOrder(order2.getOrderNum(), order2);

        assertEquals(1, dao.listOrdersForDate(LocalDate.of(2020, 03, 18)).size());
        assertEquals(1, dao.listOrdersForDate(LocalDate.of(2020, 03, 19)).size());
    }

    /**
     * Test of addOrder method, of class FlooringCompanyDao.
     */
    @Test
    public void testAddAndGetOrder() throws DelimiterInclusionException {
        setUp();

        Order order = new Order(1);

        order.setOrderDate(LocalDate.of(2020, 03, 18));

        order.setCustomerName("Jones");

        order.setState("OH");
        order.setTaxRate(dao.getTaxRate("OH"));

        order.setProductType("Wood");
        order.setCostPerSqFt(dao.getProductRate("Wood"));
        order.setLaborCostPerSqFt(dao.getLaborRate("Wood"));

        order.setArea(new BigDecimal("100"));

        dao.addOrder(order.getOrderNum(), order);

        Order fromDao = dao.getOrder(order.getOrderNum());

        assertEquals(order, fromDao);
    }

    /**
     * Test of removeOrder method, of class FlooringCompanyDao.
     */
    @Test
    public void testRemoveOrder() throws DelimiterInclusionException {
        setUp();
        
        Order order1 = new Order(1);

        order1.setOrderDate(LocalDate.of(2020, 03, 18));

        order1.setCustomerName("Jones");

        order1.setState("OH");
        order1.setTaxRate(dao.getTaxRate("OH"));

        order1.setProductType("Wood");
        order1.setCostPerSqFt(dao.getProductRate("Wood"));
        order1.setLaborCostPerSqFt(dao.getLaborRate("Wood"));

        order1.setArea(new BigDecimal("100"));

        dao.addOrder(order1.getOrderNum(), order1);

        Order order2 = new Order(2);

        order2.setOrderDate(LocalDate.of(2020, 03, 18));

        order2.setCustomerName("Smith");

        order2.setState("IN");
        order2.setTaxRate(dao.getTaxRate("IN"));

        order2.setProductType("Tile");
        order2.setCostPerSqFt(dao.getProductRate("Tile"));
        order2.setLaborCostPerSqFt(dao.getLaborRate("Tile"));

        order2.setArea(new BigDecimal("150"));

        dao.addOrder(order2.getOrderNum(), order2);

        dao.removeOrder(order1.getOrderNum());
        assertEquals(1, dao.listOrders().size());
        assertNull(dao.getOrder(order1.getOrderNum()));

        dao.removeOrder(order2.getOrderNum());
        assertEquals(0, dao.listOrders().size());
        assertNull(dao.getOrder(order2.getOrderNum()));
    }

    /**
     * Test of saveEdits method, of class FlooringCompanyDao.
     */
    @Test
    public void testSaveEdits() throws Exception {
    }

    /**
     * Test of getTaxRate method, of class FlooringCompanyDao.
     */
    @Test
    public void testGetTaxRateOH() 
            throws FlooringCompanyFileNotFoundException, DelimiterInclusionException {
        dao.loadData();
        BigDecimal actual = dao.getTaxRate("OH");
        BigDecimal expected = new BigDecimal("6.25");
        assertEquals(actual, expected);
    }

    @Test
    public void testGetTaxRatePA() 
            throws FlooringCompanyFileNotFoundException, DelimiterInclusionException {
        dao.loadData();
        BigDecimal actual = dao.getTaxRate("PA");
        BigDecimal expected = new BigDecimal("6.75");
        assertEquals(actual, expected);
    }
    
    @Test
    public void testGetTaxRateMI() 
            throws FlooringCompanyFileNotFoundException, DelimiterInclusionException {
        dao.loadData();
        BigDecimal actual = dao.getTaxRate("MI");
        BigDecimal expected = new BigDecimal("5.75");
        assertEquals(actual, expected);
    }
    
    @Test
    public void testGetTaxRateIN() 
            throws FlooringCompanyFileNotFoundException, DelimiterInclusionException {
        dao.loadData();
        BigDecimal actual = dao.getTaxRate("IN");
        BigDecimal expected = new BigDecimal("6.00");
        assertEquals(actual, expected);
    }
    
    /**
     * Test of getProductRate method, of class FlooringCompanyDao.
     */
    @Test
    public void testGetProductAndLaborRateCarpet() 
            throws FlooringCompanyFileNotFoundException, DelimiterInclusionException {
        dao.loadData();
        BigDecimal actualPR = dao.getProductRate("Carpet");
        BigDecimal expectedPR = new BigDecimal("2.25");
        assertEquals(actualPR, expectedPR);
        
        BigDecimal actualLR = dao.getLaborRate("Carpet");
        BigDecimal expectedLR = new BigDecimal("2.10");
        assertEquals(actualLR, expectedLR);
    }

    @Test
    public void testGetProductAndLaborRateLaminate() 
            throws FlooringCompanyFileNotFoundException, DelimiterInclusionException {
        dao.loadData();
        BigDecimal actualPR = dao.getProductRate("Laminate");
        BigDecimal expectedPR = new BigDecimal("1.75");
        assertEquals(actualPR, expectedPR);
        
        BigDecimal actualLR = dao.getLaborRate("Laminate");
        BigDecimal expectedLR = new BigDecimal("2.10");
        assertEquals(actualLR, expectedLR);
    }
    
    @Test
    public void testGetProductAndLaborRateTile() 
            throws FlooringCompanyFileNotFoundException, DelimiterInclusionException {
        dao.loadData();
        BigDecimal actualPR = dao.getProductRate("Tile");
        BigDecimal expectedPR = new BigDecimal("3.50");
        assertEquals(actualPR, expectedPR);
        
        BigDecimal actualLR = dao.getLaborRate("Tile");
        BigDecimal expectedLR = new BigDecimal("4.15");
        assertEquals(actualLR, expectedLR);
    }
    
    @Test
    public void testGetProductAndLaborRateWood() 
            throws FlooringCompanyFileNotFoundException, DelimiterInclusionException {
        dao.loadData();
        BigDecimal actualPR = dao.getProductRate("Wood");
        BigDecimal expectedPR = new BigDecimal("5.15");
        assertEquals(actualPR, expectedPR);
        
        BigDecimal actualLR = dao.getLaborRate("Wood");
        BigDecimal expectedLR = new BigDecimal("4.75");
        assertEquals(actualLR, expectedLR);
    }
}
