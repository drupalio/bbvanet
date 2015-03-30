package com.bbva.net.back.facade.impl;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.predicate.HiddenProductPredicate;
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
		this.globalPositionFacadeImpl.setProductService(productService);
		this.globalPositionFacadeImpl.setGlobalPositionService(globalPositionService);
	}

	@Test
	public void checkGetCustomerProducts_Visible() {

		Mockito.when(
				productService.select(Mockito.any(GlobalProductsDto.class), Mockito.any(VisibleProductPredicate.class)))
				.thenReturn(globalProductsDto);
		Assert.assertNotNull(globalPositionFacadeImpl.getGlobalProductsVisibles(globalProductsDto));

	}

	@Test
	public void checkGetGlobalProductsHidden() {
		Mockito.when(
				productService.select(Mockito.any(GlobalProductsDto.class), Mockito.any(HiddenProductPredicate.class)))
				.thenReturn(globalProductsDto);
		Assert.assertNotNull(globalPositionFacadeImpl.getGlobalProductsHidden(globalProductsDto));
	}

	@Test
	public void checkGetTotalsByProduct() {
		Map<String, BalanceDto> totals = Mockito.mock(Map.class);
		Mockito.when(productService.getTotals(globalProductsDto)).thenReturn(totals);
		Assert.assertNotNull(globalPositionFacadeImpl.getTotalsByProduct(globalProductsDto));
	}

	@Test
	public void checkGetNamesProducts() {
		Map<String, List<String>> names = Mockito.mock(Map.class);
		Mockito.when(productService.getProductsName(globalProductsDto)).thenReturn(names);
		Assert.assertNotNull(globalPositionFacadeImpl.getNamesProducts(globalProductsDto));
	}
}
