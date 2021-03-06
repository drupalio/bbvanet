/**
 * Created by Apache CXF WadlToJava code generator
 **/
package com.bbva.net.webservices.agileOperations;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.bbva.zic.agileoperations.v01.AgileOperation;
import com.bbva.zic.agileoperations.v01.ListAgileOperationsOut;

@Path("/V01")
public interface AgileOperationsService {
    
    // <!-- Entelgy / GP13137 / 21102015 / INICIO -->
    @GET
    @Produces("application/json")
    ListAgileOperationsOut listAgileOperations(@QueryParam("$filter") String $filter);
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    boolean addAgileOperation(AgileOperation agileoperation);
    
    @GET
    @Produces("application/json")
    @Path("/validated")
    boolean validateAgileOperation(@QueryParam("$filter") String $filter);
    
    @DELETE
    @Produces("application/json")
    @Path("/{agileOperationId}")
    String deleteAgileOperation(@PathParam("agileOperationId") String agileOperationId,
            @HeaderParam("attributesdeletelist") String attributesdeletelist);
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/{agileOperationId}")
    boolean modifyAgileOperation(@PathParam("agileOperationId") String agileOperationId, AgileOperation agileoperation);
    // <!-- Entelgy / GP13137 / 21102015 / FIN -->
}