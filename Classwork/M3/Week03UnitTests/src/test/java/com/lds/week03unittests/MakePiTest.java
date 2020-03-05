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
public class MakePiTest {
    
    private MakePi pi = new MakePi();
    
    public MakePiTest() {
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

    // makePi(3) -> {3, 1, 4}
    //3 . 1 4 1 5 9 2 6 5 
    @Test
    public void testSomeMethod() {
        int[] exp = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        int[] actual = pi.makePi(9);
        for (int i = 0; i < exp.length; i++){
            assertEquals(actual[i], exp[i]);
        }
        //assertEquals(exp,pi.makePi(9));
        //assertThat(pi.makePi(9), samePropertyValuesAs(exp));
        //assertThat(pi.makePi(9)).isEqualToComparingFieldByField(exp);
        //assertThat(pi.makePi(9), sameBeanAs(exp));
    }
    
    // makePi(2) -> {3, 1}
    @Test
    public void test2() {
        int[] exp = {3, 1};
        int[] actual = pi.makePi(2);
        for (int i = 0; i < exp.length; i++){
            assertEquals(actual[i], exp[i]);
        }
    }
    
    // makePi(1) -> {3}
    @Test
    public void test1() {
        int[] exp = {3};
        int[] actual = pi.makePi(1);
        for (int i = 0; i < exp.length; i++){
            assertEquals(actual[i], exp[i]);
        }
    }
    
    // makePi(0) -> {}
    @Test
    public void test0() {
        int[] exp = {};
        int[] actual = pi.makePi(0);
        for (int i = 0; i < exp.length; i++){
            assertEquals(actual[i], exp[i]);
        }
    }
    
}
