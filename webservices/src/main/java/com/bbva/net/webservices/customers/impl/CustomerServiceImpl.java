package com.bbva.net.webservices.customers.impl;

import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.customers.CustomerService;
import com.google.gson.Gson;

@RestService(value = "customerService")
public class CustomerServiceImpl extends AbstractBbvaRestService implements CustomerService {

	@Value("${rest.customer.url}")
	private String URL_CUSTOMER;

	@Value("${rest.cardsChargesCustomer.url}")
	private String URL_CARDCHARGES;

	@Value("${fiql.filter.parameter}")
	private String FILTER;

	@SuppressWarnings("unchecked")
	@Override
	public List<AccMovementsResume> listAccountsMovementsResume(String customerId, String filter) {

		WebClient wc = getJsonWebClient(URL_BASE_CUSTOMER + customerId + URL_CUSTOMER);
		LOGGER.info("PETICION: " + wc.getCurrentURI());
		if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);

		final List<AccMovementsResume> result = (List<AccMovementsResume>)wc.getCollection(AccMovementsResume.class);
		final Gson gson = new Gson();
		String json = gson.toJson(result);
		LOGGER.info("JSON ASCCOUNT MOVEMENTS RESUME: " + json);

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CardCharge> listCreditCardsCharges(String customerId, String filter) {
		WebClient wc = getJsonWebClient(URL_BASE_CUSTOMER + customerId + URL_CARDCHARGES);
		if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);
		return (List<CardCharge>)wc.getCollection(CardCharge.class);

	}

}
