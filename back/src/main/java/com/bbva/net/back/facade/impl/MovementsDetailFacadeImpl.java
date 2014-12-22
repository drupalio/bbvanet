package com.bbva.net.back.facade.impl;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.MovementsDetailFacade;
import com.bbva.net.back.model.movements.MovementDTO;

@Facade
public class MovementsDetailFacadeImpl extends AbstractBbvaFacade implements MovementsDetailFacade {

	private static final long serialVersionUID = 9136300938311662362L;

	@Override
	public MovementDTO getMovementDetailByMovementId(String numMovement) {

		return null;
	}

}
