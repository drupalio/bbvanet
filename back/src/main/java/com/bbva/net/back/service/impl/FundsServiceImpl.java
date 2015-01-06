package com.bbva.net.back.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.bbva.czic.dto.net.EnumFundsType;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.FundDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.back.predicate.FundsTypePredicate;
import com.bbva.net.back.service.FundsService;
import com.bbva.net.core.utils.CollectionBbvaUtils;

@Service(value = "fundsService")
public class FundsServiceImpl implements FundsService {

	@Override
	public <T extends ProductDTO> Money getTotal(final List<T> products) {
		return new Money(CollectionBbvaUtils.calculateTotal(products, "totalCash.amount"));
	}

	@Override
	public <T extends ProductDTO> Money getTotalAvailable(final List<T> products) {
		return new Money(CollectionBbvaUtils.calculateTotal(products, "cashAvailable.amount"));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Money getTotalFundByType(final List<FundDTO> funds, final EnumFundsType fundsType) {

		final List<ProductDTO> fundsByType = (List<ProductDTO>)CollectionUtils.select(funds, new FundsTypePredicate(
				fundsType));

		return getTotal(fundsByType);
	}

}
