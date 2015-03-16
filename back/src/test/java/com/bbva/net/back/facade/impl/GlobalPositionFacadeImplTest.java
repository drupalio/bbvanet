package com.bbva.net.back.facade.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.predicate.VisibleProductPredicate;
import com.bbva.net.back.service.ProductService;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

public class GlobalPositionFacadeImplTest {

	private GlobalPositionService globalPositionService;

	private ProductService productService;

	private GlobalProductsDto globalProductsDto;

	private GlobalPositionFacadeImpl globalPositionFacadeImpl;

	private static final String DEFAULT_USER = "123";

	@Before
	public void init() {
		this.globalPositionFacadeImpl = new GlobalPositionFacadeImpl();
		this.productService = Mockito.mock(ProductService.class);
		this.globalProductsDto = Mockito.mock(GlobalProductsDto.class);
	}

	@Test
	public void checkGetCustomerProducts_Visible() {
		GlobalProductsDto g = new GlobalProductsDto();
		productService.select(g, new VisibleProductPredicate());
		Mockito.verify(productService, Mockito.atLeastOnce()).select(g, Mockito.mock(VisibleProductPredicate.class));
	}

	@Test
	public void checkNamesProduct() {
		GlobalProductsDto globalProducts = Mockito.mock(GlobalProductsDto.class);
		// Map<String, List<String>> namesProducts = globalPositionFacadeImpl.getNamesProducts(globalProducts);
		// Assert.assertNotNull(namesProducts);
		// Mockito.verify(productService, Mockito.atLeastOnce()).getProductsName(globalProducts);
	}
}
