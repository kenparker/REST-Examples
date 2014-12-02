package com.maggioni.Client;

import com.maggioni.Entity.Developer;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * http://www.adam-bien.com/roller/abien/
 */
public class DevelopersClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/JAXRSReturningListOfInstances/resources/Developers";
    
    public DevelopersClient() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }

    public static void main(String[] args) {
        
        DevelopersClient dc = new DevelopersClient();
        List<Developer> list = dc.webTarget.request(MediaType.APPLICATION_XML).get(new GenericType<List<Developer>>(){});
        System.out.println(list);
    }
    
    public void close() {
        client.close();
    }
    
}
