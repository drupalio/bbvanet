package com.bbva.net.back.facade;

import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;

public interface AccountMovementsResumeFacade {

	GlobalResumeMovementsDto getMovementsResumeByCustomer(DateRangeDto dateRange);

	GlobalResumeMovementsDto getMovementsResumeByAccount(String accountId, DateRangeDto filter, String fields,
			String expands, String sort);

}
