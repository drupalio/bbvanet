/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.bbva.net.webservices.customers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/V01")
public interface SrvCustomersV01 {

    @GET
    @Produces("application/json")
    @Path("/{customerId}/accounts/movementsResume")
    Response listAccountsMovementsResume(@PathParam("customerId") String customerId);

    @GET
    @Produces("application/json")
    @Path("/{customerId}/creditCard/cardCharges")
    Response listCreditCardsCharges(@PathParam("customerId") String customerId);

}