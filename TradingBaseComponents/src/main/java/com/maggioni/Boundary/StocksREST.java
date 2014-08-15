package com.maggioni.Boundary;

import com.maggioni.Control.StockException;
import com.maggioni.Entities.Stock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author angelomaggioni
 */
@Stateless
@Path("stocks")
public class StocksREST
{

    @Inject
    Stocks st;
    @Inject
    Stock stock;
    
    @GET
    @Path("{id}")
    public Stock findStock() {
        
        return new Stock();
    }
    
    @POST
    @Consumes({"application/xml", "application/json"})
    public void createStock(String symbol, String name) {
        
        stock.setSymbol(symbol);
        stock.setName(name);
        try
        {
            st.createStock(stock);
        } catch (StockException ex)
        {
            Logger.getLogger(StocksREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    }
}
