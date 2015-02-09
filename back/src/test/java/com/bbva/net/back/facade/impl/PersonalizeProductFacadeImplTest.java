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

	private static final String DEFAULT_ID = "0013044300020000949";

	@Before
	public void init() {
		this.productFacadeImpl = new PersonalizeProductFacadeImpl();
		this.personalizeAccountProductMapper = Mockito.mock(PersonalizeAccountProductMapperImpl.class);
		this.globalPositionService = Mockito.mock(GlobalPositionService.class);
		this.productFacadeImpl.setGlobalPositionService(globalPositionService);
		this.productFacadeImpl.setPersonalizeAccountProductMapper(personalizeAccountProductMapper);
		this.product = Mockito.mock(Product.class);
		productDto = Mockito.mock(ProductDto.class);
		productDto.setProductId("0013044300020000949");
		productDto.setVisible(true);
		productDto.setOperationOnline(false);

	}

	@Test
	public void checkGetPersonalizeUpdateOperability() {
		Response response = Mockito.mock(Response.class);

		Mockito.when(globalPositionService.updateProductOperability(DEFAULT_ID, product)).thenReturn(response);
		Mockito.when(personalizeAccountProductMapper.map(this.productDto)).thenReturn(product);
		response = productFacadeImpl.updateProductOperability(DEFAULT_ID, this.productDto);
		Assert.assertNotNull(response);
		Mockito.verify(this.globalPositionService, Mockito.atLeastOnce()).updateProductOperability(DEFAULT_ID, product);
	}

	@Test
	public void checkGetPersonalizeUpdateVisibility() {
		Response response = Mockito.mock(Response.class);

		Mockito.when(globalPositionService.updateProductVisibility(DEFAULT_ID, product)).thenReturn(response);
		Mockito.when(personalizeAccountProductMapper.map(this.productDto)).thenReturn(product);
		response = productFacadeImpl.updateProductVisibility(DEFAULT_ID, this.productDto);
		Assert.assertNotNull(response);
		Mockito.verify(this.globalPositionService, Mockito.atLeastOnce()).updateProductVisibility(DEFAULT_ID, product);
	}

}
