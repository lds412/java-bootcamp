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
public class SumTest {
    
    Sum sum = new Sum();
    
    public SumTest() {
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

    // sum({7, 0, 0}) -> 7
    @Test
    public void test7() {
        int[] nums = {7, 0, 0};
        assertEquals(7, sum.sum(nums));
    }
    
    // sum({1, 2, 3}) -> 6
    @Test
    public void test6() {
        int[] nums = {1, 2, 3};
        assertEquals(6, sum.sum(nums));
    }
    
    // sum({5, 11, 2}) -> 18
    @Test
    public void test18() {
        int[] nums = {5, 11, 2};
        assertEquals(18, sum.sum(nums));
    }
}
