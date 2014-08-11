package com.maggioni.airhacks;


import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author maggioni
 */
@Path("developers")
public class DevelopersResource {
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray developers(@Context HttpHeaders http) {
        JsonObject obj = Json.createObjectBuilder().add("firstname", "duke").build();
        //return  Json.createArrayBuilder().add(obj).build();
        throw new RuntimeException("all at home");
        
    }
    
    @GET
    @Path("{first}-{last}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Developer developer(@PathParam("first") String first, @PathParam("last") String last) {
        return new Developer(first, last);
    }
}
