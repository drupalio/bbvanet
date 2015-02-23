/**
 * Created by Apache CXF WadlToJava code generator
 **/
package com.bbva.net.webservices.customers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;

@Path("/V01")
public interface CustomerService {

	@GET
	@Produces("application/json")
	@Path("/accounts/movementsResume")
	List<AccMovementsResume> listAccountsMovementsResume(@QueryParam("$filter") String $filter);

	@GET
	@Produces("application/json")
	@Path("/creditCard/cardCharges")
	List<CardCharge> listCreditCardsCharges(@QueryParam("$filter") String $filter);

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/customerChannels/{channelId}/verifyCustomer")
	Response verifyCustomer(@PathParam("channelId") String channelId);

	@PUT
	@Produces("application/json")
	@Path("/custommerChannels/{channelId}")
	Response addChannel(@PathParam("channelId") String channelId);

	@GET
	@Produces("application/json")
	@Path("/getCustomer")
	Customer getCustomer(@QueryParam("$filter") String $filter);

}