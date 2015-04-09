package com.bbva.net.back.model.commons;

import java.math.BigDecimal;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class BalanceRangeDtoTest extends AbstractBbvaDTOTest<BalanceRangeDto> {

	private BalanceRangeDto balanceRangeDto;

	public BalanceRangeDtoTest() {
		this.balanceRangeDto = new BalanceRangeDto(new BigDecimal(2000), new BigDecimal(2000));
	}

	@Override
	protected BalanceRangeDto getInstance() {
		return new BalanceRangeDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		// Inicializar entrada
		BalanceRangeDto balanceInEquals = new BalanceRangeDto(new BigDecimal(2000), new BigDecimal(2000));
		// Cuando el objeto es nulo
		this.balanceRangeDto.equals(null);
		// Cuando el dto comparado no es el mismo
		this.balanceRangeDto.equals(new MovementCriteriaDto());
		// Caso exitoso
		this.balanceRangeDto.equals(balanceInEquals);
		// el BalanceTo del objeto es diferente
		balanceInEquals.setBalanceTo(new BigDecimal(4000));
		this.balanceRangeDto.equals(balanceInEquals);
		// el BalanceSince del objeto es diferente
		balanceInEquals.setBalanceSince(new BigDecimal(3000));
		this.balanceRangeDto.equals(balanceInEquals);
	}
}