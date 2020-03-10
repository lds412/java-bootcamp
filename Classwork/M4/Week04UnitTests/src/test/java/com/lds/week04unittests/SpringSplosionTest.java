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
public class SpringSplosionTest {
    
    private SpringSplosion ss = new SpringSplosion();
    
    public SpringSplosionTest() {
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

    // stringSplosion("ab") -> "aab"
    @Test
    public void testAb() {
        assertEquals("aab", ss.stringSplosion("ab"));
    }
    
    // stringSplosion("Code") -> "CCoCodCode"
    @Test
    public void testCode() {
        assertEquals("CCoCodCode", ss.stringSplosion("Code"));
    }
    
    // stringSplosion("abc") -> "aababc"
    @Test
    public void testAbc() {
        assertEquals("aababc", ss.stringSplosion("abc"));
    }
}
