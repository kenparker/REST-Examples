/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maggioni.Boundary;

import javax.ejb.embeddable.EJBContainer;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.StreamingOutput;
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
public class StocksREST2Test
{
    
    public StocksREST2Test()
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
     * Test of getStock method, of class StocksREST.
     */
    @Test
    public void testGetStock() throws Exception
    {
        System.out.println("getStock");
        String symbol = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        StocksREST instance = (StocksREST)container.getContext().lookup("java:global/classes/StocksREST");
        StreamingOutput expResult = null;
        StreamingOutput result = instance.getStock(symbol);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createStock method, of class StocksREST.
     */
    @Test
    public void testCreateStock() throws Exception
    {
        System.out.println("createStock");
        String symbol = "";
        String name = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        StocksREST instance = (StocksREST)container.getContext().lookup("java:global/classes/StocksREST");
        instance.createStock(symbol, name);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of post method, of class StocksREST.
     */
    @Test
    public void testPost() throws Exception
    {
        System.out.println("post");
        MultivaluedHashMap<String, String> formParameters = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        StocksREST instance = (StocksREST)container.getContext().lookup("java:global/classes/StocksREST");
        instance.post(formParameters);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
