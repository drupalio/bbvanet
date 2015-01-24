package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.mapper.impl.GlobalPositionMapperImpl;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

public class PersonalizeProductFacadeImplTest {

	private PersonalizeProductFacadeImpl productFacadeImpl;
	private GlobalPositionFacadeImpl globalPositionFacadeImpl;
	private GlobalPositionService globalPositionService;
	private static final String DEFAULT_USER = "123";
	private GlobalPositionMapperImpl globalPositionMapper;

	@Before
	public void init() {
		this.globalPositionFacadeImpl = new GlobalPositionFacadeImpl();
		this.productFacadeImpl = new PersonalizeProductFacadeImpl();
		this.globalPositionMapper = Mockito
				.mock(GlobalPositionMapperImpl.class);
		this.globalPositionService = Mockito.mock(GlobalPositionService.class);
		// this.productFacadeImpl
		// .setGlobalPositionFacade(globalPositionFacadeImpl);
		// this.productFacadeImpl.setGlobalPositionService(globalPositionService);
		// this.productFacadeImpl.setGlobalPositionMapper(globalPositionMapper);
	}

	@Test
	public void checkGetPersonalizeAccountDto() {
		// GlobalProductsDto globalProducts =
		// Mockito.mock(GlobalProductsDto.class);
		// List<Product> products = new ArrayList<Product>();
		// Mockito.when(globalPositionService.getExtractGlobalBalance(DEFAULT_USER,
		// null,null,null,null)).thenReturn(products);
		// Mockito.when(globalPositionMapper.map(products)).thenReturn(globalProducts);
		//
		// globalProducts =
		// globalPositionFacadeImpl.getGlobalProductsByUser(DEFAULT_USER);
		// Assert.assertNotNull(globalProducts);
		// Mockito.verify(this.globalPositionService,
		// Mockito.atLeastOnce()).getExtractGlobalBalance(DEFAULT_USER, null,
		// null, null, null);
	}
}
