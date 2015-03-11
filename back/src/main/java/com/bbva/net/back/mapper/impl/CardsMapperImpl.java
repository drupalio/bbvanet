package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.CardsMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.core.pattern.VisitorCommand;

/**
 * @author Entelgy
 */
@Mapper(value = "cardsMapper")
public class CardsMapperImpl extends ConfigurableMapper implements CardsMapper {

	/**
	 * 
	 */
	@Override
	public List<CardsChargesDto> map(final List<CardCharge> cardCharges) {
		final List<CardsChargesDto> cardsCharges = new ArrayList<CardsChargesDto>();

		new VisitorCommand<CardCharge>(cardCharges) {

			/**
			 * 
			 */
			@Override
			public void execute(final CardCharge product) {
				cardsCharges.add(map(product, CardsChargesDto.class));
			}
		};
		return cardsCharges;
	}

	/**
	 * 
	 */
	@Override
	protected void configure(final MapperFactory factory) {

		factory.getConverterFactory().registerConverter(new MoneyConverter());
		// Map CardsCharges Product DTO
		factory.classMap(CardCharge.class, CardsChargesDto.class).field("category", "categorie")
				.field("amount", "ammount").byDefault().register();

	}

}
