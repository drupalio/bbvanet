package com.bbva.net.back.utils;

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class ProductUtilsTest {

	private static final String ACCOUNT_SUBTYPE = "AH";

	private static final String CUPO_SUBTYPE = "CR";

	private static final String FUND_SUBTYPE = "FA";

	private static final String PENSIONS_SUBTYPE = "FP";

	private static final String LOAN_SUBTYPE = "HI";

	private static final String CARD_SUBTYPE = "TC";

	private static final String LEASING_SYBTYPE = "LS";

	private static final String DEPOSIT_SUBTYPE = "DE";

	private static final String ADQUIRENCE_SUBTYPE = "AQ";

	@Test
	public void checkExistProductSubType() {

		Assert.assertNotNull(ProductUtils.getEnumProductTypeBySubType(ACCOUNT_SUBTYPE));

		Assert.assertNotNull(ProductUtils.getEnumProductTypeBySubType(CUPO_SUBTYPE));

		Assert.assertNotNull(ProductUtils.getEnumProductTypeBySubType(FUND_SUBTYPE));

		Assert.assertNotNull(ProductUtils.getEnumProductTypeBySubType(LOAN_SUBTYPE));

		Assert.assertNotNull(ProductUtils.getEnumProductTypeBySubType(CARD_SUBTYPE));

		Assert.assertNotNull(ProductUtils.getEnumProductTypeBySubType(LEASING_SYBTYPE));

		Assert.assertNotNull(ProductUtils.getEnumProductTypeBySubType(DEPOSIT_SUBTYPE));

		Assert.assertNotNull(ProductUtils.getEnumProductTypeBySubType(ADQUIRENCE_SUBTYPE));

	}

	@Test
	public void checkNotExistProductSubType() {

		Assert.assertNull(ProductUtils.getEnumProductTypeBySubType(PENSIONS_SUBTYPE));

		Assert.assertNull(ProductUtils.getEnumProductTypeBySubType("ZZ"));
	}

	@Test
	public void checkProductUtilsCoverage() throws SecurityException, IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException, InvocationTargetException {

		TestUtils.utilClassCodeCoverage(ProductUtils.class);
	}

}
