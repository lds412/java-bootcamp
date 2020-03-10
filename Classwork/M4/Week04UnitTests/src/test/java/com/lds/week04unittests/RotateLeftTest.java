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
public class RotateLeftTest {
    
    private RotateLeft rl = new RotateLeft();
    
    public RotateLeftTest() {
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

    // rotateLeft({1, 2, 3}) -> {2, 3, 1}
    @Test
    public void test123() {
        int[] exp = {2, 3, 1};
        int[] nums = {1, 2, 3};
        int[] actual = rl.rotateLeft(nums);
        for(int i = 0; i < exp.length; i++){
            assertEquals(exp[i],actual[i]);
        }
    }
    
    // rotateLeft({5, 11, 9}) -> {11, 9, 5}
    @Test
    public void test5119() {
        int[] exp = {11, 9, 5};
        int[] nums = {5, 11, 9};
        int[] actual = rl.rotateLeft(nums);
        for(int i = 0; i < exp.length; i++){
            assertEquals(exp[i],actual[i]);
        }
    }
    
    // rotateLeft({7, 0, 0}) -> {0, 0, 7}
    @Test
    public void test700() {
        int[] exp = {0, 0, 7};
        int[] nums = {7, 0, 0};
        int[] actual = rl.rotateLeft(nums);
        for(int i = 0; i < exp.length; i++){
            assertEquals(exp[i],actual[i]);
        }
    }
}
