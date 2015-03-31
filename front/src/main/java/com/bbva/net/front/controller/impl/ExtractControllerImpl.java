package com.bbva.net.front.controller.impl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.bbva.net.back.facade.ExtractFacade;
import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.back.predicate.ExtractDocumentPredicate;
import com.bbva.net.back.predicate.ExtractPeriodPredicate;
import com.bbva.net.front.controller.ExtractController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author Entelgy
 */
public class ExtractControllerImpl extends AbstractBbvaController implements ExtractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7877371441207311900L;

	/**
	 * 
	 */
	private String selectedYear;

	/**
	 * 
	 */
	private String selectedMonth;

	/**
	 * 
	 */
	@Resource(name = "extractFacade")
	private transient ExtractFacade extractFacade;

	/**
	 * 
	 */
	private List<ExtractDto> extractList;

	/**
	 * 
	 */
	private List<String> yearAvailable;

	/**
	 * 
	 */
	private List<String> monthAvailable;

	/**
	 * 
	 */
	private boolean enableMonth;

	/**
	 * 
	 */
	public void init() {

		this.extractList = this.extractFacade.getExtractAvailable(super.getSelectedProduct().getProductNumber());
		this.enableMonth = true;
		getExtractAvailablePeriod();

	}

	/**
	 * @param event
	 * @throws IOException
	 */
	public StreamedContent documentExtract() throws IOException {

		LOGGER.info("Consultando extracto..........");
		final ExtractDto extract = (ExtractDto)CollectionUtils.find(extractList, new ExtractDocumentPredicate(
				selectedMonth, selectedYear));
		final List<ExtractDto> extractDocument = this.extractFacade.getDocumentExtract(super.getSelectedProduct()
				.getProductNumber(), extract);
		// Hacer Redirect
		if (extractDocument != null) {
			LOGGER.info("Descargar Extracto en : " + extractDocument.get(0).getUrl());
			String url = extractDocument.get(0).getUrl();
			URL stream = new URL(url);
			return new DefaultStreamedContent(stream.openStream(), "application/pdf", "Reporte.pdf");
		}
		return new DefaultStreamedContent();
	}

	/**
	 * 
	 */
	public void actionState() {
		this.enableMonth = false;
		getExtractMontAvailable();
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getExtractAvailablePeriod() {

		this.yearAvailable = (List<String>)CollectionUtils.collect(extractList, new BeanToPropertyValueTransformer(
				"year"));

		yearAvailable = new ArrayList<String>(new LinkedHashSet<String>(yearAvailable));

		return yearAvailable;
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getExtractMontAvailable() {

		final List<String> monthByYear = (List<String>)CollectionUtils.select(extractList, new ExtractPeriodPredicate(
				selectedYear));

		this.monthAvailable = (List<String>)CollectionUtils.collect(monthByYear, new BeanToPropertyValueTransformer(
				"month"));
		monthAvailable = new ArrayList<String>(new LinkedHashSet<String>(monthAvailable));

		return monthAvailable;
	}

	/**
	 * @return
	 */
	public String getSelectedYear() {
		return selectedYear;
	}

	/**
	 * @param selectedYear
	 */
	public void setSelectedYear(final String selectedYear) {
		this.selectedYear = selectedYear;
	}

	/**
	 * @return
	 */
	public String getSelectedMonth() {
		return selectedMonth;
	}

	/**
	 * @param selectedMonth
	 */
	public void setSelectedMonth(final String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	/**
	 * @return
	 */
	public List<ExtractDto> getExtractList() {
		return extractList;
	}

	/**
	 * @param extractFacade
	 */
	public void setExtractFacade(final ExtractFacade extractFacade) {
		this.extractFacade = extractFacade;
	}

	/**
	 * @return
	 */
	public List<String> getYearAvailable() {
		return yearAvailable;
	}

	/**
	 * @return
	 */
	public List<String> getMonthAvailable() {
		return monthAvailable;
	}

	/**
	 * @return
	 */
	public boolean isEnableMonth() {
		return enableMonth;
	}

	/**
	 * @param enableMonth
	 */
	public void setEnableMonth(final boolean enableMonth) {
		this.enableMonth = enableMonth;
	}
}
