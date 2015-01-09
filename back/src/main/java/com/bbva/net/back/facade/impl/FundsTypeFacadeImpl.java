package com.bbva.net.back.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bbva.czic.dto.net.EnumFundsType;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.FundsTypeFacade;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.FundDto;

@Facade(value = "fundsTypeFacade")
public class FundsTypeFacadeImpl extends AbstractBbvaFacade implements FundsTypeFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4243379878856215155L;

	@Override
	public List<FundDto> getFundsDataGraphic(String usuario) {

		List<FundDto> funds = new ArrayList<FundDto>();

		FundDto plusValue = new FundDto();
		FundDto guarantedValue = new FundDto();

		plusValue.setTypefunds(EnumFundsType.plusValue);
		plusValue.setTotalCash(new Money(new BigDecimal(700000)));

		guarantedValue.setTypefunds(EnumFundsType.guaranteedValue);
		guarantedValue.setTotalCash(new Money(new BigDecimal(300000)));

		funds.add(plusValue);
		funds.add(guarantedValue);

		return funds;
	}
}