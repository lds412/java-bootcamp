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
public class EveryOtherTest {
    
    private EveryOther eo = new EveryOther();
    
    public EveryOtherTest() {
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

    // everyOther("Hello") -> "Hlo"
    @Test
    public void testHello() {
        String exp = "Hlo";
        assertEquals(exp,eo.everyOther("Hello"));
    }
    
    // everyOther("Hi") -> "H"
    @Test
    public void testHi() {
        String exp = "H";
        assertEquals(exp,eo.everyOther("Hi"));
    }
    
    // everyOther("Heeololeo") -> "Hello"
    @Test
    public void testHeeololeo() {
        String exp = "Hello";
        assertEquals(exp,eo.everyOther("Heeololeo"));
    }
}
