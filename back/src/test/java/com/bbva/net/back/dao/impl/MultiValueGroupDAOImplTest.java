// package com.bbva.net.back.dao.impl;
//
// import java.util.List;
//
// import javax.annotation.Resource;
//
// import org.junit.Assert;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
// import com.bbva.net.back.dao.MultiValueGroupDAO;
// import com.bbva.net.back.entity.MultiValueGroup;
//
// /**
// * @author User
// */
//
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = { "classpath*:src/test/resources/spring-test-context.xml" })
// public class MultiValueGroupDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {
//
// @Resource(name = "multiValueGroupDao")
// private transient MultiValueGroupDAO multiValueGroupDAO;
//
// @Test
// public void getTypes() {
// /**
// * Invoke test method with data
// */
// MultiValueGroupDAOImpl a = new MultiValueGroupDAOImpl();
// Assert.assertTrue(a.getTypes(1).size() > 0);
//
// /**
// * Invoke test method without data
// */
// Assert.assertFalse(this.multiValueGroupDAO.getTypes(1000).size() > 0);
// }
//
// public void getTypesWithNull() {
//
// /**
// * Invoke test method with Null
// */
// final List<MultiValueGroup> result = this.multiValueGroupDAO.getTypes(null);
//
// /**
// * Asserts
// */
// Assert.assertNotNull(result);
// Assert.assertTrue(result.size() == 0);
//
// }
//
// }
