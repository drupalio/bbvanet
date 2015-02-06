package com.bbva.net.webservices.products.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Movement;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.products.ProductsService;

@RestService(value = "productsService")
public class ProductsServiceImpl extends AbstractBbvaRestService implements ProductsService {

	@Value("${fiql.filter.parameter}")
	private String FILTER;

	@Override
	public Conditions getConditions(String productId) {
		final Conditions conditions = restTemplate.getForObject(URL_BASE_PRODUCTS + productId + URL_PRODUCTS,
				Conditions.class);
		return conditions;
	}

	@Override
	public Response listExtracts(String productId, String $filter, Integer paginationKey, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movement> listMovements(String productId, String $filter, Integer paginationKey, Integer pageSize) {
		WebClient wc = getJsonWebClient(URL_BASE_PRODUCTS + productId + URL_MOVEMENTS);
		if (!StringUtils.isEmpty($filter)) wc.query(FILTER, $filter);
		
		if (productId != null) {
			wc.query("productId", productId);
		}
		if(paginationKey!= null && pageSize!=null){
			wc.query("paginationKey", paginationKey);
			wc.query("pageSize", pageSize);
		}

		return (List<Movement>)wc.getCollection(Movement.class);
	}

	@Override
	public Movement getMovement(String productId, String movementId, String $filter) {

		WebClient wc = getJsonWebClient(URL_BASE_PRODUCTS + productId + URL_MOVEMENTS + movementId);
		if (!StringUtils.isEmpty($filter)) wc.query(FILTER, $filter);
		if (productId != null && movementId != null) {
			wc.query("productId", productId);
			wc.query("movementId", movementId);
		}

		return (Movement)wc.get(Movement.class);
	}

}
