package com.bbva.net.back.facade.impl;

import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.GlobalMovementsFacade;
import com.bbva.net.back.model.movements.GlobalResumenMovementsDTO;

@Facade(value = "globalMovementsFacade")
public class GlobalMovementsFacadeImpl implements GlobalMovementsFacade {

	@Override
	public GlobalResumenMovementsDTO getGlobalMovements() {

		// Falta la llamada a la interfaz REST - Por ahora se hardcodea el objeto de retorno

		// final List<MovementsGraphicDTO> response = this.globalPositionService.getExtractGlobalBalance(user, null, null,
		// null, null);
		// return globalPositionMapper.map(response);

		GlobalResumenMovementsDTO globalMovementsDTO = new GlobalResumenMovementsDTO();

		return globalMovementsDTO;
	}

}
