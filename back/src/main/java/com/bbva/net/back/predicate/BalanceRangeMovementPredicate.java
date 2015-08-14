package com.bbva.net.back.predicate;

import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.core.collection.BbvaPredicate;

public class BalanceRangeMovementPredicate extends BbvaPredicate<MovementDto> {

	private BalanceRangeDto balance;

	public BalanceRangeMovementPredicate(BalanceRangeDto balance) {
		this.balance = balance;
	}

	@Override
	protected boolean eval(MovementDto movementDto) {

		return (movementDto.getTotalBalance().getAmount().compareTo(balance.getBalanceTo()) == -1 || movementDto
				.getTotalBalance().getAmount().compareTo(balance.getBalanceTo()) == 0)
				&& (movementDto.getTotalBalance().getAmount().compareTo(balance.getBalanceSince()) == 1 || movementDto
						.getTotalBalance().getAmount().compareTo(balance.getBalanceSince()) == 0);
	}

}
