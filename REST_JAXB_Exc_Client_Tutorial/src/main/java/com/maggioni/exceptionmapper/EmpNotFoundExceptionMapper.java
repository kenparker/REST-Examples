package com.maggioni.exceptionmapper;

import com.maggioni.exception.EmpNotFoundException;
import com.maggioni.model.ErrorResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * http://www.javacodegeeks.com/2012/10/rest-using-jersey-complete-tutorial-with-jaxb-exception-handling-and-client-program.html
 */
@Provider
public class EmpNotFoundExceptionMapper implements
		ExceptionMapper<EmpNotFoundException> {

	public EmpNotFoundExceptionMapper() {
	}

	public Response toResponse(
			EmpNotFoundException empNotFoundException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorId(empNotFoundException.getErrorId());
		errorResponse.setErrorCode(empNotFoundException.getMessage());
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
				errorResponse).type(
				MediaType.APPLICATION_XML).build();

	}

}
