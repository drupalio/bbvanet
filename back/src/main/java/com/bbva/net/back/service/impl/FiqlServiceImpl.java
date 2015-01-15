package com.bbva.net.back.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.ext.search.client.SearchConditionBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.FiqlService;

@Service(value = "fiqlService")
public class FiqlServiceImpl implements FiqlService {

	private static final String DATE_FORMAT = "yyyy-MM-dd";

	private static final String FIQL_LANGUAGE = "fiql";

	@Value("${fiql.startDate}")
	private String START_DATE;

	@Value("${fiql.endDate}")
	private String END_DATE;

	@Override
	public String getFiqlQueryByDateRange(final DateRangeDto dateRange) {

		if (dateRange == null || dateRange.getDateSince() == null || dateRange.getDateTo() == null) {
			return StringUtils.EMPTY;
		}

		final SearchConditionBuilder filter = SearchConditionBuilder.instance(FIQL_LANGUAGE);
		return filter.is(END_DATE).notBefore(formatDate(dateRange.getDateSince())).and().is(START_DATE)
				.notAfter(dateRange.getDateTo()).query();

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

}
