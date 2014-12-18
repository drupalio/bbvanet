package com.bbva.net.core.reflection;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ReflectionBbvaUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionBbvaUtils.class);

	private ReflectionBbvaUtils() {
	}

	/**
	 * @param method
	 * @param dto
	 * @param args
	 */
	public static Object invokeMethod(final Method method, Object object, Object... args) {

		try {
			return method.invoke(object, args);
		} catch (final Exception exception) {
			LOGGER.info(exception.getMessage());
			return null;
		}
	}

}
