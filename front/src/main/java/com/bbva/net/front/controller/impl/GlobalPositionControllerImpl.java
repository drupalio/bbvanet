package com.bbva.net.front.controller.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.event.ComponentSystemEvent;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.AccountMovementsResumeFacade;
import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.MonthBalanceFacade;
import com.bbva.net.back.model.accounts.GlobalMonthlyBalanceDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;
import com.bbva.net.front.ui.globalposition.SituationPiesUI;
import com.bbva.net.front.ui.line.LineConfigUI;
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
	@Resource(name = "cardsFacade")
	private transient CardsFacade cardsFacade;

	/**
	 * 
	 */
	@Resource(name = "accountMovementsFacade")
	private transient AccountMovementsResumeFacade movementsResumeFacade;

	/**
	 * 
	 */
	@Resource(name = "monthBalanceFacade")
	private transient MonthBalanceFacade accountMonthBalanceFacade;

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
	@Resource(name = "graphicLineDelegate")
	private transient GraphicLineDelegate graphicLineDelegate;

	/**
	 * 
	 */
	private GlobalProductsDto globalProductsDTO;

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
	private GlobalMonthlyBalanceDto globalMonthlyBalance;

	/**
	 * 
	 */
	private LineConfigUI lineConfigUI;

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
	 * periodo selecionado en grafica de tarjetas
	 */
	private String periodCardSelected = StringUtils.EMPTY;

	/**
	 * producto seleccionado en grafica de tarjetas
	 */
	private String cardSelected = StringUtils.EMPTY;

	/**
	 * @author Entelgy
	 */
	private enum ActivePanelType {

		SITUATION, ASSET, FINANCIATION
	}

	/**
	 * 
	 */
	public void init() {

		try {

			LOGGER.info("STARTING BBVA GLOBAL POSITION .................");
			// Get GlobalProductsDTO by currentUser (visibles and hidden)
			this.globalProductsDTO = this.globalPositionFacade.getGlobalProductsByUser();

			LOGGER.info("Calculando totales................");
			// Calculate totals
			this.totalsProducts = this.globalPositionFacade.getTotalsByProduct(globalProductsDTO);

			LOGGER.info("Calculando Gráfica Tu Situación ................");
			// Calculate situation graphics panels
			this.situationGraphicPieUI = graphicPieDelegate.getSituationGlobalProducts(this.globalProductsDTO);

			LOGGER.info("Calculando Gráfica de Fondos ................");
			// Calculate investmentFunds graphics panels
			this.graphicPieInvestmentFunds = graphicPieDelegate.getAccountsfundsProducts(globalProductsDTO);

			LOGGER.info("Nombre Productos  ................");
			this.namesProducts = globalPositionFacade.getNamesProducts(globalProductsDTO);

			LOGGER.info("Obteniendo Tarjetas y calculando gráfica ................");

			try {
				// Calculate cards graphics panel
				this.graphicPieCards = graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(null));
			} catch (final Exception exception) {
				exception.printStackTrace();
			}
			LOGGER.info("Obteniendo la lista de resumen de movimientos................");

			try {
				// Obtiene la lista de resumen de movimientos del serivico REST
				this.globalResumeMovementsDTO = this.movementsResumeFacade.getMovementsResumeByCustomer(null);
			} catch (final Exception exception) {
				exception.printStackTrace();
			}

			LOGGER.info("Obteniendo Monthly Balances ................");

			try {

				if (!CollectionUtils.isEmpty(globalProductsDTO.getElectronicDeposits())) {

					// Delegate construye UI grafica Depositos Electrónicos
					// this.lineConfigUI = this.graphicLineDelegate.getMonthlyBalance(globalMonthlyBalance);
					// Obtiene la lista de datos para pintar la grafica Deposito electrónico
					this.globalMonthlyBalance = this.accountMonthBalanceFacade.getAccountMonthlyBalance(
							globalProductsDTO.getElectronicDeposits().get(0).getProductId(), new DateRangeDto(),
							StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);

					// Delegate construye UI grafica Depositos Electrónicos
					this.lineConfigUI = this.graphicLineDelegate.getMonthlyBalance(globalMonthlyBalance);
				}

			} catch (final Exception exception) {
				exception.printStackTrace();
			}
			LOGGER.info("Calculando gráfica de cuentas ................");
			// Calculate income, output and balance by Account Graphic
			this.accountGraphicBarLineUI = this.graphicBarLineDelegate.getInOutBalanceAccount(globalResumeMovementsDTO);

		} catch (final Exception exception) {
			LOGGER.info("HA HABIDO UNA EXCEPTION EN GLOBAL POSITION");
			exception.printStackTrace();
		}

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

	@Override
	public void onProductLoanSelected(final SelectEvent selectEvent) {
		super.onProductSelected(selectEvent);
		this.sendAction("loanSelected");
	}

	/**
	 * Filter combo of Graphic Cards
	 */
	public void onComboSelectedCard() {

		EnumPeriodType periodType = null;
		if (!this.periodCardSelected.isEmpty()) {
			periodType = EnumPeriodType.valueOf(Integer.parseInt(this.periodCardSelected));
		} else {
			periodType = EnumPeriodType.valueOf(EnumPeriodType.LAST_TWELVE_MONTH.getPeriodId());
		}
		DateRangeDto dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);

		if (MessagesHelper.INSTANCE.getString("text.allCards").equals(cardSelected) || cardSelected.isEmpty()) {
			cardSelected = MessagesHelper.INSTANCE.getString("text.allCards");
			this.graphicPieCards = graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(dateRange));
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
			// this.globalResumeMovementsDTO =
			// this.movementsResumeFacade.getMovementsResumeByAccount(accountSelected);
			this.accountGraphicBarLineUI = this.graphicBarLineDelegate.getInOutBalanceAccount(globalResumeMovementsDTO);
		}
		// Cosume Servicio Customer
		if (!StringUtils.isEmpty(periodAccountSelected)
				&& MessagesHelper.INSTANCE.getString("text.allAccounts").equals(accountSelected)) {

			this.accountGraphicBarLineUI = this.graphicBarLineDelegate.getInOutBalanceAccount(movementsResumeFacade
					.getMovementsResumeByCustomer(dateRange));

		}

	}

	/**
	 * Enmascara el número de tarjeta
	 * 
	 * @param number
	 * @return
	 */
	public String maskCardsNumber(final String number) {
		String mask = "";
		for (int i = 0; i < number.length() - 4; i++) {
			if (i % 4 == 0) mask += " ";
			mask += "*";
		}
		return mask + " " + number.substring(number.length() - 4, number.length());
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
	 * @param graphicLineDelegate
	 */
	public void setGraphicLineDelegate(final GraphicLineDelegate graphicLineDelegate) {
		this.graphicLineDelegate = graphicLineDelegate;
	}

	/**
	 * @return
	 */
	public PieConfigUI getGraphicPieInvestmentFunds() {
		return graphicPieInvestmentFunds;
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
	public void setMovementsResumeFacade(final AccountMovementsResumeFacade movementsResumeFacade) {
		this.movementsResumeFacade = movementsResumeFacade;
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

	/**
	 * @param accountMonthBalanceFacade
	 */
	public void setAccountMonthBalanceFacade(final MonthBalanceFacade accountMonthBalanceFacade) {
		this.accountMonthBalanceFacade = accountMonthBalanceFacade;
	}

	/**
	 * @return globalMonthlyBalance
	 */
	public GlobalMonthlyBalanceDto getGlobalMonthlyBalance() {
		return globalMonthlyBalance;
	}

	/**
	 * @return lineConfigUI
	 */
	public LineConfigUI getLineConfigUI() {
		return lineConfigUI;
	}

}
