package com.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
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
        WebTarget resource;
        Client client;
        String BASE_URI = "http://localhost:8080/ExampleServerClient/res/";
        client = javax.ws.rs.client.ClientBuilder.newClient();
        resource = client.target(BASE_URI).path("hello");

        String str = resource.request().get(String.class);

        assertEquals(str, "Hello duke");

    }

}
