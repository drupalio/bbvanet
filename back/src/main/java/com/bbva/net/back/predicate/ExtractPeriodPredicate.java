package com.bbva.net.back.predicate;

import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.core.collection.BbvaPredicate;

public class ExtractPeriodPredicate extends BbvaPredicate<ExtractDto> {

	private ExtractDto yearAvailable;

	public ExtractPeriodPredicate(final ExtractDto yearAvailable) {

		this.yearAvailable = yearAvailable;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean eval(final ExtractDto extractDto) {

		return extractDto.equals(yearAvailable);
	}

}
