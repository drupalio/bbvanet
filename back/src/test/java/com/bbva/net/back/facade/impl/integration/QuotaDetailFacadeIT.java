package com.bbva.net.back.facade.impl.integration;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ServiceUnavailableException;

import org.apache.commons.lang.StringUtils;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.quota.QuotaDetailDto;

@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class QuotaDetailFacadeIT {

	@Resource(name = "quotaDetailFacade")
	private QuotaDetailFacade quotaDetailFacade;

	// @Test
	// public void checkGetQuotaRotaryOK() throws Exception {
	// final QuotaDetailDto quotaDetailDto = this.quotaDetailFacade
	// .getDetailRotaryQuota("00130073005054466407");
	// Assert.assertNotNull(quotaDetailDto);
	// }
	//
	@Test(expected = ServiceUnavailableException.class)
	public void checkGetQuotaRotaryNotId() throws Exception {
		try {
			this.quotaDetailFacade.getDetailRotaryQuota(StringUtils.EMPTY);
		} catch (final ServiceUnavailableException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(),
					"HTTP 503 Service Unavailable");
			throw notFoundException;
		}
	}
	// @Test(expected = BadRequestException.class)
	// public void checkGetGlobalProdctsUserNoExist() throws Exception {
	// try {
	// this.quotaDetailFacade.getDetailRotaryQuota(null);
	// } catch (final BadRequestException notFoundException) {
	// Assert.assertEquals(notFoundException.getMessage(),
	// "HTTP 400 Bad Request");
	// throw notFoundException;
	// }
	// }
}
