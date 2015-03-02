package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.mapper.CardsMapper;
import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.back.service.ProductService;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.webservices.cards.CardService;
import com.bbva.net.webservices.customers.CustomerService;

@Facade(value = "cardsFacade")
public class CardsFacadeImpl extends AbstractBbvaFacade implements CardsFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2854959422258520144L;

	// CLIENTE REST
	@Resource(name = "customerService")
	private CustomerService cardsCustomerService;

	@Resource(name = "cardService")
	private CardService cardChargeService;

	@Resource(name = "cardsMapper")
	private CardsMapper cardsMapper;

	public void setCardChargeService(CardService cardChargeService) {
		this.cardChargeService = cardChargeService;
	}

	@Resource(name = "productService")
	private ProductService productService;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	@Value("${fiql.cards.date}")
	private String DATE;

	public void setFiqlService(FiqlService fiqlService) {
		this.fiqlService = fiqlService;
	}

	/**
	 * Determina si debe crear o no la cadena del filtro
	 */
	@Override
	public List<CardsChargesDto> getCardsChargesByUser(DateRangeDto dateRange) {
		EnumPeriodType periodType = null;
		if (dateRange == null) {
			periodType = EnumPeriodType.valueOf(EnumPeriodType.LAST_SIX_MONTH.getPeriodId());
			dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		}
		LOGGER.info("Graphic cards Facade by User dateRange:" + dateRange.toString());
		String filter = fiqlService.getFiqlQueryByDateRange(dateRange, DATE, DATE);
		LOGGER.info("Graphic cards Facade by User filter:" + filter);
		final List<CardCharge> response = cardsCustomerService.listCreditCardsCharges(filter);
		LOGGER.info("Graphic cards Facade by User Mapper:" + cardsMapper.map(response));
		return cardsMapper.map(response);
	}

	public void setCardsMapper(CardsMapper cardsMapper) {
		this.cardsMapper = cardsMapper;
	}

	/**
	 * Determina si debe crear o no la cadena del filtro
	 */
	@Override
	public List<CardsChargesDto> getCardsChargesFilter(final String productId, final DateRangeDto dateRange) {
		LOGGER.info("Graphic cards Facade by User product: id :" + productId + " dateRange: " + dateRange.toString());
		String filter = fiqlService.getFiqlQueryByDateRange(dateRange, DATE, DATE);
		LOGGER.info("Graphic cards Facade by User product:" + filter);
		final List<CardCharge> response = cardChargeService.getCreditCardCharges(productId, filter, "", "", "");
		LOGGER.info("Graphic cards Facade by User Mapper:" + cardsMapper.map(response));
		return cardsMapper.map(response);
	}

	/********************************** DEPENDENCY INJECTIONS ***********************************/

	public void setCardsCustomerService(CustomerService cardsCustomerService) {
		this.cardsCustomerService = cardsCustomerService;
	}
}
