package com.bbva.net.webservices.customers.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClientException;

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
		try {
			WebClient wc = getJsonWebClient(URL_BASE_CUSTOMER + URL_CUSTOMER);
			if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);
			return (List<AccMovementsResume>)wc.getCollection(AccMovementsResume.class);
		} catch (Exception e) {
			throw new RestClientException(
					"Servicio no disponible - No se ha podido cargar la lista de resumen de movimientos, para mayor información comunicate a nuestras líneas BBVA");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CardCharge> listCreditCardsCharges(String filter) {
		try {
			WebClient wc = getJsonWebClient(URL_BASE_CUSTOMER + URL_CARDCHARGES);
			if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);
			return (List<CardCharge>)wc.getCollection(CardCharge.class);

		} catch (Exception e) {
			throw new RestClientException(
					"Servicio no disponible - No se ha podido cargar la información de gráfica de tarjetas, para mayor información comunicate a nuestras líneas BBVA");
		}
	}

	@Override
	public Customer getCustomer(String filter) {
		try {
			WebClient wc = getJsonWebClient(URL_BASE_CUSTOMER + URL_GETEXECUTIVE);
			if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);
			return wc.get(Customer.class);
		} catch (Exception e) {
			throw new RestClientException(
					"Servicio no disponible - No se ha podido cargar la información del usuario, para mayor información comunicate a nuestras líneas BBVA");
		}
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
