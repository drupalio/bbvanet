package com.bbva.net.webservices.customers;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;

@Path("/V01")
public interface CustomerService {

	@GET
	@Produces("application/json")
	@Path("/{customerId}")
	Customer getCustomer(@PathParam("customerId") String customerId);

	@GET
	@Produces("application/json")
	@Path("/{customerId}/accounts/movementsResume")
	List<AccMovementsResume> listAccountsMovementsResume(@PathParam("customerId") String customerId,
			@QueryParam("$filter") @DefaultValue("null") String $filter);

	@GET
	@Produces("application/json")
	@Path("/{customerId}/creditCard/cardCharges")
	List<CardCharge> listCreditCardsCharges(@PathParam("customerId") String customerId,
			@QueryParam("$filter") @DefaultValue("null") String $filter);

}
