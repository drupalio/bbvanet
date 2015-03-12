package com.bbva.net.webservices.agileOperations.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

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
		// String filterParam = $filter.equals("") ? "" : "$filter";
		final WebClient webc = getJsonWebClient(URL_BASE_OPERATIONS);
		// wc.query(filterParam, $filter);
		return (List<AgileOperation>)webc.getCollection(AgileOperation.class);
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
