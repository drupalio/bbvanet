package com.bbva.net.core.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.eclipse.core.internal.runtime.Product;
import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class BeanBbvaUtilsTest {

	@Test
	public void checkinstantiateClass_OK() {

		Assert.assertNotNull(BeanBbvaUtils.instantiateClass(String.class));

		Assert.assertNotNull(BeanBbvaUtils.instantiateClass(Long.class));

		Assert.assertNotNull(BeanBbvaUtils.instantiateClass(Date.class));
	}

	@Test
	public void checkinstantiateClass_NotOK() {

		Assert.assertNull(BeanBbvaUtils.instantiateClass(null));

		Assert.assertNull(BeanBbvaUtils.instantiateClass(Product.class));

	}

	@Test
	public void checkCoverageBeanBbvaUtils() throws SecurityException, IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException, InvocationTargetException {
		TestUtils.utilClassCodeCoverage(BeanBbvaUtils.class);
	}

}
