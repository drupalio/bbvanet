package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.back.mapper.QuotaDetailMapper;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.back.model.quota.QuotaMoveDetailDto;
import com.bbva.net.webservices.loan.LoanService;

public class QuotaDetailFacadeImplTest {

	private static final String DEFAULT_ID = "9500014026069499";

	private QuotaDetailFacadeImpl quotaDetailFacede;

	// CLIENTE REST
	@Resource(name = "loanService")
	private LoanService loanService;

	@Resource(name = "quotaDetailMapper")
	private QuotaDetailMapper mapper;

	private QuotaDetailDto quotaDetailDto;

	private QuotaMoveDetailDto quotaMoveDetailDto;

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
		Mockito.when(loanService.getRotaryQuota(DEFAULT_ID)).thenReturn(loan);
		Mockito.when(mapper.mapQuota(loan)).thenReturn(quotaDetailDto);
		quotaDetailDto = quotaDetailFacede.getDetailRotaryQuota(DEFAULT_ID);
		Assert.assertNotNull(quotaDetailDto);
		Mockito.verify(this.loanService, Mockito.atLeastOnce()).getRotaryQuota(DEFAULT_ID);

	}

	@Test
	public void checkGetDetailMovemenRotaryQuota() {
		RotaryQuotaMove rotaryQuotaMove = new RotaryQuotaMove();

		quotaMoveDetailDto = Mockito.mock(QuotaMoveDetailDto.class);
		Mockito.when(loanService.getRotaryQuotaMovement(DEFAULT_ID, "544356")).thenReturn(rotaryQuotaMove);
		Mockito.when(mapper.mapQuotaMove(rotaryQuotaMove)).thenReturn(quotaMoveDetailDto);
		quotaMoveDetailDto = quotaDetailFacede.getRotaryQuotaMovement(DEFAULT_ID, "544356");
		Assert.assertNotNull(quotaMoveDetailDto);
		Mockito.verify(this.loanService, Mockito.atLeastOnce()).getRotaryQuotaMovement(DEFAULT_ID, "544356");
	}
}
