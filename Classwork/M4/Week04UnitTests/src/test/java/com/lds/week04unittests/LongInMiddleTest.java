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
public class LongInMiddleTest {
    
    private LongInMiddle lim = new LongInMiddle();
    
    public LongInMiddleTest() {
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

    // longInMiddle("aaa", "b") -> "baaab"
    @Test
    public void testBaab() {
        assertEquals("baaab",lim.longInMiddle("aaa", "b"));
    }
    
    // longInMiddle("Hello", "hi") -> "hiHellohi"
    @Test
    public void testHiHello() {
        assertEquals("hiHellohi",lim.longInMiddle("Hello", "hi"));
    }
    
    // longInMiddle("hi", "Hello") -> "hiHellohi"
    @Test
    public void testHelloHi() {
        assertEquals("hiHellohi",lim.longInMiddle("hi", "Hello"));
    }
    
    // longInMiddle("", "Hello") -> "Hello"
    @Test
    public void testHello() {
        assertEquals("Hello",lim.longInMiddle("", "Hello"));
    }
}
