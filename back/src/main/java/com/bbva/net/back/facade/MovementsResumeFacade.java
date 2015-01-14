package com.bbva.net.back.facade;

import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;

public interface MovementsResumeFacade {

	GlobalResumeMovementsDto getMovementsResumeByeCustomer(String customerId, DateRangeDto dateRange);

}
