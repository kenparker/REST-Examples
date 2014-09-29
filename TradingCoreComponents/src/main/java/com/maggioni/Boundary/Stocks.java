package com.maggioni.Boundary;

import com.maggioni.Control.StockException;
import com.maggioni.Entities.Stock;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author angelomaggioni
 */
@Stateless
public class Stocks
{

    @PersistenceContext
    private EntityManager em;

    public void setEm(EntityManager em)
    {
        this.em = em;
    }
    
    

    public Stock createStock(Stock st) throws StockException
    {

        try
        {
            Stock findByName = findBySymbol(st.getSymbol());
        } catch (StockException ex)
        {
            switch (ex.getErrorCode())
            {
                case "STOCK_NOT_FOUND":
                    // in case not found create a new Stock
                    em.persist(st);
                    return st;
             
                case "TOO_MANY_STOCKS_FOUND":
                    throw ex;
            }
        }
        throw new StockException("Stock :" + st.getSymbol() + " found", "STOCK_FOUND");
    }

    public Stock findBySymbol(String symbol) throws StockException
    {

        // Create query and get results
        List<Stock> stocks = em.createNamedQuery("Stock.findBySymbol", Stock.class)
                .setParameter("sy", symbol)
                .getResultList();

        // check if something was found
        if (stocks.isEmpty())
        {
            throw new StockException("Stock :" + symbol + " not found", "STOCK_NOT_FOUND");
        }

        // check that only one stock found
        if (stocks.size() > 1)
        {
            throw new StockException("for Stock :" + symbol + " too many entities found", "TOO_MANY_STOCKS_FOUND");
        }

        return stocks.get(0);

    }

}
