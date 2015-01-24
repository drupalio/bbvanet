/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.bbva.net.webservices.loan;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import com.bbva.czic.dto.net.Loan;

@Path("/V01")
public interface SrvLoanV01 {

    @GET
    @Produces("application/json")
    @Path("/rotaryQuota/{idLoan}")
    Loan getRotaryQuota(@PathParam("idLoan") String idLoan);

    @GET
    @Produces("application/json")
    @Path("/rotaryQuota/{idLoan}/movement/{idMovement}")
    Response getRotaryQuotaMovement(@PathParam("idLoan") String idLoan, @PathParam("idMovement") String idMovement);

    @GET
    @Produces("application/json")
    @Path("/rotaryQuota/{loanId}/movements")
    Response listRotaryQuotaMovements(@PathParam("loanId") String loanId, @QueryParam("paginationKey") String paginationKey, @QueryParam("pageSize") String pageSize, @QueryParam("$filter") @DefaultValue("null") String $filter);

}