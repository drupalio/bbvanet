package com.bbva.net.back.core.pattern.dao;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

/**
 * @author Entelgy
 * @param <T> Entity
 */
@Transactional
public abstract class AbstractBbvaDao<T extends Serializable> implements CrudDao<T> {

	protected static final Log LOGGER = I18nLogFactory.getLog(AbstractBbvaDao.class);

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public T getByID(Long id, Class<T> entityClass) {
		return (T)getSession().get(entityClass, id);
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
