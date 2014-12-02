package com.bbva.net.back.core.pattern;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Entelgy
 *
 * @param <T> Entity 
 */
@Transactional
public abstract class AbstractBbvaDao<T extends Serializable> implements CrudDao<T> {
	
	protected static final Logger LOG = LoggerFactory.getLogger(AbstractBbvaDao.class);
		
	@Autowired
	protected SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public T getByID(Long id , Class<T> entityClass) {
		return (T) getSession().get(entityClass, id);
	}
	
	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	

}
