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
public class FirstLast6Test {
    
    private FirstLast6 fl = new FirstLast6();
    
    public FirstLast6Test() {
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

    // firstLast6({1, 2, 6}) -> true
    @Test
    public void test6Last() {
        int[] nums = {1, 2, 6};
        assertTrue(fl.firstLast6(nums));
    }

    // firstLast6({6, 1, 2, 3}) -> true
    @Test
    public void test6First() {
        int[] nums = {6, 1, 2, 3};
        assertTrue(fl.firstLast6(nums));
    }
    
    // firstLast6({13, 6, 1, 2, 3}) -> false
    @Test
    public void test6Middle() {
        int[] nums = {13, 6, 1, 2, 3};
        assertFalse(fl.firstLast6(nums));
    }
    
    // firstLast6({}) -> false
    @Test
    public void testNull() {
        int[] nums = {};
        assertFalse(fl.firstLast6(nums));
    }
    
    // firstLast6({5}) -> false
    @Test
    public void test5Only() {
        int[] nums = {5};
        assertFalse(fl.firstLast6(nums));
    }
    
    // firstLast6({6}) -> true
    @Test
    public void test6Only() {
        int[] nums = {6};
        assertTrue(fl.firstLast6(nums));
    }
}
