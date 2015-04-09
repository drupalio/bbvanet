package com.bbva.net.core.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class TestUtilsTest {

	@Test
	public void checkEnumCoverage_OK() {

		TestUtils.enumCodeCoverage(CustomEnum.class);

	}

	@Test(expected = RuntimeException.class)
	public void checkEnumCoverage_NOT_OK() {
		TestUtils.enumCodeCoverage(CustomEnumError.class);
	}

	@Test
	public void checkUtilClassCoverage() throws SecurityException, IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException, InvocationTargetException {

		TestUtils.utilClassCodeCoverage(TestUtils.class);
		TestUtils.utilClassCodeCoverage(CustomUtilClass.class);

	}

	/**
	 * 
	 *
	 */
	private static enum CustomEnum {

		DEFAULT;
	}

	private static enum CustomEnumError {

		DEFAULT;

		@Override
		public String toString() {
			throw new RuntimeException();
		}

	}

	/**
	 * 
	 */
	private static final class CustomUtilClass {

		private CustomUtilClass() {
		}
	}

}
