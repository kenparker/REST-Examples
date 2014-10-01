package com.maggioni.Test;



import com.maggioni.Entities.Stock;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.Test;



public class StocksRESTClient
{

    private WebTarget resource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/TradingCore-Server/resources/";

    public StocksRESTClient()
    {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        resource = client.target(BASE_URI).path("stocks");
    }

    @Test
    public void createStock() throws ClientErrorException
    {
        System.out.println("*** Create a new Stock *****");
       
        Stock st = new Stock("SPY","fff");
        Response response = resource.request()
                .post(Entity.entity(st, MediaType.APPLICATION_XML));
        if (response.getStatus() != 201)
        {
            System.out.println("Error");
        }

        String location = response.getLocation().toString();
        System.out.println("location: " + location);
        
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
    public void close()
    {
        client.close();
    }
}
