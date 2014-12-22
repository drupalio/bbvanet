package com.bbva.net.back.facade;

import com.bbva.net.back.model.movements.MovementDTO;

public interface MovementsDetailFacade {

	// List<Movimientos> getMovementsByProduct(int product);

	/**
	 * Obtiene el detalle de un movimiento por el id de movimiento
	 * 
	 * @param numMovement
	 * @return
	 */
	MovementDTO getMovementDetailByMovementId(String numMovement);

}
