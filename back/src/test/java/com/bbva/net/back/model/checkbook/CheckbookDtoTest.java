/**
 * 
 */
package com.bbva.net.back.model.checkbook;

import java.util.ArrayList;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

/**
 * @author User
 */
public class CheckbookDtoTest extends AbstractBbvaDTOTest<CheckbookDto> {

	private CheckbookDto checkBook;

	public CheckbookDtoTest() {
		this.checkBook = new CheckbookDto("1", "12/05/2015", "12/05/2015", "2", "1", "0", "123456789",
				new ArrayList<CheckDto>());
	}

	@Override
	protected CheckbookDto getInstance() {
		return new CheckbookDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		CheckbookDto eqCheckBook = new CheckbookDto();
		// Cuando el objeto es nulo
		this.checkBook.equals(null);
		// Cuando el dto comparado no es el mismo
		this.checkBook.equals(new MovementCriteriaDto());
		// Caso exitoso
		eqCheckBook.setId("123456789");
		this.checkBook.equals(eqCheckBook);
		// el id del objeto es diferente
		eqCheckBook.setId("10172689182791776543");
		this.checkBook.equals(eqCheckBook);
		// Cuando el id del objeto entrante es nulo
		eqCheckBook.setId(null);
		this.checkBook.equals(eqCheckBook);
		// Cuando el id global es nulo
		this.checkBook.setId(null);
		this.checkBook.equals(eqCheckBook);
	}

}
