package com.bbva.net.back.model.accounts;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class InvolvedDtoTest extends AbstractBbvaDTOTest<InvolvedDto> {

	private InvolvedDto involved;

	public InvolvedDtoTest() {
		this.involved = new InvolvedDto("aaa");
	}

	@Override
	protected InvolvedDto getInstance() {
		return new InvolvedDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		// Inicializar entrada
		InvolvedDto holdInEquals = new InvolvedDto("aaa");
		// Cuando el objeto es nulo
		this.involved.equals(null);
		// Cuando el dto comparado no es el mismo
		this.involved.equals(new MovementCriteriaDto());
		// Caso exitoso
		this.involved.equals(holdInEquals);
		// el Alias del objeto es diferente
		holdInEquals.setAlias("Hour");
		this.involved.equals(holdInEquals);
	}
}