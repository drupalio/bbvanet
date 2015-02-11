package com.bbva.net.back.mapper.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.CustomConverter;

public class StringToDateConverter extends CustomConverter<String, Date> {

	private final String pattern;

	private final ThreadLocal<SimpleDateFormat> dateFormats = new ThreadLocal<SimpleDateFormat>();

	private SimpleDateFormat getDateFormat() {
		SimpleDateFormat formatter = dateFormats.get();
		if (formatter == null) {
			formatter = new SimpleDateFormat(this.pattern);
			dateFormats.set(formatter);
		}
		return formatter;
	}

	public StringToDateConverter(final String format) {
		this.pattern = format;
	}

	@Override
	public Date convert(String source, Type<? extends Date> destinationType) {
		try {
			return getDateFormat().parse(source);
		} catch (ParseException e) {
			return null;
		}
	}
}
