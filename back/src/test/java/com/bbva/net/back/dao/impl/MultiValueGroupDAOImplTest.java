package com.bbva.net.back.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author User
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-dao-context.xml")
public class MultiValueGroupDAOImplTest {
	@Autowired
	private MultiValueGroupDAOImpl multiValueGroupDAOImpl;

	@Before
	public void init() {
		this.multiValueGroupDAOImpl = new MultiValueGroupDAOImpl();
	}

	@Test
	public void getTypes() throws Exception {

		/**
		 * Invoke test method
		 */
		Assert.assertNotNull(this.multiValueGroupDAOImpl.getTypes(Mockito
				.anyInt()));

	}

	/**
	 * @return the multiValueGroupDAOImpl
	 */
	public MultiValueGroupDAOImpl getMultiValueGroupDAOImpl() {
		return multiValueGroupDAOImpl;
	}

	/**
	 * @param multiValueGroupDAOImpl
	 *            the multiValueGroupDAOImpl to set
	 */
	public void setMultiValueGroupDAOImpl(
			MultiValueGroupDAOImpl multiValueGroupDAOImpl) {
		this.multiValueGroupDAOImpl = multiValueGroupDAOImpl;
	}

}
