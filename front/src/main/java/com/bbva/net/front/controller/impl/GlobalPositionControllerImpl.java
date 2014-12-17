package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.event.SelectEvent;
import org.springframework.stereotype.Controller;

import co.com.bbva.services.transactions.globalposition.schema.Account;
import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.SituationPiesUI;

@Controller(value = "globalPositionController")
public class GlobalPositionControllerImpl extends AbstractBbvaController implements GlobalPositionController {

	private static final long serialVersionUID = 5726824668267606699L;

	private String selectedLike;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	private SituationPiesUI situationGraphicPieUI;

	private Account selectedAccount;

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
		this.selectedAccount = null;
	}

	@Override
	public GlobalProducts getCustomerProducts() {

		final GlobalProducts globalProductos = this.globalPositionFacade.getGlobalProductsByUser(getCurrentUser());
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

	public void setSelectAccount(final Account account) {
		this.selectedAccount = account;
	}

	public Account getSelectAccount() {
		return this.selectedAccount;
	}

	@Override
	public GlobalProducts getCustomerProductsVisible() {
		final GlobalProducts globalProductos = this.globalPositionFacade.getGlobalProductsByUserVisible(
				getCurrentUser(), true);
		situationGraphicPieUI = graphicPieDelegate.getSituationGlobalProducts(globalProductos);
		return globalProductos;
	}

	@Override
	public GlobalProducts getCustomerProductsNotVisible() {
		final GlobalProducts globalProductos = this.globalPositionFacade.getGlobalProductsByUserVisible(
				getCurrentUser(), false);

		return globalProductos;

	}

}
