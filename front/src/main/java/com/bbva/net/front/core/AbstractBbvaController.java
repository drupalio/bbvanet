package com.bbva.net.front.core;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.springframework.faces.webflow.FlowFacesContext;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContextHolder;

import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.helper.MessagesHelper;

/**
 * @author Entelgy
 */
public abstract class AbstractBbvaController implements Serializable {

	protected static final Log LOGGER = I18nLogFactory.getLog(AbstractBbvaController.class);

	private static final long serialVersionUID = -4820146844257478597L;

	protected String DEFAULT_USER;

	protected enum SessionParamenterType {

		SELECTED_PRODUCT, AUTHENTICATION_STATE, LAST_REQUEST_URI, SELECTED_MOVEMENT, TSEC
	}

	/**
	 * @param componenteSystemEvent
	 */
	public void preRender(final ComponentSystemEvent componentSystemEvent) {
		LOGGER.info("Rendering .... " + this.getClass().getSimpleName());
	}

	/**
	 * @param script
	 */
	protected void executeScript(final String script) {
		if (RequestContext.getCurrentInstance() != null) {
			RequestContext.getCurrentInstance().execute(script);
		}
	}

	/**
	 * @return current HttpSession from FacesContext
	 */
	protected HttpSession getSession() {
		final FacesContext facesContext = FlowFacesContext.getCurrentInstance();
		return (HttpSession)facesContext.getExternalContext().getSession(false);
	}

	/**
	 * @param parameter
	 * @return
	 */
	protected String getRequestParameter(final String parameter) {

		final HttpServletRequest request = this.getRequest();
		return request.getParameter(parameter);
	}

	/**
	 * @return HttpServletRequest
	 */
	protected HttpServletRequest getRequest() {

		final HttpServletRequest request = (HttpServletRequest)FlowFacesContext.getCurrentInstance()
				.getExternalContext().getRequest();

		return request;
	}

	/**
	 * @return
	 */
	protected ResourceBundle getMessages() {

		final FacesContext facesContext = FlowFacesContext.getCurrentInstance();
		return facesContext.getApplication().getResourceBundle(facesContext, "msg");
	}

	/**
	 * Redirect to new flow
	 * 
	 * @param url to initialize flow
	 */
	protected void initFlow(final String url) {

		final ExternalContext externalContext = FlowFacesContext.getCurrentInstance().getExternalContext();

		try {
			externalContext.redirect(url);
		} catch (IOException ex) {
			LOGGER.info(ex.getMessage());
		}
	}

	/**
	 * @param action to send in current flow
	 */
	protected void sendAction(final String action) {
		((RequestControlContext)getWebFlowRequestContext()).handleEvent(new Event(this, action));
	}

	/**
	 * @param var
	 * @param object
	 */
	protected void putViewVar(final String var, final Object object) {
		getWebFlowRequestContext().getViewScope().put(var, object);
	}

	/***
	 * @param var
	 */
	protected Object getViewVarView(final String var) {
		return getWebFlowRequestContext().getViewScope().get(var);
	}

	/**
	 * @param var
	 * @param object
	 */
	protected void putFlashVar(final String var, final Object object) {
		getWebFlowRequestContext().getFlashScope().put(var, object);
	}

	/***
	 * @param var
	 */
	protected Object getFlashVar(final String var) {
		return getWebFlowRequestContext().getFlashScope().get(var);
	}

	/**
	 * @param var
	 * @param object
	 */
	protected void putFlowVar(final String var, final Object object) {
		getWebFlowRequestContext().getFlowScope().put(var, object);
	}

	/***
	 * @param var
	 */
	protected Object getFlowVar(final String var) {
		return getWebFlowRequestContext().getFlowScope().get(var);
	}

	/**
	 * @param var
	 * @return
	 */
	protected Object getVarInFlow(final String var) {
		return getWebFlowRequestContext().getFlashScope().get(var);
	}

	/**
	 * @param defaultUser
	 */
	public void setDefaultUser(String defaultUser) {
		DEFAULT_USER = defaultUser;
	}

	/**
	 * @return
	 */
	protected String getCurrentUser() {
		return DEFAULT_USER;
	}

	/**
	 * @return get RequestContext (WebFlow) Instance
	 */
	private org.springframework.webflow.execution.RequestContext getWebFlowRequestContext() {

		org.springframework.webflow.execution.RequestContext requestContext = RequestContextHolder.getRequestContext();
		return requestContext;
	}

	/**
	 * @return
	 */
	public ProductDto getSelectedProduct() {
		return (ProductDto)getSession().getAttribute(SessionParamenterType.SELECTED_PRODUCT.name());
	}

	/**
	 * @param selectedProduct
	 */
	public void setSelectedProduct(final ProductDto selectedProduct) {
		getSession().setAttribute(SessionParamenterType.SELECTED_PRODUCT.name(), selectedProduct);
	}

	/**
	 * @param selectEvent
	 */
	public void onProductSelected(final SelectEvent selectEvent) {

		final ProductDto productDto = (ProductDto)selectEvent.getObject();
		LOGGER.info("ON productSelected Id: " + productDto.getProductId());
		LOGGER.info("ON productSelected Name: " + productDto.getProductName());
		LOGGER.info("ON productSelected Number: " + productDto.getProductNumber());
		this.setSelectedProduct(productDto);

	}

	/**
	 * @return
	 */
	public MovementDto getSelectedMovements() {
		return (MovementDto)getSession().getAttribute(SessionParamenterType.SELECTED_MOVEMENT.name());
	}

	/**
	 * @param selectedProduct
	 */
	public void setSelectedMovements(final MovementDto selectedProduct) {
		getSession().setAttribute(SessionParamenterType.SELECTED_MOVEMENT.name(), selectedProduct);
	}

	/**
	 * @param selectEvent
	 */
	public void onMovementSelected(final SelectEvent selectEvent) {
		this.setSelectedMovements((MovementDto)selectEvent.getObject());
		System.out.print("ON productSelected\n");
	}

	public String getdateString(Date date) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(
				MessagesHelper.INSTANCE.getStringI18("date.pattner.dd-mm-yyyy"));
		if (date != null) {
			return dateFormat.format(date);
		}
		return "N/A";
	}

	public void maxSize(List<Cell> cellSheet, Sheet hoja) {
		for (int i = 0; i < 5; i++) {
			int width = 0;
			int max = 0;
			for (int j = 0; j < cellSheet.size(); j = j + 5) {
				if (j == 0) {
					max = cellSheet.get(i + j).getStringCellValue().length();
				} else {
					int actual = cellSheet.get(i + j).getStringCellValue().length();
					if (max < actual) {
						max = cellSheet.get(i + j).getStringCellValue().length();
					}
				}
			}
			width = ((int)(max * 1.6) * 256);
			hoja.setColumnWidth(i + 1, width);
		}
	}

	public void createCell(Cell cell, String value, CellStyle style) {
		cell.setCellStyle(style);
		if (value != null) {
			cell.setCellValue(value);
		} else {
			cell.setCellValue(" ");
		}
	}

	public void createCellMoney(Cell cell, Money value, CellStyle style) {
		cell.setCellStyle(style);
		if (value != null) {
			cell.setCellValue(value.toString());
		} else {
			cell.setCellValue(" ");
		}
	}
}
