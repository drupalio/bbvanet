package com.bbva.jee.arq.spring.core.servicing.utils;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class MoneyTest extends AbstractBbvaDTOTest<Money> {

	@Override
	protected Money getInstance() {
		return new Money();
	}

}
