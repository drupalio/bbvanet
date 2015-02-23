/**
 * 
 */
package com.bbva.net.back.predicate;

import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class IncomesPredicate extends BbvaPredicate<MovementDto> {

	private static final int INCOMES = 1;

	@Override
	protected boolean eval(MovementDto movementDto) {
		if (movementDto == null || movementDto.getMovementValue() == null) {
			return false;
		}
		return (movementDto.getMovementValue().getAmount().signum()) == INCOMES;
	}

}
