package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumAccountStateTest {

	@Test
	public void checkEnumAccountState() {
		TestUtils.enumCodeCoverage(EnumAccountState.class);
	}

}
