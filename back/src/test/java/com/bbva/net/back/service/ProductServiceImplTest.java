package com.bbva.net.back.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;
import co.com.bbva.services.transactions.globalposition.schema.Product;

import com.bbva.net.back.service.impl.ProductServiceImpl;

public class ProductServiceImplTest {

	private ProductServiceImpl productServiceImpl;

	@Before
	public void init(){
		
		this.productServiceImpl = new ProductServiceImpl();
	}
	
	
	@Test
	public void checkGetProductsNotEmpty() {
		final List<Product> products = productServiceImpl.getProducts(new GlobalProducts());

		/**
		 * Asserts
		 */
		Assert.assertNotNull(products);

	}

	@Test
	public void isAssetProduct() {
		productServiceImpl.isAssetProductType("");

	}

}
