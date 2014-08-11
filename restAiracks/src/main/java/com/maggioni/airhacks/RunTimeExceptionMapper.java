
package com.maggioni.airhacks;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author maggioni
 * also interesting:
 *  http://search-hadoop.com/c/Zookeeper:src/contrib/rest/src/java/org/apache/zookeeper/server/jersey/resources/RuntimeExceptionMapper.java%7C%7C+%2522CPU+usage%2522+%2522NOTICE+file%2522
 * 
 * or:
 * http://gary-rowe.com/agilestack/2012/10/23/how-to-implement-a-runtimeexceptionmapper-for-dropwizard/
 */
@Provider
public class RunTimeExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException exception) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).header("x-reason", exception.getMessage()).build();
    }
    
    
    
}
