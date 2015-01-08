package com.bbva.net.back.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.service.impl.ProductServiceImpl;

public class ProductServiceImplTest {

	private ProductServiceImpl productServiceImpl;

	@Before
	public void init() {

		this.productServiceImpl = new ProductServiceImpl();
	}

	@Test
	public void checkGetProductsNotEmpty() {
		final List<ProductDto> products = productServiceImpl.getProducts(new GlobalProductsDto());

		/**
		 * Asserts
		 */
		Assert.assertNotNull(products);

	}
}
