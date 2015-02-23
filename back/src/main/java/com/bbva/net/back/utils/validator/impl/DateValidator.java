package com.bbva.net.back.utils.validator.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bbva.net.back.utils.validator.EDateFormat;

/**
 * Created by Entelgy on 12/01/2015.
 */
public class DateValidator extends Validator {

	final DateFormat formatter = new SimpleDateFormat(EDateFormat.ANIO_MES_DIA.getPattern());

	public DateValidator noFuture(Date date) {
		if (date.after(new Date())) {
			// exceptions.add(new BusinessServiceException(EnumError.DATE_INTERVAL_OUT_OF_RANGE.getAlias()));
		}
		return this;
	}

	public DateValidator validDateRange(Date from, Date to) {
		if (from.after(to)) {
			// exceptions.add(new BusinessServiceException(EnumError.DATE_INTERVAL_OUT_OF_RANGE.getAlias()));
		}
		return this;
	}

	public DateValidator hasDateFormat(String strDate) {
		try {
			formatter.parse(strDate);
		} catch (ParseException e) {
			// exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		return this;
	}

	public DateValidator validDateRange(String startDate, String endDate, EDateFormat pattern) {
		try {
			DateFormat format = new SimpleDateFormat(pattern.getPattern());
			if (format.parse(startDate).after(format.parse(endDate))) {
				// exceptions.add(new BusinessServiceException(EnumError.DATE_INTERVAL_OUT_OF_RANGE.getAlias()));
			}
		} catch (ParseException e) {
			// exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		return this;
	}

	public DateValidator equals(String from, String to) {
		if (!from.equals(to)) {
			// exceptions.add(new BusinessServiceException(EnumError.DATE_INTERVAL_OUT_OF_RANGE.getAlias()));
		}
		return this;
	}

	public DateValidator noFuture(String date, EDateFormat pattern) {
		try {
			DateFormat format = new SimpleDateFormat(pattern.getPattern());
			if (format.parse(date).after(new Date())) {
				// exceptions.add(new BusinessServiceException(EnumError.DATE_INTERVAL_OUT_OF_RANGE.getAlias()));
			}
		} catch (ParseException e) {
			// exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		return this;
	}
}
