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
public class InsertWordTest {
    
    private InsertWord word = new InsertWord();
    
    public InsertWordTest() {
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

    // insertWord("[[]]", "word") -> "[[word]]"
    @Test
    public void testWord() {
        String exp = "[[word]]";
        assertEquals(exp, word.insertWord("[[]]", "word"));
    }
    
    // insertWord("<<>>", "Yay") -> "<<Yay>>"
    @Test
    public void testYay() {
        String exp = "<<Yay>>";
        assertEquals(exp, word.insertWord("<<>>", "Yay"));
    }
    
    // insertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
    @Test
    public void testWooHoo() {
        String exp = "<<WooHoo>>";
        assertEquals(exp, word.insertWord("<<>>", "WooHoo"));
    }
}
