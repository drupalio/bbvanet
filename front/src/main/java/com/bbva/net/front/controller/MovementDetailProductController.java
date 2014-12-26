package com.bbva.net.front.controller;

import com.bbva.net.back.model.movements.MovementDTO;

/**
 * Interface que define los métodos que retornan los datos del detalle de los movimientos en los productos
 * 
 * @author Entelgy
 */
public interface MovementDetailProductController {

	/**
	 * Método que obtiene el detalle del movimiento en una cuenta
	 * 
	 * @return
	 */
	MovementDTO getDetailMovementByAccount();

	/**
	 * Método que obtiene la lista de movimientos en una cuenta
	 */
	// getMovementsByAccount();

}
