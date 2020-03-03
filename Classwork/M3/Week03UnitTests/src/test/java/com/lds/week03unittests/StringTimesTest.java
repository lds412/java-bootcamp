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
public class StringTimesTest {
    
    StringTimes stringTimes = new StringTimes();
    
    public StringTimesTest() {
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

    // stringTimes("Nonsense", 1) -> "Nonsense"
    @Test
    public void testNonsense1() {
        String expectedResult = "Nonsense";
        assertEquals(expectedResult, stringTimes.stringTimes("Nonsense", 1));
    }
    
    // stringTimes("Bye", 3) -> "ByeByeBye"
    @Test
    public void testBye3() {
        String expectedResult = "ByeByeBye";
        assertEquals(expectedResult, stringTimes.stringTimes("Bye", 3));
    }
    
    // stringTimes("Hi", 2) -> "HiHi"
    @Test
    public void testHi2() {
        String expectedResult = "HiHi";
        assertEquals(expectedResult, stringTimes.stringTimes("Hi", 2));
    }
    
    // stringTimes("Uhoh", 0) -> ""
    @Test
    public void testUhoh0() {
        String expectedResult = "";
        assertEquals(expectedResult, stringTimes.stringTimes("Uhoh", 0));
    }
}
