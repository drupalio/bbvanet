package com.bbva.net.core.test;

/**
 * @author Entelgy
 */
public abstract class TestUtils {

	/**
	 * @param enumClass
	 */
	public static void superficialEnumCodeCoverage(Class<? extends Enum<?>> enumClass) {

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
	 */
	public static void superficialAbstractCodeCoverage(Class<?> abstractClass) {

		try {
			abstractClass.newInstance();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
