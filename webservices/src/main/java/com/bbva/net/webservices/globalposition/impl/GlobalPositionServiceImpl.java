package com.bbva.net.webservices.globalposition.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.bbva.czic.dto.net.Product;
// import com.bbva.czic.dto.net.Product;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@RestService(value = "globalPositionService")
public class GlobalPositionServiceImpl extends AbstractBbvaRestService implements GlobalPositionService {

	@Value("${rest.globalPosition.url}")
	private String URL_GLOBAL_POSITION;

	@Override
	public List<Product> getExtractGlobalBalance(String customerId, String $filter, String $fields, String $expands,
			String $sort) {

		@SuppressWarnings("unchecked")
		// List<Product> response = restTemplate
		// .getForObject(URL_BASE + customerId + URL_GLOBAL_POSITION, ArrayList.class);
		final Product[] products = restTemplate.getForObject(URL_BASE + customerId + URL_GLOBAL_POSITION,
				Product[].class);

		final List<Product> productsResult = new ArrayList<Product>();

		CollectionUtils.addAll(productsResult, products);

		/*
		 * @SuppressWarnings("unchecked") List<Product> response = restTemplate.getForObject(URL_BASE + customerId +
		 * URL_GLOBAL_POSITION, List.class);
		 */
		return productsResult;
	}

	private List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new MappingJackson2HttpMessageConverter());
		return converters;
	}

	@Override
	public Response update(String idProduct) {
		// TODO Auto-generated method stub
		return null;
	}

}
