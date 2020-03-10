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
public class MakeTagsTest {
    
    private MakeTags tags = new MakeTags();
    
    public MakeTagsTest() {
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

    // makeTags("cite", "Yay") -> "<cite>Yay</cite>"
    @Test
    public void testCite() {
        assertEquals("<cite>Yay</cite>", tags.makeTags("cite", "Yay"));
    }
    
    // makeTags("i", "Yay") -> "<i>Yay</i>"
    @Test
    public void testYay() {
        assertEquals("<i>Yay</i>", tags.makeTags("i", "Yay"));
    }
    
    // makeTags("i", "Hello") -> "<i>Hello</i>"
    @Test
    public void testHello() {
        assertEquals("<i>Hello</i>", tags.makeTags("i", "Hello"));
    }
}
