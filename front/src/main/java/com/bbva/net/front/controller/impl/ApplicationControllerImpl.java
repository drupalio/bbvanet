package com.bbva.net.front.controller.impl;

import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.SelectEvent;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.controller.ApplicationController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "applicationController")
public class ApplicationControllerImpl extends AbstractBbvaController implements ApplicationController {

	private static final long serialVersionUID = -7098769540244437001L;

	private ProductDto product;

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	@Override
	public void onLikeAccount(final ValueChangeEvent valueChangeEvent) {
		// super.onProductSelected(changeEvent);
		LOGGER.info("onLikeAccount " + valueChangeEvent);
		super.setSelectedProduct((ProductDto)valueChangeEvent.getOldValue());
		super.getSelectedProduct();
		this.sendAction("accountSelected");

	}

	@Override
	public void onProductSelected(SelectEvent selectEvent) {
		// TODO Auto-generated method stub
		super.onProductSelected(selectEvent);
	}
}
