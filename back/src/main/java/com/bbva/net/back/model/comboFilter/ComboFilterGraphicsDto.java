package com.bbva.net.back.model.comboFilter;

import com.bbva.net.back.core.pattern.dto.Dto;

public class ComboFilterGraphicsDto implements Dto {

	private static final long serialVersionUID = 3962274908934070992L;

	private String period;

	private String product;

	private String startDate;

	private String endDate;

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
