package com.maggioni.ClientREST;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.internal.LocalizationMessages;

/**
 * Jersey REST client generated for REST resource:StocksREST [/stocks]<br>
 * USAGE:
 * <pre>
 * StocksHelloClient client = new StocksHelloClient();
 * Object response = client.XXX(...);
 * // do whatever with response
 * client.close();
 * </pre>
 *
 * @author angelomaggioni
 */
public class StocksRESTClient
{

    private WebTarget resource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ExampleChapter3/resources/";

    public StocksRESTClient()
    {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        resource = client.target(BASE_URI).path("stocks");
    }

    public void createStock() throws ClientErrorException
    {
        System.out.println("*** Create a new Stock *****");
        String xml = "<stock symbol=\"spy\">"
                + "<name>" + "SP 500" + "</name>"
                + "</stock>";
        Response response = resource.request().post(Entity.xml(xml));
        if (response.getStatus() != 201)
        {
            throw new RuntimeException("Failed to create");
        }

        String location = response.getLocation().toString();
        System.out.println("location: " + location);
    }

    public void close()
    {
        client.close();
    }
}
