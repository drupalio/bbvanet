package com.bbva.net.webservices.globalposition.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@RestService(value = "globalPositionService")
public class GlobalPositionServiceImpl extends AbstractBbvaRestService implements GlobalPositionService {

	@Value("${rest.globalPosition.url}")
	private String URL_GLOBAL_POSITION;

	@Value("${rest.operability.url}")
	private String URL_OPERABILITY;

	@Value("${rest.visibility.url}")
	private String URL_VISIBILITY;

	@Override
	public List<Product> getExtractGlobalBalance(String $filter) {
		
		LOGGER.info("PETICION: " + URL_BASE +  URL_GLOBAL_POSITION);
		final List<Product> result = getJsonCollection(URL_BASE + URL_GLOBAL_POSITION, Product.class);
		LOGGER.info("NUMERO DE PRODUCTOS:" + result.size());
		return result;
	}

	@Override
	public Response updateProductOperability(String idProduct, Product product) {
		return getJsonWebClient(URL_GLOBAL_BASE + idProduct + URL_OPERABILITY).put(product);
	}

	@Override
	public Response updateProductVisibility(String idProduct, Product product) {
		return getJsonWebClient(URL_GLOBAL_BASE + idProduct + URL_VISIBILITY).put(product);
	}
}
