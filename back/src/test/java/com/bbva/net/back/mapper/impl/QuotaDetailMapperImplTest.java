package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
		this.quotaDetailMapperImpl = new QuotaDetailMapperImpl();
		this.quotaDetailDto = new QuotaDetailDto();
		this.quotaMoveDetailDto = new MovementDetailDto();
		this.quotaMovementsDto = new ArrayList<MovementDto>();
	}

	@Test
	public void checkMapQuota() {
		this.quotaDetailDto = quotaDetailMapperImpl.mapQuota(new Loan());
		Assert.assertNotNull(quotaDetailDto);
	}

	@Test
	public void checkMapQuotaMove() {
		this.quotaMoveDetailDto = quotaDetailMapperImpl.mapQuotaMove(new RotaryQuotaMove());
		Assert.assertNotNull(quotaMoveDetailDto);
	}

	@Test
	public void listRotaryQuotaMovements() {
		this.quotaMovementsDto = quotaDetailMapperImpl.listRotaryQuotaMovements(new ArrayList<Movement>());
		Assert.assertNotNull(quotaMovementsDto);
	}
}
