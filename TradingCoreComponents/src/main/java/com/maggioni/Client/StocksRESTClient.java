
package com.maggioni.Client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author magang
 */
public class StocksRESTClient
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/TradingBaseComponents").path("resource/stocks/testPost");
        Form form = new Form();
        form.param("Symbol", "SPY");
        form.param("Name","SPO 500");
        
        Response response = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        
        System.out.println(response.getStatus());
        
        
    }
    
}
