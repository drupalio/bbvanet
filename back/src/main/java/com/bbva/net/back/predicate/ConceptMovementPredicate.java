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
		Boolean estado = false;
		if (movementDto == null) {
			estado = false;
		} else {
			if (status == null || movementDto.getStatus() == null) {

				if (movementDto.getMovementDetailDto().getOperationDescription() != null)
					estado = movementDto.getMovementDetailDto().getOperationDescription().toLowerCase()
							.contains(concept.toLowerCase());

				if (movementDto.getMovementConcept() != null)
					estado = movementDto.getMovementConcept().toLowerCase().contains(concept.toLowerCase());

			} else {
				if (movementDto.getMovementDetailDto().getOperationDescription() != null)
					estado = movementDto.getMovementDetailDto().getOperationDescription().toLowerCase()
							.contains(concept.toLowerCase())
							&& movementDto.getStatus().contains(status);

				if (movementDto.getMovementConcept() != null)
					estado = movementDto.getMovementConcept().toLowerCase().contains(concept.toLowerCase())
							&& movementDto.getStatus().contains(status);

			}

		}
		return estado;
	}
}
