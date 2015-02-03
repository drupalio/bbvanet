package com.bbva.net.back.facade.impl.integration;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.Assert;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

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

	// Test de updateVisibility

	@Test
	public void checkVisibilityOK() throws Exception {
		ProductDto productDto = new ProductDto();
		productDto.setProductId("00130073005054466407");
		productDto.setVisible(true);
		Response response = this.personalizeProductFacade.updateProductVisibility("00130073005054466407", productDto);
		Assert.assertEquals(response.getStatus(), 200);
	}

	@Test
	public void checkVisibilityNull() {
		Response response = this.personalizeProductFacade.updateProductVisibility("00130073005054466407", null);
		Assert.assertEquals(response.getStatus(), 500);
	}

	@Test(expected = BadRequestException.class)
	public void checkVisibilityProductNoId() {
		ProductDto productDto = new ProductDto();
		try {
			productDto.setVisible(false);
			this.personalizeProductFacade.updateProductVisibility(null, productDto);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkVisibilityProductNoData() {
		try {
			ProductDto productDto = new ProductDto();
			productDto.setProductId("00130073005054466407");
			this.personalizeProductFacade.updateProductVisibility("00130073005054466407", productDto);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	// test de updateOperability

	@Test
	public void checkOperabilityOK() {
		ProductDto productDto = new ProductDto();
		productDto.setProductId("00130073005054466407");
		productDto.setOperationOnline(true);
		Response response = this.personalizeProductFacade.updateProductOperability("00130073005054466407", productDto);
		Assert.assertEquals(response.getStatus(), 200);
	}

	@Test
	public void checkOperabilityNull() {
		Response response = this.personalizeProductFacade.updateProductOperability("00130073005054466407", null);
		Assert.assertEquals(response.getStatus(), 500);
	}

	@Test(expected = BadRequestException.class)
	public void checkOperabilityProductNoId() {
		ProductDto productDto = new ProductDto();
		try {
			productDto.setVisible(false);
			this.personalizeProductFacade.updateProductOperability(null, productDto);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkOperabilityProductNoData() {
		try {
			ProductDto productDto = new ProductDto();
			productDto.setProductId("00130073005054466407");
			this.personalizeProductFacade.updateProductOperability("00130073005054466407", productDto);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}
}
