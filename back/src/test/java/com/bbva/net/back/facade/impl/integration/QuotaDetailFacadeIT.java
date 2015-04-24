package com.bbva.net.back.facade.impl.integration;

import java.util.Date;
import java.util.List;

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

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;

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
		final MovementDetailDto quotaMoveDetailDto = this.quotaDetailFacade.getRotaryQuotaMovement(DEFAULT_ID,
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

	// Servicio GetRotaryQuota

	@Test
	public void checklistRotaryQuotaMovementsOK() throws Exception {
		final List<MovementDto> quotaDetailDto = this.quotaDetailFacade.listRotaryQuotaMovements(
				"00130443000200009410", new DateRangeDto(new Date(), new Date()), "098787654", 10);
		Assert.assertNotNull(quotaDetailDto);
	}

	@Test(expected = ServiceUnavailableException.class)
	public void listRotaryQuotaMovementsNotId() throws Exception {
		try {
			this.quotaDetailFacade.listRotaryQuotaMovements(null, new DateRangeDto(new Date(), new Date()),
					"098787654", 10);
		} catch (final ServiceUnavailableException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 503 Service Unavailable");
			throw notFoundException;
		}
	}

	@Test(expected = ServiceUnavailableException.class)
	public void listRotaryQuotaMovementsNotPagination() throws Exception {
		try {
			this.quotaDetailFacade.listRotaryQuotaMovements("00130443000200009410", new DateRangeDto(new Date(),
					new Date()), null, 10);
		} catch (final ServiceUnavailableException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 503 Service Unavailable");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void listRotaryQuotaMovementsMistake() throws Exception {
		try {
			this.quotaDetailFacade.listRotaryQuotaMovements("00130443000200009410", new DateRangeDto(new Date(),
					new Date()), "0", 10);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}
}
