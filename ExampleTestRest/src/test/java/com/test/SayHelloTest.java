package com.test;

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
public class SayHelloTest
{
    SayHello sayHello;

    public SayHelloTest()
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
        sayHello = new SayHello();
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of hello method, of class SayHello.
     */
    @Test
    public void testHello()
    {
  
        String hello = sayHello.hello();
        assertEquals(hello, "Hello duke");

    }
    
    

}
