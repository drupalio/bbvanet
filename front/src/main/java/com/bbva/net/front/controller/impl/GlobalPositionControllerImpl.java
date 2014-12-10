package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.stereotype.Controller;

import co.com.bbva.services.transactions.globalposition.schema.Account;
import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.SituationPiesUI;

@Controller(value = "globalPositionController")
public class GlobalPositionControllerImpl extends AbstractBbvaController implements GlobalPositionController {

	private static final long serialVersionUID = 5726824668267606699L;

	// private GraphicUI graphicUI;
	private Integer LISTA_QUIEROS = 1;

	private String selectedLike;

	private List<String> listPrb;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	private SituationPiesUI situationGraphicPieUI;

	private Account selectedProduct;

	private ActivePanelType activePanel = ActivePanelType.SITUATION;

	private transient boolean stateGlobalPosition = true;

	public boolean isStateGlobalPosition() {
		return stateGlobalPosition;
	}

	public void setStateGlobalPosition(boolean stateGlobalPosition) {
		this.stateGlobalPosition = stateGlobalPosition;
	}

	private enum ActivePanelType {

		SITUATION, ASSET, FINANCIATION
	}

	@PostConstruct
	public void init() {

		listPrb = new ArrayList<String>();
		listPrb.add("hola 0");
		listPrb.add("holaa 1");
		listPrb.add("hoolaa 2");

		LOGGER.info("STARTING BBVA NET .................");

	}

	@Override
	public GlobalProducts getCustomerProducts() {

		final GlobalProducts globalProductos = this.globalPositionFacade.getGlobalProductsByUser(getCurrentUser());

		situationGraphicPieUI = graphicPieDelegate.getSituationGlobalProducts(globalProductos);

		return globalProductos;
	}

	public void renderPieSituation() {
		this.activePanel = ActivePanelType.SITUATION;
	}

	public void renderPieAssets() {
		this.activePanel = ActivePanelType.ASSET;
	}

	public void renderPieFinanciation() {
		this.activePanel = ActivePanelType.FINANCIATION;
	}

	public void setGlobalPositionFacade(final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	public void setGraphicPieDelegate(GraphicPieDelegate graphicPieDelegate) {
		this.graphicPieDelegate = graphicPieDelegate;
	}

	public String getActivePanel() {
		return this.activePanel.name();
	}

	public SituationPiesUI getSituationGraphicPieUI() {
		return situationGraphicPieUI;
	}

	/**
	 * @return the listMultiValueLikes
	 */
	public List<MultiValueGroup> getListMultiValueLikes() {
		return this.multiValueGroupFacade.getMultiValueTypes(LISTA_QUIEROS);
	}

	/**
	 * @return the multiValueGroupFacade
	 */
	public MultiValueGroupFacade getMultiValueGroupFacade() {
		return multiValueGroupFacade;
	}

	/**
	 * @param multiValueGroupFacade the multiValueGroupFacade to set
	 */
	public void setMultiValueGroupFacade(MultiValueGroupFacade multiValueGroupFacade) {
		this.multiValueGroupFacade = multiValueGroupFacade;
	}

	/**
	 * @return the selectedProduct
	 */
	public Account getSelectedProduct() {
		return selectedProduct;
	}

	/**
	 * @param selectedProduct the selectedProduct to set
	 */
	public void setSelectedProduct(Account selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	/**
	 * @return the selectedLike
	 */
	public String getSelectedLike() {
		return selectedLike;
	}

	/**
	 * @param selectedLike the selectedLike to set
	 */
	public void setSelectedLike(String selectedLike) {
		this.selectedLike = selectedLike;
	}

	/**
	 * @return the listPrb
	 */
	public List<String> getListPrb() {
		return listPrb;
	}

	/**
	 * @param listPrb the listPrb to set
	 */
	public void setListPrb(List<String> listPrb) {
		this.listPrb = listPrb;
	}

	public void onRowSelect(SelectEvent event) {
		System.out.println("LLego selected");
		System.out.println("Product Selected" + ((Account)event.getObject()).getProduct().getProductId());
		FacesMessage msg = new FacesMessage("Product Selected", ((Account)event.getObject()).getProduct()
				.getProductId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		System.out.println("LLego iunselected");
		FacesMessage msg = new FacesMessage("Product Unselected", ((Account)event.getObject()).getProduct()
				.getProductId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String goAccounts() {
		return "accounts";
	}

	public void hola(ActionEvent action) {
		System.out.println("hola!!");

	}

	public void selectedValue() {
		System.out.println("Selected Like" + getSelectedLike());
	}

	public void testValidate() {
		System.out.println("Test validate" + getSelectedLike());
	}

}
