package com.maggioni.Boundary;

import com.maggioni.Control.StockException;
import com.maggioni.Entities.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StocksTest {

    Stocks stocks;
    EntityManager em;
    
    List<Stock> list;
    String symbol;
    TypedQuery<Stock> query;

    public StocksTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
       
        stocks = new Stocks();
        list = new ArrayList();
        symbol = "SPY";
        
        em = mock(EntityManager.class);
        stocks.setEm(em);
        
        // Mock the Query
        query = mock(TypedQuery.class);
        when(em.createNamedQuery("Stock.findBySymbol", Stock.class)).thenReturn(query);
        when(query.setParameter("sy", symbol)).thenReturn(query);
        when(query.getResultList()).thenReturn(list);
    }

    /**
     * Test of findBySymbol method, of class Stocks.
     */
    @Test
    public void testFindByNameFound() throws Exception {

        symbol = "SPY";      
        list.add(new Stock("SPY", "SPPPPP"));
  
        // Let's call the function now
        Stock result = stocks.findBySymbol(symbol);

        // check whether the query was called
        verify(em).createNamedQuery("Stock.findBySymbol", Stock.class);
        verify(query).setParameter("sy", symbol);
        verify(query).getResultList();

        // verify the results
        assertEquals(list.get(0), result);

    }

    @Test
    public void testFindByNameNotFound() throws Exception {

        symbol = "SPYsss";

        // Let's call the function now
        String errorCode = null;
        try {
            Stock result = stocks.findBySymbol(symbol);
        } catch (StockException se) {
            errorCode = se.getErrorCode();
        }

        // check whether the query was called
        verify(em).createNamedQuery("Stock.findBySymbol", Stock.class);
        verify(query).setParameter("sy", symbol);
        verify(query).getResultList();

        // verify the results
        assertEquals(errorCode, "STOCK_NOT_FOUND");

    }

    @Test
    public void testFindByNameTooManyFound() throws Exception {

        symbol = "SPY";

        list.add(new Stock("SPY", "cccc"));
        list.add(new Stock("SPY", "ddd"));
        list.add(new Stock("SPY", "dddd"));

        // Let's call the function now
        String errorCode = null;
        try {
            Stock result = stocks.findBySymbol(symbol);
        } catch (StockException se) {
            errorCode = se.getErrorCode();
        }

        // check whether the query was called
        verify(em).createNamedQuery("Stock.findBySymbol", Stock.class);
        verify(query).setParameter("sy", symbol);
        verify(query).getResultList();

        // verify the results
        assertEquals(errorCode, "TOO_MANY_STOCKS_FOUND");

    }

    @Test
    public void testcreateStockOK() throws Exception {

        symbol = "SPY";
        Stock st = new Stock("SPY", "ssssss");
         
        // Let's call the function now
        String errorCode = null;
        Stock result = null;
        try {
            result = stocks.createStock(st);
        } catch (StockException se) {
            errorCode = se.getErrorCode();
        }

        // check whether the query was called
        verify(em).createNamedQuery("Stock.findBySymbol", Stock.class);
        verify(query).setParameter("sy", symbol);
        verify(query).getResultList();

        // verify the results
        assertEquals(st, result);

    }

    @Test
    public void testcreateStockTooMany() throws Exception {

        symbol = "SPY";
        Stock st = new Stock("SPY", "ssssss");

        list.add(new Stock("SPY", "cccc"));
        list.add(new Stock("SPY", "ddd"));
        list.add(new Stock("SPY", "dddd"));

        // Let's call the function now
        String errorCode = null;
        Stock result = null;
        try {
            result = stocks.createStock(st);
        } catch (StockException se) {
            errorCode = se.getErrorCode();
        }

        // check whether the query was called
        verify(em).createNamedQuery("Stock.findBySymbol", Stock.class);
        verify(query).setParameter("sy", symbol);
        verify(query).getResultList();

        // verify the results
        assertEquals(errorCode, "TOO_MANY_STOCKS_FOUND");

    }

    @Test
    public void testcreateStockNotOK() throws Exception {

        symbol = "SPY";
        Stock st = new Stock("SPY", "ssssss");
        list.add(new Stock("SPY", "cccc"));

        // Let's call the function now
        String errorCode = null;
        Stock result = null;
        try {
            result = stocks.createStock(st);
        } catch (StockException se) {
            errorCode = se.getErrorCode();
        }

        // check whether the query was called
        verify(em).createNamedQuery("Stock.findBySymbol", Stock.class);
        verify(query).setParameter("sy", symbol);
        verify(query).getResultList();

        // verify the results
        assertEquals(errorCode, "STOCK_FOUND");

    }

    @After
    public void tearDown() {

    }

}
