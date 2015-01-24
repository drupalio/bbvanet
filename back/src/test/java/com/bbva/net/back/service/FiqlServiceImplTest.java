package com.bbva.net.back.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	@Test
	public void checkRange() throws ParseException {

		final String dateFrom = "2014-01-01";
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		final Date fromDate = formatter.parse(dateFrom);

		final String dateTo = "2014-12-12";
		final Date toDate = formatter.parse(dateTo);

		final DateRangeDto dateRange = new DateRangeDto(fromDate, toDate);
		final String result = fiqlServiceImpl.getFiqlQueryByDateRange(dateRange);
		Assert.assertEquals("null=ge=2014-01-01;null=le=2014-12-12", result);

	}
}
