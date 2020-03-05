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
public class FrontTimesTest {
    
    private FrontTimes ft = new FrontTimes();
    
    public FrontTimesTest() {
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

    // frontTimes("Chocolate", 2) -> "ChoCho"
    @Test
    public void testCho2() {
        String expected = "ChoCho";
        assertEquals(expected, ft.frontTimes("Chocolate", 2));
    }
    
    // frontTimes("Hi", 3) -> "HiHiHi"
    @Test
    public void testHi3() {
        String expected = "HiHiHi";
        assertEquals(expected, ft.frontTimes("Hi", 3));
    }
    
    // frontTimes("Abc", 4) -> "AbcAbcAbcAbc"
    @Test
    public void testAbc4() {
        String expected = "AbcAbcAbcAbc";
        assertEquals(expected, ft.frontTimes("Abc", 4));
    }
}
