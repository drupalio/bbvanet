package com.bbva.net.back.model.extracts;

import org.junit.Assert;
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
		ExtractDto extract = new ExtractDto();
		extract.setExternalCode("922131073");
		extract.setGenerationDate("");
		extract.setMonth("2");
		extract.setUrl("http://www.primefaces.org/docs/guide/primefaces_user_guide_5_0.pdf");
		extract.setYear("2014");
		ExtractDto extractDto = new ExtractDto("922131073", "2", "2014", "",
				"http://www.primefaces.org/docs/guide/primefaces_user_guide_5_0.pdf");

		Assert.assertFalse(extract.equals(null));

		Assert.assertTrue(extract.equals(extractDto));
	}

}
