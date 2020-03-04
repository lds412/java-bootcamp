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
public class GreatPartyTest {
    
    GreatParty party = new GreatParty();
    
    public GreatPartyTest() {
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

    @Test
    public void test30False() {
        assertFalse(party.greatParty(30, false));
    }
    
    @Test
    public void test50False() {
        assertTrue(party.greatParty(50, false));
    }
    
    @Test
    public void test70True(){
        assertTrue(party.greatParty(70, true));
    }
    
    //greatParty(39, true) → false
    @Test
    public void test39True(){
        assertFalse(party.greatParty(39, true));
    }
    
    //greatParty(39, false) → false
    @Test
    public void test39False(){
        assertFalse(party.greatParty(39, false));
    }
    
    //greatParty(40, true) → true
    @Test
    public void test40True(){
        assertTrue(party.greatParty(40, true));
    }
    
    //greatParty(40, false) → true
    @Test
    public void test40False(){
        assertTrue(party.greatParty(40, false));
    }
    
    //greatParty(60, true) → true
    @Test
    public void test60True(){
        assertTrue(party.greatParty(60, true));
    }
    
    //greatParty(60, false) → true
    @Test
    public void test60False(){
        assertTrue(party.greatParty(60, false));
    }
    
    //greatParty(61, true) → true
    @Test
    public void test61True(){
        assertTrue(party.greatParty(61, true));
    }
    
    //greatParty(61, false) → false
    @Test
    public void test61False(){
        assertFalse(party.greatParty(61, false));
    }
}
