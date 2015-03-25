package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;

public class QuotaDetailMapperImplTest {

	private QuotaDetailMapperImpl quotaDetailMapperImpl;

	private QuotaDetailDto quotaDetailDto;

	private MovementDetailDto quotaMoveDetailDto;

	private List<MovementDto> quotaMovementsDto;

	@Before
	public void init() {
		// inicializar mapper
		this.quotaDetailMapperImpl = new QuotaDetailMapperImpl();
		// Mockitos
		this.quotaDetailDto = Mockito.mock(QuotaDetailDto.class);
		this.quotaMoveDetailDto = Mockito.mock(MovementDetailDto.class);
		this.quotaMovementsDto = new ArrayList<MovementDto>();
	}

	@Test
	public void checkMapQuota() {
		// Llamar al método mapQuota
		this.quotaDetailDto = quotaDetailMapperImpl.mapQuota(new Loan());
		// Verificar que no venga nulo
		Assert.assertNotNull(quotaDetailDto);
	}

	@Test
	public void checkMapQuotaMove() {
		// Llamar al método mapQuotaMove
		this.quotaMoveDetailDto = quotaDetailMapperImpl.mapQuotaMove(new RotaryQuotaMove());
		// Verificar que no venga nulo
		Assert.assertNotNull(quotaMoveDetailDto);
	}

	@Test
	public void listRotaryQuotaMovements() {
		// Llamar al método listRotaryQuotaMovements
		this.quotaMovementsDto = quotaDetailMapperImpl.listRotaryQuotaMovements(new ArrayList<Movement>());
		// Verificar que no venga nulo
		Assert.assertNotNull(quotaMovementsDto);
	}
}
