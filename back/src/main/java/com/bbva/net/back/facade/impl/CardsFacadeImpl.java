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
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.webservices.cards.CardService;
import com.bbva.net.webservices.customers.CustomerService;

/**
 * @author Entelgy
 */
@Facade(value = "cardsFacade")
public class CardsFacadeImpl extends AbstractBbvaFacade implements CardsFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2854959422258520144L;

	/**
	 * CLIENTE REST
	 */
	@Resource(name = "customerService")
	private CustomerService customService;

	/**
	 * 
	 */
	@Resource(name = "cardService")
	private CardService cardChargeService;

	/**
	 * 
	 */
	@Resource(name = "cardsMapper")
	private CardsMapper cardsMapper;

	/**
	 * @param cardChargeService
	 */
	public void setCardChargeService(final CardService cardChargeService) {
		this.cardChargeService = cardChargeService;
	}

	/**
	 * 
	 */
	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	/**
	 * 
	 */
	@Value("${fiql.cards.date}")
	private String date;

	/**
	 * @param fiqlService
	 */
	public void setFiqlService(final FiqlService fiqlService) {
		this.fiqlService = fiqlService;
	}

	/**
	 * Determina si debe crear o no la cadena del filtro
	 */
	@Override
	public List<CardsChargesDto> getCardsChargesByUser(final DateRangeDto dateRange) {
		EnumPeriodType periodType;
		DateRangeDto dateRangeUser = dateRange;
		if (dateRangeUser == null) {
			periodType = EnumPeriodType.valueOf(EnumPeriodType.LAST_SIX_MONTH.getPeriodId());
			dateRangeUser = new DateFilterServiceImpl().getPeriodFilter(periodType);
		}
		LOGGER.info("Graphic cards Facade by User dateRange:" + dateRangeUser.toString());
		final String filter = fiqlService.getFiqlQueryByDateRange(dateRangeUser, date, date);
		LOGGER.info("Graphic cards Facade by User filter:" + filter);
		final List<CardCharge> response = customService.listCreditCardsCharges(filter);
		LOGGER.info("Graphic cards Facade by User Mapper:" + cardsMapper.map(response));
		return cardsMapper.map(response);
	}

	/**
	 * @param cardsMapper
	 */
	public void setCardsMapper(final CardsMapper cardsMapper) {
		this.cardsMapper = cardsMapper;
	}

	/**
	 * Determina si debe crear o no la cadena del filtro
	 */
	@Override
	public List<CardsChargesDto> getCardsChargesFilter(final String productId, final DateRangeDto dateRange) {
		LOGGER.info("Graphic cards Facade by User product: id :" + productId + " dateRange: " + dateRange.toString());
		final String filter = fiqlService.getFiqlQueryByDateRange(dateRange, date, date);
		LOGGER.info("Graphic cards Facade by User product:" + filter);
		final List<CardCharge> response = cardChargeService.getCreditCardCharges(productId, filter, "", "", "");
		LOGGER.info("Graphic cards Facade by User Mapper:" + cardsMapper.map(response));
		return cardsMapper.map(response);
	}

	/** DEPENDENCY INJECTIONS **/

	public void setCardsCustomerService(final CustomerService CustomService) {
		this.customService = CustomService;
	}
}
