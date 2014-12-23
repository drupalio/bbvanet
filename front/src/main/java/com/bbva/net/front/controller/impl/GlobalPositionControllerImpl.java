package com.bbva.net.front.controller.impl;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.event.SelectEvent;
import org.springframework.stereotype.Controller;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.accounts.AccountsPieUI;
import com.bbva.net.front.ui.globalposition.SituationPiesUI;

@Controller(value = "globalPositionController")
public class GlobalPositionControllerImpl extends AbstractBbvaController implements GlobalPositionController {

	private static final long serialVersionUID = 5726824668267606699L;

	private String selectedLike;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	private GlobalProductsDTO globalProductsDTO;

	private SituationPiesUI situationGraphicPieUI;

	private AccountsPieUI investmentFundsPieUI;

	private ActivePanelType activePanel = ActivePanelType.SITUATION;

	private Map<EnumProductType, Money> totalsProducts;

	private enum ActivePanelType {

		SITUATION, ASSET, FINANCIATION
	}

	@PostConstruct
	public void init() {

		LOGGER.info("STARTING BBVA NET .................");

		// Get GlobalProductsDTO by currentUser (visibles and hidden)
		this.globalProductsDTO = this.globalPositionFacade.getGlobalProductsByUser(getCurrentUser());

		// Calculate situation graphics panels
		this.situationGraphicPieUI = graphicPieDelegate.getSituationGlobalProducts(this.globalProductsDTO);

		// Calculate investmentFunds graphics panels
		this.investmentFundsPieUI = graphicPieDelegate.getAccountsfundsProducts(this.globalProductsDTO);

		// Calculate totals
		this.totalsProducts = this.globalPositionFacade.getTotalsByProduct(globalProductsDTO);

	}

	@Override
	public void preRender(final ComponentSystemEvent event) {
		this.selectedProduct = null;
	}

	@Override
	public GlobalProductsDTO getCustomerProducts() {
		return this.globalPositionFacade.getGlobalProductsVisibles(globalProductsDTO);
	}

	@Override
	public GlobalProductsDTO getCustomerProductsHidden() {
		return this.globalPositionFacade.getGlobalProductsHidden(globalProductsDTO);
	}

	@Override
	public void renderPieSituation() {
		this.activePanel = ActivePanelType.SITUATION;
		initChart();
	}

	@Override
	public void renderPieAssets() {
		this.activePanel = ActivePanelType.ASSET;
		initChart();
	}

	@Override
	public void renderPieFinanciation() {
		this.activePanel = ActivePanelType.FINANCIATION;
		initChart();
	}

	public void onAccountSelected(final SelectEvent selectEvent) {
		System.out.print("hooola");
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
	 * @return
	 */
	@Override
	public Map<EnumProductType, Money> getTotalsProducts() {
		return totalsProducts;
	}

	/**
	 * @param selectedLike the selectedLike to set
	 */
	public void setSelectedLike(final String selectedLike) {
		this.selectedLike = selectedLike;
	}

	/**
	 * 
	 */
	public void initChart() {
		executeScript("initChart();");
	}

	public AccountsPieUI getInvestmentFundsPieUI() {
		return investmentFundsPieUI;
	}

	public void setInvestmentFundsPieUI(AccountsPieUI investmentFundsPieUI) {
		this.investmentFundsPieUI = investmentFundsPieUI;
	}

	/************************************* SETTER BEANS **************************************/

	public void setGlobalPositionFacade(final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	public void setGraphicPieDelegate(GraphicPieDelegate graphicPieDelegate) {
		this.graphicPieDelegate = graphicPieDelegate;
	}

}
