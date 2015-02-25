package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.bbva.net.back.facade.ExtractFacade;
import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.back.predicate.ExtractPeriodPredicate;
import com.bbva.net.front.controller.ExtractController;
import com.bbva.net.front.core.AbstractBbvaController;

public class ExtractControllerImpl extends AbstractBbvaController implements ExtractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7877371441207311900L;

	private String selectedYear;

	private String selectedMonth;

	@Resource(name = "extractFacade")
	private transient ExtractFacade extractFacade;

	private List<ExtractDto> extractList;

	private List<String> yearAvailable;

	private List<String> monthAvailable;

	private boolean enableMonth = true;

	public void init() {

		try {
			this.extractList = this.extractFacade.getExtractAvailablePeriod(super.getSelectedProduct()
					.getProductNumber(), StringUtils.EMPTY);

			getExtractAvailablePeriod();
		} catch (final Exception exception) {
			exception.printStackTrace();
		}

	}

	public void actionState() {
		enableMonth = true;
		getExtractMontAvailable();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getExtractAvailablePeriod() {

		this.yearAvailable = (List<String>)CollectionUtils.collect(extractList, new BeanToPropertyValueTransformer(
				"year"));

		yearAvailable = new ArrayList<String>(new LinkedHashSet<String>(yearAvailable));

		return yearAvailable;
	}

	@SuppressWarnings("unchecked")
	public List<String> getExtractMontAvailable() {

		@SuppressWarnings("unused")
		final List<String> monthByYear = (List<String>)CollectionUtils.select(extractList, new ExtractPeriodPredicate(
				selectedYear));

		this.monthAvailable = (List<String>)CollectionUtils.collect(monthByYear, new BeanToPropertyValueTransformer(
				"month"));
		monthAvailable = new ArrayList<String>(new LinkedHashSet<String>(monthAvailable));

		return monthAvailable;
	}

	public String getSelectedYear() {
		return selectedYear;
	}

	public void setSelectedYear(final String selectedYear) {
		this.selectedYear = selectedYear;
	}

	public String getSelectedMonth() {
		return selectedMonth;
	}

	public void setSelectedMonth(final String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	public List<ExtractDto> getExtractList() {
		return extractList;
	}

	public void setExtractFacade(final ExtractFacade extractFacade) {
		this.extractFacade = extractFacade;
	}

	public List<String> getYearAvailable() {
		return yearAvailable;
	}

	public List<String> getMonthAvailable() {
		return monthAvailable;
	}

	public void setMonthAvailable(List<String> monthAvailable) {
		this.monthAvailable = monthAvailable;
	}

	public boolean isEnableMonth() {
		return enableMonth;
	}

	public void setEnableMonth(boolean enableMonth) {
		this.enableMonth = enableMonth;
	}

}
