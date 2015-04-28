package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	private LoanService loanService;

	private QuotaDetailMapper mapper;

	private FiqlService fiqlService;

	private QuotaDetailDto quotaDetailDto;

	private MovementDetailDto quotaMoveDetailDto;

	@Before
	public void init() {
		// inicializar controlador
		this.quotaDetailFacede = new QuotaDetailFacadeImpl();
		// Mockitos
		this.loanService = Mockito.mock(LoanService.class);
		this.mapper = Mockito.mock(QuotaDetailMapper.class);
		this.fiqlService = Mockito.mock(FiqlService.class);
		this.quotaDetailDto = Mockito.mock(QuotaDetailDto.class);
		this.quotaMoveDetailDto = Mockito.mock(MovementDetailDto.class);
		// set
		this.quotaDetailFacede.setLoanService(loanService);
		this.quotaDetailFacede.setMapper(mapper);
		this.quotaDetailFacede.setFiqlService(fiqlService);
	}

	@Test
	public void checkGetDetailRotaryQuota() {
		Loan loan = new Loan();
		// Mockear respuestas
		Mockito.when(loanService.getRotaryQuota(DEFAULT_ID)).thenReturn(loan);
		Mockito.when(mapper.mapQuota(loan)).thenReturn(quotaDetailDto);
		Mockito.when(quotaDetailFacede.getDetailRotaryQuota(DEFAULT_ID)).thenReturn(quotaDetailDto);
		// Llamar método getDetailRotaryQuota
		this.quotaDetailDto = this.quotaDetailFacede.getDetailRotaryQuota(DEFAULT_ID);
		// Verificar que no venga nulo
		Assert.assertNotNull(quotaDetailDto);
		// Verificar método getRotaryQuota
		Mockito.verify(this.loanService, Mockito.atLeastOnce()).getRotaryQuota(DEFAULT_ID);
	}

	@Test
	public void checkGetDetailMovemenRotaryQuota() {
		RotaryQuotaMove rotaryQuotaMove = new RotaryQuotaMove();
		// Mockear respuestas
		Mockito.when(loanService.getRotaryQuotaMovement(DEFAULT_ID, "544356")).thenReturn(rotaryQuotaMove);
		Mockito.when(mapper.mapQuotaMove(rotaryQuotaMove)).thenReturn(quotaMoveDetailDto);
		Mockito.when(quotaDetailFacede.getRotaryQuotaMovement(DEFAULT_ID, "544356")).thenReturn(quotaMoveDetailDto);
		// Llamar método getRotaryQuotaMovement
		this.quotaMoveDetailDto = this.quotaDetailFacede.getRotaryQuotaMovement(DEFAULT_ID, "544356");
		// Verificar que no venga nulo
		Assert.assertNotNull(quotaMoveDetailDto);
		// Verificar método getRotaryQuotaMovement
		Mockito.verify(this.loanService, Mockito.atLeastOnce()).getRotaryQuotaMovement(DEFAULT_ID, "544356");
	}

	@Test
	public void checkGetListRotaryQuotaMovements() {
		DateRangeDto date = new DateRangeDto();
		date.setDateSince(new Date());
		date.setDateTo(new Date());
		List<Movement> listMovement = new ArrayList<Movement>();
		List<MovementDto> listMovementDto = new ArrayList<MovementDto>();
		// Mockear respuestas
		Mockito.when(loanService.listRotaryQuotaMovements(DEFAULT_ID, "1", 10, null)).thenReturn(listMovement);
		Mockito.when(mapper.listRotaryQuotaMovements(listMovement)).thenReturn(listMovementDto);
		Mockito.when(quotaDetailFacede.listRotaryQuotaMovements(DEFAULT_ID, date, "1", 10)).thenReturn(listMovementDto);
		Mockito.when(quotaDetailFacede.listRotaryQuotaMovements(DEFAULT_ID, null, "1", 10)).thenReturn(listMovementDto);
		// Llamar el método listRotaryQuotaMovements
		listMovementDto = this.quotaDetailFacede.listRotaryQuotaMovements(DEFAULT_ID, date, "1", 10);
		// Verificar que no venga nulo
		Assert.assertNotNull(listMovementDto);
		// Verificar método listRotaryQuotaMovements
		Mockito.verify(this.loanService, Mockito.atLeastOnce()).listRotaryQuotaMovements(DEFAULT_ID, "1", 10, null);
	}
}
