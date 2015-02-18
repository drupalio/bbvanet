package com.bbva.net.webservices.products;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extracto;
import com.bbva.czic.dto.net.Movement;

@Path("/V01")
public interface ProductsService {

	@GET
	@Produces("application/json")
	@Path("/{productId}/conditions")
	Conditions getConditions(@PathParam("productId") String productId);

	@GET
	@Produces("application/json")
	@Path("/{productId}/extracts")
	List<Extracto> listExtracts(@PathParam("productId") String productId,
			@QueryParam("$filter") @DefaultValue("null") String $filter);

	@GET
	@Produces("application/json")
	@Path("/{productId}/movements")
	List<Movement> listMovements(@PathParam("productId") String productId,
			@QueryParam("$filter") @DefaultValue("null") String $filter,
			@QueryParam("paginationKey") @DefaultValue("null") Integer paginationKey,
			@QueryParam("pageSize") @DefaultValue("null") Integer pageSize);

	@GET
	@Produces("application/json")
	@Path("/{productId}/movements/{movementId}")
	Movement getMovement(@PathParam("productId") String productId, @PathParam("movementId") String movementId,
			@QueryParam("$filter") @DefaultValue("null") String $filter);

}
