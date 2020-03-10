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
public class TrimOneTest {
    private TrimOne t = new TrimOne();
            
    public TrimOneTest() {
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

    // trimOne("coding") -> "odin"
    @Test
    public void testCoding() {
        assertEquals("odin", t.trimOne("coding"));
    }
    
    // trimOne("Hello") -> "ell"
    @Test
    public void testHello() {
        assertEquals("ell", t.trimOne("Hello"));
    }
    
    // trimOne("java") -> "av"
    @Test
    public void testJava() {
        assertEquals("av", t.trimOne("java"));
    }
}
