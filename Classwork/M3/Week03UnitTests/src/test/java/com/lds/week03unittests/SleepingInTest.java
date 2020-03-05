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
public class SleepingInTest {
    
    private SleepingIn si = new SleepingIn();
    
    public SleepingInTest() {
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

    // canSleepIn(false, false) -> true
    @Test
    public void testFalseFalse() {
        assertTrue(si.canSleepIn(false, false));
    }
    
    // canSleepIn(false, true) -> true
    @Test
    public void testFalseTrue() {
        assertTrue(si.canSleepIn(false, true));
    }
    
    // canSleepIn(true, true) -> true
    @Test
    public void testTrueTrue() {
        assertTrue(si.canSleepIn(true, true));
    }
    
    // canSleepIn(true, false) -> false
    @Test
    public void testTrueFalse() {
        assertFalse(si.canSleepIn(true, false));
    }
}
