package com.bbva.net.core.collection;

import org.apache.commons.collections.Predicate;
import org.apache.commons.logging.Log;

import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

/**
 * Predicate to avoid casting in evaluate Predicate methods
 * 
 * @author Entelgy
 * @param <T>
 */
public abstract class BbvaPredicate<T> implements Predicate {

	protected static final Log LOGGER = I18nLogFactory.getLog(BbvaPredicate.class);

	/**
	 * @param object
	 * @return
	 */
	protected abstract boolean eval(T object);

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean evaluate(Object object) {
		return eval((T)object);
	}

}
