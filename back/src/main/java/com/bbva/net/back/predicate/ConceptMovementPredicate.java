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

	public ConceptMovementPredicate(final String concept) {
		this.concept = concept;
	}

	@Override
	protected boolean eval(final MovementDto movementDto) {

		return movementDto.getMovementConcept().contentEquals(concept);
	}

}
