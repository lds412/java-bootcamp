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
public class FirstHalfTest {
    
    private FirstHalf fh = new FirstHalf();
    
    public FirstHalfTest() {
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

    // firstHalf("abcdef") -> "abc"
    @Test
    public void testAbc() {
        assertEquals("abc", fh.firstHalf("abcdef"));
    }
    
    // firstHalf("WooHoo") -> "Woo"
    @Test
    public void testWoo() {
        assertEquals("Woo", fh.firstHalf("WooHoo"));
    }
    
    // firstHalf("HelloThere") -> "Hello"
    @Test
    public void testHello() {
        assertEquals("Hello", fh.firstHalf("HelloThere"));
    }
}
