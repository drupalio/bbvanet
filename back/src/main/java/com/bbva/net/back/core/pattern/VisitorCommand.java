package com.bbva.net.back.core.pattern;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * @author Entelgy
 *
 * @param <T>
 */
public abstract class VisitorCommand<T extends Serializable> {
	
	/**
	 * 
	 * @param list
	 */
	public VisitorCommand(final List<T> list){
		
		if (CollectionUtils.isEmpty(list)){
			return;
		}
		
		for (final T object : list) {
			exceute(object);
		}
	}
	
	protected abstract void exceute(T object);
}
