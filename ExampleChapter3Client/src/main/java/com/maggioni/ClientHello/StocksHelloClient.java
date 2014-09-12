
package com.maggioni.ClientHello;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:StocksREST [/stocks]<br>
 * USAGE:
 * <pre>
        StocksHelloClient client = new StocksHelloClient();
        Object response = client.XXX(...);
        // do whatever with response
        client.close();
 </pre>
 *
 * @author angelomaggioni
 */
public class StocksHelloClient
{
private WebTarget resource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ExampleChapter3/resources/";

    public StocksHelloClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        resource = client.target(BASE_URI).path("Hello");
    }

    public String sayHello() throws ClientErrorException {
        //WebTarget resource = this.resource;
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void close() {
        client.close();
    }    
}
