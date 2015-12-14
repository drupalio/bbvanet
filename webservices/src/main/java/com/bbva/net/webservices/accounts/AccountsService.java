/**
 * Created by Apache CXF WadlToJava code generator
 **/
package com.bbva.net.webservices.accounts;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.MonthlyBalances;

@Path("/V01")
public interface AccountsService {

	/*
	 * GP12834 Cheques y chequeras - Entelgy - inicio
	 */
    // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
    @GET
    @Produces("application/json")
    @Path("/{accountId}/checkbooks/{checkbookId}")
    Checkbook getCheckbook(@PathParam("checkbookId") String checkbookId, @PathParam("accountId") String accountId);
    
	@GET
	@Produces("application/json")
	@Path("/{accountId}/checks/{checkId}")
	Check getCheck(@PathParam("accountId") String accountId, @PathParam("checkId") String checkId);

	@GET
	@Produces("application/json")
	@Path("/{id}")
	Account getAccount(@PathParam("id") String id);

	@GET
	@Produces("application/json")
	@Path("/{id}/listChecks")
    List<Check> listCheck(@PathParam("id") String id, @QueryParam("$filter") String $filter, 
			@QueryParam("paginationKey") Integer paginationKey,
            @QueryParam("pageSize") Integer pageSize);

	/*
	 * GP12834 Cheques y chequeras - Entelgy - fin
	 */

	@GET
	@Produces("application/json")
    @Path("/{accountId}/monthlyBalances")
    List<MonthlyBalances> getAccountMonthlyBalance(@PathParam("accountId") String accountId,
			@QueryParam("$filter") @DefaultValue("null") String $filter,
			@QueryParam("$fields") @DefaultValue("null") String $fields,
			@QueryParam("$expands") @DefaultValue("null") String $expands,
			@QueryParam("$sort") @DefaultValue("null") String $sort);

    // <!-- Entelgy / GP-12834 / 25112015 / FIN -->

	@GET
	@Produces("application/json")
	@Path("/{id}/movementsResumes")
	List<AccMovementsResume> getAccMovementResume(@PathParam("id") String id,
			@QueryParam("$filter") @DefaultValue("null") String $filter,
			@QueryParam("$fields") @DefaultValue("null") String $fields,
			@QueryParam("$expands") @DefaultValue("null") String $expands,
			@QueryParam("$sort") @DefaultValue("null") String $sort);

}