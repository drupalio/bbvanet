package com.bbva.net.webservices.globalposition.impl;

import org.springframework.beans.factory.annotation.Value;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@RestService(value = "globalPositionService")
public class GlobalPositionServiceImpl extends AbstractBbvaRestService implements GlobalPositionService {

	@Value(value = "${rest.globalPosition.url}")
	private String URL_GLOBAL_POSITION;

	@Override
	public GlobalProducts get(String customerId) {

		final GlobalProducts result = restTemplate.getForObject(URL_BASE + URL_GLOBAL_POSITION + customerId,
				GlobalProducts.class);

		return result;
	}

	public void setURL_GLOBAL_POSITION(String uRL_GLOBAL_POSITION) {
		URL_GLOBAL_POSITION = uRL_GLOBAL_POSITION;
	}

}
