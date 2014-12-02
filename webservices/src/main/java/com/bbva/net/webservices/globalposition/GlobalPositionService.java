/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.bbva.net.webservices.globalposition;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

@Path("/customers/{customerId}")
public interface GlobalPositionService {

    @GET
    @Produces("application/json")
    GlobalProducts get(@PathParam("customerId") String customerId);

}