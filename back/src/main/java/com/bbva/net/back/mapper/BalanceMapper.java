package com.bbva.net.back.mapper;

import java.math.BigDecimal;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.model.globalposition.BalanceDTO;
import com.bbva.net.back.model.globalposition.Cuenta;

@Mapper(value = "balanceMapper")
public class BalanceMapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(BalanceDTO.class, Cuenta.class).field("availableBalance", "alias").byDefault().register();
	}

	public static void main(final String[] args) {

		BalanceDTO balanceDTO = new BalanceDTO();
		balanceDTO.setAvailableBalance(BigDecimal.ONE);

		Cuenta cuenta = new BalanceMapper().map(balanceDTO, Cuenta.class);

		System.out.print(cuenta.getAlias());

	}

}
