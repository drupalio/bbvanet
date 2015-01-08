package com.bbva.net.back.service;

import java.util.List;

import com.bbva.czic.dto.net.EnumFundsType;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.FundDto;
import com.bbva.net.back.model.globalposition.ProductDto;

public interface FundsService {

	public <T extends ProductDto> Money getTotal(final List<T> products);

	public <T extends ProductDto> Money getTotalAvailable(final List<T> products);

	Money getTotalFundByType(List<FundDto> funds, EnumFundsType fundsType);


}
