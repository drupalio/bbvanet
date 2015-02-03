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
import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extract;

@Path("/V01")
public interface SrvProductsV01 {

    @GET
    @Produces("application/json")
    @Path("/{productId}/conditions")
    Conditions getConditions(@PathParam("productId") String productId);

    @GET
    @Produces("application/json")
    @Path("/{productId}/extracts")
    Extract listExtracts(@PathParam("productId") String productId, @QueryParam("$filter") @DefaultValue("null") String $filter, @QueryParam("paginationKey") @DefaultValue("null") Integer paginationKey, @QueryParam("pageSize") @DefaultValue("null") Integer pageSize);

}