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
public class PlayOutsideTest {
    
    private PlayOutside p = new PlayOutside();
    
    public PlayOutsideTest() {
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

    // playOutside(101, true) -> false
    @Test
    public void test101True() {
        assertFalse(p.playOutside(101, true));
    }
    
    // playOutside(59, false) -> false
    @Test
    public void test59False() {
        assertFalse(p.playOutside(59, false));
    }
    
    // playOutside(70, false) → true
    @Test
    public void test70False() {
        assertTrue(p.playOutside(70, false));
    }
    
    // playOutside(95, false) → false
    @Test
    public void test95False() {
        assertFalse(p.playOutside(95, false));
    }
    
    // playOutside(100, true) → true
    @Test
    public void test100True() {
        assertTrue(p.playOutside(100, true));
    }
}
