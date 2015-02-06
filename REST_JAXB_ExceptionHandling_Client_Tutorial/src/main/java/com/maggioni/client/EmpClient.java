package com.maggioni.client;

import com.maggioni.model.EmpRequest;
import com.maggioni.model.EmpResponse;
import com.maggioni.model.ErrorResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/**
 *
 * http://www.javacodegeeks.com/2012/10/rest-using-jersey-complete-tutorial-with-jaxb-exception-handling-and-client-program.html
 */
public class EmpClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String uri = "http://localhost:8080/jd/rest/emp/getEmp";
        EmpRequest request = new EmpRequest();
        //set id as 1 for OK response
        request.setId(2);
        request.setName("PK");
        try {
            Client client = Client.create();
            WebResource r = client.resource(uri);
            ClientResponse response = r.type(MediaType.APPLICATION_XML).post(ClientResponse.class, request);
            System.out.println(response.getStatus());
            if (response.getStatus() == 200) {
                EmpResponse empResponse = response.getEntity(EmpResponse.class);
                System.out.println(empResponse.getId() + "::" + empResponse.getName());
            } else {
                ErrorResponse exc = response.getEntity(ErrorResponse.class);
                System.out.println(exc.getErrorCode());
                System.out.println(exc.getErrorId());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
