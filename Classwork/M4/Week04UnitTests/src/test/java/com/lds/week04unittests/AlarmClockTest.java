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
public class AlarmClockTest {
    
    private AlarmClock ac = new AlarmClock();
    
    public AlarmClockTest() {
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

    // alarmClock(1, false) → "7:00"
    @Test
    public void test1False() {
        assertEquals("7:00", ac.alarmClock(1, false));
    }
    
    // alarmClock(2, true) -> "10:00"
    @Test
    public void test2Tru() {
        assertEquals("10:00", ac.alarmClock(2, true));
    }
    
    // alarmClock(5, false) → "7:00"
    @Test
    public void test5False() {
        assertEquals("7:00", ac.alarmClock(5, false));
    }
    
    // alarmClock(0, false) → "10:00"
    @Test
    public void test0False() {
        assertEquals("10:00", ac.alarmClock(0, false));
    }
    
    // alarmClock(6, true) -> "off"
    @Test
    public void test6True() {
        assertEquals("off", ac.alarmClock(6, true));
    }
}
