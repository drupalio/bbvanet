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

import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.model.globalposition.ProductDto;

@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonalizeProductFacadeIT {

	@Resource(name = "personalizeProductAccountFacade")
	private PersonalizeProductFacade personalizeProductFacade;

	ProductDto productDto = new ProductDto();

	// @Test
	// public void checkVisibilityOK() throws Exception {
	// try {
	// this.personalizeProductFacade.updateProductVisibility(
	// "00130073005054466407", productDto);
	// } catch (Exception e) {
	// throw e;
	// }
	// }
	//
	// @Test(expected = BadRequestException.class)
	// public void checkVisibilityProductNull() throws Exception {
	// try {
	// this.personalizeProductFacade.updateProductVisibility(
	// "00130073005054466407", null);
	// } catch (final BadRequestException notFoundException) {
	// Assert.assertEquals(notFoundException.getMessage(),
	// "HTTP 400 Bad Request");
	// throw notFoundException;
	// }
	// }

	// @Test
	// public void checkOperabilityOK() throws Exception {
	// try {
	// this.personalizeProductFacade.updateProductOperability(
	// "00130073005054466407", productDto);
	// } catch (Exception e) {
	// throw e;
	// }
	// }

	@Test(expected = BadRequestException.class)
	public void checkOperabilityProductNull() throws Exception {
		try {
			this.personalizeProductFacade.updateProductOperability(
					"00130073005054466407", null);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(),
					"HTTP 400 Bad Request");
			throw notFoundException;
		}
	}
}
