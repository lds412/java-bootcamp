/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.service;

import com.lds.flooringcompany.dao.FlooringCompanyDao;
import com.lds.flooringcompany.dao.FlooringCompanyDaoStubImpl;
import com.lds.flooringcompany.dto.DelimiterInclusionException;
import com.lds.flooringcompany.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
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
public class FlooringCompanyServiceLayerTest {

    private FlooringCompanyServiceLayer service;

    public FlooringCompanyServiceLayerTest() throws DelimiterInclusionException {
        FlooringCompanyDao dao = new FlooringCompanyDaoStubImpl();
        service = new FlooringCompanyServiceLayerImpl(dao);
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
     * Test of loadData method, of class FlooringCompanyServiceLayer.
     */
    @Test
    public void testLoadData() throws Exception {
    }

    /**
     * Test of listOrders method, of class FlooringCompanyServiceLayer.
     */
    @Test
    public void testListOrders() {
        assertEquals(1, service.listOrders().size());
    }
    
    /**
     * Test of listOrdersForDate method, of class FlooringCompanyServiceLayer.
     */
    @Test
    public void testListOrdersForDate() throws Exception {
        assertEquals(1, service.listOrdersForDate(LocalDate.of(2020, 03, 18)).size());
    }

    @Test
    public void testListOrdersForDateException() throws Exception {
        try{
            service.listOrdersForDate(LocalDate.of(2020, 03, 17));
            fail("Expected InvalidChoiceException was not thrown.");
        } catch (InvalidChoiceException e){
            return;
        }
    }
    
    /**
     * Test of validateOrder method, of class FlooringCompanyServiceLayer.
     */
    @Test
    public void testValidateOrder() throws Exception {
        Order order2 = new Order(2);

        order2.setOrderDate(LocalDate.of(2020, 03, 18));
        order2.setCustomerName("Smith");
        order2.setState("IN");
        order2.setProductType("Tile");
        order2.setArea(new BigDecimal("150"));

        service.validateOrder(order2);
    }

    @Test
    public void testValidateOrderInvalidData() throws Exception {
        Order order2 = new Order(2);

        order2.setOrderDate(LocalDate.of(2020, 03, 18));
        order2.setCustomerName("N/A");
        order2.setState("IN");
        order2.setProductType("Tile");
        order2.setArea(new BigDecimal("150"));

        try {
            service.validateOrder(order2);
            fail("Expected RequiredDataException was not thrown.");
        } catch (RequiredDataException e) {
            return;
        }
    }

    @Test
    public void testValidateOrderInvalidState() throws Exception {
        Order order2 = new Order(2);

        order2.setOrderDate(LocalDate.of(2020, 03, 18));
        order2.setCustomerName("Smith");
        order2.setState("WI");
        order2.setProductType("Tile");
        order2.setArea(new BigDecimal("150"));

        try {
            service.validateOrder(order2);
            fail("Expected InvalidChoiceException was not thrown.");
        } catch (InvalidChoiceException e) {
            return;
        }
    }

    @Test
    public void testValidateOrderInvalidProduct() throws Exception {
        Order order2 = new Order(2);

        order2.setOrderDate(LocalDate.of(2020, 03, 18));
        order2.setCustomerName("Smith");
        order2.setState("OH");
        order2.setProductType("");
        order2.setArea(new BigDecimal("150"));

        try {
            service.validateOrder(order2);
            fail("Expected InvalidChoiceException was not thrown.");
        } catch (InvalidChoiceException e) {
            return;
        }
    }

    @Test
    public void testValidateOrderDelimiterInclusion() throws Exception {
        Order order2 = new Order(2);

        order2.setOrderDate(LocalDate.of(2020, 03, 18));

        try {
            
            order2.setCustomerName("Smi,  th");
            order2.setState("OH");
            order2.setProductType("Tile");
            order2.setArea(new BigDecimal("150"));

            service.validateOrder(order2);
            fail("Expected DelimiterInclusionException was not thrown.");
        } catch (DelimiterInclusionException e) {
            return;
        }
    }

    @Test
    public void testEditOrder() throws Exception {
        
        Order order2 = new Order(2);

        order2.setOrderDate(LocalDate.of(2020, 03, 18));
        order2.setCustomerName("Smith");
        order2.setState("IN");
        order2.setProductType("Tile");
        order2.setArea(new BigDecimal("150"));
        
        Order editedOrder = service.getOrder(LocalDate.of(2020, 03, 18), 1);
        
        service.editOrder(editedOrder, order2);
        
        assertEquals(editedOrder.getOrderDate(), order2.getOrderDate());
        assertEquals(editedOrder.getCustomerName(),order2.getCustomerName());
        assertEquals(editedOrder.getState(), order2.getState());
        assertEquals(editedOrder.getTaxRate(), order2.getTaxRate());
        assertEquals(editedOrder.getProductType(), order2.getProductType());
        assertEquals(editedOrder.getCostPerSqFt(), order2.getCostPerSqFt());
        assertEquals(editedOrder.getLaborCostPerSqFt(), order2.getLaborCostPerSqFt());
        assertEquals(editedOrder.getArea(), order2.getArea());
    }
    
    /**
     * Test of addOrder method, of class FlooringCompanyServiceLayer.
     */
    @Test
    public void testAddOrder() {
    }

    /**
     * Test of getOrder method, of class FlooringCompanyServiceLayer.
     */
    @Test
    public void testGetOrder() throws Exception {
        Order order = service.getOrder(LocalDate.of(2020, 03, 18), 1);
        assertNotNull(order);
    }

    @Test
    public void testGetOrderWrongOrderNum() throws Exception {
        try {
            Order order = service.getOrder(LocalDate.of(2020, 03, 18), 2);
            fail("Expected DateDiscrepencyException was not thrown.");
        } catch (InvalidChoiceException e) {
            return;
        }

    }

    @Test
    public void testGetOrderWrongDate() throws Exception {
        try {
            Order order = service.getOrder(LocalDate.of(2020, 03, 17), 1);
            fail("Expected InvalidChoiceException was not thrown.");
        } catch (InvalidChoiceException e) {
            return;
        }

    }

    /**
     * Test of removeOrder method, of class FlooringCompanyServiceLayer.
     */
    @Test
    public void testRemoveOrder() {
        Order order = service.removeOrder(LocalDate.of(2020, 03, 17), 1);
        assertNotNull(order);
        order = service.removeOrder(LocalDate.of(2020, 03, 17), 2);
        assertNull(order);
    }

    @Test
    public void getOrderNum(){
        assertEquals(1, service.getOrderNum());
    }
    
    /**
     * Test of saveEdits method, of class FlooringCompanyServiceLayer.
     */
    @Test
    public void testSaveEdits() throws Exception {
    }

}
