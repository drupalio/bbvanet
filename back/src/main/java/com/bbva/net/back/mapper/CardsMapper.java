package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.back.model.globalposition.CreditCardDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;

public interface CardsMapper {

	/**
	 * 
	 * @param CardCharges
	 * @return
	 */
	List<CardsChargesDto> map(List<CardCharge> CardCharges);

}
