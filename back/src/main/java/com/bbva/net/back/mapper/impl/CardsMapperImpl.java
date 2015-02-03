package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.back.command.CardVisitorCommand;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.CardsMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.model.cards.CardsChargesDto;

@Mapper(value = "cardsMapper")
public class CardsMapperImpl extends ConfigurableMapper implements CardsMapper {

	@Override
	public List<CardsChargesDto> map(List<CardCharge> CardCharges) {
		final List<CardsChargesDto> cardsCharges = new ArrayList<CardsChargesDto>();

		new CardVisitorCommand(CardCharges) {

			@Override
			public void executeCards(CardCharge product) {
				cardsCharges.add(map(product, CardsChargesDto.class));
			}
		};
		return cardsCharges;
	}

	/**
	 * 
	 */
	@Override
	protected void configure(MapperFactory factory) {

		factory.getConverterFactory().registerConverter(new MoneyConverter());
		// Map CardsCharges Product DTO
		factory.classMap(CardCharge.class, CardsChargesDto.class).field("category", "categorie")
				.field("amount", "ammount").byDefault().register();

	}

}
