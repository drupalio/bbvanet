package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.net.back.mapper.ConditionsMapper;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.webservices.products.ProductsService;

public class TermasAccountsFacadeImplTest {

	private final String DEFAULT_CUENTA = "00130443000200009416";

	private TermasAccountsFacadeImpl termasAccountsFacade;

	@Resource(name = "productsService")
	private ProductsService productsService;

	@Resource(name = "conditionsMapper")
	private ConditionsMapper mapper;

	@Before
	public void init() {
		termasAccountsFacade = new TermasAccountsFacadeImpl();
		productsService = Mockito.mock(ProductsService.class);
		mapper = Mockito.mock(ConditionsMapper.class);
		termasAccountsFacade.setMapper(mapper);
		termasAccountsFacade.setProductsService(productsService);
	}

	@Test
	public void getAllConditions() {
		Conditions condi = new Conditions();
		TermsAccountsDto condiciones = Mockito.mock(TermsAccountsDto.class);
		Mockito.when(productsService.getConditions(DEFAULT_CUENTA)).thenReturn(condi);
		Mockito.when(mapper.map(condi)).thenReturn(condiciones);
		condiciones = termasAccountsFacade.getAllConditions(DEFAULT_CUENTA);
		Assert.assertNotNull(condiciones);
		Mockito.verify(this.productsService, Mockito.atLeastOnce()).getConditions(DEFAULT_CUENTA);
	}

}
