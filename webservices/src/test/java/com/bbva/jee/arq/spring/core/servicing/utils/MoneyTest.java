package com.bbva.jee.arq.spring.core.servicing.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class MoneyTest extends AbstractBbvaDTOTest<Money> {

	@Override
	protected Money getInstance() {
		return new Money();
	}

	@Test
	public void checkAccessNotNullMethods() {

		Money money = new Money("13.56 COP");
		assertNotNull(money);
		money = new Money(null);
		assertNull(money.getAmount());
		money = new Money("13.56COP");
		assertNull(money.getAmount());
		money = new Money("13.56 COP COP");
		assertNull(money.getAmount());
		money = new Money("13.56 COPO ");
		assertNotNull(money.getAmount());
		money = new Money("13..56 COP COP HOLA");
		assertNull(money.getAmount());
		money = new Money("HOLA");
		assertNull(money.getAmount());
		money = new Money("");
		assertNull(money.getAmount());

	}

}
