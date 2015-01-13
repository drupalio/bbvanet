package com.bbva.net.webservices.cards.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.webservices.cards.CardService;
// import com.bbva.czic.dto.net.Product;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;

@RestService(value = "cardService")
public class CardServiceImpl extends AbstractBbvaRestService implements CardService {

	@Value("${rest.cardsCharges.url}")
	private String URL_CARDCHARGES;

	@Override
	public List<CardCharge> getCreditCardCharges(String id, String $filter, String $fields, String $expands,
			String $sort) {

		final CardCharge[] products = restTemplate.getForObject(URL_BASE_CARDS + id + URL_CARDCHARGES,
				CardCharge[].class);
		final List<CardCharge> productsResult = new ArrayList<CardCharge>();
		CollectionUtils.addAll(productsResult, products);
		return productsResult;
	}

}
