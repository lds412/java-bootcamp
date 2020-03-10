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
public class CaughtSpeedingTest {
    
    private CaughtSpeeding caught = new CaughtSpeeding();
    
    public CaughtSpeedingTest() {
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

    // caughtSpeeding(60, false) → 0
    @Test
    public void test60False() {
        assertEquals(0,caught.caughtSpeeding(60, false));
    }
    
    // caughtSpeeding(65, true) → 0
    @Test
    public void test65True() {
        assertEquals(0,caught.caughtSpeeding(65, true));
    }
    
    // caughtSpeeding(61, false) → 1
    @Test
    public void test61False() {
        assertEquals(1,caught.caughtSpeeding(61, false));
    }
    
    // caughtSpeeding(66, true) → 1
    @Test
    public void test66True() {
        assertEquals(1,caught.caughtSpeeding(66, true));
    }
    
    // caughtSpeeding(80, false) -> 1
    @Test
    public void test80False() {
        assertEquals(1,caught.caughtSpeeding(80, false));
    }
    
    // caughtSpeeding(85, true) -> 1
    @Test
    public void test85True() {
        assertEquals(1,caught.caughtSpeeding(85, true));
    }
    
    // caughtSpeeding(81, false) -> 2
    @Test
    public void test81False() {
        assertEquals(2,caught.caughtSpeeding(81, false));
    }
    // caughtSpeeding(86, true) -> 2
    @Test
    public void test86True() {
        assertEquals(2,caught.caughtSpeeding(86, true));
    }
}
