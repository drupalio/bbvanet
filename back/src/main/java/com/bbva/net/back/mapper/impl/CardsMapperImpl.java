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
import com.bbva.net.back.model.cards.CardsChargesDTO;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDTO;
import com.bbva.net.back.model.globalposition.BalanceDTO;
import com.bbva.net.back.model.globalposition.CreditCardDTO;
import com.bbva.net.back.model.globalposition.DepositDTO;
import com.bbva.net.back.model.globalposition.FundDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.LoanDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;

@Mapper(value = "cardsMapper")
public class CardsMapperImpl extends ConfigurableMapper implements CardsMapper {

	@Override
	public List<CardsChargesDTO> map(List<CardCharge> CardCharges) {
		final List<CardsChargesDTO> cardsCharges =  new ArrayList<CardsChargesDTO>();

		new CardVisitorCommand(CardCharges) {
			@Override
			public void executeCards(CardCharge product,String name) {
				cardsCharges.add(map(product, CardsChargesDTO.class));
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
		factory.classMap(CardCharge.class, CardsChargesDTO.class).field("category", "categorie")
				.field("amount", "ammount").byDefault()
				.register();

	}

}
