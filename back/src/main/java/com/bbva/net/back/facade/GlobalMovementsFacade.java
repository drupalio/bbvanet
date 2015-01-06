package com.bbva.net.back.facade;

import com.bbva.net.back.model.movements.GlobalResumeMovementsDTO;

public interface GlobalMovementsFacade {

	// GlobalResumeMovementsDTO getGlobalMovementsByCustomer(String customerId);

	GlobalResumeMovementsDTO getMovementsResumeByeCustomer(String customerId);

}
