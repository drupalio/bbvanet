package com.bbva.net.webservices.globalposition.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;
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
		try {
			LOGGER.info("PETICION: " + URL_BASE + URL_GLOBAL_POSITION);
			final List<Product> result = getJsonCollection(URL_BASE + URL_GLOBAL_POSITION, Product.class);
			LOGGER.info("NUMERO DE PRODUCTOS:" + result.size());
			return result;
		} catch (Exception ex) {
			LOGGER.info("[Servicio getExtractGlobalBalance No respondió al obtener Lista de Posición global] "
					+ ex.getMessage());
			return new ArrayList<Product>();
		}

	}

	@Override
	public Boolean updateProductOperability(String idProduct, Product product) {
		final WebClient webc = getJsonWebClient(URL_GLOBAL_BASE + idProduct + URL_OPERABILITY);

		webc.put(product);

		if (webc.getResponse().getStatus() == 200) {
			LOGGER.info("Servicio updateSubject actualizó el operation Online");
			return true;
		} else {
			LOGGER.info("Servicio updateSubject no actualizó el operation Online");
			return false;
		}
	}

	@Override
	public Boolean updateProductVisibility(String idProduct, Product product) {
		WebClient webc = getJsonWebClient(URL_GLOBAL_BASE + idProduct + URL_VISIBILITY);

		webc.put(product);

		if (webc.getResponse().getStatus() == 200) {
			LOGGER.info("Servicio updateSubject actualizó la visibilidad");
			return true;
		} else {
			LOGGER.info("Servicio updateSubject no actualizó la visibilidad");
			return false;
		}
	}
}
