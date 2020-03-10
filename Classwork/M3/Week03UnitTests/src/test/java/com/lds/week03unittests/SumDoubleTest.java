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
public class SumDoubleTest {
    
    SumDouble s = new SumDouble();
    
    public SumDoubleTest() {
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

    // sumDouble(2, 2) -> 8
    @Test
    public void test22() {
        assertEquals(8, s.sumDouble(2, 2));
    }
    
    // sumDouble(1, 2) -> 3
    @Test
    public void test12() {
        assertEquals(3, s.sumDouble(1, 2));
    }
    
    // sumDouble(3, 2) -> 5
    @Test
    public void test32() {
        assertEquals(5, s.sumDouble(3, 2));
    }
}
