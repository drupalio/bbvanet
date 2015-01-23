package com.bbva.net.front.controller.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ComponentSystemEvent;

import org.apache.commons.lang.StringUtils;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.facade.FundsTypeFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.MovementsResumeFacade;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.FundDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;
import com.bbva.net.front.ui.globalposition.SituationPiesUI;
import com.bbva.net.front.ui.pie.PieConfigUI;

/**
 * @author Entelgy
 */
public class GlobalPositionControllerImpl extends AbstractBbvaController implements GlobalPositionController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5726824668267606699L;

	/**
	 * 
	 */
	private String selectedLike;

	/**
	 * 
	 */
	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	/**
	 * 
	 */
	@Resource(name = "fundsTypeFacade")
	private transient FundsTypeFacade fundsTypeFacade;

	/**
	 * 
	 */
	@Resource(name = "cardsFacade")
	private transient CardsFacade cardsFacade;

	/**
	 * 
	 */
	@Resource(name = "globalMovementsFacade")
	private transient MovementsResumeFacade movementsResumeFacade;

	/**
	 * 
	 */
	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	/**
	 * 
	 */
	@Resource(name = "graphicBarLineDelegate")
	private transient GraphicBarLineDelegate graphicBarLineDelegate;

	/**
	 * 
	 */
	private GlobalProductsDto globalProductsDTO;

	/**
	 * 
	 */
	private List<FundDto> fundDTOs;

	/**
	 * 
	 */
	private SituationPiesUI situationGraphicPieUI;

	/**
	 * 
	 */
	private PieConfigUI graphicPieInvestmentFunds;

	/**
	 * 
	 */

	private GlobalResumeMovementsDto globalResumeMovementsDTO;

	/**
	 * 
	 */
	private AccountBarLineUI accountGraphicBarLineUI;

	/**
	 * 
	 */
	private PieConfigUI graphicPieCards;

	/**
	 * 
	 */
	private ActivePanelType activePanel = ActivePanelType.SITUATION;

	/**
	 * 
	 */
	private Map<String, BalanceDto> totalsProducts;

	/**
	 * 
	 */
	private Map<String, List<String>> namesProducts;

	/**
	 * periodo seleccionado en grafica de cuentas
	 */
	private String periodAccountSelected = StringUtils.EMPTY;

	/**
	 * producto seleccionado en grafica de cuentas
	 */
	private String accountSelected = StringUtils.EMPTY;

	/**
	 * 
	 */
	private String periodCardSelected = "0";

	/**
	 * 
	 */
	private String cardSelected = "";

	/**
	 * @author Entelgy
	 */
	private enum ActivePanelType {

		SITUATION, ASSET, FINANCIATION
	}

	/**
	 * 
	 */
	@PostConstruct
	public void init() {

		LOGGER.info("STARTING BBVA NET .................");

		// Get GlobalProductsDTO by currentUser (visibles and hidden)
		this.globalProductsDTO = this.globalPositionFacade.getGlobalProductsByUser(getCurrentUser());

		this.fundDTOs = this.fundsTypeFacade.getFundsDataGraphic(getCurrentUser());

		// Obtiene la lista de resumen de movimientos del serivico REST
		this.globalResumeMovementsDTO = this.movementsResumeFacade.getMovementsResumeByCustomer(getCurrentUser(), null);

		// Calculate situation graphics panels
		this.situationGraphicPieUI = graphicPieDelegate.getSituationGlobalProducts(this.globalProductsDTO);

		// Calculate investmentFunds graphics panels
		this.graphicPieInvestmentFunds = graphicPieDelegate.getAccountsfundsProducts(this.fundDTOs);

		// Calculate situation graphics panels
		this.graphicPieCards = graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(getCurrentUser(),
				null));

		// Calculate totals
		this.totalsProducts = this.globalPositionFacade.getTotalsByProduct(globalProductsDTO);

		// Calculate income, output and balance by Account Graphic
		// Acualmente obtiene el objeto Ui quemado en el delegate
		this.accountGraphicBarLineUI = this.graphicBarLineDelegate.getInOutBalanceAccount(globalResumeMovementsDTO);

		// Get names of products
		this.namesProducts = globalPositionFacade.getNamesProducts(globalProductsDTO);

	}

	/**
	 * 
	 */
	@Override
	public void preRender(final ComponentSystemEvent event) {

	}

	/**
	 * 
	 */
	@Override
	public GlobalProductsDto getCustomerProducts() {
		return this.globalPositionFacade.getGlobalProductsVisibles(globalProductsDTO);
	}

	/**
	 * 
	 */
	@Override
	public GlobalProductsDto getCustomerProductsHidden() {
		return this.globalPositionFacade.getGlobalProductsHidden(globalProductsDTO);
	}

	/**
	 * 
	 */
	@Override
	public void renderPieSituation() {
		this.activePanel = ActivePanelType.SITUATION;
		initChart();
	}

	/**
	 * 
	 */
	@Override
	public void renderPieAssets() {
		this.activePanel = ActivePanelType.ASSET;
		initChart();
	}

	/**
	 * 
	 */
	@Override
	public void renderPieFinanciation() {
		this.activePanel = ActivePanelType.FINANCIATION;
		initChart();
	}

	/**
	 * @return
	 */
	public String getActivePanel() {
		return this.activePanel.name();
	}

	/**
	 * @return
	 */
	public SituationPiesUI getSituationGraphicPieUI() {
		return situationGraphicPieUI;
	}

	/**
	 * @return
	 */
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
	public void setGraphicPieCards(final PieConfigUI graphicPieCards) {
		this.graphicPieCards = graphicPieCards;
	}

	/**
	 * 
	 */
	public void initChart() {
		executeScript("initChart();");
	}

	/**
	 * 
	 */
	@Override
	public void onProductSelected(final SelectEvent selectEvent) {
		super.onProductSelected(selectEvent);
		this.sendAction("accountSelected");

	}

	/**
	 * Filter combo of Graphic Cards
	 */
	public void onComboSelectedCard() {

		DateRangeDto dateRange = null;
		if (!periodCardSelected.equals("0")) {
			final EnumPeriodType periodType = EnumPeriodType.valueOf(Integer.parseInt(this.periodCardSelected));
			dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		}

		if (MessagesHelper.INSTANCE.getString("text.allCards").equals(cardSelected)) {
			this.graphicPieCards = graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(
					getCurrentUser(), dateRange));
		} else {

			this.graphicPieCards = graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesFilter(cardSelected,
					dateRange));
		}
	}

	/**
	 * Captura la acción de los combo filtro en gráfica cuentas.
	 */
	public void onComboSelectedAccountGraphic() {

		final EnumPeriodType periodType = StringUtils.isNotEmpty(periodAccountSelected) ? EnumPeriodType
				.valueOf(Integer.parseInt(this.periodAccountSelected)) : null;

		final DateRangeDto dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);

		// Consume Servicio Accounts
		if (!StringUtils.isEmpty(accountSelected)
				&& !MessagesHelper.INSTANCE.getString("text.allAccounts").equals(accountSelected)) {

			this.globalResumeMovementsDTO = this.movementsResumeFacade.getMovementsResumeByAccount(DEFAULT_ACCOUNT,
					dateRange, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);
			// this.globalResumeMovementsDTO = this.movementsResumeFacade.getMovementsResumeByAccount(accountSelected);
			this.accountGraphicBarLineUI = this.graphicBarLineDelegate.getInOutBalanceAccount(globalResumeMovementsDTO);
		}
		// Cosume Servicio Customer
		if (!StringUtils.isEmpty(periodAccountSelected)
				&& MessagesHelper.INSTANCE.getString("text.allAccounts").equals(accountSelected)) {

			this.accountGraphicBarLineUI = this.graphicBarLineDelegate.getInOutBalanceAccount(movementsResumeFacade
					.getMovementsResumeByCustomer(getCurrentUser(), dateRange));

		}

	}

	/************************************* SETTER BEANS **************************************/

	/**
	 * @param globalPositionFacade
	 */
	public void setGlobalPositionFacade(final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	/**
	 * @param graphicPieDelegate
	 */
	public void setGraphicPieDelegate(final GraphicPieDelegate graphicPieDelegate) {
		this.graphicPieDelegate = graphicPieDelegate;
	}

	/**
	 * @param graphicBarLineDelegate
	 */
	public void setGraphicBarLineDelegate(final GraphicBarLineDelegate graphicBarLineDelegate) {
		this.graphicBarLineDelegate = graphicBarLineDelegate;
	}

	/**
	 * @return
	 */
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

	/**
	 * @param graphicPieInvestmentFunds
	 */
	public void setGraphicPieInvestmentFunds(final PieConfigUI graphicPieInvestmentFunds) {
		this.graphicPieInvestmentFunds = graphicPieInvestmentFunds;

	}

	/**
	 * @param movementsResumeFacade
	 */
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
	public void setFundsTypeFacade(final FundsTypeFacade fundsTypeFacade) {
		this.fundsTypeFacade = fundsTypeFacade;
	}

	/**
	 * @return
	 */
	public Map<String, List<String>> getNamesProducts() {
		return namesProducts;
	}

	/**
	 * @param cardsFacade
	 */
	public void setCardsFacade(final CardsFacade cardsFacade) {
		this.cardsFacade = cardsFacade;
	}

	/**
	 * @return
	 */
	public String getPeriodCardSelected() {
		return periodCardSelected;
	}

	/**
	 * @param periodCardSelected
	 */
	public void setPeriodCardSelected(final String periodCardSelected) {
		this.periodCardSelected = periodCardSelected;
	}

	/**
	 * @return
	 */
	public String getPeriodAccountSelected() {
		return periodAccountSelected;
	}

	/**
	 * @param periodAccountSelected
	 */
	public void setPeriodAccountSelected(final String periodAccountSelected) {
		this.periodAccountSelected = periodAccountSelected;
	}

	/**
	 * @return
	 */
	public String getCardSelected() {
		return cardSelected;
	}

	/**
	 * @param cardSelected
	 */
	public void setCardSelected(final String cardSelected) {
		this.cardSelected = cardSelected;
	}

	/**
	 * @return
	 */
	public String getAccountSelected() {
		return accountSelected;
	}

	/**
	 * @param accountSelected
	 */
	public void setAccountSelected(final String accountSelected) {
		this.accountSelected = accountSelected;
	}

}
