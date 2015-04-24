package com.bbva.net.back.model.movements;

import java.util.Date;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class MovementDtoTest extends AbstractBbvaDTOTest<MovementDto> {

	private MovementDto movementDto;

	public MovementDtoTest() {
		this.movementDto = new MovementDto("1234567", new Date(), new Date(), "concept", new Money(), new Money(),
				"desac", "1", "000000000", new MovementDetailDto());
	}

	@Override
	protected MovementDto getInstance() {
		return new MovementDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		// Inicializar entrada
		MovementDto moveInEquals = new MovementDto();
		// Cuando el objeto es nulo
		this.movementDto.equals(null);
		// Cuando el dto comparado no es el mismo
		this.movementDto.equals(new MovementCriteriaDto());
		// Caso exitoso
		moveInEquals.setMovementId("1234567");
		this.movementDto.equals(moveInEquals);
		// el id del objeto es diferente
		moveInEquals.setMovementId("10172689182791776543");
		this.movementDto.equals(moveInEquals);
		// Cuando el id del objeto entrante es nulo
		moveInEquals.setMovementId(null);
		this.movementDto.equals(moveInEquals);
		// Cuando el id global es nulo
		this.movementDto.setMovementId(null);
		this.movementDto.equals(moveInEquals);
	}

}
