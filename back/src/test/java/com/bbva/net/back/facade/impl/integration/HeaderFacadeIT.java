package com.bbva.net.back.facade.impl.integration;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ServiceUnavailableException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.facade.HeaderFacade;

@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HeaderFacadeIT {

	@Resource(name = "headerFacade")
	private HeaderFacade headerfacade;

	@Test(expected = BadRequestException.class)
	public void checkGetENotUser() {
		try {
			this.headerfacade.getExecutive(null);
		} catch (final BadRequestException badRequestException) {
			Assert.assertEquals(badRequestException.getMessage(), "HTTP 400 Bad Request");
			throw badRequestException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetEUserEmpty() throws Exception {
		try {
			this.headerfacade.getExecutive("");
		} catch (final BadRequestException badRequestException) {
			Assert.assertEquals(badRequestException.getMessage(), "HTTP 400 Bad Request");
			throw badRequestException;
		}
	}

	@Test
	public void checkGetExecutiveByUserOK() {
		Assert.assertNotNull(this.headerfacade.getExecutive("123"));
	}

	@Test
	public void checkGetCustomerByUserOK() {

		Assert.assertNotNull(this.headerfacade.getCustomer("12345678"));
	}

	@Test(expected = BadRequestException.class)
	public void checkGetENotCustomer() {
		try {
			this.headerfacade.getCustomer(null);
		} catch (final BadRequestException badRequestException) {
			Assert.assertEquals(badRequestException.getMessage(), "HTTP 400 Bad Request");
			throw badRequestException;
		}
	}

	@Test(expected = ServiceUnavailableException.class)
	public void checkGetEmptyCustomer() {
		try {
			this.headerfacade.getCustomer("");
		} catch (final ServiceUnavailableException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 503 Service Unavailable");
			throw notFoundException;
		}
	}

}
