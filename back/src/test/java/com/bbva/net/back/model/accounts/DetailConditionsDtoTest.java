package com.bbva.net.back.model.accounts;

import java.util.Date;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class DetailConditionsDtoTest extends AbstractBbvaDTOTest<DetailConditionsDto> {

	private DetailConditionsDto detailCondition;

	public DetailConditionsDtoTest() {
		this.detailCondition = new DetailConditionsDto("A", "hold", new Date(), "xx");
	}

	@Override
	protected DetailConditionsDto getInstance() {
		return new DetailConditionsDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		// Inicializar entrada
		DetailConditionsDto detailInEquals = new DetailConditionsDto("A", "hold", new Date(), "xx");
		// Cuando el objeto es nulo
		this.detailCondition.equals(null);
		// Cuando el dto comparado no es el mismo
		this.detailCondition.equals(new MovementCriteriaDto());
		// Caso exitoso
		this.detailCondition.equals(detailInEquals);
		// el Comisiones del objeto es diferente
		detailInEquals.setComisiones("ss");
		this.detailCondition.equals(detailInEquals);
		// el Comisiones del objeto es diferente
		detailInEquals.setFechaApertura(new Date(114543));
		this.detailCondition.equals(detailInEquals);
		// el Comisiones del objeto es diferente
		detailInEquals.setDescripcion("holer");
		this.detailCondition.equals(detailInEquals);
		// el Comisiones del objeto es diferente
		detailInEquals.setCategoria("B");
		this.detailCondition.equals(detailInEquals);
	}
}
