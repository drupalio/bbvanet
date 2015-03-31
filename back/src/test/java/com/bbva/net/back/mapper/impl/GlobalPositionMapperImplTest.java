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
	public void checkMapperRotatingAccount() {
		List<Product> products = new ArrayList<Product>();
		GlobalProductsDto productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);

		Product po = new Product();
		po.setType("CR");
		products.add(po);
		productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);
	}

	@Test
	public void checkMapperLoan() {
		List<Product> products = new ArrayList<Product>();
		GlobalProductsDto productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);

		Product po = new Product();
		po.setType("HI");
		products.add(po);
		productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);
	}

	@Test
	public void checkMapperLeasing() {
		List<Product> products = new ArrayList<Product>();
		GlobalProductsDto productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);

		Product po = new Product();
		po.setType("LS");
		products.add(po);
		productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);
	}

	@Test
	public void checkMapperFund() {
		List<Product> products = new ArrayList<Product>();
		GlobalProductsDto productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);

		Product po = new Product();
		po.setType("FA");
		products.add(po);
		productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);
	}

	@Test
	public void checkMapperDeposit() {
		List<Product> products = new ArrayList<Product>();
		GlobalProductsDto productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);

		Product po = new Product();
		po.setType("DE");
		products.add(po);
		productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);
	}

	@Test
	public void checkMapperCreditCard() {
		List<Product> products = new ArrayList<Product>();
		GlobalProductsDto productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);

		Product po = new Product();
		po.setType("TC");
		products.add(po);
		productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);
	}

	@Test
	public void checkMapperAdquirencia() {
		List<Product> products = new ArrayList<Product>();
		GlobalProductsDto productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);

		Product po = new Product();
		po.setType("AQ");
		products.add(po);
		productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);
	}

	@Test
	public void checkMapperAccount() {
		List<Product> products = new ArrayList<Product>();
		GlobalProductsDto productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);

		Product po = new Product();
		po.setType("CC");
		products.add(po);
		productsDto = globalPositionMapper.map(products);
		Assert.assertNotNull(productsDto);
	}
}
