package com.bbva.net.back.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.ext.search.client.SearchConditionBuilder;
import org.springframework.stereotype.Service;

import com.bbva.net.back.model.comboFilter.EnumMonthType;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.back.service.FiqlService;

@Service(value = "fiqlService")
public class FiqlServiceImpl implements FiqlService {

	private static final String DATE_FORMAT = "yyyy-MM-dd";

	private static final String MONTH_FORMAT = "MM";

	private static final String FIQL_LANGUAGE = "fiql";

	@Override
	public String getFiqlQueryByDateRange(final DateRangeDto dateRange, final String startProperty,
			final String endProperty) {

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
		// Aki cambiar solo a mes hacia atras
		return filter.is(monthProperty).lexicalNotBefore(formatOldMont(dateRange.getDateSince())).query();
	}

	@Override
	public String getFiqlQueryByCustomerIdAndProductType(final String productType, final String startProperty) {
		if (productType == null) {
			return StringUtils.EMPTY;
		}
		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);

		return filter.is(startProperty).equalTo(productType).query();
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
	public String getExecutiveFiql() {
		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);
		return filter.is("type").equalTo("CUSTOMER").query();
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

	private String formatOldMont(final Date date) {

		final Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(new Date());
		final Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(date);

		final int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		final int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		final int strD = Math.abs(diffMonth);
		final String oldDate = strD < 10 ? "0" + String.valueOf(strD) : String.valueOf(strD);
		return oldDate;
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

	@Override
	public String getFiqlQueryCustomer(String userName, String docTypeUser, String docIdUser) {
		if (userName == null || docTypeUser == null || docIdUser == null) {
			return StringUtils.EMPTY;
		}
		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);
		return filter.is("document").equalTo(docIdUser).and().is("username").equalTo(userName).and("documentType")
				.equalTo(docTypeUser).query();
	}

	/**
	 * Fiql Query que construye el filtro para consultar la URL de descarga para un extracto
	 */
	@Override
	public String getFiqlQueryByExtract(ExtractDto extract) {
		if (extract == null) {
			return StringUtils.EMPTY;
		}

		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);

		return filter.is("extractId").equalTo(extract.getExternalCode()).and().is("month")
				.equalTo(EnumMonthType.valueOfLabel(extract.getMonth()).getMonthNum()).and().is("year")
				.equalTo(extract.getYear()).query();
	}
}
