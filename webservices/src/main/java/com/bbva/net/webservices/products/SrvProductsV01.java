/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.bbva.net.webservices.products;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import com.bbva.czic.dto.net.Conditions;

@Path("/V01")
public interface SrvProductsV01 {

    @GET
    @Produces("application/json")
    @Path("/{productId}/conditions")
    Conditions getConditions(@PathParam("productId") String productId);

    @GET
    @Produces("application/json")
    @Path("/{productId}/listExtracts")
    Response listExtracts(@PathParam("productId") String productId, @QueryParam("$filter") @DefaultValue("null") String $filter, @QueryParam("paginationKey") @DefaultValue("null") Integer paginationKey, @QueryParam("pageSize") @DefaultValue("null") Integer pageSize);

    @GET
    @Produces("application/json")
    @Path("/{productId}/movements")
    Response listMovements(@PathParam("productId") String productId, @QueryParam("$filter") @DefaultValue("null") String $filter, @QueryParam("paginationKey") @DefaultValue("null") Integer paginationKey, @QueryParam("pageSize") @DefaultValue("null") Integer pageSize);

    @GET
    @Produces("application/json")
    @Path("/{productId}/movements/{movementId}")
    Response getMovement(@PathParam("productId") String productId, @PathParam("movementId") String movementId, @QueryParam("$filter") @DefaultValue("null") String $filter);

}