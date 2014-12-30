package com.bbva.net.webservices.executives;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.bbva.czic.dto.net.Executive;

@Path("/V01")
public interface ExecutiveService {

	@GET
	@Produces("application/json")
	Executive getExecutive(@QueryParam("$filter") @DefaultValue("null") String $filter,
			@QueryParam("$fields") @DefaultValue("null") String $fields,
			@QueryParam("$expands") @DefaultValue("null") String $expands,
			@QueryParam("$sort") @DefaultValue("null") String $sort);

}
