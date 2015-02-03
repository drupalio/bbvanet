package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.accounts.AccountsMonthBalanceDto;
import com.bbva.net.back.model.commons.DateRangeDto;

public interface AccountMonthBalanceFacade {

	public List<AccountsMonthBalanceDto> getAccountMonthlyBalance(String accountId, DateRangeDto dateRange,
			String fields, String expands, String sort);

}
