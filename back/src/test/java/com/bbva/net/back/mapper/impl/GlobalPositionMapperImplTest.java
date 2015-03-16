package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;

public class GlobalPositionMapperImplTest {

	GlobalPositionMapperImpl globalPositionMapper;

	@Before
	public void init() {
		this.globalPositionMapper = new GlobalPositionMapperImpl();

	}

	@Test
	public void checkMapper() {
		List<Product> products = new ArrayList<Product>();
		GlobalProductsDto productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);

		Product po = new Product();
		po.setType("AQ");
		products.add(po);
		productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);
	}
}
