package com.bbva.net.back.facade.impl.integration;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.facade.MonthBalanceFacade;
import com.bbva.net.back.model.accounts.GlobalMonthlyBalanceDto;
import com.bbva.net.back.model.commons.DateRangeDto;

@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MonthlyBalanceFacadeIT {

	private static final String DEFAULT_ACCOUNT = "12345678998765432101";

	@Resource(name = "monthBalanceFacade")
	private MonthBalanceFacade monthBalanceFacade;

	@Test()
	public void checkMonthlyBalanceOK() {
		// SrvAccountsV01 -> getAccountMonthlyBalance
		final GlobalMonthlyBalanceDto resume = this.monthBalanceFacade.getAccountMonthlyBalance(DEFAULT_ACCOUNT,
				new DateRangeDto(), StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);

		Assert.assertNotNull(resume);
		Assert.assertNotNull(resume.getMonthlyBalanceList().get(0));

	}

//	@Test(expected = BadRequestException.class)
//	public void checkMonthlyBalanceWithOutFilter() {
//
//		// SrvAccountsV01 -> getAccountMonthlyBalance
//		try {
//			this.monthBalanceFacade.getAccountMonthlyBalance(DEFAULT_ACCOUNT, null, StringUtils.EMPTY,
//					StringUtils.EMPTY, StringUtils.EMPTY);
//		} catch (final BadRequestException notFoundException) {
//			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
//			throw notFoundException;
//		}
//
//	}

}
