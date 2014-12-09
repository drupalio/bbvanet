package com.bbva.net.core.reflection;

import java.lang.reflect.InvocationTargetException;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.BeanUtils;

public abstract class BeanBbvaUtils {

	/**
	 * @param clazz
	 * @return
	 */
	public static <T> T instantiateClass(Class<T> clazz) {
		try {
			return instantiate(clazz);
		} catch (final Exception exception) {
		}
		return null;
	}

	/**
	 * @param clazz
	 * @return
	 * @throws BeanInstantiationException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 */
	private static <T> T instantiate(Class<T> clazz) throws BeanInstantiationException, IllegalArgumentException,
			SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {

		final DataFactory dataFactory = new DataFactory();

		if (Number.class.isAssignableFrom(clazz)) {
			return clazz.getConstructor(String.class).newInstance(dataFactory.getNumber());
		}

		if (CharSequence.class.isAssignableFrom(clazz)) {
			return clazz.getConstructor(String.class).newInstance(dataFactory.getRandomWord());
		}

		return BeanUtils.instantiate(clazz);
	}

}
