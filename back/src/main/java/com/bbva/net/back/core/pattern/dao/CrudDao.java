package com.bbva.net.back.core.pattern.dao;

/**
 * @author Entelgy
 * @param <T>
 */
public interface CrudDao<T> {

	/**
	 * Get record by Id
	 * 
	 * @param id key of Entity
	 * @param entityClass
	 * @return entity row
	 */
	T getByID(Long id, Class<T> entityClass);
}
