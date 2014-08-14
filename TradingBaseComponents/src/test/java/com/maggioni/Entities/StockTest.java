/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.maggioni.Entities;

import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author angelomaggioni
 */
public class StockTest
{
    
    public StockTest()
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

    /**
     * Test of getSymbol method, of class Stock.
     */
    @Test
    public void testGetSymbol()
    {
        System.out.println("getSymbol");
        Stock instance = new Stock();
        String expResult = "";
        String result = instance.getSymbol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSymbol method, of class Stock.
     */
    @Test
    public void testSetSymbol()
    {
        System.out.println("setSymbol");
        String symbol = "";
        Stock instance = new Stock();
        instance.setSymbol(symbol);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Stock.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        Stock instance = new Stock();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Stock.
     */
    @Test
    public void testSetName()
    {
        System.out.println("setName");
        String name = "";
        Stock instance = new Stock();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Stock.
     */
    @Test
    public void testGetId()
    {
        System.out.println("getId");
        Stock instance = new Stock();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Stock.
     */
    @Test
    public void testSetId()
    {
        System.out.println("setId");
        Long id = null;
        Stock instance = new Stock();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBarSize method, of class Stock.
     */
    @Test
    public void testGetBarSize()
    {
        System.out.println("getBarSize");
        Stock instance = new Stock();
        Map<String, Barsize> expResult = null;
        Map<String, Barsize> result = instance.getBarSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOneBarSize method, of class Stock.
     */
    @Test
    public void testGetOneBarSize()
    {
        System.out.println("getOneBarSize");
        String intervaltype = "";
        Stock instance = new Stock();
        Barsize expResult = null;
        Barsize result = instance.getOneBarSize(intervaltype);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBarSize method, of class Stock.
     */
    @Test
    public void testSetBarSize()
    {
        System.out.println("setBarSize");
        Map<String, Barsize> quotes = null;
        Stock instance = new Stock();
        instance.setBarSize(quotes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addIntervalType method, of class Stock.
     */
    @Test
    public void testAddIntervalType()
    {
        System.out.println("addIntervalType");
        String intervaltype = "";
        Stock instance = new Stock();
        instance.addIntervalType(intervaltype);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuotes method, of class Stock.
     */
    @Test
    public void testGetQuotes()
    {
        System.out.println("getQuotes");
        String intervaltype = "";
        Stock instance = new Stock();
        List<Quote> expResult = null;
        List<Quote> result = instance.getQuotes(intervaltype);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Stock.
     */
    @Test
    public void testHashCode()
    {
        System.out.println("hashCode");
        Stock instance = new Stock();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Stock.
     */
    @Test
    public void testEquals()
    {
        System.out.println("equals");
        Object obj = null;
        Stock instance = new Stock();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Stock.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        Stock instance = new Stock();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of intervalToString method, of class Stock.
     */
    @Test
    public void testIntervalToString()
    {
        System.out.println("intervalToString");
        Stock instance = new Stock();
        String expResult = "";
        String result = instance.intervalToString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
