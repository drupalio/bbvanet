package com.bbva.net.back.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.predicate.VisibleProductPredicate;
import com.bbva.net.back.service.impl.ProductServiceImpl;

public class ProductServiceImplTest {

	private ProductServiceImpl productServiceImpl;

	@Before
	public void init() {

		this.productServiceImpl = new ProductServiceImpl();
	}

	@Test
	public void checkGetProductsByTypeNotEmpty() {
		final List<ProductDto> productList = new ArrayList<ProductDto>();
		final EnumProductType enumType = null;

		/**
		 * Asserts
		 */
		Assert.assertNotNull(productServiceImpl.getTotalProductsByType(productList, enumType));

	}

	@Test
	public void checkGetProductsBySubTypeNotEmpty() {
		final List<ProductDto> productList = new ArrayList<ProductDto>();

		/**
		 * Asserts
		 */
		Assert.assertNotNull(productServiceImpl.getTotalProductsBySubType(productList, "FE"));

	}

	@Test
	public void checkGetProductsNotEmpty() {
		final List<ProductDto> products = productServiceImpl.getProducts(new GlobalProductsDto());

		/**
		 * Asserts
		 */
		Assert.assertNotNull(products);

	}

	@Test
	public void checkSelectNotEmpty() {

		/**
		 * Asserts
		 */
		Assert.assertNotNull(productServiceImpl.select(new GlobalProductsDto(), new VisibleProductPredicate())
				.getAccounts());

	}

	@Test
	public void checkProductsNameNotEmpty() {

		/**
		 * Asserts
		 */
		Assert.assertNotNull(productServiceImpl.getProductsName(new GlobalProductsDto()));

	}

	@Test
	public void checkGetTotalNotEmpty() {
		final List<ProductDto> productList = new ArrayList<ProductDto>();

		/**
		 * Asserts
		 */
		Assert.assertNotNull(productServiceImpl.getTotal(productList));
	}

	@Test
	public void checkGetTotalAvaialableNotEmpty() {
		final List<ProductDto> productList = new ArrayList<ProductDto>();

		/**
		 * Asserts
		 */
		Assert.assertNotNull(productServiceImpl.getTotalAvailable(productList));
	}

	@Test
	public void checkGetNameProductNotEmpty() {
		final List<ProductDto> productList = new ArrayList<ProductDto>();

		/**
		 * Asserts
		 */
		Assert.assertNotNull(productServiceImpl.getNameProduct(productList));
	}

	@Test
	public void checkGetTotalAssetsNotEmpty() {
		final List<ProductDto> productList = new ArrayList<ProductDto>();

		/**
		 * Asserts
		 */
		Assert.assertNotNull(productServiceImpl.getTotalAssets(productList));
	}

	@Test
	public void checkGetTotalsNotEmpty() {
		/**
		 * Asserts
		 */
		Assert.assertNotNull(productServiceImpl.getTotals(new GlobalProductsDto()));
	}

	@Test
	public void checkGetTotalFinanciacionNotEmpty() {
		final List<ProductDto> productList = new ArrayList<ProductDto>();

		/**
		 * Asserts
		 */
		Assert.assertNotNull(productServiceImpl.getTotalFinanciacion(productList));
	}

	@Test
	public void checkGetLoanTotalsNotEmpty() {

		/**
		 * Asserts
		 */
		Assert.assertNotNull(productServiceImpl.getLoanTotals(new GlobalProductsDto()));
	}

}