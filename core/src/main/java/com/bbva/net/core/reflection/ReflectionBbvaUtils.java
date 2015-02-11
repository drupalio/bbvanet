package com.bbva.net.core.reflection;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;

import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

public final class ReflectionBbvaUtils {

	protected static final Log LOGGER = I18nLogFactory.getLog(ReflectionBbvaUtils.class);

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
