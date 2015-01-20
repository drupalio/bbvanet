package com.bbva.net.webservices.customers.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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

	@Value("${rest.cardsCharges.url}")
	private String URL_CARDCHARGES;

	@SuppressWarnings("unchecked")
	@Override
	public List<AccMovementsResume> listAccountsMovementsResume(String customerId, String filter) {

		String filterParam = filter.equals("") ? "" : "filter";
		WebClient wc = getJsonWebClient(URL_BASE_CUSTOMER + customerId + URL_CUSTOMER);
		wc.query(filterParam, filter);

		return (List<AccMovementsResume>)wc.getCollection(AccMovementsResume.class);
	}

	@Override
	public List<CardCharge> listCreditCardsCharges(String customerId, String filter) {

		final CardCharge[] cardsCharges = restTemplate.getForObject(URL_BASE_CUSTOMER + customerId + URL_CARDCHARGES
				+ filter, CardCharge[].class);
		final List<CardCharge> cardsChargesResult = new ArrayList<CardCharge>();
		CollectionUtils.addAll(cardsChargesResult, cardsCharges);
		return cardsChargesResult;

	}

}
