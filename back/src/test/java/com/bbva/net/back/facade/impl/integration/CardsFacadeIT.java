package com.bbva.net.back.facade.impl.integration;

import java.util.Date;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.ServiceUnavailableException;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;

@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CardsFacadeIT {

	@Resource(name = "cardsFacade")
	private CardsFacade cardsFacade;

	EnumPeriodType periodType = EnumPeriodType.valueOf(EnumPeriodType.LAST_TWELVE_MONTH.getPeriodId());

	DateRangeDto dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);

	@Test
	public void checkGetCardsChargesFilterOK() {
		Assert.assertNotNull(this.cardsFacade.getCardsChargesFilter("1234567890123456", dateRange));
		DateRangeDto dateRange = new DateRangeDto();
		// Fechas iguales
		Date since = new Date();
		Date to = new Date();
		dateRange.setDateSince(to);
		dateRange.setDateTo(since);
		Assert.assertNotNull(this.cardsFacade.getCardsChargesFilter("1234567890123456", dateRange));
	}

	@Test(expected = ClientErrorException.class)
	public void checkGetCardsChargesFilterWrong() throws Exception {
		try {
			DateRangeDto dateRange = new DateRangeDto();

			dateRange.setDateSince(this.dateRange.getDateTo());
			dateRange.setDateTo(this.dateRange.getDateSince());
			Assert.assertNotNull(this.cardsFacade.getCardsChargesFilter("1234567890123456", dateRange));
		} catch (final ClientErrorException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 409 Conflict");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetCardsChargesFilterUserWrong() throws Exception {
		try {
			Assert.assertNotNull(this.cardsFacade.getCardsChargesFilter("9234", dateRange));
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetCardsChargesFilterNotProduct() throws Exception {
		try {
			this.cardsFacade.getCardsChargesFilter(null, dateRange);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetCardsChargesFilterNotFilter() throws Exception {
		try {
			this.cardsFacade.getCardsChargesFilter("12345678123456789123", null);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetCardsChargesFilterNotDateSince() throws Exception {
		try {
			DateRangeDto dateRange = new DateRangeDto();
			dateRange.setDateSince(null);
			dateRange.setDateTo(this.dateRange.getDateTo());
			this.cardsFacade.getCardsChargesFilter("12345678123456789123", null);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetCardsChargesFilterNotDateTo() throws Exception {
		try {
			DateRangeDto dateRange = new DateRangeDto();
			dateRange.setDateSince(this.dateRange.getDateSince());
			dateRange.setDateTo(null);
			this.cardsFacade.getCardsChargesFilter("12345678123456789123", null);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetCardsChargesFilterNull() throws Exception {
		try {
			this.cardsFacade.getCardsChargesFilter(null, null);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = ServiceUnavailableException.class)
	public void checkGetCardsChargesProductEmpty() throws Exception {
		try {
			this.cardsFacade.getCardsChargesFilter(StringUtils.EMPTY, dateRange);
		} catch (final ServiceUnavailableException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 503 Service Unavailable");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetCardsChargesByFilterOk() throws Exception {
		try {
			this.cardsFacade.getCardsChargesByUser(dateRange);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetCardsChargesByFilterNull() throws Exception {
		try {
			this.cardsFacade.getCardsChargesByUser(null);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}
}
