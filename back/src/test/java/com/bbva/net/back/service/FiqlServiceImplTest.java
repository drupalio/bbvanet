package com.bbva.net.back.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.back.service.impl.FiqlServiceImpl;

public class FiqlServiceImplTest {

	private FiqlServiceImpl fiqlServiceImpl;

	EnumPeriodType periodType;

	@Before
	public void init() {

		this.fiqlServiceImpl = new FiqlServiceImpl();
	}

	@Test
	public void checkFiqlNotEmpty() {
		periodType = EnumPeriodType.valueOf(Integer.parseInt("12"));
		DateRangeDto dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		final String filtro = fiqlServiceImpl.getFiqlQueryByDateRange(dateRange);
		Assert.assertNotNull(filtro);

	}

	@Test
	public void checkFiqlEmpty() {
		DateRangeDto dateRange = null;
		final String filtro = fiqlServiceImpl.getFiqlQueryByDateRange(dateRange);
		Assert.assertEquals("filtro vacia", "", filtro);
	}
}
