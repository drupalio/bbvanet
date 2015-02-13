package com.bbva.net.front.controller.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;

public class QuotaControllerImplTest {

	private static final String DEFAULT_ID = "0013044300020000949";

	private static final String DEFAULT_ID_MOV = "554654";

	private QuotaControllerImpl quotaControllerImpl;

	private QuotaDetailFacade quotaDetailFacade;

	private QuotaDetailDto quotaDetailDto;

	private MovementDetailDto quotaMoveDetailDto;

	// @Before
	// public void init() {
	// this.quotaControllerImpl = new QuotaControllerImpl();
	// this.quotaDetailFacade = Mockito.mock(QuotaDetailFacade.class);
	// this.quotaControllerImpl.setQuotaDetailFacade(quotaDetailFacade);
	// }
	//
	// @Test
	// public void checkGetRotaryQuota() {
	//
	// // prepara el test
	// Mockito.when(quotaDetailFacade.getDetailRotaryQuota(DEFAULT_ID)).thenReturn(new QuotaDetailDto());
	// quotaDetailDto = quotaDetailFacade.getDetailRotaryQuota(DEFAULT_ID);
	// Assert.assertNotNull(quotaDetailDto);
	// Mockito.verify(this.quotaDetailFacade, Mockito.atLeastOnce()).getDetailRotaryQuota(DEFAULT_ID);
	// }
	//
	// @Test
	// public void chekGetDetailMovementsQuota() {
	// Mockito.when(quotaDetailFacade.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV)).thenReturn(
	// new MovementDetailDto());
	// quotaMoveDetailDto = quotaDetailFacade.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV);
	// Assert.assertNotNull(quotaMoveDetailDto);
	// Mockito.verify(this.quotaDetailFacade, Mockito.atLeastOnce())
	// .getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV);
	// }

}
