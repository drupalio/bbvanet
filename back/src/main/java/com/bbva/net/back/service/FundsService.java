package com.bbva.net.back.service;

import java.util.List;

import com.bbva.czic.dto.net.EnumFundsType;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.FundDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;

public interface FundsService {

	public <T extends ProductDTO> Money getTotal(final List<T> products);

	public <T extends ProductDTO> Money getTotalAvailable(final List<T> products);

	Money getTotalFundByType(List<FundDTO> funds, EnumFundsType fundsType);


}
