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
        LOGGER.info("onLikeAccount " + valueChangeEvent + " "
                + MessagesHelper.INSTANCE.getString("quiero.viewBalancesMovements"));
        if (valueChangeEvent.getNewValue().equals(MessagesHelper.INSTANCE.getString("quiero.viewBalancesMovements"))) {
            super.setSelectedProduct((ProductDto)valueChangeEvent.getOldValue());
            super.getSelectedProduct();
            flow = true;
            this.sendAction("accountSelected");
        }
        if (valueChangeEvent.getNewValue().equals(MessagesHelper.INSTANCE.getString("quiero.seeMoreOptions"))) {
            super.setSelectedProduct((ProductDto)valueChangeEvent.getOldValue());
            super.getSelectedProduct();
            this.sendAction("accountSelected");
            final HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext()
                    .getSession(false);
            flow = true;
            session.setAttribute("operationsAccount", "true");
        }
        if (!flow) {
            this.sendAction("back");
        }

    }

    public void onLike(ValueChangeEvent valueChangeEvent) {
        this.sendAction("back");
    }

    @Override
    public void onLikeQuota(ValueChangeEvent valueChangeEvent) {
        LOGGER.info("onLikeQuota " + valueChangeEvent + " "
                + MessagesHelper.INSTANCE.getString("quiero.viewMovements"));
        if (valueChangeEvent.getNewValue().equals(MessagesHelper.INSTANCE.getString("quiero.viewMovements"))) {
            super.setSelectedProduct((ProductDto)valueChangeEvent.getOldValue());
            super.getSelectedProduct();
            this.sendAction("quotaSelected");
        }
        if (valueChangeEvent.getNewValue().equals(MessagesHelper.INSTANCE.getString("quiero.seeMoreOptions"))) {
            super.setSelectedProduct((ProductDto)valueChangeEvent.getOldValue());
            super.getSelectedProduct();
            this.sendAction("quotaSelected");
            final HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext()
                    .getSession(false);
            session.setAttribute("operationsRotary", "true");
        }
    }
}
