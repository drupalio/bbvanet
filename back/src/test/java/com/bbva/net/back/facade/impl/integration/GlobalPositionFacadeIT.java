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

import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;

@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GlobalPositionFacadeIT {

	@Resource(name = "globalPositionFacade")
	private GlobalPositionFacade globalPositionFacade;

	@Test
	public void checkGetGlobalProductsByUserOK() {

		final GlobalProductsDto globalProductsDto = this.globalPositionFacade.getGlobalProductsByUser("123");
		Assert.assertNotNull(globalProductsDto);
		Assert.assertEquals("0590025666565", globalProductsDto.getAccounts().get(0).getProductId());

	}

	@Test(expected = ServiceUnavailableException.class)
	public void checkGetGlobalProdctsEmptyUser() throws Exception {
		try {
			this.globalPositionFacade.getGlobalProductsByUser(StringUtils.EMPTY);
		} catch (final ServiceUnavailableException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 503 Service Unavailable");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetGlobalProdctsNullUser() throws Exception {
		try {
			this.globalPositionFacade.getGlobalProductsByUser(null);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}
}
