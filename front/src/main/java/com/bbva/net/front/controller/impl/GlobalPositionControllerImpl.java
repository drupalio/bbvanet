package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.apache.commons.lang.StringUtils;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.AccountMovementsResumeFacade;
import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.MonthBalanceFacade;
import com.bbva.net.back.model.accounts.GlobalMonthlyBalanceDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.model.movements.MovementsResumeDto;
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
	public enum ActivePanelType {

		SITUATION, ASSET, FINANCIATION
	}

	/**
	 * 
	 */
	public void init() {

		LOGGER.info("STARTING BBVA GLOBAL POSITION .................");

		try {
			// Get GlobalProductsDTO by currentUser (visibles and hidden)
			this.globalProductsDTO = this.globalPositionFacade.getGlobalProductsByUser();
		} catch (Exception e) {
			// FacesContext ctx = FacesContext.getCurrentInstance();
			// ctx.addMessage("GlobalProductsDTO", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
			this.globalProductsDTO = new GlobalProductsDto();
		}
		// Obtiene la lista de resumen de movimientos del serivico REST
		try {
			this.globalResumeMovementsDTO = this.movementsResumeFacade.getMovementsResumeByCustomer(new DateRangeDto());
		} catch (Exception e) {
			// FacesContext ctx = FacesContext.getCurrentInstance();
			// ctx.addMessage("GlobalResumeMovementsDto ",
			// new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
			this.globalResumeMovementsDTO = new GlobalResumeMovementsDto();
			this.globalResumeMovementsDTO.setMovementsResumeDto(new ArrayList<MovementsResumeDto>());
		}
		// Obtiene la lista de datos para pintar la grafica Deposito electrónico
		if (globalProductsDTO.getElectronicDeposits().size() > 0) {
			try {
				this.globalMonthlyBalance = this.accountMonthBalanceFacade.getAccountMonthlyBalance(globalProductsDTO
						.getElectronicDeposits().get(0).getProductNumber(), new DateRangeDto(), StringUtils.EMPTY,
						StringUtils.EMPTY, StringUtils.EMPTY);
				// Delegate construye UI grafica Depositos Electrónicos
				this.lineConfigUI = this.graphicLineDelegate.getMonthlyBalance(globalMonthlyBalance);
			} catch (Exception e) {
				// FacesContext ctx = FacesContext.getCurrentInstance();
				// ctx.addMessage("globalMonthlyBalance ",
				// new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
				this.globalMonthlyBalance = new GlobalMonthlyBalanceDto();
				this.lineConfigUI = new LineConfigUI();
			}
		}

		// Calculate situation graphics panels
		this.situationGraphicPieUI = graphicPieDelegate.getSituationGlobalProducts(this.globalProductsDTO);

		// Calculate investmentFunds graphics panels
		this.graphicPieInvestmentFunds = graphicPieDelegate.getAccountsfundsProducts(globalProductsDTO);

		try {
			// Calculate cards graphics panel
			this.graphicPieCards = graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(null));
		} catch (Exception e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage(
					"graphicPieCards ",
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Error",
							"Servicio no disponible - No se han podido cargar algunos datos, para mayor información comunicate a nuestras líneas BBVA"));
			this.graphicPieCards = new PieConfigUI();
			// Verifica si en el mensaje de error existe la palabra tsec
		}
		// Calculate totals
		this.totalsProducts = this.globalPositionFacade.getTotalsByProduct(globalProductsDTO);

		// Calculate income, output and balance by Account Graphic
		this.accountGraphicBarLineUI = this.graphicBarLineDelegate.getInOutBalanceAccount(globalResumeMovementsDTO);

		// Get names of products
		this.namesProducts = globalPositionFacade.getNamesProducts(globalProductsDTO);

	}

	/**
	 * @return
	 */
	public GlobalPositionFacade getGlobalPositionFacade() {
		return globalPositionFacade;
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
	 * @param lineConfigUI
	 */
	public void setLineConfigUI(final LineConfigUI lineConfigUI) {
		this.lineConfigUI = lineConfigUI;
	}

	/**
	 * @param accountGraphicBarLineUI
	 */
	public void setAccountGraphicBarLineUI(final AccountBarLineUI accountGraphicBarLineUI) {
		this.accountGraphicBarLineUI = accountGraphicBarLineUI;
	}

	/**
	 * @param globalMonthlyBalance
	 */
	public void setGlobalMonthlyBalance(final GlobalMonthlyBalanceDto globalMonthlyBalance) {
		this.globalMonthlyBalance = globalMonthlyBalance;
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
	public ActivePanelType getActivePanelEnum() {
		return this.activePanel;
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
	 * 
	 */
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
			LOGGER.info("Graphic cards Controller periodSelected: " + periodCardSelected);
		} else {
			periodType = EnumPeriodType.valueOf(EnumPeriodType.LAST_SIX_MONTH.getPeriodId());
			LOGGER.info("Graphic cards Controller periodSelected: " + periodCardSelected);
		}
		final DateRangeDto dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);

		if (MessagesHelper.INSTANCE.getString("text.allCards").equals(cardSelected) || cardSelected.isEmpty()) {
			this.cardSelected = MessagesHelper.INSTANCE.getString("text.allCards");
			try {
				LOGGER.info("Graphic cards Controller carSelected: " + cardSelected + "  dateRange:"
						+ dateRange.toString());
				this.graphicPieCards = graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(dateRange));
			} catch (Exception e) {
				FacesContext ctx = FacesContext.getCurrentInstance();
				ctx.addMessage("graphicPieCards",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
				this.graphicPieCards = new PieConfigUI();
			}
		} else {
			try {
				LOGGER.info("Graphic cards Controller carSelected: " + cardSelected + "  dateRange:"
						+ dateRange.toString());
				this.graphicPieCards = graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesFilter(
						cardSelected, dateRange));
			} catch (Exception e) {
				FacesContext ctx = FacesContext.getCurrentInstance();
				ctx.addMessage("graphicPieCards",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
				this.graphicPieCards = new PieConfigUI();
			}
		}
	}

	/**
	 * Captura la acción de los combo filtro en gráfica cuentas.
	 */
	public void onComboSelectedAccountGraphic() {
		final EnumPeriodType periodType = StringUtils.isNotEmpty(periodAccountSelected) ? EnumPeriodType
				.valueOf(Integer.parseInt(this.periodAccountSelected)) : EnumPeriodType
				.valueOf(EnumPeriodType.LAST_SIX_MONTH.getPeriodId());

		final DateRangeDto dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);

		// Consume Servicio Accounts
		if (!StringUtils.isEmpty(accountSelected)
				&& !MessagesHelper.INSTANCE.getString("text.allAccounts").equals(accountSelected)) {
			try {
				this.accountGraphicBarLineUI = this.graphicBarLineDelegate
						.getInOutBalanceAccount(this.movementsResumeFacade.getMovementsResumeByAccount(accountSelected,
								dateRange, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY));
			} catch (Exception e) {
				FacesContext ctx = FacesContext.getCurrentInstance();
				ctx.addMessage("globalResumeMovementsDTO ",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
				this.accountGraphicBarLineUI = new AccountBarLineUI();
			}
		}
		// Cosume Servicio Customer
		if (!StringUtils.isEmpty(periodAccountSelected)
				&& (MessagesHelper.INSTANCE.getString("text.allAccounts").equals(accountSelected))
				|| accountSelected.isEmpty()) {
			try {
				this.accountGraphicBarLineUI = this.graphicBarLineDelegate
						.getInOutBalanceAccount(this.movementsResumeFacade.getMovementsResumeByCustomer(dateRange));
			} catch (Exception e) {
				FacesContext ctx = FacesContext.getCurrentInstance();
				ctx.addMessage("accountGraphicBarLineUI ",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
				this.accountGraphicBarLineUI = new AccountBarLineUI();
			}
		}
	}

	/**
	 * Enmascara el número de tarjeta
	 * 
	 * @param number
	 * @return
	 */
	public String maskCardsNumber(final String number) {
		final StringBuilder mask = new StringBuilder("");
		for (int i = 0; i < number.length() - 4; i++) {
			if (i % 4 == 0) mask.append(" ");
			mask.append("*");
		}
		return mask + " " + number.substring(number.length() - 4, number.length());
	}

	/**
	 * Calcula el total utilizado
	 * 
	 * @param total
	 * @param available
	 * @return
	 */
	public Money getTotalUsedCards(final Money total, final Money available) {

		return new Money(total.getAmount().subtract(available.getAmount()));
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

	/**
	 * @return globalProductsDTO
	 */
	public GlobalProductsDto getGlobalProductsDTO() {
		return globalProductsDTO;
	}

}
