package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.controller.ApplicationController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.helper.MessagesHelper;

@Controller(value = "applicationController")
public class ApplicationControllerImpl extends AbstractBbvaController implements ApplicationController {

	private static final long serialVersionUID = -7098769540244437001L;

	private ProductDto product;

	private transient ComboCriteriaControllerImpl combos = new ComboCriteriaControllerImpl();

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	@Override
	public void onLikeAccount(final ValueChangeEvent valueChangeEvent) {
		boolean flow = false;
		LOGGER.info("onLikeAccount " + valueChangeEvent + " ");
		if (valueChangeEvent.getNewValue().equals(
				MessagesHelper.INSTANCE.getString(multiValueGroupFacade.getMultiValueTypes(6).get(0).getValue()))) {
			super.setSelectedProduct((ProductDto)valueChangeEvent.getOldValue());
			super.getSelectedProduct();
			flow = true;
			this.sendAction("accountSelected");
		}
		if (valueChangeEvent.getNewValue().equals(
				MessagesHelper.INSTANCE.getString(multiValueGroupFacade.getMultiValueTypes(6).get(3).getValue()))) {
			super.setSelectedProduct((ProductDto)valueChangeEvent.getOldValue());
			super.getSelectedProduct();
			this.sendAction("accountSelected");
			final HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			flow = true;
			session.setAttribute("operations", "true");
		}
		if (!flow) {
			this.sendAction("back");
		}

	}

	@Override
	public void onLike(ValueChangeEvent valueChangeEvent) {
		LOGGER.info("onLike" + valueChangeEvent);

	}
}
