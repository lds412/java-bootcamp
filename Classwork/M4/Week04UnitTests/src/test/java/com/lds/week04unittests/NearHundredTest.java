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
public class NearHundredTest {
    
    private NearHundred nh = new NearHundred();
    
    public NearHundredTest() {
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

    // nearHundred(203) -> true
    @Test
    public void test203() {
        assertTrue(nh.nearHundred(203));
    }
    
    // nearHundred(90) -> true
    @Test
    public void test90() {
        assertTrue(nh.nearHundred(90));
    }
    
    // nearHundred(89) -> false
    @Test
    public void test89() {
        assertFalse(nh.nearHundred(89));
    }
}
