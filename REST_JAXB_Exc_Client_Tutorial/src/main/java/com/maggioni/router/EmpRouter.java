package com.maggioni.router;

import com.maggioni.exception.EmpNotFoundException;
import com.maggioni.model.EmpRequest;
import com.maggioni.model.EmpResponse;
import javax.enterprise.inject.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author magang
 */
@Path("/emp")
public class EmpRouter {

	@POST
	@Path("/getEmp")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response getEmp(JAXBElement<EmpRequest> empRequest)
			throws EmpNotFoundException {
		EmpResponse empResponse = new EmpResponse();
		if (empRequest.getValue().getId() == 1) {
			empResponse.setId(empRequest.getValue().getId());
			empResponse.setName(empRequest.getValue().getName());
		} else {
			throw new EmpNotFoundException("Wrong ID", empRequest.getValue()
					.getId());
		}
		return Response.ok(empResponse).build();
	}
}
