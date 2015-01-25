package com.bbva.net.webservices.cards.impl;

import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<CardCharge> getCreditCardCharges(String id, String $filter, String $fields, String $expands,
			String $sort) {
		String filterParam = $filter.equals("") ? "" : "$filter";
		WebClient wc = getJsonWebClient(URL_BASE_CARDS + id + URL_CARDCHARGES);
		wc.query(filterParam, $filter);
		return (List<CardCharge>)wc.getCollection(CardCharge.class);
	}
}
