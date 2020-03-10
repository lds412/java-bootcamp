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
public class Makes10Test {
    
    private Makes10 m = new Makes10();
    
    public Makes10Test() {
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

    // makes10(9, 10) -> true
    @Test
    public void test910() {
        assertTrue(m.makes10(9, 10));
    }
    
    // makes10(9, 9) -> false
    @Test
    public void test99() {
        assertFalse(m.makes10(9, 9));
    }
    
    // makes10(1, 9) -> true
    @Test
    public void test19() {
        assertTrue(m.makes10(1, 9));
    }
}
