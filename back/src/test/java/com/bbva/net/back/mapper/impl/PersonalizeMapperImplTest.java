package com.bbva.net.back.mapper.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.model.globalposition.ProductDto;

public class PersonalizeMapperImplTest {

	private PersonalizeAccountProductMapperImpl personalizeMapper;

	private Product product;

	@Before
	public void init() {
		this.personalizeMapper = new PersonalizeAccountProductMapperImpl();
		this.product = new Product();
	}

	@Test
	public void checkMap() {
		this.product = personalizeMapper.map(new ProductDto());
		Assert.assertNotNull(this.product);
	}
}