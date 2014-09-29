package com.maggioni.Boundary;

import com.maggioni.Control.StockException;
import com.maggioni.Entities.Stock;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.StreamingOutput;

/**
 *
 * @author angelomaggioni
 */
@Stateless
@Path("stocks")
public class StocksREST {

    @Inject
    Stocks st;
    @Inject
    Stock stock;

    public StocksREST() {
    }

    public StocksREST(Stocks st) {
        this.st = st;
    }

    @GET
    @Path("{symbol}")
    @Produces("application/xml")
    public StreamingOutput getStock(@PathParam("symbol") String symbol) {

        Stock stock;
        try {
            stock = st.findBySymbol(symbol);
            return new StreamingOutput() {
                @Override
                public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                    outputStock(outputStream, stock);
                }
            };

        } catch (StockException ex) {
            throw new RuntimeException(ex.getErrorCode());
        }

    }

    @POST
    @Path("/standardPost")
    @Consumes(
            {
                "application/xml", "application/json"
            })
    public void createStock(String symbol, String name) {

        stock.setSymbol(symbol);
        stock.setName(name);
        try {
            st.createStock(stock);
        } catch (StockException ex) {
            Logger.getLogger(StocksREST.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @POST
    @Path("/testPost")
    @Consumes("application/x-www-form.urlencoded")
    public void post(MultivaluedHashMap<String, String> formParameters) {

        Set<Map.Entry<String, List<String>>> entrySet = formParameters.entrySet();

    }

    public void outputStock(OutputStream os, Stock stock) {
        PrintStream writer = new PrintStream(os);
        writer.println("<stock symbol=\"" + stock.getSymbol() + "\">");
        writer.println(" <name>" + stock.getName() + "</name>");
        writer.println("</stock>");
    }
}
