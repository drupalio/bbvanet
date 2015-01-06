package com.bbva.net.back.facade.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.MovementsDetailFacade;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDetailOperationDto;

@Facade(value = "movementsDetailFacade")
public class MovementsDetailFacadeImpl extends AbstractBbvaFacade implements MovementsDetailFacade {

	private static final long serialVersionUID = 9136300938311662362L;

	@Override
	public MovementDto getMovementDetailByMovementId(String numMovement) {

		MovementDto movement = new MovementDto();
		MovementDetailDto movementDetail = new MovementDetailDto();
		MovementDetailOperationDto movementOperation = new MovementDetailOperationDto();
		Money moneyMovement = new Money();
		Money moneyBalanceMovement = new Money();

		moneyMovement.setAmount(new BigDecimal(390));
		moneyMovement.setCurrency("$");

		moneyBalanceMovement.setAmount(new BigDecimal(1000000));
		moneyBalanceMovement.setCurrency("$");

		movementDetail.setCentralSourceMovement("0136 CHAPINERO");
		movementDetail.setState("Enviada");
		movementDetail.setPlaza("BOGOTA(CUNDIMARCA)");
		movementDetail.setObservations("xxxxx");

		movementOperation.setOperationID("056111");
		movementOperation.setOperationDate(new Date());
		movementOperation.setOperationHour(new Date());
		movementOperation.setOperationDescription("TRANSFERENCIA");

		movement.setMovementConcept("Transferencia");
		movement.setMovementDate(new Date());
		movement.setMovementID("001");
		movement.setMovementType("");
		movement.setMovementValue(moneyMovement);
		movement.setTotalBalance(moneyBalanceMovement);

		movement.setMovementDetailDTO(movementDetail);
		movement.setMovementDetailOperationDTO(movementOperation);

		return movement;
	}

}
