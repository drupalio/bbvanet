package com.bbva.net.back.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author User
 *
 */
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("/spring-test-dao-context.xml")
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
		// Assert.assertNotNull(this.multiValueGroupDAOImpl.getTypes(Mockito
		// .anyInt()));

	}

}
