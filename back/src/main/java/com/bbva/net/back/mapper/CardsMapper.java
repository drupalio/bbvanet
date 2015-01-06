package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.model.cards.CardsChargesDTO;
import com.bbva.net.back.model.globalposition.CreditCardDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;

public interface CardsMapper {

	/**
	 * 
	 * @param CardCharges
	 * @return
	 */
	List<CardsChargesDTO> map(List<CardCharge> CardCharges);

}
