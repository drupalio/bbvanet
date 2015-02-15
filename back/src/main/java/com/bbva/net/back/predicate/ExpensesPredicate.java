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

	public ExpensesPredicate() {

	}

	@Override
	protected boolean eval(MovementDto movementDto) {

		return (movementDto.getMovementValue().getAmount().signum()) == -1;
	}

}
