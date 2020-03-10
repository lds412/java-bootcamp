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
public class CommonEndTest {
    
    private CommonEnd common = new CommonEnd();
    
    public CommonEndTest() {
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

    // commonEnd({1, 2, 3}, {7, 3}) -> true
    @Test
    public void testSameEnd() {
        int[] a = {1, 2, 3};
        int[] b = {7, 3};
        assertTrue(common.commonEnd(a, b));
    }
    
    // commonEnd({1, 2, 3}, {1, 5}) -> true
    @Test
    public void testSameStart() {
        int[] a = {1, 2, 3};
        int[] b = {1, 5};
        assertTrue(common.commonEnd(a, b));
    }
    
    // commonEnd({1, 2, 3}, {1, 3}) -> true
    @Test
    public void testBoth() {
        int[] a = {1, 2, 3};
        int[] b = {1, 3};
        assertTrue(common.commonEnd(a, b));
    }
    
    // commonEnd({1, 2, 3}, {7, 3, 2}) -> false
    @Test
    public void testNeither() {
        int[] a = {1, 2, 3};
        int[] b = {7, 3, 2};
        assertFalse(common.commonEnd(a, b));
    }
}
