package com.bbva.net.back.model.globalposition;

import com.bbva.czic.dto.net.EnumFundsType;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class FundDtoTest extends AbstractBbvaDTOTest<FundDto> {

	private FundDto fund;

	public FundDtoTest() {
		this.fund = new FundDto(EnumFundsType.AN);
	}

	@Override
	protected FundDto getInstance() {
		return new FundDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		FundDto eqfund = new FundDto();
		// Cuando el objeto es nulo
		this.fund.equals(null);
		// Cuando el dto comparado no es el mismo
		this.fund.equals(new MovementCriteriaDto());
		// Caso exitoso
		eqfund.setTypefunds(EnumFundsType.AN);
		this.fund.equals(eqfund);
		// el id del objeto es diferente
		eqfund.setTypefunds(EnumFundsType.BF);
		this.fund.equals(eqfund);
	}

}