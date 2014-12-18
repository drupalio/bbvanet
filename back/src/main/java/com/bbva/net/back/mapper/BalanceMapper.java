package com.bbva.net.back.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.BalanceDTO;

// import com.bbva.net.back.model.globalposition.Cuenta;

@Mapper(value = "balanceMapper")
public class BalanceMapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(BalanceDTO.class, AccountDTO.class).field("available", "alias").byDefault().register();
	}

	public static void main(final String[] args) {

		BalanceDTO balanceDTO = new BalanceDTO();

		Product producto = new BalanceMapper().map(balanceDTO, Product.class);

		System.out.print(producto.getAlias());

	}

}
