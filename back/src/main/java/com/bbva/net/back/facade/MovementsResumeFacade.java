package com.bbva.net.back.facade;

import com.bbva.net.back.model.movements.GlobalResumeMovementsDTO;

public interface MovementsResumeFacade {

	GlobalResumeMovementsDTO getMovementsResumeByeCustomer(String customerId);

}
