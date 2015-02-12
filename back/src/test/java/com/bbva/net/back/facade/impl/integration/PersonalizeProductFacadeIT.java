package com.bbva.net.back.facade.impl.integration;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.Assert;
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

	// Test de updateVisibility.

	@Test
	public void checkVisibilityOK() throws Exception {
		ProductDto productDto = new ProductDto();
		productDto.setProductId("00130073005054466407");
		productDto.setVisible(true);
		Assert.assertEquals(
				this.personalizeProductFacade.updateProductVisibility(productDto.getProductId(), productDto), true);
	}

	// 500 Error interno del servidor.

	@Test
	public void checkVisibilityNull() {
		ProductDto productDto = new ProductDto();
		Assert.assertEquals(this.personalizeProductFacade.updateProductVisibility(productDto.getProductId(), null),
				false);
	}

	// 400 Petición incorrecta.

	@Test
	public void checkVisibilityProductNoId() {
		ProductDto productDto = new ProductDto();
		productDto.setVisible(false);
		Assert.assertEquals(
				this.personalizeProductFacade.updateProductVisibility(productDto.getProductId(), productDto), false);
	}

	// 409 Artibutos obligatorios vacíos.

	@Test
	public void checkVisibilityProductNoData() {
		ProductDto productDto = new ProductDto();
		productDto.setProductId("00130073005054466407");
		Assert.assertEquals(
				this.personalizeProductFacade.updateProductVisibility(productDto.getProductId(), productDto), false);
	}

	// test de updateOperability.

	@Test
	public void checkOperabilityOK() {
		ProductDto productDto = new ProductDto();
		productDto.setProductId("00130073005054466407");
		productDto.setOperationOnline(true);
		Boolean response = this.personalizeProductFacade
				.updateProductOperability(productDto.getProductId(), productDto);
		Assert.assertEquals(response, true);
	}

	// 500 Error interno del servidor.

	@Test
	public void checkOperabilityNull() {
		ProductDto productDto = new ProductDto();
		Boolean response = this.personalizeProductFacade.updateProductOperability(productDto.getProductId(), null);
		Assert.assertEquals(response, false);
	}

	// 400 Petición incorrecta.

	@Test
	public void checkOperabilityProductNoId() {
		ProductDto productDto = new ProductDto();
		productDto.setVisible(false);
		Assert.assertEquals(this.personalizeProductFacade.updateProductOperability(null, productDto), false);
	}

	// 409 Artibutos obligatorios vacíos.

	@Test
	public void checkOperabilityProductNoData() {
		ProductDto productDto = new ProductDto();
		productDto.setProductId("00130073005054466407");
		Assert.assertEquals(this.personalizeProductFacade.updateProductOperability("00130073005054466407", productDto),
				false);
	}
}
