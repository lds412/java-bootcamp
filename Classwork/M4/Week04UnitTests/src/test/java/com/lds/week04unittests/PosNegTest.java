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
public class PosNegTest {
    
    private PosNeg pn = new PosNeg();
    
    public PosNegTest() {
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

    // posNeg(-1, 1, true) -> false
    @Test
    public void testOneTrue() {
        assertFalse(pn.posNeg(-1, 1, true));
    }
    
    // posNeg(1, -1, false) -> true
    @Test
    public void testOneFalse() {
        assertTrue(pn.posNeg(1, -1, false));
    }
    
    // posNeg(1, 1, false) -> false
    @Test
    public void testNoneFalse() {
        assertFalse(pn.posNeg(1, 1, false));
    }
    
    // posNeg(-4, -5, true) -> true
    @Test
    public void testBothTrue() {
        assertTrue(pn.posNeg(-4, -5, true));
    }
}
