package com.maggioni.Boundary;

import com.maggioni.Control.StockException;
import com.maggioni.Entities.Stock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import javax.ejb.embeddable.EJBContainer;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author angelomaggioni
 */
public class StocksRESTTest
{
    StocksREST stocksREST;
    Stocks st;
    Stock stock;
    
    public StocksRESTTest()
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
    public void setUp() throws StockException
    {
        
        stock = new Stock("SPY", "SSSS");
        
        st = Mockito.mock(Stocks.class);
        
            when(st.findBySymbol("SPY"))
                    .thenReturn(stock);
            when(st.findBySymbol("QQQ"))
                    .thenThrow(new StockException("Stock :" + "QQQ" + " not found", "STOCK_NOT_FOUND"));
            
        stocksREST = new StocksREST(st);
        
    }
  
    /**
     * Test of getStock method, of class StocksREST.
     */
    @Test
    public void testGetStock() throws IOException
    {
        System.out.println("getStock");
        
        StreamingOutput result = new StreamingOutput()
        {

            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException
            {
                stocksREST.outputStock(output, stock);
            }
        };
        
        StreamingOutput so = stocksREST.getStock("SPY");
        if (so.equals(result))
        {
            System.out.println("equal");
        }
      //  assertTrue(so.equals(result));
       
       
    }
    
    

}
