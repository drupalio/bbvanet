package com.bbva.net.back.core.pattern.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.entity.MultiValueGroup;

@Ignore
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractBbvaDaoTest {

	@Autowired
	private CustomDao customDao;

	private SessionFactory sessionFactory;

	@Before
	public void setUp() {

		Assert.assertNotNull(customDao);
		Assert.assertNotNull(customDao.getSession());
		this.sessionFactory = customDao.getSession().getSessionFactory();
	}

	@Test
	public void checkCustomDAO_OK() {

		Assert.assertNotNull(customDao.getByID(1L, MultiValueGroup.class));

	}

	@Test
	public void checkCustomDAO_SessionFactoryNull() {

		customDao.setSessionFactory(this.sessionFactory);
		Assert.assertNotNull(customDao.getByID(1L, MultiValueGroup.class));

	}

	/**
	 * @author Entelgy
	 */
	@Repository(value = "customDao")
	private static class CustomDaoImpl extends AbstractBbvaDao<MultiValueGroup> implements CustomDao {

	}

	private static interface CustomDao {

		MultiValueGroup getByID(Long id, Class<MultiValueGroup> entityClass);

		void setSessionFactory(SessionFactory sessionFactory);

		Session getSession();

	}

}
