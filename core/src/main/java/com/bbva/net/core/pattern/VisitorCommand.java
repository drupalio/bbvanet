package com.bbva.net.core.pattern;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * @author Entelgy
 * @param <T>
 */
public abstract class VisitorCommand<T> {

	/**
	 * Constructor and applies this pattern
	 * 
	 * @param list
	 */
	public VisitorCommand(final List<T> list) {

		if (CollectionUtils.isEmpty(list)) {
			return;
		}

		for (final T object : list) {
			exceute(object);
		}
	}

	/**
	 * This pattern executes executes this method for each element in List<T>
	 * 
	 * @param object
	 */
	protected abstract void exceute(T object);
}
