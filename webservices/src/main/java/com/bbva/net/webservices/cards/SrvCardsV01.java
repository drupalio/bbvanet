/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.bbva.net.webservices.cards;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/V01")
public interface SrvCardsV01 {

    @GET
    @Produces("application/json")
    @Path("/creditCard/{id}/cardCharges")
    Response getCreditCardCharges(@PathParam("id") String id, @QueryParam("$filter") @DefaultValue("null") String $filter, @QueryParam("$fields") @DefaultValue("null") String $fields, @QueryParam("$expands") @DefaultValue("null") String $expands, 
                @QueryParam("$sort") @DefaultValue("null") String $sort);

}