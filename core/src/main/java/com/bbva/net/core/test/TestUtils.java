package com.bbva.net.core.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.apache.commons.logging.Log;
import org.junit.Assert;

import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

/**
 * @author Entelgy
 */
public final class TestUtils {

	private TestUtils() {
	}

	protected static final Log LOGGER = I18nLogFactory.getLog(TestUtils.class);

	/**
	 * @param enumClass
	 */
	public static void enumCodeCoverage(Class<? extends Enum<?>> enumClass) {

		try {
			for (Object o : (Object[])enumClass.getMethod("values").invoke(null)) {
				enumClass.getMethod("valueOf", String.class).invoke(null, o.toString());
			}
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param enumClass
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 */
	public static void utilClassCodeCoverage(Class<?> abstractClass) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {

		Constructor<?> constructor = abstractClass.getDeclaredConstructor();
		Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
		constructor.setAccessible(true);
		constructor.newInstance();

	}
}
