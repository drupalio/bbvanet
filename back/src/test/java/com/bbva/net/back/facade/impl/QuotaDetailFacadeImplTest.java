package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.mapper.QuotaDetailMapper;
import com.bbva.net.webservices.loan.LoanService;

public class QuotaDetailFacadeImplTest {

	private QuotaDetailFacadeImpl quotaDetailFacede;

	// CLIENTE REST
	@Resource(name = "loanService")
	private LoanService loanService;

	@Resource(name = "quotaDetailMapper")
	private QuotaDetailMapper mapper;

	@Before
	public void init() {
		this.quotaDetailFacede = new QuotaDetailFacadeImpl();
		this.loanService = Mockito.mock(LoanService.class);
		this.mapper = Mockito.mock(QuotaDetailMapper.class);
	}

	@Test
	public void checkGetDetailRotaryQuota() {
	}
}
