package com.bbva.net.back.model.extracts;

import org.junit.Test;

import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class ExtractDtoTest extends AbstractBbvaDTOTest<ExtractDto> {

	@Override
	protected ExtractDto getInstance() {
		return new ExtractDto();
	}

	@Override
	@Test
	public void checkEqualsMethod() {
	}

}
