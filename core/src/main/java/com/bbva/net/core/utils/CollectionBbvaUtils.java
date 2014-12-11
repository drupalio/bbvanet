package com.bbva.net.core.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author Entelgy
 */
public final class CollectionBbvaUtils {

	private CollectionBbvaUtils() {
	}

	/**
	 * @param list (to calculate total)
	 * @param expressionLenguage (field to invoke get Method and calculate total)
	 * @return Total of sum every element of list
	 * @throws NoSuchMethodException
	 */
	public static <T extends Serializable> BigDecimal calculateTotal(List<T> list, final String expressionLenguage) {

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
	public static double getValueByEL(final Serializable object, final String expressionLenguage) {

		try {
			return ((Number)PropertyUtils.getProperty(object, expressionLenguage)).doubleValue();
		} catch (final Exception exception) {
			return 0;
		}
	}

}
