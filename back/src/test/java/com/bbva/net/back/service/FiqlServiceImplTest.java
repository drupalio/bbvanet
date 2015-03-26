package com.bbva.net.back.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.back.service.impl.FiqlServiceImpl;

public class FiqlServiceImplTest {

	private FiqlServiceImpl fiqlServiceImpl;

	EnumPeriodType periodType;

	@Value("${fiql.accountMovement.date}")
	private String DATE;

	@Value("${fiql.productMovements.productType}")
	private String PRODUCTTYPE;

	@Before
	public void init() {

		this.fiqlServiceImpl = new FiqlServiceImpl();
	}

	@Test
	public void checkFiqlNotEmpty() {
		periodType = EnumPeriodType.valueOf(Integer.parseInt("12"));
		DateRangeDto dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		final String filtro = fiqlServiceImpl.getFiqlQueryByDateRange(dateRange, "", "");
		Assert.assertNotNull(filtro);

	}

	@Test
	public void checkFiqlNotEmptyFormat() throws ParseException {

		final String filtro = fiqlServiceImpl.getFiqlQueryByDateRange(null, "", "");
		Assert.assertNotNull(filtro);
	}

	@Test
	public void checkFiqlEmpty() {
		DateRangeDto dateRange = null;
		final String filtro = fiqlServiceImpl.getFiqlQueryByDateRange(dateRange, null, null);
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
		final String result = fiqlServiceImpl.getFiqlQueryByDateRange(dateRange, null, null);
		Assert.assertEquals("null=ge=2014-01-01;null=le=2014-12-12", result);

	}

	@Test
	public void checkFormatMonthByAccMovementResume() throws ParseException {
		final String dateFrom = "2014-01-01";
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		final Date fromDate = formatter.parse(dateFrom);

		final String dateTo = "2014-12-12";
		final Date toDate = formatter.parse(dateTo);

		final DateRangeDto dateRange = new DateRangeDto(fromDate, toDate);
		// No es null
		String result = fiqlServiceImpl.formatMonthByAccMovementResume(dateRange, "mes");
		Assert.assertNotNull(result);

	}

	@Test
	public void checkFormatMonthByAccMovementResumeLess() throws ParseException {
		final String dateFrom = "2014-01-01";
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		final Date fromDate = formatter.parse(dateFrom);

		final String dateTo = "2014-02-12";
		final Date toDate = formatter.parse(dateTo);

		final DateRangeDto dateRange = new DateRangeDto(fromDate, toDate);
		String result = fiqlServiceImpl.formatMonthByAccMovementResume(dateRange, "mes");
		Assert.assertNotNull(result);

	}

	@Test
	public void checkFormatMonthByAccMovementResumeNull() {
		final String result = fiqlServiceImpl.formatMonthByAccMovementResume(null, "mes");
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetFiqlQueryMonthlyByDateRangeNull() throws ParseException {
		final String result = fiqlServiceImpl.getFiqlQueryMonthlyByDateRange(null, DATE, DATE);
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetFiqlQueryMonthlyByDateRange() throws ParseException {

		final String dateFrom = "2014-01-01";
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		final Date fromDate = formatter.parse(dateFrom);

		final String dateTo = "2014-02-12";
		final Date toDate = formatter.parse(dateTo);

		final DateRangeDto dateRange = new DateRangeDto(fromDate, toDate);
		final String result = fiqlServiceImpl.getFiqlQueryMonthlyByDateRange(dateRange, DATE, DATE);
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetFiqlQueryByBalanceRange() throws ParseException {
		BalanceRangeDto balanceRange = new BalanceRangeDto();
		balanceRange.setBalanceSince(new BigDecimal(10000));
		balanceRange.setBalanceTo(new BigDecimal(20000));
		final String result = fiqlServiceImpl.getFiqlQueryByBalanceRange(balanceRange, DATE, DATE);
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetFiqlQueryByBalanceRangeNull() throws ParseException {
		final String result = fiqlServiceImpl.getFiqlQueryByBalanceRange(null, DATE, DATE);
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetFiqlQueryByCustomerIdAndProductType() {
		final String result = fiqlServiceImpl.getFiqlQueryByCustomerIdAndProductType("TC", PRODUCTTYPE);
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetFiqlQueryByCustomerIdAndProductTypeNull() {
		final String result = fiqlServiceImpl.getFiqlQueryByCustomerIdAndProductType(null, PRODUCTTYPE);
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetFiqlQueryCustomer() {
		final String result = fiqlServiceImpl.getFiqlQueryCustomer("Nerly", "CC", "1026283049");
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetFiqlQueryCustomerEmpty() {
		final String result = fiqlServiceImpl.getFiqlQueryCustomer(null, null, null);
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetFiqlQueryByExtract() {
		ExtractDto extract = new ExtractDto("1234", "Marzo", "2014", "dates", "URL");
		final String result = fiqlServiceImpl.getFiqlQueryByExtract(extract);
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetFiqlQueryByExtractNull() {
		ExtractDto extract = null;
		final String result = fiqlServiceImpl.getFiqlQueryByExtract(extract);
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetFiqlEqual() {
		final String result = fiqlServiceImpl.getFiqlEqual("condicion1", "condicion2");
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetFiqlEqualNull() {
		final String result = fiqlServiceImpl.getFiqlEqual(null, null);
		Assert.assertNotNull(result);
	}
}
