/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.week03unittests;

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
public class CanHazTableTest {
    
    private CanHazTable canHazTable = new CanHazTable();
    
    public CanHazTableTest() {
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

    // canHazTable(3, 8) → 2
    @Test
    public void test38() {
        assertEquals(2, canHazTable.canHazTable(3, 8));
    }
    
    // canHazTable(2, 8) → 0
    @Test
    public void test28() {
        assertEquals(0, canHazTable.canHazTable(2, 8));
    }
    
    // canHazTable(2, 7) → 0
    @Test
    public void test27() {
        assertEquals(0, canHazTable.canHazTable(2, 7));
    }
    
    // canHazTable(3, 7) → 1
    @Test
    public void test37() {
        assertEquals(1, canHazTable.canHazTable(3, 7));
    }
}
