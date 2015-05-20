package com.bbva.net.webservices.cards.impl;

import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClientException;

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

		try {
			final WebClient webC = getJsonWebClient(URL_BASE_CARDS + idProduct + urlCardcharges);
			final String filterParam = !filter.equals("") ? "$filter" : "";
			webC.query(filterParam, filter);
			return (List<CardCharge>)webC.getCollection(CardCharge.class);
		} catch (Exception e) {
			throw new RestClientException(
					"Servicio no disponible - No se ha podido cargar la información de la gráfica de tarjetas, para mayor información comunicate a nuestras líneas BBVA");
		}
	}
}
