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
public class SameFirstLastTest {
    
    private SameFirstLast sfl = new SameFirstLast();
    
    public SameFirstLastTest() {
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

    // sameFirstLast({1, 2, 3}) -> false
    @Test
    public void testDiffSize3() {
        int[] nums = {1, 2, 3};
        assertFalse(sfl.sameFirstLast(nums));
    }
    
    // sameFirstLast({5}) -> true
    @Test
    public void testSameSize1() {
        int[] nums = {5};
        assertTrue(sfl.sameFirstLast(nums));
    }
    
    // sameFirstLast({}) -> false
    @Test
    public void testSameSizeNull() {
        int[] nums = {};
        assertFalse(sfl.sameFirstLast(nums));
    }
    
    // sameFirstLast({1, 2, 3, 1}) -> true
    @Test
    public void testSameSize4() {
        int[] nums = {1, 2, 3, 1};
        assertTrue(sfl.sameFirstLast(nums));
    }
    
    // sameFirstLast({10, 2, 10}) -> true
    @Test
    public void testSameSize3() {
        int[] nums = {10, 2, 10};
        assertTrue(sfl.sameFirstLast(nums));
    }
}
