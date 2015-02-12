package com.bbva.net.core.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;

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

		if (!CollectionUtils.isEmpty(list)) {
			for (Iterator<T> iterator = list.iterator(); iterator.hasNext();) {
				T object = iterator.next();
				totalValue = totalValue + getValueByEL(object, expressionLenguage);
			}
		}

		return BigDecimal.valueOf(totalValue);
	}

	/**
	 * @param list
	 * @param expressionLenguage
	 * @return
	 */
	public static <T extends Serializable> List<String> nameProduct(List<T> list, final String expressionLenguage) {

		List<String> names = new ArrayList<String>();
		for (Iterator<T> iterator = list.iterator(); iterator.hasNext();) {
			T object = iterator.next();
			names.add(getNameByEL(object, expressionLenguage));
		}

		return names;
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

	/**
	 * @param object
	 * @param expressionLenguage
	 * @return
	 */
	public static String getNameByEL(final Serializable object, final String expressionLenguage) {

		try {
			return (String)PropertyUtils.getProperty(object, expressionLenguage);
		} catch (final Exception exception) {
			return "";
		}
	}
}
