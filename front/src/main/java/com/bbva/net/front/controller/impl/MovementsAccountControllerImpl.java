package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.front.controller.MovementsAccountController;
import com.bbva.net.front.core.AbstractBbvaController;

@ManagedBean
@ViewScoped
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
