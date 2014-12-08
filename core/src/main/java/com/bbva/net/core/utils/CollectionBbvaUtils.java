package com.bbva.net.core.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author Entelgy
 */
public abstract class CollectionBbvaUtils {

	/**
	 * @param list
	 * @param expressionLenguage
	 * @return
	 * @throws NoSuchMethodException
	 */
	public static <T extends Serializable> BigDecimal calculateTotal(List<T> list, final String expressionLenguage)
			throws NoSuchMethodException {

		double totalValue = 0d;

		for (Iterator<T> iterator = list.iterator(); iterator.hasNext();) {
			T object = iterator.next();
			totalValue = totalValue + getValueByEL(object, expressionLenguage);
		}

		return BigDecimal.valueOf(totalValue);
	}

	/**
	 * @param object
	 * @param expressionLenguage
	 * @return
	 * @throws NoSuchMethodException
	 */
	public static double getValueByEL(final Serializable object, final String expressionLenguage)
			throws NoSuchMethodException {

		try {
			return ((Number)PropertyUtils.getProperty(object, expressionLenguage)).doubleValue();
		} catch (final Exception exception) {
			throw new NoSuchMethodException(exception.getMessage());
		}

	}

}
