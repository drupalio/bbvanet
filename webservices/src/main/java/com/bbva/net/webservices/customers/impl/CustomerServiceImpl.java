package com.bbva.net.webservices.customers.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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

	@Override
	public List<AccMovementsResume> listAccountsMovementsResume(String customerId) {
		
		final AccMovementsResume[] customers = restTemplate.getForObject(URL_BASE_CUSTOMER + customerId + URL_CUSTOMER,
				AccMovementsResume[].class);
		final List<AccMovementsResume> customerResult = new ArrayList<AccMovementsResume>();
		CollectionUtils.addAll(customerResult, customers);
		return customerResult;
	}

	@Override
	public List<CardCharge> listCreditCardsCharges(String customerId) {
		
		final CardCharge[] cardsCharges = restTemplate.getForObject(URL_BASE_CUSTOMER + customerId + URL_CARDCHARGES,
				CardCharge[].class);
		final List<CardCharge> cardsChargesResult = new ArrayList<CardCharge>();
		CollectionUtils.addAll(cardsChargesResult, cardsCharges);
		return cardsChargesResult;
		
		
	}

}
