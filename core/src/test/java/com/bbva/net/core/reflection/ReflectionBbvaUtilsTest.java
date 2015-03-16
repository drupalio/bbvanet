package com.bbva.net.core.reflection;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.math.NumberUtils;
import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class ReflectionBbvaUtilsTest {

	private static final Long DEFAULT_VALUE = NumberUtils.LONG_ONE;

	@SuppressWarnings("all")
	@Test
	public void checkinstantiateClass_OK() throws SecurityException, NoSuchMethodException {

		final CustomClass customClass = new CustomClass();
		customClass.setValue(DEFAULT_VALUE);
		Assert.assertNotNull(customClass.getValue());
		Assert.assertNotNull(ReflectionBbvaUtils.invokeMethod(customClass.getClass().getMethod("getValue", null),
				customClass, null));
	}

	@SuppressWarnings("all")
	@Test
	public void checkinstantiateClass_NotOK() {

		Assert.assertNull(ReflectionBbvaUtils.invokeMethod(CustomClass.class.getMethods()[0],
				NumberUtils.BYTE_MINUS_ONE, NumberUtils.BYTE_MINUS_ONE));

		Assert.assertNull(ReflectionBbvaUtils.invokeMethod(null, null, null));

	}

	@Test
	public void checkCoverageReflectionBbvaUtils() throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		TestUtils.utilClassCodeCoverage(ReflectionBbvaUtils.class);
	}

	/**
	 * INNER TESTING CLASSES
	 * 
	 * @author Entelgy
	 */
	private static class CustomClass {

		private Long value;

		public Long getValue() {
			return value;
		}

		public void setValue(Long value) {
			this.value = value;
		}
	}

}
