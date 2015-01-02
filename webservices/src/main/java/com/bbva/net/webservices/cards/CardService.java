package com.bbva.net.webservices.cards;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.bbva.czic.dto.net.CardCharge;

@Path("/V01")
public interface CardService {

	@GET
	@Produces("application/json")
	@Path("/creditCard/{id}/cardCharges")
	List<CardCharge> getCreditCardCharges(@PathParam("id") String id,
			@QueryParam("$filter") @DefaultValue("null") String $filter,
			@QueryParam("$fields") @DefaultValue("null") String $fields,
			@QueryParam("$expands") @DefaultValue("null") String $expands,
			@QueryParam("$sort") @DefaultValue("null") String $sort);

}
