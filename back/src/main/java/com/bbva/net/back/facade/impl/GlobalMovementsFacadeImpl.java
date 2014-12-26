package com.bbva.net.back.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.GlobalMovementsFacade;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.movements.GlobalResumenMovementsDTO;
import com.bbva.net.back.model.movements.MovementsResumeDTO;

@Facade(value = "globalMovementsFacade")
public class GlobalMovementsFacadeImpl implements GlobalMovementsFacade {

	@Override
	public GlobalResumenMovementsDTO getGlobalMovements() {
		// Falta la llamada a la interfaz REST - Por ahora se hardcodea el objeto de retorno

		// final List<MovementsGraphicDTO> response = this.globalPositionService.getExtractGlobalBalance(user, null, null,
		// null, null);
		// return globalPositionMapper.map(response);

		GlobalResumenMovementsDTO globalMovementsDTO = new GlobalResumenMovementsDTO();

		List<MovementsResumeDTO> movementsGraphicList = new ArrayList<MovementsResumeDTO>();

		for (int i = 0; i < 10; i++) {

			MovementsResumeDTO movementsGraphicDTO = new MovementsResumeDTO();
			Money valor1 = new Money();
			valor1.setAmount(new BigDecimal(1000).multiply(new BigDecimal(50)));
			valor1.setCurrency("$");

			movementsGraphicDTO.setBalance(valor1);
			movementsGraphicDTO.setInCome(valor1);
			movementsGraphicDTO.setOutCome(valor1);
			movementsGraphicDTO.setMonth("Enero");

			movementsGraphicList.add(movementsGraphicDTO);

			globalMovementsDTO.setGlobalMovementsDTO(movementsGraphicList);
		}

		for (int i = 0; i < 10; i++) {

			MovementsResumeDTO movementsGraphicDTO = new MovementsResumeDTO();
			Money valor2 = new Money();
			valor2.setAmount(new BigDecimal(1000).multiply(new BigDecimal(50)));
			valor2.setCurrency("$");

			movementsGraphicDTO.setBalance(valor2);
			movementsGraphicDTO.setInCome(valor2);
			movementsGraphicDTO.setOutCome(valor2);
			movementsGraphicDTO.setMonth("Enero");

			movementsGraphicList.add(movementsGraphicDTO);

			globalMovementsDTO.setGlobalMovementsDTO(movementsGraphicList);
		}

		return globalMovementsDTO;
	}

}
