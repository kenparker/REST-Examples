
package com.maggioni.jersey.client.example_1;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;




/**
 *
 * @author maggioni
 */
public class HelloClientMain1 {

    private static final String BASE_URI = "http://localhost:8080/REST-MyFirstRest/resources";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Client client = ClientBuilder.newClient();
        WebTarget res = client.target(BASE_URI).path("hello");
        String get = res.request(MediaType.TEXT_XML).get(String.class);
        System.out.println(get);
        client.close();
        
    }
    
}
