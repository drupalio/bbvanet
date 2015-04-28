/**
 * Created by Apache CXF WadlToJava code generator
 **/
package com.bbva.net.webservices.loan;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;

@Path("/V01")
public interface LoanService {

	@GET
	@Produces("application/json")
	@Path("/rotaryQuota/{idLoan}")
	Loan getRotaryQuota(@PathParam("idLoan") String idLoan);

	@GET
	@Produces("application/json")
	@Path("/rotaryQuota/{idLoan}/movement/{idMovement}")
	RotaryQuotaMove getRotaryQuotaMovement(@PathParam("idLoan") String idLoan,
			@PathParam("idMovement") String idMovement);

	@GET
	@Produces("application/json")
	@Path("/rotaryQuota/{loanId}/movements")
	List<Movement> listRotaryQuotaMovements(@PathParam("loanId") String loanId,
			@QueryParam("paginationKey") String paginationKey, @QueryParam("pageSize") Integer pageSize,
			@QueryParam("$filter") @DefaultValue("null") String $filter);

}