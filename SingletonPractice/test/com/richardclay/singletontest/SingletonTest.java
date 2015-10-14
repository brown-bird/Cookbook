/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardclay.singletontest;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import singletonpractice.*;

/**
 *
 * @author Richard
 */
public class SingletonTest
{

    public SingletonTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testSingleton()
    {
        Singleton s1 = Singleton.getInstance();
        assertFalse(s1 == null);
        
        Singleton s2 = Singleton.getInstance();
        assertTrue(s1 == s2);
        
        
        s2.setName("Fred");
        s1.setNum(54);
        assertTrue(s1.getName().equals(s2.getName()));
        assertTrue(s1.getNum() == s2.getNum());
    }
    @Test
    public void EagerSingletonTest()
    {
        EagerSingleton s1 = EagerSingleton.getInstance();
        assertFalse(s1 == null);
        
        EagerSingleton s2 = EagerSingleton.getInstance();
        assertTrue(s1 == s2);
        
        
        s2.setName("Fred");
        s1.setNum(54);
        assertTrue(s1.getName().equals(s2.getName()));
        assertTrue(s1.getNum() == s2.getNum());
    }
    @Test
    public void DoubleCheckedLockedSingletonTest()
    {
        DoubleCheckedLockedSingleton s1 = DoubleCheckedLockedSingleton.getInstance();
        assertFalse(s1 == null);
        
        DoubleCheckedLockedSingleton s2 = DoubleCheckedLockedSingleton.getInstance();
        assertTrue(s1 == s2);
        
        
        s2.setName("Fred");
        s1.setNum(54);
        assertTrue(s1.getName().equals(s2.getName()));
        assertTrue(s1.getNum() == s2.getNum());
    }
}
