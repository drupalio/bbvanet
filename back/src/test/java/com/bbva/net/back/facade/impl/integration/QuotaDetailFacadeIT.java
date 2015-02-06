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
import com.bbva.net.back.model.quota.QuotaMoveDetailDto;

@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class QuotaDetailFacadeIT {

	@Resource(name = "quotaDetailFacade")
	private QuotaDetailFacade quotaDetailFacade;

	private static final String DEFAULT_ID = "00130443000200009497";

	private static final String DEFAULT_ID_MOV = "554654";

	// Servicio GetRotaryQuota

	@Test
	public void checkGetQuotaRotaryOK() throws Exception {
		final QuotaDetailDto quotaDetailDto = this.quotaDetailFacade.getDetailRotaryQuota(DEFAULT_ID);
		Assert.assertNotNull(quotaDetailDto);
	}

	@Test(expected = ServiceUnavailableException.class)
	public void checkGetQuotaRotaryNotId() throws Exception {
		try {
			this.quotaDetailFacade.getDetailRotaryQuota(StringUtils.EMPTY);
		} catch (final ServiceUnavailableException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 503 Service Unavailable");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetQuotaRotaryUserNoExist() throws Exception {
		try {
			this.quotaDetailFacade.getDetailRotaryQuota(null);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	// Servicio getRotaryQuotaMovement

	@Test
	public void checkGetQuotaDetailRotaryOK() throws Exception {
		final QuotaMoveDetailDto quotaMoveDetailDto = this.quotaDetailFacade.getRotaryQuotaMovement(DEFAULT_ID,
				DEFAULT_ID_MOV);
		Assert.assertNotNull(quotaMoveDetailDto);
	}

	@Test(expected = BadRequestException.class)
	public void checkGetQuotaDetailRotaryNotId() throws Exception {
		try {
			this.quotaDetailFacade.getRotaryQuotaMovement(StringUtils.EMPTY, StringUtils.EMPTY);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetQuotaDetailRotaryUserNoExist() throws Exception {
		try {
			this.quotaDetailFacade.getRotaryQuotaMovement(null, null);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

}
