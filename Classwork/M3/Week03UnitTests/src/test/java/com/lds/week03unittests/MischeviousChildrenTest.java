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
public class MischeviousChildrenTest {
    
    MischeviousChildren mischeviousChildren = new MischeviousChildren();
    
    public MischeviousChildrenTest() {
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

    // areWeInTrouble(true, true) -> true
    @Test
    public void testTrueTrue() {
        assertTrue(mischeviousChildren.areWeInTrouble(true, true));
    }
    
    // areWeInTrouble(false, false) -> true
    @Test
    public void testFalseFalse() {
        assertTrue(mischeviousChildren.areWeInTrouble(false, false));
    }
    
    // areWeInTrouble(true, false) -> false
    @Test
    public void testTrueFalse() {
        assertFalse(mischeviousChildren.areWeInTrouble(true, false));
    }
    
    // areWeInTrouble(false, true) -> false
    @Test
    public void testFalseTrue() {
        assertFalse(mischeviousChildren.areWeInTrouble(false, true));
    }
}
