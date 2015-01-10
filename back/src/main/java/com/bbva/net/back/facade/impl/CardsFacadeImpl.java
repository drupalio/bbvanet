package com.bbva.net.back.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.cxf.jaxrs.ext.search.client.FiqlSearchConditionBuilder;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.mapper.CardsMapper;
import com.bbva.net.back.mapper.GlobalPositionMapper;
import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.predicate.HiddenProductPredicate;
import com.bbva.net.back.predicate.VisibleProductPredicate;
import com.bbva.net.back.service.ProductService;
import com.bbva.net.webservices.cards.CardService;
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
	private CustomerService cardsCustomerService;

	@Resource(name = "cardsMapper")
	private CardsMapper cardsMapper;

	@Resource(name = "productService")
	private ProductService productService;
	
	@Resource(name = "cardService")
	private CardService cardChargeService;
	
	@Override
	public List<CardsChargesDto> getCardsChargesByUser(String customerId, DateRangeDto dateRange) {
		final List<CardCharge> response = cardsCustomerService
				.listCreditCardsCharges(customerId,"");
		return cardsMapper.map(response);
	}

	@Override
	public List<CardsChargesDto> getCardsChargesFilter(String customerId, DateRangeDto dateRange) {

		Map<String, String> props = new HashMap<String, String>();
		props.put("search.date-format", dateRange.getDateSince().toString());
		props.put("search.timezone.support", "false");

		         
		FiqlSearchConditionBuilder bCustom = new FiqlSearchConditionBuilder(props);
		//linea de creacion del filtro
		String filter = bCustom.is("foo").before(dateRange.getDateSince()).query();
		/*
		(chargeDate=ge={startDate};chargeDate=le={enDate})
		
		SearchConditionBuilder b = SearchConditionBuilder.instance();
		String filter = b.is("starDateSelectd").greaterThan(10).and().is("starDate").lessThan(20).query();
		
		 */
		
		final List<CardCharge> response=cardChargeService.getCreditCardCharges(customerId, filter,null,null, null);
		return cardsMapper.map(response);
	}
	

}
