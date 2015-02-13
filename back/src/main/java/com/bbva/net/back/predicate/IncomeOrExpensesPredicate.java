/**
 * 
 */
package com.bbva.net.back.predicate;

import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.core.collection.BbvaPredicate;


/**
 * @author User
 *
 */
public class IncomeOrExpensesPredicate extends BbvaPredicate<MovementDto> {
	
	private String concept;
	
	public IncomeOrExpensesPredicate(String concept){
		this.concept = concept;
	}

	@Override
	protected boolean eval(MovementDto movementDto) {		
		return false;
	}

}
