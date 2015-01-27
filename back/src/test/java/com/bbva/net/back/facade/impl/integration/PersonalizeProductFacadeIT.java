package com.bbva.net.back.facade.impl.integration;

import javax.annotation.Resource;
import javax.ws.rs.ServiceUnavailableException;

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

	@Test(expected = ServiceUnavailableException.class)
	public void checkVisibilityOK() throws Exception {
		try {
			this.personalizeProductFacade.updateProductVisibility("12345",
					productDto);
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(expected = ServiceUnavailableException.class)
	public void checkVisibilityProductNull() throws Exception {
		try {
			this.personalizeProductFacade
					.updateProductVisibility("12345", null);
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(expected = ServiceUnavailableException.class)
	public void checkOperabilityOK() throws Exception {
		try {
			this.personalizeProductFacade.updateProductOperability("12345",
					productDto);
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(expected = ServiceUnavailableException.class)
	public void checkOperabilityProductNull() throws Exception {
		try {
			this.personalizeProductFacade.updateProductOperability("12345",
					null);
		} catch (Exception e) {
			throw e;
		}
	}

}
