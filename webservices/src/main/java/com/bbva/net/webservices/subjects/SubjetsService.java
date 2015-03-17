package com.bbva.net.webservices.subjects;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bbva.zic.subjects.v01.UpdateAccountOut;
import com.bbva.zic.subjects.v01.UpdateSubjectIn;

@Path("/V01")
public interface SubjetsService {

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/{contractNumber}")
	UpdateAccountOut updateSubject(@PathParam("contractNumber") String contractNumber, UpdateSubjectIn updatesubjectin);

}
