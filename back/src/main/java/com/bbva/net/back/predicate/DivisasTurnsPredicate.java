/**
 *
 */
package com.bbva.net.back.predicate;

import com.bbva.net.back.model.turnsClient.TurnsClientDetailDto;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class DivisasTurnsPredicate extends BbvaPredicate<TurnsClientDetailDto> {

	private String typeBusiness;

	public DivisasTurnsPredicate(final String typeBusiness) {
		this.typeBusiness = typeBusiness;
	}

	/**
	 * @param object
	 * @return
	 */
	@Override
	protected boolean eval(TurnsClientDetailDto turns) {
		return turns != null && turns.getRates().getTypeBusiness() != null
				&& turns.getRates().getTypeBusiness().equals(typeBusiness);
	}
}
