package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.event.SelectEvent;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.globalposition.SituationPiesUI;

@Controller(value = "globalPositionController")
public class GlobalPositionControllerImpl extends AbstractBbvaController implements GlobalPositionController {

	private static final long serialVersionUID = 5726824668267606699L;

	private String selectedLike;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	private SituationPiesUI situationGraphicPieUI;

	private AccountDTO selectedProduct;

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
		LOGGER.info("STARTING BBVA NET .................");
	}

	@Override
	public void preRender(ComponentSystemEvent event) {
		this.selectedProduct = null;
	}

	@Override
	public GlobalProductsDTO getCustomerProducts() {

		final GlobalProductsDTO globalProductos = this.globalPositionFacade.getGlobalProductsByUser(getCurrentUser());

		situationGraphicPieUI = graphicPieDelegate.getSituationGlobalProducts(globalProductos);
		return globalProductos;
	}

	public void renderPieSituation() {
		this.activePanel = ActivePanelType.SITUATION;
		executeScript("initChart();");
	}

	public void renderPieAssets() {
		this.activePanel = ActivePanelType.ASSET;
		executeScript("initChart();");
	}

	public void renderPieFinanciation() {
		this.activePanel = ActivePanelType.FINANCIATION;
		executeScript("initChart();");
	}

	public void onAccountSelected(final SelectEvent selectEvent) {
		System.out.print("hooola");
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
	 * @return the selectedProduct
	 */
	public AccountDTO getSelectedProduct() {
		return selectedProduct;
	}

	/**
	 * @param selectedProduct the selectedProduct to set
	 */
	public void setSelectedProduct(AccountDTO selectedProduct) {
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

	public void setSelectAccount(final AccountDTO account) {
		this.selectedProduct = account;
	}

	public AccountDTO getSelectAccount() {
		return this.selectedProduct;
	}

	@Override
	public GlobalProductsDTO getCustomerProductsNotVisible() {
		final GlobalProductsDTO globalProductos = this.globalPositionFacade.getGlobalProductsByUserVisible(
				getCurrentUser(), false);

		return globalProductos;
	}

	@Override
	public GlobalProductsDTO getCustomerProductsVisible() {
		final GlobalProductsDTO globalProductos = this.globalPositionFacade.getGlobalProductsByUserVisible(
				getCurrentUser(), true);

		return globalProductos;
	}

}
