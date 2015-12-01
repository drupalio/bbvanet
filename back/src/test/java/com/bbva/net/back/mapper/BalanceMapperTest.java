package com.bbva.net.back.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.model.globalposition.BalanceDto;

public class BalanceMapperTest {

	private BalanceMapper balanceMapper;

	@Before
	public void init() {
		this.balanceMapper = new BalanceMapper();

	}

	@Test
	public void checkgetCardsChargesByUser() {
		BalanceDto balanceDTO = new BalanceDto();

		Product producto = new BalanceMapper().map(balanceDTO, Product.class);
		Assert.assertNotNull(producto);
	}
}
