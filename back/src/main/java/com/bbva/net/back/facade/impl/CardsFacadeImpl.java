package com.bbva.net.back.facade.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.mapper.CardsMapper;
import com.bbva.net.back.mapper.GlobalPositionMapper;
import com.bbva.net.back.model.cards.CardsChargesDTO;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.predicate.HiddenProductPredicate;
import com.bbva.net.back.predicate.VisibleProductPredicate;
import com.bbva.net.back.service.ProductService;
import com.bbva.net.webservices.customers.CustomerService;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "cardsFacade")
public class CardsFacadeImpl extends AbstractBbvaFacade implements CardsFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2854959422258520144L;

	// CLIENTE REST
	@Resource(name = "customerService")
	private CustomerService cardsChargeService;

	@Resource(name = "cardsMapper")
	private CardsMapper cardsMapper;

	@Resource(name = "productService")
	private ProductService productService;
	
	@Override
	public List<CardsChargesDTO> getCardsChargesByUser(String customerId) {
		
		final List<CardCharge> response = cardsChargeService
				.listCreditCardsCharges(customerId);
		return cardsMapper.map(response);
	}
	

}
