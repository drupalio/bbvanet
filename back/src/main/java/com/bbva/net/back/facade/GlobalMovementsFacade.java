package com.bbva.net.back.facade;

import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;

public interface GlobalMovementsFacade {

	GlobalResumeMovementsDto getGlobalMovementsByCustomer(String customerId);
	

}
