package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.MovementsDetailFacade;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.controller.MovementDetailProductController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * Implemmenta el llamado a la fachada para obtener el detalle de movimiento de un producto por su Id
 * 
 * @author Entelgy
 */

@Controller(value = "movementDetailController")
public class MovementDetailProductControllerImpl extends AbstractBbvaController implements
		MovementDetailProductController {

	private static final long serialVersionUID = 3042333175288504951L;

	private String movementId;

	@Resource(name = "movementsDetailFacade")
	private transient MovementsDetailFacade movementsDetailFacade;

	@Override
	public MovementDto getDetailMovementByAccount() {

		return this.movementsDetailFacade.getMovementDetailByMovementId(movementId);
	}

	public void setMovementsDetailFacade(MovementsDetailFacade movementsDetailFacade) {
		this.movementsDetailFacade = movementsDetailFacade;
	}

	public String getMovementId() {
		return movementId;
	}

	public void setMovementId(String movementId) {
		this.movementId = movementId;
	}

}
