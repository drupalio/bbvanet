package com.bbva.net.back.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bbva.net.back.model.movements.MovementDto;

public class ConceptMovementPredicateTest {

	private static final String CONCEPT = "Concepto";

	private static final String ANOTHER_CONCEPT = "Otro";

	@Test
	public void checkConceptMovementPredicatedTrue() {

		// Check Equals Concept
		final ConceptMovementPredicate conceptMovementPredicated = new ConceptMovementPredicate(CONCEPT, "OK");

		final MovementDto movementDto = new MovementDto();
		movementDto.setMovementConcept(CONCEPT);
		// Check asset Null
		assertTrue(conceptMovementPredicated.eval(movementDto));

	}

	@Test
	public void checkConceptMovementPredicatedFalse() {

		final ConceptMovementPredicate conceptMovementPredicated = new ConceptMovementPredicate(CONCEPT, "OK");

		final MovementDto movementDto = new MovementDto();
		movementDto.setMovementConcept(ANOTHER_CONCEPT);
		// Check Another
		assertFalse(conceptMovementPredicated.eval(movementDto));

		// Check Null
		assertFalse(conceptMovementPredicated.eval(null));

		// Check Concept Null
		movementDto.setMovementConcept(null);
		assertFalse(conceptMovementPredicated.eval(movementDto));

	}

}
