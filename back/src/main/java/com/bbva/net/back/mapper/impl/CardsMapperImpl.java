package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.back.command.CardVisitorCommand;
import com.bbva.net.back.command.ProductVisitorCommand;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.BalanceMapper;
import com.bbva.net.back.mapper.CardsMapper;
import com.bbva.net.back.mapper.GlobalPositionMapper;
import com.bbva.net.back.mapper.converter.AssetConverter;
import com.bbva.net.back.mapper.converter.FinancialStateConverter;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.mapper.factory.ProductDTOFactory;
import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDto;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.CreditCardDto;
import com.bbva.net.back.model.globalposition.DepositDto;
import com.bbva.net.back.model.globalposition.FundDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;

@Mapper(value = "cardsMapper")
public class CardsMapperImpl extends ConfigurableMapper implements CardsMapper {

	@Override
	public List<CardsChargesDto> map(List<CardCharge> CardCharges) {
		final List<CardsChargesDto> cardsCharges =  new ArrayList<CardsChargesDto>();

		new CardVisitorCommand(CardCharges) {
			@Override
			public void executeCards(CardCharge product,String name) {
				cardsCharges.add(map(product, CardsChargesDto.class));
				cardsCharges.get(cardsCharges.size()-1).setCategorie(name);
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
				.field("amount", "ammount").byDefault()
				.register();

	}

}
