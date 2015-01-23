package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Loan;
import com.bbva.net.back.mapper.QuotaDetailMapper;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.webservices.loan.LoanService;

public class QuotaDetailFacadeImplTest {

	private final String DEFAULT_ID = "9500-01-40-2606-9499";
	private QuotaDetailFacadeImpl quotaDetailFacede;

	// CLIENTE REST
	@Resource(name = "loanService")
	private LoanService loanService;

	@Resource(name = "quotaDetailMapper")
	private QuotaDetailMapper mapper;

	private QuotaDetailDto quotaDetailDto;

	@Before
	public void init() {
		this.quotaDetailFacede = new QuotaDetailFacadeImpl();
		this.loanService = Mockito.mock(LoanService.class);
		this.mapper = Mockito.mock(QuotaDetailMapper.class);
		this.quotaDetailFacede.setLoanService(loanService);
		this.quotaDetailFacede.setMapper(mapper);
	}

	@Test
	public void checkGetDetailRotaryQuota() {
		Loan loan = new Loan();
		quotaDetailDto = Mockito.mock(QuotaDetailDto.class);
		// preparando el test
		Mockito.when(loanService.getRotaryQuota(DEFAULT_ID)).thenReturn(loan);
		Mockito.when(mapper.map(loan)).thenReturn(quotaDetailDto);

		quotaDetailDto = quotaDetailFacede.getDetailRotaryQuota(DEFAULT_ID);
		Assert.assertNotNull(quotaDetailDto);

		Mockito.verify(this.loanService, Mockito.atLeastOnce()).getRotaryQuota(
				DEFAULT_ID);
	}
}
