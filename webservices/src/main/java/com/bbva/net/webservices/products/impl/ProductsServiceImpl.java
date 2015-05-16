package com.bbva.net.webservices.products.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extracto;
import com.bbva.czic.dto.net.Movement;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.products.ProductsService;

@RestService(value = "productsService")
public class ProductsServiceImpl extends AbstractBbvaRestService implements ProductsService {

	@Value("${fiql.filter.parameter}")
	private String FILTER;

	@Value("${rest.extract.url}")
	private String EXTRACT;

	@Override
	public Conditions getConditions(String productId) {
		try {
			final Conditions conditions = getJsonWebClient(URL_BASE_PRODUCTS + productId + URL_PRODUCTS).get(
					Conditions.class);
			return conditions;
		} catch (Exception ex) {
			LOGGER.info("[Servicio getConditions No respondió al obtener las condiciones del producto] "
					+ ex.getMessage());
			return new Conditions();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Extracto> listExtracts(String productId, String filter) {

		WebClient wc = getJsonWebClient(URL_BASE_PRODUCTS + productId + EXTRACT);
		if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);

		try {
			return (List<Extracto>)wc.getCollection(Extracto.class);
		} catch (Exception ex) {
			LOGGER.info("[Servicio Product No respondió al obtener Lista de Extractos] " + ex.getMessage());
			return new ArrayList<Extracto>();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movement> listMovements(String productId, String $filter, Integer paginationKey, Integer pageSize) {
		WebClient wc = getJsonWebClient(URL_BASE_PRODUCTS + productId + URL_MOVEMENTS);
		if (!StringUtils.isEmpty($filter)) wc.query(FILTER, $filter);

		if (paginationKey != null && pageSize != null) {
			wc.query("paginationKey", paginationKey);
			wc.query("pageSize", pageSize);
		}
		try {
			LOGGER.info("URL_BASE_PRODUCTS + productId + URL_MOVEMENTS");
			return (List<Movement>)wc.getCollection(Movement.class);
		} catch (final Exception ex) {
			LOGGER.info("[Servicio listMovements No respondió al obtener la lista de movimientos] " + ex.getMessage());
			return new ArrayList<Movement>();
		}
	}

	@Override
	public Movement getMovement(String productId, String movementId, String $filter) {

		WebClient wc = getJsonWebClient(URL_BASE_PRODUCTS + productId + URL_MOVEMENTS + "/" + movementId);
		if (!StringUtils.isEmpty($filter)) wc.query(FILTER, $filter);
		try {
			LOGGER.info("PETICION: " + URL_BASE_PRODUCTS + productId + URL_MOVEMENTS + "/" + movementId);
			return wc.get(Movement.class);
		} catch (final Exception ex) {
			LOGGER.info("[Servicio getMovement No respondió al obtener el movimiento] " + ex.getMessage());
			return new Movement();
		}
	}
}
