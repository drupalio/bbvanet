package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;

import org.primefaces.event.ToggleEvent;
import com.bbva.net.back.facade.QuotaMoveDetailFacade;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.quota.QuotaMoveDetailDto;
import com.bbva.net.front.controller.QuotaMoveController;
import com.bbva.net.front.core.AbstractBbvaController;

public class QuotaMoveControllerImpl extends AbstractBbvaController implements QuotaMoveController {

	private static final long serialVersionUID = 1L;

	@Resource(name = "quotaMoveDetailFacade")
	private transient QuotaMoveDetailFacade quotaMoveDetailFacade;

	private QuotaMoveDetailDto quotaMoveDetailDto = new QuotaMoveDetailDto();

	private final static String idMovement = "000000000";

	private ProductDto productDto = new ProductDto();

	public QuotaMoveDetailDto onRowToggle(ToggleEvent toggeEvent) {
		this.productDto = super.getSelectedProduct();
		return this.quotaMoveDetailFacade.getRotaryQuotaMovement(productDto.getProductId(), idMovement);
	}

	/**
	 * @return the quotaMoveDetailDto
	 */
	public QuotaMoveDetailDto getQuotaMoveDetailDto() {
		return quotaMoveDetailDto;
	}

	/**
	 * @param quotaMoveDetailDto the quotaMoveDetailDto to set
	 */
	public void setQuotaMoveDetailDto(QuotaMoveDetailDto quotaMoveDetailDto) {
		this.quotaMoveDetailDto = quotaMoveDetailDto;
	}
}
