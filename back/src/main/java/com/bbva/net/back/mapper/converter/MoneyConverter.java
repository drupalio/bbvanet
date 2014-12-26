package com.bbva.net.back.mapper.converter;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

import com.bbva.net.back.model.commons.Money;

/**
 * @author Entelgy
 */
public class MoneyConverter extends CustomConverter<com.bbva.jee.arq.spring.core.servicing.utils.Money, Money> {

	/**
	 * 
	 */
	@Override
	public Money convert(com.bbva.jee.arq.spring.core.servicing.utils.Money source,
			Type<? extends Money> destinationType) {
		return new Money(source.getAmount(), source.getCurrency());
	}

}
