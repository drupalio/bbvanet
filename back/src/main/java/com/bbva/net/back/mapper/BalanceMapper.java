package com.bbva.net.back.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.BalanceDto;

// import com.bbva.net.back.model.globalposition.Cuenta;

@Mapper(value = "balanceMapper")
public class BalanceMapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(BalanceDto.class, AccountDto.class).field("available", "alias").byDefault().register();
	}

	// public static void main(final String[] args) {
	//
	// BalanceDto balanceDTO = new BalanceDto();
	//
	// Product producto = new BalanceMapper().map(balanceDTO, Product.class);
	//
	// System.out.print(producto.getAlias());
	//
	// }

}
