package com.bbva.net.back.facade.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.mapper.PersonalizeAccountProductMapper;
import com.bbva.net.back.mapper.impl.PersonalizeAccountProductMapperImpl;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

public class PersonalizeProductFacadeImplTest {

	private PersonalizeProductFacadeImpl productFacadeImpl;

	private PersonalizeAccountProductMapper personalizeAccountProductMapper;

	private GlobalPositionService globalPositionService;

	private Product product;

	private ProductDto productDto;

	private static final String DEFAULT_ID = "00130073005054466407";

	@Before
	public void init() {
		this.productFacadeImpl = new PersonalizeProductFacadeImpl();
		this.personalizeAccountProductMapper = Mockito.mock(PersonalizeAccountProductMapperImpl.class);
		this.globalPositionService = Mockito.mock(GlobalPositionService.class);
		this.productFacadeImpl.setGlobalPositionService(globalPositionService);
		this.productFacadeImpl.setPersonalizeAccountProductMapper(personalizeAccountProductMapper);
		this.product = Mockito.mock(Product.class);
		this.productDto = Mockito.mock(ProductDto.class);
		this.productDto.setProductId("00130073005054466407");
		this.productDto.setVisible(true);
		this.productDto.setOperationOnline(false);

	}

	@Test
	public void checkGetPersonalizeUpdateOperability() {
		boolean response;
		Response responseService = Mockito.mock(Response.class);

		Mockito.when(globalPositionService.updateProductOperability(DEFAULT_ID, product)).thenReturn(responseService);
		Mockito.when(personalizeAccountProductMapper.map(this.productDto)).thenReturn(product);
		response = productFacadeImpl.updateProductOperability(DEFAULT_ID, this.productDto);
		Assert.assertNotNull(response);
		Mockito.verify(this.globalPositionService, Mockito.atLeastOnce()).updateProductOperability(DEFAULT_ID, product);
	}

	@Test
	public void checkGetPersonalizeUpdateVisibility() {
		boolean response;
		Response responseService = Mockito.mock(Response.class);
		Mockito.when(globalPositionService.updateProductVisibility(DEFAULT_ID, product)).thenReturn(responseService);
		Mockito.when(personalizeAccountProductMapper.map(this.productDto)).thenReturn(product);
		response = productFacadeImpl.updateProductVisibility(DEFAULT_ID, this.productDto);
		Assert.assertNotNull(response);
		Mockito.verify(this.globalPositionService, Mockito.atLeastOnce()).updateProductVisibility(DEFAULT_ID, product);
	}

}
