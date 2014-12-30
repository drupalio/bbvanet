package com.bbva.net.front.controller.impl;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;

import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.GlobalMovementsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.BalanceDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;
import com.bbva.net.front.ui.globalposition.SituationPiesUI;
import com.bbva.net.front.ui.pie.PieConfigUI;

@ManagedBean
@ViewScoped
public class GlobalPositionControllerImpl extends AbstractBbvaController implements GlobalPositionController {

	private static final long serialVersionUID = 5726824668267606699L;

	private String selectedLike;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	@Resource(name = "globalMovementsFacade")
	private transient GlobalMovementsFacade globalMovementsFacade;

	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	@Resource(name = "graphicBarLineDelegate")
	private transient GraphicBarLineDelegate graphicBarLineDelegate;

	private GlobalProductsDTO globalProductsDTO;

	private SituationPiesUI situationGraphicPieUI;

	private PieConfigUI graphicPieInvestmentFunds;

	private AccountBarLineUI accountGraphicBarLineUI;

	private PieConfigUI graphicPieProducts;

	private ActivePanelType activePanel = ActivePanelType.SITUATION;

	private Map<String, BalanceDTO> totalsProducts;

	private enum ActivePanelType {

		SITUATION, ASSET, FINANCIATION
	}

	@PostConstruct
	public void init() {

		LOGGER.info("STARTING BBVA NET .................");

		// Get GlobalProductsDTO by currentUser (visibles and hidden)
		this.globalProductsDTO = this.globalPositionFacade.getGlobalProductsByUser(getCurrentUser());

		// Obtiene la lista de resumen de movimientos del serivico REST
		// this.globalMovementsFacade.getGlobalMovements();

		// Calculate situation graphics panels
		this.situationGraphicPieUI = graphicPieDelegate.getSituationGlobalProducts(this.globalProductsDTO);

		// Calculate investmentFunds graphics panels
		this.graphicPieInvestmentFunds = graphicPieDelegate.getAccountsfundsProducts(this.globalProductsDTO);

		// Calculate situation graphics panels
		this.graphicPieProducts = graphicPieDelegate.getGeneralGraphicConfig(this.globalProductsDTO);

		// Calculate totals
		this.totalsProducts = this.globalPositionFacade.getTotalsByProduct(globalProductsDTO);

		// Calculate income, output and balance by Account Graphic
		// Acualmente obtiene el objeto Ui quemado en el delegate
		this.accountGraphicBarLineUI = this.graphicBarLineDelegate.getInOutBalanceByAccount();

	}

	@Override
	public void preRender(final ComponentSystemEvent event) {

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

	public String getActivePanel() {
		return this.activePanel.name();
	}

	public SituationPiesUI getSituationGraphicPieUI() {
		return situationGraphicPieUI;
	}

	public AccountBarLineUI getAccountGraphicBarLineUI() {
		return accountGraphicBarLineUI;
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
	public Map<String, BalanceDTO> getTotalsProducts() {
		return totalsProducts;
	}

	/**
	 * @param selectedLike the selectedLike to set
	 */
	public void setSelectedLike(final String selectedLike) {
		this.selectedLike = selectedLike;
	}

	/**
	 * @return
	 */
	public PieConfigUI getGraphicPieProducts() {
		return graphicPieProducts;
	}

	/**
	 * @param graphicPieProducts
	 */
	public void setGraphicPieProducts(PieConfigUI graphicPieProducts) {
		this.graphicPieProducts = graphicPieProducts;
	}

	/**
	 * 
	 */
	public void initChart() {
		executeScript("initChart();");
	}

	@Override
	public void onProductSelected(SelectEvent selectEvent) {
		super.onProductSelected(selectEvent);
		this.sendAction("accountSelected");

	}

	/************************************* SETTER BEANS **************************************/

	public void setGlobalPositionFacade(final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	public void setGraphicPieDelegate(GraphicPieDelegate graphicPieDelegate) {
		this.graphicPieDelegate = graphicPieDelegate;
	}

	public void setGraphicBarLineDelegate(GraphicBarLineDelegate graphicBarLineDelegate) {
		this.graphicBarLineDelegate = graphicBarLineDelegate;
	}

	public PieConfigUI getGraphicPieInvestmentFunds() {
		return graphicPieInvestmentFunds;
	}

	public void setGraphicPieInvestmentFunds(PieConfigUI graphicPieInvestmentFunds) {
		this.graphicPieInvestmentFunds = graphicPieInvestmentFunds;

	}

}
