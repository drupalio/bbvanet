package com.bbva.net.back.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.back.service.impl.ProductServiceImpl;

public class ProductServiceImplTest {

	private ProductServiceImpl productServiceImpl;

	@Before
	public void init() {

		this.productServiceImpl = new ProductServiceImpl();
	}

	@Test
	public void checkGetProductsNotEmpty() {
		final List<ProductDTO> products = productServiceImpl.getProducts(new GlobalProductsDTO());

		/**
		 * Asserts
		 */
		Assert.assertNotNull(products);

	}
}
