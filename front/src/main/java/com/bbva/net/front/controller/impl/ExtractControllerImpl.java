package com.bbva.net.front.controller.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.bbva.net.back.facade.ExtractFacade;
import com.bbva.net.back.model.extract.ExtractDto;
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

	@Override
	public Map<String, List<String>> getExtractAvailablePeriod() {

		return null;
	}

	public void init() {

		this.extractList = this.extractFacade.getExtractAvailablePeriod(super.getSelectedProduct().getProductNumber(),
				StringUtils.EMPTY);

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

}
