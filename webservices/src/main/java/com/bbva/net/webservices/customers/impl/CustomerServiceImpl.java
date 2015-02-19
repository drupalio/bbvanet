package com.bbva.net.webservices.customers.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.customers.CustomerService;

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
	public List<AccMovementsResume> listAccountsMovementsResume(String filter) {

		WebClient wc = getJsonWebClient(URL_BASE_CUSTOMER + URL_CUSTOMER);
		LOGGER.info("PETICION: " + wc.getCurrentURI());
		if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);
		return (List<AccMovementsResume>)wc.getCollection(AccMovementsResume.class);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CardCharge> listCreditCardsCharges(String filter) {
		WebClient wc = getJsonWebClient(URL_BASE_CUSTOMER + URL_CARDCHARGES);
		if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);
		return (List<CardCharge>)wc.getCollection(CardCharge.class);

	}

	@Override
	public Customer getCustomer() {
		WebClient wc = getJsonWebClient(URL_BASE_CUSTOMER);
		return wc.get(Customer.class);
	}

	@Override
	public Response verifyCustomer(String channelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response addChannel(String channelId) {
		// TODO Auto-generated method stub
		return null;
	}

}
