package com.maggioni.Boundary;

import com.maggioni.Entities.Stock;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

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
    
    @Path("{id}")
    public Stock findStock() {
        
        return new Stock();
    }
}
