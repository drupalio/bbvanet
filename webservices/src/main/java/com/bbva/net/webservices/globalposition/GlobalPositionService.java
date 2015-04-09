package com.bbva.net.webservices.globalposition;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.bbva.czic.dto.net.Product;

@Path("/V01")
public interface GlobalPositionService {

	@GET
	@Produces("application/json")
	@Path("/customers/products")
	List<Product> getExtractGlobalBalance(@QueryParam("$filter") String $filter);

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/{idProduct}/setProductOperability")
	Boolean updateProductOperability(@PathParam("idProduct") String idProduct, Product product);

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/{idProduct}/setProductVisibility")
	Boolean updateProductVisibility(@PathParam("idProduct") String idProduct, Product product);

}