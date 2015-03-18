package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.model.globalposition.AccountDto;
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
		AccountDto account = new AccountDto();
		account.setVisible(true);
		List<AccountDto> lista = new ArrayList<AccountDto>();
		lista.add(account);
		GlobalProductsDto global = new GlobalProductsDto();
		global.setAccounts(lista);

		Mockito.when(productService.select(globalProductsDto, new VisibleProductPredicate())).thenReturn(global);
		Assert.assertNull(globalPositionFacadeImpl.getGlobalProductsVisibles(global));

	}

	@Test
	public void checkGetGlobalProductsHidden() {
		Mockito.when(productService.select(globalProductsDto, new HiddenProductPredicate())).thenReturn(
				globalProductsDto);
		Assert.assertNull(globalPositionFacadeImpl.getGlobalProductsHidden(globalProductsDto));
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
