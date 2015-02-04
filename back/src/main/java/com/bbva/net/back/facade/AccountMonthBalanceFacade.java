package com.bbva.net.back.facade;

import com.bbva.net.back.model.accounts.GlobalMonthlyBalance;
import com.bbva.net.back.model.commons.DateRangeDto;

public interface AccountMonthBalanceFacade {

	GlobalMonthlyBalance getAccountMonthlyBalance(String accountId, DateRangeDto dateRange, String fields,
			String expands, String sort);

}
