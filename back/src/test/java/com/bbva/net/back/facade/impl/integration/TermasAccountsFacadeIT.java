package com.bbva.net.back.facade.impl.integration;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ServiceUnavailableException;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.facade.TermasAccountsFacade;

@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TermasAccountsFacadeIT {

	@Resource(name = "TermsFacade")
	private TermasAccountsFacade condiciones;

	@Test
	public void checkGetConditionsByAccountOK() {
		Assert.assertNotNull(this.condiciones.getAllConditions("00130073000100000135"));
	}

	@Test(expected = ServiceUnavailableException.class)
	public void checkGetEmptyConditions() throws Exception {
		try {
			this.condiciones.getAllConditions(StringUtils.EMPTY);
		} catch (final ServiceUnavailableException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 503 Service Unavailable");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetENotConditions() throws Exception {
		try {
			this.condiciones.getAllConditions(null);
		} catch (final BadRequestException badRequestException) {
			Assert.assertEquals(badRequestException.getMessage(), "HTTP 400 Bad Request");
			throw badRequestException;
		}
	}

}
