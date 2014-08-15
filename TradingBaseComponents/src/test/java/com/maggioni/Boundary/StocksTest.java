
package com.maggioni.Boundary;

import com.maggioni.Entities.Stock;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author angelomaggioni
 */
public class StocksTest
{
    private static Context ctx;
    private static EJBContainer ejbcontainer;
    
    
    public StocksTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        ejbcontainer = EJBContainer.createEJBContainer();
        System.out.println("----->>  Opening container");
        ctx = ejbcontainer.getContext();
        
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        ejbcontainer.close();
        System.out.println("close EJB Container  <<---------");
    }
    

    /**
     * Test of createStock method, of class Stocks.
     */
    @Test
    public void testCreateStock() throws Exception
    {
        System.out.println("createStock");
        Stock st = new Stock("SPY","SP 500");
        
        Stocks instance = (Stocks)ctx.lookup("java:global/classes/Stocks");
        
        Stock result = instance.createStock(st);
        assertEquals(st.getSymbol(), result.getSymbol());
        
    }

    /**
     * Test of findByName method, of class Stocks.
     */
    @Test
    public void testFindByName() throws Exception
    {
        System.out.println("findByName");
        String symbol = "SPY";
        
        Stocks instance = (Stocks)ctx.lookup("java:global/classes/Stocks");
        Stock expResult = null;
        Stock result = instance.findByName(symbol);
        assertEquals(expResult, result);
        
        }
    
    @After
    public void tearDown()
    {
        
    }
    
}
