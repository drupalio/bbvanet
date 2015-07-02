package com.bbva.net.front.controller.impl;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.HeaderFacade;
import com.bbva.net.back.model.header.CustomerDto;
import com.bbva.net.back.model.header.ExecutiveDto;
import com.bbva.net.front.controller.HeaderController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "headerController")
@Scope(value = "globalSession")
public class HeaderControllerImpl extends AbstractBbvaController implements HeaderController {

	@Resource(name = "headerFacade")
	private transient HeaderFacade headerFacade;

	/**
	 * 
	 */
	private ExecutiveDto ejecutivo;

	private CustomerDto cliente;

	private static final long serialVersionUID = 5284952254890332374L;

	@PostConstruct
	public void init() {
		this.cliente = this.getCustomer();
		this.ejecutivo = this.getExecutive();
	}

	@Override
	public ExecutiveDto getExecutive() {
		try {
			return headerFacade.getExecutive();
		} catch (Exception e) {
			// FacesContext ctx = FacesContext.getCurrentInstance();
			// ctx.addMessage("getExecutive ", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
			return new ExecutiveDto();
		}
	}

	@Override
	public CustomerDto getCustomer() {

		LOGGER.info("====================================== GET CUSTOMER ==============================");
		final String userName = (getSession().getAttribute("userName") == null) ? StringUtils.EMPTY : getSession()
				.getAttribute("userName").toString();

		LOGGER.info("CLIENTE: " + userName);
		final String docTypeUser = (getSession().getAttribute("docTypeUser") == null) ? StringUtils.EMPTY
				: getSession().getAttribute("docTypeUser").toString();
		LOGGER.info("DOC TYPE USER" + docTypeUser);
		final String docIdUser = (getSession().getAttribute("docIdUser") == null) ? StringUtils.EMPTY : getSession()
				.getAttribute("docIdUser").toString();
		LOGGER.info("DOC ID USER" + docIdUser);

		try {
			return headerFacade.getCustomer(userName, docTypeUser, docIdUser);

		} catch (Exception e) {
			// FacesContext ctx = FacesContext.getCurrentInstance();
			// ctx.addMessage("getCustomer", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
			return new CustomerDto();
		}

	}

	@Override
	public void logOut() {
		getSession().removeAttribute("tsec");
		getSession().removeAttribute(SessionParamenterType.AUTHENTICATION_STATE.name());
		getSession().removeAttribute("userName");
		getSession().removeAttribute("docTypeUser");
		getSession().removeAttribute("docIdUser");
		getSession().invalidate();
		LOGGER.info("Se cerro la sesion " + getSession());
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("https://www.bbvanet.com.co/bbvaco/kqpu_co_web/page/init");
		} catch (IOException e) {
			LOGGER.info("No pudo redidreccionar a https://www.bbvanet.com.co/bbvaco/kqpu_co_web/page/init");
		}
	}

	public ExecutiveDto getEjecutivo() {
		return ejecutivo;
	}

	public CustomerDto getCliente() {

		return cliente;
	}

	public void setHeaderFacade(HeaderFacade headerFacade) {
		this.headerFacade = headerFacade;
	}
}
