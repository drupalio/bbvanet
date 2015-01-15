package com.bbva.net.back.facade.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.service.ProductService;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

public class GlobalPositionFacadeImplTest {

	private GlobalPositionService globalPositionService;

	private ProductService productService;

	private GlobalPositionFacadeImpl globalPositionFacadeImpl;

	private static final String DEFAULT_USER = "123";

	@Before
	public void init() {
		this.globalPositionFacadeImpl = new GlobalPositionFacadeImpl();
		productService = Mockito.mock(ProductService.class);
	}

	@Test
	public void checkGetCustomerProducts_Visible() {

	}

	@Test
	public void checkNamesProduct() {
		GlobalProductsDto globalProducts = Mockito.mock(GlobalProductsDto.class);
		// Map<String, List<String>> namesProducts = globalPositionFacadeImpl.getNamesProducts(globalProducts);
		// Assert.assertNotNull(namesProducts);
		// Mockito.verify(productService, Mockito.atLeastOnce()).getProductsName(globalProducts);
	}
}
