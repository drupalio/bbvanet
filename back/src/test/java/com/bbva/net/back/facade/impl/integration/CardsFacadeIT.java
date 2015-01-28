package com.bbva.net.back.facade.impl.integration;

import javax.annotation.Resource;
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

	EnumPeriodType periodType = null;

	DateRangeDto dateRange = null;

	@Test
	public void checkGetCardsChargesFilterOK() {
		periodType = EnumPeriodType.valueOf(EnumPeriodType.LAST_TWELVE_MONTH.getPeriodId());
		dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		Assert.assertNotNull(this.cardsFacade.getCardsChargesFilter("123", dateRange));
	}

	@Test
	public void checkGetCardsChargesFilterNotProduct() {
		periodType = EnumPeriodType.valueOf(EnumPeriodType.LAST_TWELVE_MONTH.getPeriodId());
		dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		this.cardsFacade.getCardsChargesFilter(null, dateRange);
	}

	@Test(expected = ClientErrorException.class)
	public void checkGetCardsChargesFilterNotFilter() {
		this.cardsFacade.getCardsChargesFilter("123", null);
	}

	@Test(expected = ClientErrorException.class)
	public void checkGetCardsChargesFilterNull() {
		this.cardsFacade.getCardsChargesFilter(null, null);
	}

	@Test(expected = ServiceUnavailableException.class)
	public void checkGetCardsChargesProductEmpty() {
		periodType = EnumPeriodType.valueOf(EnumPeriodType.LAST_TWELVE_MONTH.getPeriodId());
		dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		this.cardsFacade.getCardsChargesFilter(StringUtils.EMPTY, dateRange);
	}

}
