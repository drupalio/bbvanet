package com.bbva.net.back.facade.impl;

import javax.ws.rs.core.Response;

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

	private PersonalizeAccountProductMapper personalizeAccountProductMapper;

	private GlobalPositionService globalPositionService;

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
		Response responseService = Mockito.mock(Response.class);
		Mockito.when(personalizeAccountProductMapper.map(this.productDto)).thenReturn(product);
		Mockito.when(globalPositionService.updateProductOperability(DEFAULT_ID, product)).thenReturn(responseService);
		Assert.assertNotNull(responseService);
		this.personalizeFacadeImpl.setStatus(200);
		Mockito.when(personalizeFacadeImpl.updateProductOperability(DEFAULT_ID, this.productDto)).thenReturn(false);
		Mockito.verify(this.globalPositionService, Mockito.atLeastOnce()).updateProductOperability(
				this.productDto.getProductId(), product);
	}

	// @Test
	// public void checkGetPersonalizeUpdateVisibility() {
	// boolean response;
	// Response responseService = Mockito.mock(Response.class);
	// Mockito.when(personalizeAccountProductMapper.map(this.productDto)).thenReturn(product);
	// this.product = personalizeAccountProductMapper.map(this.productDto);
	// Mockito.when(globalPositionService.updateProductVisibility(DEFAULT_ID, product)).thenReturn(responseService);
	// response = productFacadeImpl.updateProductVisibility(DEFAULT_ID, this.productDto);
	// Assert.assertEquals(response, true);
	// Mockito.verify(this.globalPositionService, Mockito.atLeastOnce()).updateProductVisibility(DEFAULT_ID, product);
	// }

}
