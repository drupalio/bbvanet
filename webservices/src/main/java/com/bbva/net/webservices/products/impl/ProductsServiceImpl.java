package com.bbva.net.webservices.products.impl;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extract;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.products.ProductsService;

@RestService(value = "productsService")
public class ProductsServiceImpl extends AbstractBbvaRestService implements ProductsService {

	@Override
	public Conditions getConditions(String productId) {
		final Conditions conditions = restTemplate.getForObject(URL_BASE_PRODUCTS + productId + URL_PRODUCTS,
				Conditions.class);
		return conditions;
	}

	@Override
	public Extract listExtracts(String productId, String $filter, Integer paginationKey, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
