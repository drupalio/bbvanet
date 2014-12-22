package com.bbva.net.front.controller.impl;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.model.movements.MovementDTO;
import com.bbva.net.front.controller.MovementDetailProductController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "movementDetailController")
public class MovementDetailProductControllerImpl extends AbstractBbvaController implements
		MovementDetailProductController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3042333175288504951L;

	@Override
	public MovementDTO getDetailMovementByAccount() {

		return null;
	}

}
