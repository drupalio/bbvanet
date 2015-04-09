/**
 * 
 */
package com.bbva.net.back.model.checkbook;

import java.util.Date;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

/**
 * @author User
 */
public class CheckDtoTest extends AbstractBbvaDTOTest<CheckDto> {

	private CheckDto check;

	public CheckDtoTest() {
		this.check = new CheckDto("123456789");
		this.check = new CheckDto("12/02/2015", "1", new Money(), new Date(), "123456789");
	}

	@Override
	protected CheckDto getInstance() {
		return new CheckDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		CheckDto eqCheck = new CheckDto();
		// Cuando el objeto es nulo
		this.check.equals(null);
		// Cuando el dto comparado no es el mismo
		this.check.equals(new MovementCriteriaDto());
		// Caso exitoso
		eqCheck.setId("123456789");
		this.check.equals(eqCheck);
		// el id del objeto es diferente
		eqCheck.setId("10172689182791776543");
		this.check.equals(eqCheck);
		// Cuando el id del objeto entrante es nulo
		eqCheck.setId(null);
		this.check.equals(eqCheck);
		// Cuando el id global es nulo
		this.check.setId(null);
		this.check.equals(eqCheck);
	}

}
