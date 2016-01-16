package com.bbva.net.back.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.TurnsGeneralFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.turnsClient.BankDto;
import com.bbva.net.back.model.turnsClient.CityDto;
import com.bbva.net.back.model.turnsClient.ContactDto;
import com.bbva.net.back.model.turnsClient.DivisaDto;
import com.bbva.net.back.model.turnsClient.FormCurrencyDto;
import com.bbva.net.back.model.turnsClient.QuotationMoneyDto;
import com.bbva.net.back.model.turnsClient.TurnsClientDetailDto;
import com.bbva.net.back.predicate.DivisasDetailPredicate;

/**
 * @author Entelgy
 */
@Facade(value = "turnsGeneralFacade")
public class TurnsGeneralFacadeImpl extends AbstractBbvaFacade implements TurnsGeneralFacade {

	private List<TurnsClientDetailDto> turnsClient;

	/**
     *
     */
	private static final long serialVersionUID = 1L;

	@Override
	public List<TurnsClientDetailDto> getTurns(final String advanceNumber, final DateRangeDto dateRange,
			final String type, final Integer paginationKey, final Integer pageSize, final String clientId) {
		this.turnsClient = new ArrayList<TurnsClientDetailDto>();

		FormCurrencyDto form = new FormCurrencyDto("4", "1", "");
		QuotationMoneyDto quotation = new QuotationMoneyDto(new DivisaDto("EUR", "3"), new Money(new BigDecimal(5000)),
				"0013-0411-00-398000030", "NM", "3,655.00", "3,655.00", "3,655.00", "3,655.00");
		QuotationMoneyDto quotation1 = new QuotationMoneyDto(new DivisaDto("USD", "2"), new Money(
				new BigDecimal(700000)), "0013-0411-00-776456483", "MN", "3,655.00", "3,655.00", "3,655.00", "3,655.00");
		CityDto city = new CityDto("Inglaterra", "3", "Londres", "1");
		CityDto city1 = new CityDto("Colombia", "1", "Bogota", "2");
		CityDto city2 = new CityDto("Argentina", "3", "Lima", "3");
		BankDto bank = new BankDto("Citibank", city1, "796001880", "3535");
		BankDto bank1 = new BankDto("Citibank", city, "34567786785", "5050");
		BankDto bank2 = new BankDto("Bancolombia", city2, "796001880", "3030");
		ContactDto contact = new ContactDto("Pepito Gomez", "Carrera 22 B N° 50 - 40", "34573456", city, "", bank);
		ContactDto contact1 = new ContactDto("Fermando dolores", "Carrera 30 C N° 13 - 28", "4523176", city1, "", bank1);

		TurnsClientDetailDto turns0 = new TurnsClientDetailDto(new Date(), "T00283", new Date(), "STD",
				"Transferencia personal", "SETECIENTOS SESENTA MIL", "34252435", contact, contact1, bank1, form,
				quotation, "");

		TurnsClientDetailDto turns1 = new TurnsClientDetailDto(new Date(), "H00555", new Date(), "STD",
				"Transferencia", "SETECIENTOS SESENTA MIL", "34252435", contact, contact1, bank2, form, quotation1, "");

		turnsClient.add(turns0);
		turnsClient.add(turns1);
		return turnsClient;
	}

	/**
	 * @param productId
	 * @param movementId
	 * @return
	 */
	@Override
	public TurnsClientDetailDto onTurnDetail(final String productId, final String movementId) {
		TurnsClientDetailDto detail = (TurnsClientDetailDto)CollectionUtils.select(turnsClient,
				new DivisasDetailPredicate(movementId));
		return detail;
	}

	/**
	 * @return the turnsClient
	 */
	public List<TurnsClientDetailDto> getTurnsClient() {
		return turnsClient;
	}

	/**
	 * @param turnsClient the turnsClient to set
	 */
	public void setTurnsClient(List<TurnsClientDetailDto> turnsClient) {
		this.turnsClient = turnsClient;
	}
}
