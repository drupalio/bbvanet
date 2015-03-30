package com.bbva.net.back.model.globalposition;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class GlobalProductsDtoTest extends AbstractBbvaDTOTest<GlobalProductsDto> {

	GlobalProductsDto globalProductsDto;

	@Override
	protected GlobalProductsDto getInstance() {
		globalProductsDto = new GlobalProductsDto();
		return globalProductsDto;
	}

	@Test
	public void checkUnSetMethods() {

		globalProductsDto.unsetAccounts();
		globalProductsDto.unsetCreditCards();
		globalProductsDto.unsetElectronicDeposits();
		globalProductsDto.unsetFunds();
		globalProductsDto.unsetLeasings();
		globalProductsDto.unsetRotatingAccounts();
	}

	@Test
	public void check() {
		Assert.assertNotNull(globalProductsDto.isSetAccounts());
		Assert.assertNotNull(globalProductsDto.isSetCreditCards());
		Assert.assertNotNull(globalProductsDto.isSetElectronicDeposits());
		Assert.assertNotNull(globalProductsDto.isSetFunds());
		Assert.assertNotNull(globalProductsDto.isSetLeasings());
		Assert.assertNotNull(globalProductsDto.isSetRotatingAccounts());

	}
}