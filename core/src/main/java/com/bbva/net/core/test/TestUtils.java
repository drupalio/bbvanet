package com.bbva.net.core.test;

public final class TestUtils {

	public static void superficialEnumCodeCoverage(Class<? extends Enum<?>> enumClass) {

		try {
			for (Object o : (Object[])enumClass.getMethod("values").invoke(null)) {
				enumClass.getMethod("valueOf", String.class).invoke(null, o.toString());
			}
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
