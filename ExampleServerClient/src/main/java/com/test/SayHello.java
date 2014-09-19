package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author angelomaggioni
 */
@Path("/hello")
public class SayHello
{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        System.out.println("Hello there");
        return "Hello duke";
    }
}
