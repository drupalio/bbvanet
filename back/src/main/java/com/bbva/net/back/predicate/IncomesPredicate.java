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

	public IncomesPredicate() {

	}

	@Override
	protected boolean eval(MovementDto movementDto) {

		return (movementDto.getMovementValue().getAmount().signum()) == 1;
	}

}
