/**
 *
 */
package com.bbva.net.back.predicate;

import com.bbva.net.back.model.turnsClient.TurnsClientDetailDto;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class DivisasDetailPredicate extends BbvaPredicate<TurnsClientDetailDto> {

	private String operationId;

	public DivisasDetailPredicate(final String operationId) {
		this.operationId = operationId;
	}

	/**
	 * @param object
	 * @return
	 */
	@Override
	protected boolean eval(TurnsClientDetailDto turns) {
		return turns != null && turns.getOperationNumber() != null && turns.getOperationNumber().equals(operationId);
	}
}
