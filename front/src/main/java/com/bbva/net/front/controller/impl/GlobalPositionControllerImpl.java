package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;

import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.facade.FundsTypeFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.FundDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.facade.MovementsResumeFacade;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.helper.MessagesHelper;
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

	@Resource(name = "fundsTypeFacade")
	private transient FundsTypeFacade fundsTypeFacade;
	
	@Resource(name = "cardsFacade")
	private transient CardsFacade cardsFacade;

	@Resource(name = "globalMovementsFacade")
	private transient MovementsResumeFacade movementsResumeFacade;

	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	@Resource(name = "graphicBarLineDelegate")
	private transient GraphicBarLineDelegate graphicBarLineDelegate;

	private GlobalProductsDto globalProductsDTO;

	private List<FundDto> fundDTOs;

	private SituationPiesUI situationGraphicPieUI;

	private PieConfigUI graphicPieInvestmentFunds;

	private GlobalResumeMovementsDto globalResumeMovementsDTO;

	private AccountBarLineUI accountGraphicBarLineUI;

	private PieConfigUI graphicPieCards;

	private ActivePanelType activePanel = ActivePanelType.SITUATION;

	private Map<String, BalanceDto> totalsProducts;

	private Map<String, List<String>> namesProducts;
	
	private String datos;

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	private enum ActivePanelType {

		SITUATION, ASSET, FINANCIATION
	}

	@PostConstruct
	public void init() {

		LOGGER.info("STARTING BBVA NET .................");

		// Get GlobalProductsDTO by currentUser (visibles and hidden)
		this.globalProductsDTO = this.globalPositionFacade.getGlobalProductsByUser(getCurrentUser());

		this.fundDTOs = this.fundsTypeFacade.getFundsDataGraphic(getCurrentUser());

		// Obtiene la lista de resumen de movimientos del serivico REST
		this.globalResumeMovementsDTO = this.movementsResumeFacade.getMovementsResumeByeCustomer(getCurrentUser());

		// Calculate situation graphics panels
		this.situationGraphicPieUI = graphicPieDelegate.getSituationGlobalProducts(this.globalProductsDTO);

		// Calculate investmentFunds graphics panels
		this.graphicPieInvestmentFunds = graphicPieDelegate.getAccountsfundsProducts(this.fundDTOs);

		// Calculate situation graphics panels
		this.graphicPieCards=graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(getCurrentUser()));

		// Calculate totals
		this.totalsProducts = this.globalPositionFacade.getTotalsByProduct(globalProductsDTO);

		// Calculate income, output and balance by Account Graphic
		// Acualmente obtiene el objeto Ui quemado en el delegate

		this.accountGraphicBarLineUI = this.graphicBarLineDelegate.getInOutBalanceByAccount(globalResumeMovementsDTO);

		// Get names of products
		this.namesProducts = globalPositionFacade.getNamesProducts(globalProductsDTO);

	}

	@Override
	public void preRender(final ComponentSystemEvent event) {
		
	}

	@Override
	public GlobalProductsDto getCustomerProducts() {
		return this.globalPositionFacade.getGlobalProductsVisibles(globalProductsDTO);
	}

	@Override
	public GlobalProductsDto getCustomerProductsHidden() {
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
	public Map<String, BalanceDto> getTotalsProducts() {
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
	public PieConfigUI getGraphicPieCards() {
		return graphicPieCards;
	}

	/**
	 * @param graphicPieCards
	 */
	public void setGraphicPieCards(PieConfigUI graphicPieCards) {
		this.graphicPieCards = graphicPieCards;
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
	/**
	 * Filter combo of Cards
	 */
	public void onComboSelectedCard() {
		System.out.println("Seleciona combo tarjetas"+datos);
		if(datos.equals(MessagesHelper.INSTANCE.getString("text.allCards"))){
			//this.graphicPieCards=graphicPieDelegate.getCardGraphicByUser(getCurrentUser());
			this.graphicPieCards=graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(getCurrentUser()));
		}else{
			//this.graphicPieCards = graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesFilter(getCurrentUser(),"",""));
			this.graphicPieCards = graphicPieDelegate.getAccountsfundsProducts(this.fundDTOs);
		}
	}
	public void onComboSelectedAccount() {
		System.out.println("Seleciona combo cuentas"+datos);
		this.accountGraphicBarLineUI = this.graphicBarLineDelegate.getInOutBalanceByAccount(globalResumeMovementsDTO);
	}
	
	public List<String> periodGraphics(){
		final List<String> period= new ArrayList<String>();
		period.add("Últimos 12 meses");
		period.add("Últimos 6 meses");
		period.add("Últimos 3 meses");
		period.add("Últimos mes");
		return period;
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

	/**
	 * @return the fundDTOs
	 */
	public List<FundDto> getFundDTOs() {
		return fundDTOs;
	}

	/**
	 * @param fundDTOs the fundDTOs to set
	 */
	public void setFundDTOs(List<FundDto> fundDTOs) {
		this.fundDTOs = fundDTOs;
	}

	public void setGraphicPieInvestmentFunds(PieConfigUI graphicPieInvestmentFunds) {
		this.graphicPieInvestmentFunds = graphicPieInvestmentFunds;

	}

	public void setMovementsResumeFacade(final MovementsResumeFacade movementsResumeFacade) {
		this.movementsResumeFacade = movementsResumeFacade;
	}

	/**
	 * @return the fundsTypeFacade
	 */
	public FundsTypeFacade getFundsTypeFacade() {
		return fundsTypeFacade;
	}

	/**
	 * @param fundsTypeFacade the fundsTypeFacade to set
	 */
	public void setFundsTypeFacade(FundsTypeFacade fundsTypeFacade) {
		this.fundsTypeFacade = fundsTypeFacade;
	}

	public Map<String, List<String>> getNamesProducts() {
		return namesProducts;
	}
}
