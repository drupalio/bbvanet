package com.bbva.net.webservices.globalposition.impl;

import org.springframework.beans.factory.annotation.Value;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@RestService(value = "globalPositionService")
public class GlobalPositionServiceImpl 
				extends AbstractBbvaRestService implements GlobalPositionService {

	@Value(value="${rest.globalPosition.url}")
	private String URL_GLOBAL_POSITION;
	
	@Value("${rest.base.url}")
	private String URL_BASE;

	@Override
	public GlobalProducts get(String customerId) {
		
		final GlobalProducts result = restTemplate.getForObject(
				"http://localhost:8099/GlobalPosition/V01/customers/" +customerId, GlobalProducts.class);


		return result;
	}


}
