/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.bbva.net.webservices.accounts;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Checkbook;

@Path("/V01")
public interface SrvAccountsV01 {

    @GET
    @Produces("application/json")
    @Path("/{accountId}/checkbooks/{checkbookId}")
    Checkbook getCheckbook(@PathParam("checkbookId") String checkbookId, @PathParam("accountId") String accountId);

    @GET
    @Produces("application/json")
    @Path("/{id}")
    Account getAccount(@PathParam("id") String id);

    @GET
    @Produces("application/json")
    @Path("/{id}/listChecks")
    Response listCheck(@PathParam("id") String id, @QueryParam("$filter") @DefaultValue("null") String $filter, @QueryParam("paginationKey") @DefaultValue("null") Integer paginationKey, @QueryParam("pageSize") @DefaultValue("null") Integer pageSize);

    @GET
    @Produces("application/json")
    @Path("/{id}/monthlyBalances")
    Response getAccountMonthlyBalance(@PathParam("id") String id, @QueryParam("$filter") @DefaultValue("null") String $filter, @QueryParam("$fields") @DefaultValue("null") String $fields, @QueryParam("$expands") @DefaultValue("null") String $expands, 
                @QueryParam("$sort") @DefaultValue("null") String $sort);

    @GET
    @Produces("application/json")
    @Path("/{id}/movementsResumes")
    Response getAccMovementResume(@PathParam("id") String id, @QueryParam("$filter") @DefaultValue("null") String $filter, @QueryParam("$fields") @DefaultValue("null") String $fields, @QueryParam("$expands") @DefaultValue("null") String $expands, 
                @QueryParam("$sort") @DefaultValue("null") String $sort);

}