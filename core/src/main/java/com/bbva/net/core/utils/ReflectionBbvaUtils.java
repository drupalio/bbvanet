package com.bbva.net.core.utils;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ReflectionBbvaUtils {

	protected static final Logger LOGGER = LoggerFactory.getLogger(ReflectionBbvaUtils.class);

	/**
	 * @param method
	 * @param dto
	 * @param args
	 */
	public static void invokeMethod(final Method method, Object object, Object... args) {

		try {
			method.invoke(object, args);
		} catch (final Exception exception) {
			LOGGER.info(exception.getMessage());
		}
	}

}
