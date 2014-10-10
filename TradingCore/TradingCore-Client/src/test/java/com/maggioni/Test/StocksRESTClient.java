package com.maggioni.Test;

import com.maggioni.Entities.Stock;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StocksRESTClient {

    private WebTarget resource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/TradingCore-Server/resources/";

    public StocksRESTClient() {

    }

    @Before
    public void setUp() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        resource = client.target(BASE_URI).path("stocks");
    }

    @Test
    public void create_stock_Found_error() throws ClientErrorException {
        System.out.println("*** Create a new Stock - Stock found *****");

        Stock st = new Stock("QQQ", "Nasdaq");
        Response response = resource.request()
                .post(Entity.entity(st, MediaType.APPLICATION_XML));
       
        Assert.assertEquals(Status.fromStatusCode(response.getStatus()), Status.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void create_stock_created() throws ClientErrorException {
        System.out.println("*** Create a new Stock - Stock created *****");

        Stock st = new Stock("QQQ3", "Nasdaq");
        Response response = resource.request()
                .post(Entity.entity(st, MediaType.APPLICATION_XML));
        
        if (Status.fromStatusCode(response.getStatus()) == Status.CREATED) {
            String location = response.getLocation().toString();
            System.out.println("location: " + location);
        }
        Assert.assertEquals(Status.CREATED,Status.fromStatusCode(response.getStatus()));
    }

    @Test
    public void get_stock_found() {
        System.out.println("*** get Stock - stock found ****");
        
        String symbol = "SPY";
        
        Builder request = resource.path("/{symbol}")
                .resolveTemplate("symbol", symbol)
                .request();      
        Response response = request.get();
        
        Assert.assertEquals(Status.OK,Status.fromStatusCode(response.getStatus()));
        Stock stock = request.get(Stock.class);
        Assert.assertEquals(symbol,stock.getSymbol());
        
    }
    /*
     public void getStock(String location)
     {
     System.out.println("*** GET Stock ***");
     //final WebTarget path = client.target(BASE_URI+location);
     //System.out.println(path.getUri().toString());
     String stock = client.target(location).request().get(String.class);
     System.out.println(stock);
     }
     */
    @After
    public void close() {
        client.close();
    }
}
