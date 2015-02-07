package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;

import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.controller.MovementsAccountController;
import com.bbva.net.front.core.AbstractBbvaController;

public class MovementsAccountControllerImpl extends AbstractBbvaController implements MovementsAccountController {

	private static final long serialVersionUID = 2246759826282199706L;

	@PostConstruct
	public void init() {
		LOGGER.info("Initialize MovementesAccountController");
	}

	@Override
	public void setSelectedProduct(ProductDto selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

	public ProductDto getProduct() {
		return super.getSelectedProduct();
	}

}
