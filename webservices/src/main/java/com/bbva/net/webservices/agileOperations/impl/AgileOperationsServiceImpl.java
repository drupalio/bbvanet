package com.bbva.net.webservices.agileOperations.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import com.bbva.net.webservices.agileOperations.AgileOperationsService;
// import com.bbva.czic.dto.net.Product;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.zic.agileoperations.v01.AgileOperation;

@RestService(value = "agileOperationsService")
public class AgileOperationsServiceImpl extends AbstractBbvaRestService implements AgileOperationsService {

	@SuppressWarnings("unchecked")
	@Override
	public List<AgileOperation> getAgileOperations(String $filter) {
		// String filterParam = $filter.equals("") ? "" : "$filter";
		WebClient wc = getJsonWebClient(URL_BASE_OPERATIONS);
		// wc.query(filterParam, $filter);
		return (List<AgileOperation>)wc.getCollection(AgileOperation.class);
	}

	@Override
	public Response addAgileOperation(AgileOperation agileoperation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response validateAgileOperation(String $filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteAgileOperation(String agileOperationId, String attributesdeletelist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response modifyAgileOperation(String agileOperationId, AgileOperation agileoperation) {
		// TODO Auto-generated method stub
		return null;
	}

}
