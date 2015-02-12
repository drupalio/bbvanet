package com.bbva.net.back.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.ext.search.client.SearchConditionBuilder;
import org.springframework.stereotype.Service;

import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.FiqlService;

@Service(value = "fiqlService")
public class FiqlServiceImpl implements FiqlService {

	private static final String DATE_FORMAT = "yyyy-MM-dd";

	private static final String MONTH_FORMAT = "MM";

	private static final String FIQL_LANGUAGE = "fiql";

	@Override
	public String getFiqlQueryByDateRange(final DateRangeDto dateRange, final String startProperty,
			final String endProperty)  {

		if (dateRange == null || dateRange.getDateSince() == null || dateRange.getDateTo() == null) {
			return StringUtils.EMPTY;
		}

		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);
		return filter.is(startProperty).notBefore(formatDate(dateRange.getDateSince())).and().is(endProperty)
				.notAfter(dateRange.getDateTo()).query();

	}

	/**
	 * Este método que formatea la fecha a una cadena de mes, solo aplica para el servicio SrvAccounts01 -
	 * getAccMovementResume
	 */
	@Override
	public String formatMonthByAccMovementResume(final DateRangeDto dateRange, String monthProperty) {

		if (dateRange == null || dateRange.getDateSince() == null || dateRange.getDateTo() == null) {
			return StringUtils.EMPTY;
		}

		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);

		return filter.is(monthProperty).lexicalNotBefore(formatMonth(dateRange.getDateTo())).query();
	}

	@Override
	public String getFiqlQueryByCustomerIdAndProductType(final String customerId, final String productType,
			final String startProperty, final String endProperty) {
		if (productType == null || customerId == null) {
			return StringUtils.EMPTY;
		}
		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);

		return filter.is(startProperty).equalTo(customerId).and().is(endProperty).equalTo(productType).query();
	}

	@Override
	public String getFiqlQueryByBalanceRange(final BalanceRangeDto balanceRange, String startProperty,
			String endProperty) {

		if (balanceRange == null || balanceRange.getBalanceSince() == null || balanceRange.getBalanceTo() == null) {
			return StringUtils.EMPTY;
		}
		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);
		return filter.is(startProperty).greaterOrEqualTo(balanceRange.getBalanceSince().intValueExact()).and()
				.is(endProperty).lessOrEqualTo(balanceRange.getBalanceTo().intValueExact()).query();

	}

	@Override
	public String getFiqlQueryByStatus(final String status, String statusProperty) {

		if (status == null) {
			return StringUtils.EMPTY;
		}

		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);
		return filter.is(statusProperty).equalTo(status).query();

	}

	@Override
	public String getFiqlEqual(String parameter, String value) {
		if (parameter == null || value == null) {
			return StringUtils.EMPTY;
		}
		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);
		return filter.is(parameter).equalTo(value).query();
	}

	@Override
	public String getCustomerFiql(String user) {
		if (StringUtils.isEmpty(user)) {
			return StringUtils.EMPTY;
		}
		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);
		return filter.is("id").equalTo(user).and().is("type").equalTo("CUSTOMER").query();
	}

	/**
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	private Date formatDate(final Date date) {

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		// dateis the java.util.Date in yyyy-mm-dd format
		// Converting it into String using formatter
		final String strDate = simpleDateFormat.format(date);

		try {
			return simpleDateFormat.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
	}

	private String formatMonth(final Date date) {

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(MONTH_FORMAT);
		final String strDate = simpleDateFormat.format(date);

		return strDate;
	}

	@Override
	public String getFiqlQueryMonthlyByDateRange(DateRangeDto dateRange, String startProperty, String endProperty) {

		if (dateRange == null || dateRange.getDateSince() == null || dateRange.getDateTo() == null) {
			return StringUtils.EMPTY;
		}

		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);
		return filter.is(startProperty).lexicalNotBefore(formatMonth(dateRange.getDateSince())).and().is(endProperty)
				.lexicalNotAfter(formatMonth(dateRange.getDateTo())).query();

	}
}
