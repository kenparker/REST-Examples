package com.maggioni.Boundary;

import com.maggioni.Control.StockException;
import com.maggioni.Entities.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StocksTest {

    Stock st;
    Stocks stocks;
    EntityManager em;

    List<Stock> list;
    String symbol;
    TypedQuery<Stock> query;

    public StocksTest() {
    }

    @Before
    public void setUp() {

        st = new Stock("SPY", "SP 500");
        stocks = new Stocks();
        list = new ArrayList();

        em = mock(EntityManager.class);
        stocks.setEm(em);
    }

    private void mockQuery() {
        // Mock the Query
        query = mock(TypedQuery.class);
        when(em.createNamedQuery("Stock.findBySymbol", Stock.class)).thenReturn(query);
        when(query.setParameter("sy", st.getSymbol())).thenReturn(query);
        when(query.getResultList()).thenReturn(list);
    }

    private void verifyQuery() {
        // check whether the query was called
        verify(em).createNamedQuery("Stock.findBySymbol", Stock.class);
        verify(query).setParameter("sy", st.getSymbol());
        verify(query).getResultList();
    }

    @Test
    public void testFindByNameFound() throws Exception {

        list.add(new Stock("SPY", "SPPPPP"));
        mockQuery();

        // Let's call the function now
        Stock result = stocks.findBySymbol(st.getSymbol());

        verifyQuery();

        // verify the results
        assertEquals(list.get(0), result);

    }

    @Test
    public void testFindByNameNotFound() throws Exception {

        st.setSymbol("SPYsss");
        mockQuery();

        // Let's call the function now
        String errorCode = null;
        try {
            Stock result = stocks.findBySymbol(st.getSymbol());
        } catch (StockException se) {
            errorCode = se.getErrorCode();
        }

        verifyQuery();

        // verify the results
        assertEquals(errorCode, "STOCK_NOT_FOUND");

    }

    @Test
    public void testFindByNameTooManyFound() throws Exception {

        list.add(new Stock("SPY", "cccc"));
        list.add(new Stock("SPY", "ddd"));
        list.add(new Stock("SPY", "dddd"));

        mockQuery();

        // Let's call the function now
        String errorCode = null;
        try {
            Stock result = stocks.findBySymbol(st.getSymbol());
        } catch (StockException se) {
            errorCode = se.getErrorCode();
        }

        // check whether the query was called
        verifyQuery();

        // verify the results
        assertEquals(errorCode, "TOO_MANY_STOCKS_FOUND");

    }

    @Test
    public void testcreateStockOK() throws Exception {

        mockQuery();

        // Let's call the function now
        Stock result = null;
        try {
            result = stocks.createStock(st);
        } catch (StockException se) {
            fail("It should not get here");
        }

        // check whether the query was called
        verifyQuery();

        // verify the results
        assertEquals(st, result);
    }

    @Test
    public void testcreateStockTooMany() throws Exception {

        list.add(new Stock("SPY", "cccc"));
        list.add(new Stock("SPY", "ddd"));
        list.add(new Stock("SPY", "dddd"));

        mockQuery();

        // Let's call the function now
        try {
            stocks.createStock(st);
            fail("It should not get here");
        } catch (StockException se) {
            // check whether the query was called
            verifyQuery();
            // verify the results
            assertEquals("TOO_MANY_STOCKS_FOUND", se.getErrorCode());
        }
    }

    @Test
    public void testcreateStockNotOK() throws Exception {

        list.add(new Stock("SPY", "cccc"));

        mockQuery();

        // Let's call the function now
        try {
            stocks.createStock(st);
            fail("It should not get here");
        } catch (StockException se) {
            // check whether the query was called
            verifyQuery();
            // verify the results
            assertEquals("STOCK_FOUND", se.getErrorCode());
        }

    }

    @Test
    public void testUpdateStockNotOK() {

        mockQuery();
        try {
            stocks.updateStock(st);
        } catch (StockException ex) {
            verifyQuery();
            assertEquals("STOCK_NOT_FOUND", ex.getErrorCode());
        }

    }

    @Test
    public void testUpdateStockTooMany() {

        list.add(new Stock("SPY", "cccc"));
        list.add(new Stock("SPY", "cccc"));

        mockQuery();

        try {
            stocks.updateStock(st);
            fail("It should not do any update");
        } catch (StockException ex) {
            verifyQuery();
            assertEquals("TOO_MANY_STOCKS_FOUND", ex.getErrorCode());
        }

    }

    @Test
    public void testUpdateStockOK() {

        list.add(new Stock("SPY", "cccc"));
        mockQuery();

        try {
            stocks.updateStock(st);
            verifyQuery();
        } catch (StockException ex) {
            fail("Stockexception occurred");
        }
    }
}
