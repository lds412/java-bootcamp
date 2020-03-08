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
public class CountXXTest {
    
    private CountXX cXX = new CountXX();
    
    public CountXXTest() {
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

    // countXX("abcxx") -> 1
    @Test
    public void testXX() {
        assertEquals(1, cXX.countXX("abcxx"));
    }
    
    // countXX("xxx") -> 2
    @Test
    public void testXXX() {
        assertEquals(2, cXX.countXX("xxx"));
    }
    
    // countXX("xxxx") -> 3
    @Test
    public void testXXXX() {
        assertEquals(3, cXX.countXX("xxxx"));
    }
    
    // countXX("x") -> 0
    @Test
    public void testX() {
        assertEquals(0, cXX.countXX("x"));
    }
}
