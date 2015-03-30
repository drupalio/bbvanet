package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.mapper.PersonalizeAccountProductMapper;
import com.bbva.net.back.mapper.impl.PersonalizeAccountProductMapperImpl;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

public class PersonalizeProductFacadeImplTest {

	private PersonalizeProductFacadeImpl personalizeFacadeImpl;

	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;

	@Resource(name = "personalizeProductMapper")
	private PersonalizeAccountProductMapper personalizeAccountProductMapper;

	private Product product;

	private ProductDto productDto;

	private static final String DEFAULT_ID = "00130443000200009410";

	@Before
	public void init() {
		this.personalizeFacadeImpl = new PersonalizeProductFacadeImpl();
		this.personalizeAccountProductMapper = Mockito.mock(PersonalizeAccountProductMapperImpl.class);
		this.globalPositionService = Mockito.mock(GlobalPositionService.class);
		this.personalizeFacadeImpl.setGlobalPositionService(globalPositionService);
		this.personalizeFacadeImpl.setPersonalizeAccountProductMapper(personalizeAccountProductMapper);
		this.product = Mockito.mock(Product.class);
		this.productDto = Mockito.mock(ProductDto.class);
	}

	@Test
	public void checkGetPersonalizeUpdateOperability() {
		Mockito.when(globalPositionService.updateProductOperability(DEFAULT_ID, product)).thenReturn(true);
		Mockito.when(personalizeAccountProductMapper.map(this.productDto)).thenReturn(product);
		Assert.assertTrue(personalizeFacadeImpl.updateProductOperability(DEFAULT_ID, this.productDto));
		Mockito.verify(this.globalPositionService, Mockito.atLeastOnce()).updateProductOperability(DEFAULT_ID, product);
	}

	@Test
	public void checkGetPersonalizeUpdateVisibility() {
		Mockito.when(globalPositionService.updateProductVisibility(DEFAULT_ID, product)).thenReturn(true);
		Mockito.when(personalizeAccountProductMapper.map(this.productDto)).thenReturn(product);
		Assert.assertTrue(personalizeFacadeImpl.updateProductVisibility(DEFAULT_ID, this.productDto));
		Mockito.verify(this.globalPositionService, Mockito.atLeastOnce()).updateProductVisibility(DEFAULT_ID, product);
	}
}
