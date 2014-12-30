/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.bbva.net.webservices.grantingticket;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bbva.saz.co.grantingticket.v01.AuthenticationState;
import com.bbva.saz.co.grantingticket.v01.ConsumerContext;

@Path("/V01")
public interface SrvCOGrantingTicket {

    @DELETE
    void deleteTicket();

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    AuthenticationState createTicket(ConsumerContext consumercontext);

}