package com.bbva.net.webservices.agileOperations.impl;

import java.util.List;

import javax.ws.rs.core.Response;

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
public class AgileOperationsServiceImpl extends AbstractBbvaRestService implements AgileOperationsService {

	/**
	 * get favorite operations
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AgileOperation> getAgileOperations(final String $filter) {
		try {
			final WebClient webc = getJsonWebClient(URL_BASE_OPERATIONS);
			return (List<AgileOperation>)webc.getCollection(AgileOperation.class);
		} catch (Exception e) {
			throw new RestClientException(
					"Servicio no disponible - No se han podido cargar la información de favoritos, para mayor información comunicate a nuestras líneas BBVA");
		}
	}

	/**
	 * 
	 */
	@Override
	public Response addAgileOperation(final AgileOperation agileoperation) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public Response validateAgileOperation(final String $filter) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public Response deleteAgileOperation(final String agileOperationId, final String attributesdeletelist) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public Response modifyAgileOperation(final String agileOperationId, final AgileOperation agileoperation) {
		// TODO Auto-generated method stub
		return null;
	}

}
