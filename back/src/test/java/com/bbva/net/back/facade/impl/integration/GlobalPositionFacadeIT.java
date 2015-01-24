package com.bbva.net.back.facade.impl.integration;

import javax.annotation.Resource;
import javax.ws.rs.ClientErrorException;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.facade.GlobalPositionFacade;

@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GlobalPositionFacadeIT {

	@Resource(name = "globalPositionFacade")
	private GlobalPositionFacade globalPositionFacade;

	@Test
	public void checkGetGlobalProductsByUserOK() {
		//
		Assert.assertNotNull(this.globalPositionFacade.getGlobalProductsByUser("123"));
	}

	@Test(expected = ClientErrorException.class)
	public void checkGetGlobalProdctsNotUser() {
		this.globalPositionFacade.getGlobalProductsByUser(null);
	}

	@Test(expected = ClientErrorException.class)
	public void checkGetGlobalProdctsEmptyUser() {
		this.globalPositionFacade.getGlobalProductsByUser(StringUtils.EMPTY);
	}

	@Test(expected = ClientErrorException.class)
	public void checkGetGlobalProdctsUserExist() {
		this.globalPositionFacade.getGlobalProductsByUser("4321432");
	}
}
