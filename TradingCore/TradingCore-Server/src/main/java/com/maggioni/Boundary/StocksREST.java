package com.maggioni.Boundary;

import com.maggioni.Control.StockException;
import com.maggioni.Entities.Stock;

import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

    public StocksREST()
    {
    }

    public StocksREST(Stocks st)
    {
        this.st = st;
    }

    @GET
    @Path("{symbol}")
    @Produces("application/xml")
    public Response getStock(@PathParam("symbol") String symbol)
    {
        Stock stock;
        try {
            stock = st.findBySymbol(symbol);

        } catch (StockException ex) {
            throw new RuntimeException(ex.getErrorCode());
        }

        return Response.ok().build();
    }

    @POST
    @Consumes("application/xml")
    public Response createStock(Stock stock)
    {
        try {
            st.createStock(stock);
        } catch (StockException ex) {
            throw new RuntimeException(ex.getErrorCode());
        }

        return Response.created(URI.create(stock.getSymbol())).build();
    }
}
