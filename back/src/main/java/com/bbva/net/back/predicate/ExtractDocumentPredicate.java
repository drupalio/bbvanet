package com.bbva.net.back.predicate;

import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.core.collection.BbvaPredicate;

public class ExtractDocumentPredicate extends BbvaPredicate<ExtractDto> {

	private String yearAvailable;

	private String monthAvailable;

	public ExtractDocumentPredicate(final String month, final String year) {
		this.yearAvailable = year;
		this.monthAvailable = month;
	}

	@Override
	protected boolean eval(final ExtractDto productExtract) {
		return productExtract != null && productExtract.getYear() != null && productExtract.getMonth() != null
				&& productExtract.getMonth().equals(monthAvailable) && productExtract.getYear().equals(yearAvailable);
	}
}
