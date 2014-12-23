package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.front.controller.MovementsAccountController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "movementsAccountController")
public class MovementsAccountControllerImpl extends AbstractBbvaController implements MovementsAccountController {

	private static final long serialVersionUID = 2246759826282199706L;

	@PostConstruct
	public void init() {
		LOGGER.info("Initialize MovementesAccountController");
	}

	@Override
	public void setSelectedProduct(ProductDTO selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

}
