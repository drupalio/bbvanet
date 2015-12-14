package com.bbva.net.back.mapper.converter;

import java.math.BigDecimal;

import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.back.model.commons.Money;

public class MoneyConverterTest {

	private MoneyConverter moneyConverter;

	@Test
	public void convertOK() {
		moneyConverter = new MoneyConverter();
		Type<Money> destinationType = TypeFactory.valueOf(Money.class);
		com.bbva.jee.arq.spring.core.servicing.utils.Money sourceType = new com.bbva.jee.arq.spring.core.servicing.utils.Money();
		sourceType.setAmount(new BigDecimal(100000));
		sourceType.setCurrency("COP");
		Assert.assertNotNull(moneyConverter.convert(sourceType, destinationType));

	}
}
