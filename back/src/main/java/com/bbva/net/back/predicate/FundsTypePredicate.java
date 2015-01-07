package com.bbva.net.back.predicate;

import com.bbva.czic.dto.net.EnumFundsType;
import com.bbva.net.back.model.globalposition.FundDto;
import com.bbva.net.core.collection.BbvaPredicate;

public class FundsTypePredicate extends BbvaPredicate<FundDto> {

	private EnumFundsType fundsType;

	public FundsTypePredicate(final EnumFundsType fundsType) {
		this.fundsType = fundsType;
	}

	@Override
	protected boolean eval(final FundDto fund) {
		return fund.getTypefunds().equals(fundsType);
	}
}
