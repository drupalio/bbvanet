/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.bbva.net.webservices.loan;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.bbva.czic.dto.net.Loan;

@Path("/V01")
public interface SrvLoanV01 {

    @GET
    @Produces("application/json")
    @Path("/rotaryQuota/{idLoan}")
    Loan getRotaryQuota(@PathParam("idLoan") String idLoan);

}