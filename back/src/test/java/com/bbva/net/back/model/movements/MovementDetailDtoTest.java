package com.bbva.net.back.model.movements;

import java.util.Date;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class MovementDetailDtoTest extends AbstractBbvaDTOTest<MovementDetailDto> {

	private MovementDetailDto movementDetailDto;

	public MovementDetailDtoTest() {
		this.movementDetailDto = new MovementDetailDto(new Date(), "1234", "desc", "none", "salitre", "salitre",
				"desac", new Money(), new Money(), new Money(), "12342345", new Date(), new Date(), "trasaccion",
				"none", "desac", "1", "3");
	}

	@Override
	protected MovementDetailDto getInstance() {
		return new MovementDetailDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		// Inicializar entrada
		MovementDetailDto moveInEquals = new MovementDetailDto();
		// Cuando el objeto es nulo
		this.movementDetailDto.equals(null);
		// Cuando el dto comparado no es el mismo
		this.movementDetailDto.equals(new MovementCriteriaDto());
		// Caso exitoso
		moveInEquals.setId("12342345");
		this.movementDetailDto.equals(moveInEquals);
		// el id del objeto es diferente
		moveInEquals.setId("10172689182791776543");
		this.movementDetailDto.equals(moveInEquals);
		// Cuando el id del objeto entrante es nulo
		moveInEquals.setId(null);
		this.movementDetailDto.equals(moveInEquals);
		// Cuando el id global es nulo
		this.movementDetailDto.setId(null);
		this.movementDetailDto.equals(moveInEquals);
	}
}
