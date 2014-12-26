package com.bbva.net.back.model.commons;

import java.math.BigDecimal;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class MoneyTest extends AbstractBbvaDTOTest<Money> {

	@Override
	protected Money getInstance() {
		return new Money(new BigDecimal(0));
	}

}