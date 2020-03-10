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
public class Diff21Test {
    
    private Diff21 d = new Diff21();
    
    public Diff21Test() {
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

    // diff21(21) -> 0
    @Test
    public void test21() {
        assertEquals(0, d.diff21(21));
    }
    
    // diff21(23) -> 4
    @Test
    public void test23() {
        assertEquals(4, d.diff21(23));
    }
    
    // diff21(10) -> 11
    @Test
    public void test11() {
        assertEquals(11, d.diff21(10));
    }
}
