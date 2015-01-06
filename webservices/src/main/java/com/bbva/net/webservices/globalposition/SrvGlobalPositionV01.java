/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.bbva.net.webservices.globalposition;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import com.bbva.czic.dto.net.Product;

@Path("/V01")
public interface SrvGlobalPositionV01 {

    @GET
    @Produces("application/json")
    @Path("/customers/{customerId}/products")
    Response getExtractGlobalBalance(@PathParam("customerId") String customerId, @QueryParam("$filter") @DefaultValue("(productType=={productType})") String $filter, @QueryParam("$fields") @DefaultValue("null") String $fields, @QueryParam("$expands") @DefaultValue("null") String $expands, 
                @QueryParam("$sort") @DefaultValue("null") String $sort);

    @PUT 
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/{idProduct}")
    Response update(@PathParam("idProduct") String idProduct, Product product);

}