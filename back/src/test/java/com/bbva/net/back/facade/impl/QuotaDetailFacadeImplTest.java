package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.back.mapper.QuotaDetailMapper;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.loan.LoanService;

public class QuotaDetailFacadeImplTest {

	private static final String DEFAULT_ID = "00130443000200009410";

	private QuotaDetailFacadeImpl quotaDetailFacede;

	// CLIENTE REST
	@Resource(name = "loanService")
	private LoanService loanService;

	@Resource(name = "quotaDetailMapper")
	private QuotaDetailMapper mapper;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	private QuotaDetailDto quotaDetailDto;

	private MovementDetailDto quotaMoveDetailDto;

	@Before
	public void init() {
		this.quotaDetailFacede = new QuotaDetailFacadeImpl();
		this.loanService = Mockito.mock(LoanService.class);
		this.mapper = Mockito.mock(QuotaDetailMapper.class);
		this.fiqlService = Mockito.mock(FiqlService.class);
		this.quotaDetailFacede.setLoanService(loanService);
		this.quotaDetailFacede.setMapper(mapper);
		this.quotaDetailFacede.setFiqlService(fiqlService);
		this.quotaDetailFacede.setTransaccionDate("transaccionDate");
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
		quotaMoveDetailDto = Mockito.mock(MovementDetailDto.class);

		Mockito.when(loanService.getRotaryQuotaMovement(DEFAULT_ID, "544356")).thenReturn(rotaryQuotaMove);
		Mockito.when(mapper.mapQuotaMove(rotaryQuotaMove)).thenReturn(quotaMoveDetailDto);
		quotaMoveDetailDto = quotaDetailFacede.getRotaryQuotaMovement(DEFAULT_ID, "544356");
		Assert.assertNotNull(quotaMoveDetailDto);
		Mockito.verify(this.loanService, Mockito.atLeastOnce()).getRotaryQuotaMovement(DEFAULT_ID, "544356");
	}

	@Test
	public void checkGetListRotaryQuotaMovements() {
		DateRangeDto date = new DateRangeDto();
		date.setDateSince(new Date());
		date.setDateTo(new Date());
		String stg = null;
		List<Movement> listMovement = new ArrayList<Movement>();
		List<MovementDto> listMovementDto = new ArrayList<MovementDto>();
		Mockito.when(loanService.listRotaryQuotaMovements(DEFAULT_ID, 1, 10, stg)).thenReturn(listMovement);
		Mockito.when(mapper.listRotaryQuotaMovements(listMovement)).thenReturn(listMovementDto);
		listMovementDto = quotaDetailFacede.listRotaryQuotaMovements(DEFAULT_ID, date, 1, 10);
		Assert.assertNotNull(listMovementDto);
		Mockito.verify(this.loanService, Mockito.atLeastOnce()).listRotaryQuotaMovements(DEFAULT_ID, 1, 10, null);
	}
}
