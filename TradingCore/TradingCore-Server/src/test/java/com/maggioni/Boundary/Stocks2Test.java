package com.maggioni.Boundary;

import com.maggioni.Control.StockException;
import com.maggioni.Entities.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author angelomaggioni
 */
public class Stocks2Test {

    @Inject
    Stocks stocks;

    List<Stock> list;
    Stock stock;

    @Mock
    TypedQuery<Stock> query;
    @Mock
    EntityManager em;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        stocks = new Stocks();
        stocks.setEm(em);
        list = new ArrayList();
        stock = new Stock("SPY", "SP500");
        mockQuery();
    }

    private void mockQuery() {
        when(em.createNamedQuery("Stock.findBySymbol", Stock.class)).thenReturn(query);
        when(query.setParameter("sy", stock.getSymbol())).thenReturn(query);
        when(query.getResultList()).thenReturn(list);
    }

    @Test
    public void testCreateStockOK() throws Exception {
        Stock result = null;
        try {
            result = stocks.createStock(stock);
            Mockito.verify(em).persist(stock);
            assertEquals(stock, result);
        } catch (StockException se) {
            fail("It should not get here");
        }

    }

    @Test
    public void testCreateStockNotOK() throws Exception {
        list.add(new Stock("SPY", "cccc"));
        try {
            stocks.createStock(stock);
            fail("It should not get here");
        } catch (StockException se) {
            assertEquals("STOCK_FOUND", se.getErrorCode());
        }
    }
}
