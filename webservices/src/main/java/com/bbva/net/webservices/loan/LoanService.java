package com.bbva.net.webservices.loan;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bbva.czic.dto.net.Loan;

@Path("/V01")
public interface LoanService {

	@GET
	@Produces("application/json")
	@Path("/rotaryQuota/{idLoan}")
	Loan getRotaryQuota(@PathParam("idLoan") String idLoan);

}
