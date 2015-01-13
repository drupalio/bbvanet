package com.bbva.net.webservices.checkbooks;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;

@Path("/V01")
public interface CheckBookService {
	
    @GET
    @Produces("application/json")
    @Path("/checks/{checkId}")
    List<Check> getChecks(@PathParam("checkId") String checkId, @QueryParam("$filter") @DefaultValue("null") String $filter, @QueryParam("$fields") @DefaultValue("null") String $fields, @QueryParam("$expands") @DefaultValue("null") String $expands, 
                @QueryParam("$sort") @DefaultValue("null") String $sort);

    @GET
    @Produces("application/json")
    @Path("/{checkbookId}")
    List<Checkbook> getCheckbooks(@PathParam("checkbookId") String checkbookId, @QueryParam("$filter") @DefaultValue("null") String $filter, @QueryParam("$fields") @DefaultValue("null") String $fields, @QueryParam("$expands") @DefaultValue("null") String $expands, 
                @QueryParam("$sort") @DefaultValue("null") String $sort);



}
