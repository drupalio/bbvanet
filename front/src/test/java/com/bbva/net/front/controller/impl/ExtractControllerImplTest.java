package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.primefaces.model.StreamedContent;
import org.springframework.web.client.RestClientException;

import com.bbva.net.back.facade.ExtractFacade;
import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class ExtractControllerImplTest extends AbstractBbvaControllerTest {

	private ExtractControllerImpl extractController;

	private static final String DEFAULT_PRODUCT = "00112345678909954345";

	@Resource(name = "extractFacade")
	private transient ExtractFacade extractFacade;

	private List<ExtractDto> extractList;

	private List<String> yearAvailable;

	private ProductDto productDto;

	private ExtractDto extractDto;

	private List<String> monthAvailable;

	@Before
	public void init() {
		// Inicialización
		this.extractController = new ExtractControllerImpl();
		// Lista de mes
		this.monthAvailable = new ArrayList<String>();
		monthAvailable.add("03");
		// Lista de años
		this.yearAvailable = new ArrayList<String>();
		yearAvailable.add("2015");
		// ExtractList
		this.extractList = new ArrayList<ExtractDto>();
		this.extractDto = new ExtractDto("12345", "03", "2015", "EE", null);
		extractList.add(extractDto);
		// Producto
		this.productDto = new ProductDto();
		productDto.setProductNumber(DEFAULT_PRODUCT);
		// Mockitos y set
		this.extractFacade = Mockito.mock(ExtractFacade.class);
		this.extractController.setExtractFacade(extractFacade);

		this.extractController.setSelectedProduct(productDto);
		Mockito.when(extractController.getSelectedProduct()).thenReturn(productDto);

		// OK
		Mockito.when(extractFacade.getExtractAvailable(DEFAULT_PRODUCT)).thenReturn(extractList);
		this.extractController.init();
	}

	@Test
	public void wormExtract() {
		// ClientException
		Mockito.when(extractFacade.getExtractAvailable(DEFAULT_PRODUCT)).thenThrow(new RestClientException("OK"));
		this.extractController.init();
	}

	@Test
	public void checkDocumentExtract() {
		// OK
		Mockito.when(extractFacade.getDocumentExtract(DEFAULT_PRODUCT, extractDto)).thenReturn(extractList);
		// Year null and Month null, URL NULL
		StreamedContent file = this.extractController.documentExtract();
		Assert.assertNull(file);
		// setSelectedYear y setSelectedMonth
		this.extractController.setSelectedYear("2015");
		this.extractController.setSelectedMonth("03");
		// Year not null and Month not null, URL NULL
		file = this.extractController.documentExtract();
		Assert.assertNull(file);
		// URL CHECK
		this.extractDto.setUrl("http://www.primefaces.org/docs/guide/primefaces_user_guide_5_0.pdf");
		file = extractController.documentExtract();
		Assert.assertNotNull(file);
		// Year not null, URL NULL
		this.extractController.setSelectedMonth(null);
		file = this.extractController.documentExtract();
		Assert.assertNull(file);
		// Month not null, URL NULL
		this.extractController.setSelectedYear(null);
		this.extractController.setSelectedMonth("03");
		file = this.extractController.documentExtract();
		Assert.assertNull(file);
		// extractList
		Assert.assertNotNull(extractList);
		Assert.assertEquals(extractDto, extractFacade.getDocumentExtract(DEFAULT_PRODUCT, extractDto).get(0));
		Mockito.when(extractFacade.getDocumentExtract(DEFAULT_PRODUCT, extractDto)).thenReturn(null);
		// Verify
		Mockito.verify(extractFacade, Mockito.atLeastOnce()).getDocumentExtract(DEFAULT_PRODUCT, extractDto);

		// ClientException
		this.extractController.setSelectedYear("2015");
		Mockito.when(extractFacade.getDocumentExtract(DEFAULT_PRODUCT, extractDto)).thenThrow(
				new RestClientException("OK"));
		file = extractController.documentExtract();
		Assert.assertNull(file);
	}

	@Test
	public void checkActionState() {
		this.extractController.setSelectedMonth("03");
		this.extractController.setSelectedYear("2015");
		this.extractController.setEnableMonth(false);
		this.extractController.actionState();
		Assert.assertEquals(monthAvailable.get(0), this.extractController.getMonthAvailable().get(0));
		Assert.assertFalse(this.extractController.isEnableMonth());
	}

	@Test
	public void getSelectedMonth() {
		this.extractController.setSelectedMonth("03");
		Assert.assertEquals(monthAvailable.get(0), this.extractController.getSelectedMonth());
	}

	@Test
	public void checkGetSelectedYear() {
		this.extractController.setSelectedYear("2015");
		Assert.assertEquals(yearAvailable.get(0), this.extractController.getSelectedYear());
	}

	@Test
	public void checkGetExtractList() {
		Assert.assertEquals(extractList, this.extractController.getExtractList());
	}

	@Test
	public void checkGetYearAvailable() {
		Assert.assertEquals(yearAvailable, this.extractController.getYearAvailable());
	}
}
