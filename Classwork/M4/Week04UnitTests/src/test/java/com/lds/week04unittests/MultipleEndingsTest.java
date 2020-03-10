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
public class MultipleEndingsTest {
    
    private MultipleEndings me = new MultipleEndings();
    
    public MultipleEndingsTest() {
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

    // multipleEndings("Hi") -> "HiHiHi"
    @Test
    public void testHi() {
        String exp = "HiHiHi";
        assertEquals(exp,me.multipleEndings("Hi"));
    }
    
    // multipleEndings("Hello") -> "lololo"
    @Test
    public void testHello() {
        String exp = "lololo";
        assertEquals(exp,me.multipleEndings("Hello"));
    }
    
    // multipleEndings("ab") -> "ababab"
    @Test
    public void testAb() {
        String exp = "ababab";
        assertEquals(exp,me.multipleEndings("ab"));
    }
}
