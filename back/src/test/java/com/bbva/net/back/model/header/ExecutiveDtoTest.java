package com.bbva.net.back.model.header;

import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class ExecutiveDtoTest extends AbstractBbvaDTOTest<ExecutiveDto> {

	@Override
	protected ExecutiveDto getInstance() {
		return new ExecutiveDto();
	}

	@Override
	@Test
	public void checkEqualsMethod() {
	}

}
