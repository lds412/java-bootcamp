/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.week04unittests;

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
public class DoubleXTest {
    
    private DoubleX doubleX = new DoubleX();
    
    public DoubleXTest() {
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
    
    // doubleX("xxxxx") -> true
    @Test
    public void testAllX() {
        assertTrue(doubleX.doubleX("xxxxx"));
    }
    
    // doubleX("axxbb") -> true
    @Test
    public void testDoubleX() {
        assertTrue(doubleX.doubleX("axxbb"));
    }
    
    // doubleX("axaxxax") -> false
    @Test
    public void testSingleX() {
        assertFalse(doubleX.doubleX("axaxxax"));
    }
    
    // doubleX("aaa") -> false
    @Test
    public void testNoX() {
        assertFalse(doubleX.doubleX("aaa"));
    }
}
