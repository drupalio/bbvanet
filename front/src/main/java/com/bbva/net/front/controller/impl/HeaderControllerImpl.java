package com.bbva.net.front.controller.impl;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.faces.webflow.FlowFacesContext;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.HeaderFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
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

	private DateRangeDto date = new DateRangeDto();

	private static final long serialVersionUID = 5284952254890332374L;

	@PostConstruct
	public void init() {
		this.cliente = this.getCustomer();
		if (!this.cliente.getSegment().equals("N") || !this.cliente.getSegment().isEmpty())
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
		final String userName = (getSession().getAttribute("userName") == null) ? StringUtils.EMPTY : getSession()
				.getAttribute("userName").toString();
		final String docTypeUser = (getSession().getAttribute("docTypeUser") == null) ? StringUtils.EMPTY
				: getSession().getAttribute("docTypeUser").toString();
		final String docIdUser = (getSession().getAttribute("docIdUser") == null) ? StringUtils.EMPTY : getSession()
				.getAttribute("docIdUser").toString();
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
			LOGGER.info("Redireccionó a " + "https://www.bbvanet.com.co/bbvaco/kqpu_co_web/page/init");
		} catch (IOException e) {
			LOGGER.info("No pudo redidreccionar a https://www.bbvanet.com.co/bbvaco/kqpu_co_web/page/init");
		}
	}

	public void onIdle() {

		try {
			getSession().removeAttribute("tsec");
			getSession().removeAttribute(SessionParamenterType.AUTHENTICATION_STATE.name());
			getSession().removeAttribute("userName");
			getSession().removeAttribute("docTypeUser");
			getSession().removeAttribute("docIdUser");
			FacesContext context = FlowFacesContext.getCurrentInstance();
			context.getExternalContext().redirect("/kqco_co_web/error/error.xhtml");
		} catch (Exception d) {

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

	public DateRangeDto getDate() {
		return date;
	}

	public void setDate(DateRangeDto date) {
		this.date = date;
	}

}
