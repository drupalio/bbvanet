package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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

	private ActionEvent event;

	private ExtractDto extractDto;

	private List<String> monthAvailable;

	@SuppressWarnings("unchecked")
	@Before
	public void init() {

		this.monthAvailable = new ArrayList<String>();
		monthAvailable.add("03");

		this.yearAvailable = new ArrayList<String>();
		yearAvailable.add("2015");
		this.extractList = new ArrayList<ExtractDto>();
		extractDto = new ExtractDto();
		extractDto.setExternalCode("12345");
		extractDto.setGenerationDate("2105-03-24");
		extractDto.setMonth("03");
		extractDto.setUrl("http://");
		extractDto.setYear("2015");
		extractList.add(extractDto);

		// this.productDto = Mockito.mock(ProductDto.class);
		this.productDto = new ProductDto();
		productDto.setProductNumber(DEFAULT_PRODUCT);

		this.extractController = new ExtractControllerImpl();
		this.extractFacade = Mockito.mock(ExtractFacade.class);

		this.extractController.setExtractFacade(extractFacade);
		this.extractController.setSelectedMonth("03");
		this.extractController.setSelectedYear("2015");
		this.extractController.setSelectedProduct(productDto);

		event = Mockito.mock(ActionEvent.class);

		Mockito.when(extractController.getSelectedProduct()).thenReturn(productDto);

		Mockito.when(extractFacade.getExtractAvailable(DEFAULT_PRODUCT)).thenReturn(extractList);

		this.extractController.init();

	}

	@Test
	public void checkActionState() {

		this.extractController.setEnableMonth(false);
		this.extractController.actionState();
		Assert.assertEquals(monthAvailable.get(0), this.extractController.getMonthAvailable().get(0));
		Assert.assertFalse(this.extractController.isEnableMonth());
	}

	@Test
	public void checkDocumentExtract() {
		Mockito.when(extractFacade.getDocumentExtract(DEFAULT_PRODUCT, extractDto)).thenReturn(extractList);
		this.extractController.documentExtract(event);
		Assert.assertNotNull(extractList);
		Assert.assertEquals(extractDto, extractFacade.getDocumentExtract(DEFAULT_PRODUCT, extractDto).get(0));
		Mockito.verify(extractFacade, Mockito.atLeastOnce()).getDocumentExtract(DEFAULT_PRODUCT, extractDto);
	}

	@Test
	public void getSelectedMonth() {

		Assert.assertEquals(monthAvailable.get(0), this.extractController.getSelectedMonth());
	}

	@Test
	public void checkGetSelectedYear() {

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
