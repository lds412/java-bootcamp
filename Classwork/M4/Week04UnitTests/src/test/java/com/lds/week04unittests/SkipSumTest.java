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
public class SkipSumTest {
    
    private SkipSum ss = new SkipSum();
    
    public SkipSumTest() {
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
     * Test of skipSum method, of class SkipSum.
     */
    
    // skipSum(10, 11) → 21
    @Test
    public void test1011() {
        assertEquals(21, ss.skipSum(10,11));
    }
    
    // skipSum(3, 4) → 7
    @Test
    public void test34() {
        assertEquals(7, ss.skipSum(3,4));
    }
    
    // skipSum(9, 4) → 20
    @Test
    public void test94() {
        assertEquals(20, ss.skipSum(9,4));
    }
    
    // skipSum(5, 5) -> 20
    @Test
    public void test55() {
        assertEquals(20, ss.skipSum(5,5));
    }
}
