package com.bbva.net.back.core.pattern.dto;

import java.io.Serializable;

/**
 * @author Entelgy
 */
public interface Dto extends Serializable {

	/**
	 * @param obj
	 * @return
	 */
	@Override
	boolean equals(Object obj);

	/**
	 * @return
	 */
	@Override
	int hashCode();

	/**
	 * @return
	 */
	@Override
	String toString();
}
