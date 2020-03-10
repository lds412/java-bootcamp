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
public class ParrotTroubleTest {
    
    private ParrotTrouble p = new ParrotTrouble();
    
    public ParrotTroubleTest() {
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

    // parrotTrouble(true, 21) -> true
    @Test
    public void testTrue21() {
        assertTrue(p.parrotTrouble(true, 21));
    }
    
    // parrotTrouble(true, 6) -> true
    @Test
    public void testTrue6() {
        assertTrue(p.parrotTrouble(true, 6));
    }
    
    // parrotTrouble(true, 7) -> false
    @Test
    public void testTrue7() {
        assertFalse(p.parrotTrouble(true, 7));
    }
    
    // parrotTrouble(false, 6) -> false
    @Test
    public void testFalse6() {
        assertFalse(p.parrotTrouble(false, 6));
    }
}
