package com.bbva.net.webservices.products;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bbva.czic.dto.net.Conditions;

@Path("/V01")
public interface ProductsService {

	@GET
	@Produces("application/json")
	@Path("/{productId}/conditions")
	Conditions getConditions(@PathParam("productId") String productId);
}
