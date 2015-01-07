package com.bbva.net.back.facade;

import com.bbva.net.back.model.movements.MovementDto;

public interface MovementsDetailFacade {

	// List<Movimientos> getMovementsByProduct(int product);

	/**
	 * Obtiene el detalle de un movimiento por el id de movimiento
	 * 
	 * @param numMovement
	 * @return
	 */
	MovementDto getMovementDetailByMovementId(String numMovement);

}
