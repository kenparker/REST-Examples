package com.maggioni.Boundary;

import com.maggioni.Entity.Developer;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Developers")
public class DevelopersResource {
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getDevelopers() {
        
        List<Developer> developers = new ArrayList<>();
        
        developers.add(new Developer("Angelo", "Maggioni"));
        developers.add(new Developer("John", "Denver"));
        developers.add(new Developer("Hari", "Krischna"));
        
        GenericEntity<List<Developer>> list = new GenericEntity<List<Developer>>(developers) {};
        
        return Response.ok(list).build();
    }

}
