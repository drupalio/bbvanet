package com.bbva.net.webservices.cards.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.webservices.cards.CardService;
// import com.bbva.czic.dto.net.Product;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;

/**
 * @author Entelgy
 */
@RestService(value = "cardService")
public class CardServiceImpl extends AbstractBbvaRestService implements CardService {

	/**
	 * 
	 */
	@Value("${rest.cardsCharges.url}")
	private String urlCardcharges;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CardCharge> getCreditCardCharges(final String idProduct, final String filter, final String fields,
			final String expands, final String sort) {
		final String filterParam = !filter.equals("") ? "$filter" : "";
		final WebClient webC = getJsonWebClient(URL_BASE_CARDS + idProduct + urlCardcharges);
		webC.query(filterParam, filter);
		try {
			LOGGER.info("PETICION: " + URL_BASE_CARDS + idProduct + urlCardcharges);
			return (List<CardCharge>)webC.getCollection(CardCharge.class);
		} catch (Exception ex) {
			LOGGER.info("[Servicio getCreditCardCharges No respondió al obtener garfica de tarjetas] "
					+ ex.getMessage());
			return new ArrayList<CardCharge>();
		}
	}
}
