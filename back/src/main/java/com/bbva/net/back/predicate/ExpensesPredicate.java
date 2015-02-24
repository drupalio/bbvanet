/**
 * 
 */
package com.bbva.net.back.predicate;

import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class ExpensesPredicate extends BbvaPredicate<MovementDto> {

	private static final int EXPENSE = -1;

	@Override
	protected boolean eval(MovementDto movementDto) {
		if (movementDto == null || movementDto.getMovementValue() == null
				|| movementDto.getMovementValue().getAmount() == null) {
			return false;
		}
		return (movementDto.getMovementValue().getAmount().signum()) == EXPENSE;
	}

}
