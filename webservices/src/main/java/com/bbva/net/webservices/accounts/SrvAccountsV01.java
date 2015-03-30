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
import com.bbva.czic.dto.net.Check;

@Path("/V01")
public interface SrvAccountsV01 {

    @GET
    @Produces("application/json")
    @Path("/{accountId}/checkbooks/{checkbookId}")
    Response getCheckbook(@PathParam("checkbookId") String checkbookId, @PathParam("accountId") String accountId);

    @GET
    @Produces("application/json")
    @Path("/{accountId}/checks/{checkId}")
    Check getCheck(@PathParam("accountId") String accountId, @PathParam("checkId") String checkId);

    @GET
    @Produces("application/json")
    @Path("/{accountId}/monthlyBalances")
    Response getAccountMonthlyBalance(@PathParam("accountId") String accountId, @QueryParam("$filter") @DefaultValue("null") String $filter);

    @GET
    @Produces("application/json")
    @Path("/{id}")
    Account getAccount(@PathParam("id") String id);

    @GET
    @Produces("application/json")
    @Path("/{id}/listChecks")
    Response listCheck(@PathParam("id") String id, @QueryParam("$filter") String $filter, @QueryParam("paginationKey") Integer paginationKey, @QueryParam("pageSize") Integer pageSize);

    @GET
    @Produces("application/json")
    @Path("/{id}/movementsResumes")
    Response getAccMovementResume(@PathParam("id") String id, @QueryParam("$filter") @DefaultValue("null") String $filter);

}