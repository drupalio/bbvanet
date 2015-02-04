package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.controller.MovementsAccountController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.ui.pie.PieConfigUI;

@ManagedBean
@ViewScoped
public class MovementsAccountControllerImpl extends AbstractBbvaController implements MovementsAccountController {

	private static final long serialVersionUID = 2246759826282199706L;

	private PieConfigUI graphicLineMovements;

	private transient GraphicLineDelegate graphicLineDelegate;

	@PostConstruct
	public void init() {
		LOGGER.info("Initialize MovementesAccountController");
		// this.graphicLineMovements = graphicLineDelegate.getMovementAccount();
	}

	@Override
	public void setSelectedProduct(ProductDto selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

	public ProductDto getProduct() {
		return super.getSelectedProduct();
	}

}
