package com.bbva.net.back.predicate;

import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.core.collection.BbvaPredicate;

public class ExtractPeriodPredicate extends BbvaPredicate<ExtractDto> {

	private String yearAvailable;

	public ExtractPeriodPredicate(final String year) {
		this.yearAvailable = year;
	}

	@Override
	protected boolean eval(final ExtractDto productExtract) {
		return productExtract.getYear().equals(yearAvailable);
	}

}
