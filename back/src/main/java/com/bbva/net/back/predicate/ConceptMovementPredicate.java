/**
 * 
 */
package com.bbva.net.back.predicate;

import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class ConceptMovementPredicate extends BbvaPredicate<MovementDto> {

	private String concept;

	private String status;

	public ConceptMovementPredicate(final String concept, final String status) {
		this.concept = concept;
		this.status = status;
	}

	@Override
	protected boolean eval(final MovementDto movementDto) {
		if (movementDto == null || movementDto.getMovementDetailDto().getOperationDescription() == null) {
			return false;
		} else {
			if (status == null || movementDto.getStatus() == null) {
				return movementDto.getMovementDetailDto().getOperationDescription().contains(concept);
			} else {
				return movementDto.getMovementDetailDto().getOperationDescription().contains(concept)
						&& movementDto.getStatus().contains(status);
			}

		}

	}
}
