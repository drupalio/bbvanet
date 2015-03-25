package com.bbva.net.back.facade.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.net.back.mapper.ConditionsMapper;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.webservices.products.ProductsService;

public class TermasAccountsFacadeImplTest {

	private TermasAccountsFacadeImpl termasAccountsFacade;

	private ProductsService productsService;

	private ConditionsMapper mapper;

	private TermsAccountsDto termsAccounts;

	@Before
	public void init() {
		this.termasAccountsFacade = new TermasAccountsFacadeImpl();
		// Mockitos
		this.productsService = Mockito.mock(ProductsService.class);
		this.mapper = Mockito.mock(ConditionsMapper.class);
		this.termsAccounts = Mockito.mock(TermsAccountsDto.class);
		// Set
		this.termasAccountsFacade.setMapper(mapper);
		this.termasAccountsFacade.setProductsService(productsService);
	}

	@Test
	public void checkAllConditions() {
		Conditions conditions = new Conditions();
		// Mockear respuestas
		Mockito.when(productsService.getConditions("544356")).thenReturn(conditions);
		Mockito.when(mapper.map(conditions)).thenReturn(termsAccounts);
		Mockito.when(termasAccountsFacade.getAllConditions("544356")).thenReturn(termsAccounts);
		// Llamar método getAllConditions
		this.termsAccounts = this.termasAccountsFacade.getAllConditions("544356");
		// Verificar que no venga nulo
		Assert.assertNotNull(this.termsAccounts);
		// Verificar método getConditions
		Mockito.verify(this.productsService, Mockito.atLeastOnce()).getConditions("544356");
	}

}
