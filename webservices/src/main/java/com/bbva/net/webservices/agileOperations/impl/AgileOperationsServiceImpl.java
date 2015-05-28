package com.bbva.net.webservices.agileOperations.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.web.client.RestClientException;

import com.bbva.net.webservices.agileOperations.AgileOperationsService;
// import com.bbva.czic.dto.net.Product;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.zic.agileoperations.v01.AgileOperation;

/**
 * @author Entelgy
 */
@RestService(value = "agileOperationsService")
public class AgileOperationsServiceImpl extends AbstractBbvaRestService
		implements AgileOperationsService {

	/**
	 * get favorite operations
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AgileOperation> getAgileOperations(final String $filter) {
		try {
			final WebClient webc = getJsonWebClient(URL_BASE_OPERATIONS);
			return (List<AgileOperation>) webc
					.getCollection(AgileOperation.class);
		} catch (Exception e) {
			throw new RestClientException(
					"Servicio no disponible - No se han podido cargar la información de favoritos, para mayor información comunicate a nuestras líneas BBVA");
		}
	}

	/**
	 * 
	 */
	@Override
	public boolean addAgileOperation(final AgileOperation agileoperation) {
		try {
			final WebClient webc = getJsonWebClient(URL_BASE_OPERATIONS);
			Response res = webc.post(agileoperation);			
			return res.getStatus() == 0;
		} catch (Exception s) {
			throw new RestClientException(
					"Servicio no disponible - No se han podido agregar la operacion");
		}
	}

	/**
	 * 
	 */
	@Override
	public boolean validateAgileOperation(final String $filter) {
		try {
			final WebClient webc = getJsonWebClient(URL_BASE_OPERATIONS
					+ URL_VALIDATED);
			if (!StringUtils.isEmpty($filter))
				webc.query("$filter", $filter);
			return webc.get(boolean.class);
		} catch (Exception s) {
			throw new RestClientException(
					"Servicio no disponible - No se han podido Validar la operacion");
		}
	}

	/**
	 * 
	 */
	@Override
	public Response deleteAgileOperation(final String agileOperationId,
			final String attributesdeletelist) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public Response modifyAgileOperation(final String agileOperationId,
			final AgileOperation agileoperation) {
		// TODO Auto-generated method stub
		return null;
	}

}
