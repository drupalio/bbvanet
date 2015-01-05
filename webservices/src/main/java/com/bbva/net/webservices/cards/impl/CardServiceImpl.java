package com.bbva.net.webservices.cards.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.Product;
// import com.bbva.czic.dto.net.Product;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@RestService(value = "cardService")
public class CardServiceImpl extends AbstractBbvaRestService implements GlobalPositionService {

	@Value("${rest.customer.url}")
	private String URL_CARDCHARGES;

	@Override
	public List<Product> getExtractGlobalBalance(String customerId, String $filter, String $fields, String $expands,
			String $sort) {

		final Product[] products = restTemplate.getForObject(URL_BASE + customerId + URL_CARDCHARGES,
				Product[].class);
		final List<Product> productsResult = new ArrayList<Product>();
		CollectionUtils.addAll(productsResult, products);
		return productsResult;
	}

	@Override
	public Response update(String idProduct) {
		// TODO Auto-generated method stub
		return null;
	}

}
