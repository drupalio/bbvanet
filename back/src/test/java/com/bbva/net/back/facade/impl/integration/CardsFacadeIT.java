package com.bbva.net.back.facade.impl.integration;

import javax.annotation.Resource;

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

	// @Test
	// public void checkGetCardsChargesFilterOK() {
	// Assert.assertNotNull(this.cardsFacade.getCardsChargesFilter("9234-3456-1234-1234", dateRange));
	// }
	//
	// /**
	// * Debió fallar producto del id pequeño
	// *
	// * @throws Exception
	// */
	// @Test
	// public void checkGetCardsChargesFilterUserWrong() throws Exception {
	// try {
	// Assert.assertNotNull(this.cardsFacade.getCardsChargesFilter("9234", dateRange));
	// } catch (Exception e) {
	// System.out.println("Error");
	// throw e;
	// }
	// }
	//
	// /**
	// * Se espera una exepcion ya que el id del producto va null
	// */
	// @Test
	// public void checkGetCardsChargesFilterNotProduct() {
	// this.cardsFacade.getCardsChargesFilter(null, dateRange);
	// }

	// @Test(expected = BadRequestException.class)
	// public void checkGetCardsChargesFilterNotFilter() throws Exception {
	// try {
	// this.cardsFacade.getCardsChargesFilter("9234-3456-1234-1234", null);
	// } catch (Exception e) {
	// System.out.println("HTTP 400 Bad Request");
	// throw e;
	// }
	// }
	//
	// @Test(expected = BadRequestException.class)
	// public void checkGetCardsChargesFilterNull() throws Exception {
	// try {
	// this.cardsFacade.getCardsChargesFilter(null, null);
	// } catch (Exception e) {
	// System.out.println("HTTP 400 Bad Request");
	// throw e;
	// }
	// }

	// @Test(expected = ServiceUnavailableException.class)
	// public void checkGetCardsChargesProductEmpty() throws Exception {
	// try {
	// this.cardsFacade.getCardsChargesFilter(StringUtils.EMPTY, dateRange);
	// } catch (Exception e) {
	// System.out.println("HTTP 503 Service Unavailable");
	// throw e;
	// }
	// }
	//
	// @Test
	// public void checkGetCardsChargesFilterDateEqual() throws Exception {
	//
	// DateRangeDto dateRange = new DateRangeDto();
	// Date since = new Date();
	// Date to = new Date();
	// dateRange.setDateSince(since);
	// dateRange.setDateTo(to);
	// Assert.assertNotNull(this.cardsFacade.getCardsChargesFilter("9234-3456-1234-1234", dateRange));
	//
	// }
	// /*
	// * Revisar el mapeo no entra
	// */
	// @Test
	// public void recheckGetCardsChargesByUserOK() throws Exception {
	// try {
	// Assert.assertNotNull(this.cardsFacade.getCardsChargesByUser("1024275067", dateRange));
	// } catch (Exception e) {
	// System.out.println("HTTP 409 No data");
	// throw e;
	// }
	// }

	/*
	 * No entra valida el formato del usuario
	 */
	@Test
	public void recheckGetCardsChargesByUserOK() throws Exception {
		try {
			Assert.assertNotNull(this.cardsFacade.getCardsChargesByUser("10", dateRange));
		} catch (Exception e) {
			System.out.println("HTTP 409 No data");
			throw e;
		}
	}
	// @Test(expected=BadRequestException.class)
	// public void checkGetCardsChargesByUserNotFilter() throws Exception {
	// try {
	// this.cardsFacade.getCardsChargesByUser("1024275067", null);
	// } catch (Exception e) {
	// System.out.println("");
	// throw e;
	// }
	// }
	// @Test(expected = ClientErrorException.class)
	// public void checkGetCardsChargesByUserNotUser() throws Exception {
	// try {
	// this.cardsFacade.getCardsChargesByUser(null, dateRange);
	// } catch (Exception e) {
	// System.out.println("HTTP 409 Conflict");
	// throw e;
	// }
	// }

	// @Test(expected = BadRequestException.class)
	// public void recheckGetCardsChargesByUserNull() throws Exception {
	// try {
	// this.cardsFacade.getCardsChargesByUser(null, null);
	// } catch (Exception e) {
	// throw e;
	// }
	// }
	// /**
	// * Pasa test retorna excepción por no haber datos de retorno
	// *
	// * @throws Exception
	// */
	// @Test
	// public void checkGetCardsChargesByUserEmpty() throws Exception {
	// try {
	// this.cardsFacade.getCardsChargesByUser(StringUtils.EMPTY, dateRange);
	// } catch (Exception e) {
	// System.out.println("HTTP 409 Conflict");
	// throw e;
	// }
	// }

}
