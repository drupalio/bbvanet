package com.bbva.net.back.core.pattern;

public interface CrudDao<T> {
	
	T getByID(Long id, Class<T> entityClass);
}
