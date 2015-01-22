package com.bbva.net.webservices.customers.impl;

import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.customers.CustomerService;

@RestService(value = "customerService")
public class CustomerServiceImpl extends AbstractBbvaRestService implements CustomerService {

	@Value("${rest.customer.url}")
	private String URL_CUSTOMER;

	@Value("${rest.cardsChargesCustomer.url}")
	private String URL_CARDCHARGES;

	@SuppressWarnings("unchecked")
	@Override
	public List<AccMovementsResume> listAccountsMovementsResume(String customerId, String filter) {

		String filterParam = filter.equals("") ? "" : "filter";
		WebClient wc = getJsonWebClient(URL_BASE_CUSTOMER + customerId + URL_CUSTOMER);
		wc.query(filterParam, filter);

		return (List<AccMovementsResume>)wc.getCollection(AccMovementsResume.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CardCharge> listCreditCardsCharges(String customerId, String filter) {
		System.out.println("customer " + filter);
		String filterParam = filter.equals("") ? "" : "$filter";
		WebClient wc = getJsonWebClient(URL_BASE_CUSTOMER + customerId + URL_CARDCHARGES);
		wc.query(filterParam, filter);
		return (List<CardCharge>)wc.getCollection(CardCharge.class);

	}

}
