package com.bbva.net.front.controller.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.MovementsAccountFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.MovementCriteriaController;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.line.LineConfigUI;

/**
 * @author User
 */

@Controller(value = "movementsCriteriaController")
@Scope(value = "globalSession")
public class MovementCriteriaControllerImpl extends MovementPaginatedController implements MovementCriteriaController {

	private static final long serialVersionUID = 1L;

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date");

	private static final String BALANCE_TITLE = MessagesHelper.INSTANCE.getString("msg.message.balance");

	private static final String SINCE_TITLE = MessagesHelper.INSTANCE.getString("text.since");

	private static final String TO_TITLE = MessagesHelper.INSTANCE.getString("text.to");

	SimpleDateFormat dateFormat = new SimpleDateFormat(MessagesHelper.INSTANCE.getStringI18("date.pattner.dd.mm.yyyy"));

	private StringBuilder messageBalance;

	private String sinceText, toText, selectDate, sinceDatestr, toDatestr;

	private Date sinceDate, toDate;

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	private BalanceRangeDto balanceRange = null;

	private DateRangeDto dateRange = null;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@Resource(name = "movementsAccountFacade")
	private transient MovementsAccountFacade movementsFacade;

	private List<MovementDto> movementsList = null;

	@Resource(name = "graphicLineDelegate")
	private transient GraphicLineDelegate graphicLineDelegate;

	private LineConfigUI graphicLineMovements;

	private MovementDetailDto movementDetail = null;

	private Map<String, Boolean> renderComponents = new HashMap<String, Boolean>();

	@PostConstruct
	public void init() {
		super.init();
		LOGGER.info("Initialize MovementesAccountController");
		if (movementsList == null) {
			getAllMovements();
		}
		this.graphicLineMovements = graphicLineDelegate.getMovementAccount(movementsList);
		cleanFilters();
	}

	public void criteriaSearch() {

		if (this.dateRange != null) {
			setDateRangePc(this.dateRange);
		}
		if (this.balanceRange != null) {
			setBalanceRangePc(this.balanceRange);
		}
		setUserPc(getCurrentUser());
		setProductTypePc(getSelectedProduct().getSubTypeProd());
		setProductIdPc(getSelectedProduct().getProductId());
		search();
		this.movementsList = getCurrentList();
	}

	public void nextPage(ActionEvent event) {
		criteriaSearch();
	}

	@Override
	public List<MovementDto> getAllMovements() {
		movementsList = new ArrayList<MovementDto>();
		movementsList = this.movementsFacade.listMovements(
				"00130073000296247953"/* getSelectedProduct().getProductId() */, getCurrentUser(), getSelectedProduct()
						.getSubTypeProd(), null, null, 1, 10);
		return movementsList;
	}

	@Override
	public void onMovementSelected(SelectEvent selectEvent) {
		super.onMovementSelected(selectEvent);
		movementDetail = new MovementDetailDto();
		movementDetail = this.movementsFacade.getMovement(getSelectedProduct().getProductId(), getCurrentUser(),
				getSelectedProduct().getTypeProd().value(), getSelectedMovements().getMovementId());
		System.out.println("mov id selected: " + getSelectedMovements().getMovementId());
	}

	@Override
	public void searchMovementByFilter(final ActionEvent event) {
		System.out.println("Movimeintos x criteria \n");

		if (renderComponents.get(RenderAttributes.FILTERDATE.toString())) {
			System.out.println(" selectDate " + movementCriteria.getSelectDate());
			EnumPeriodType periodType = EnumPeriodType.valueOfLabel(this.getSelectDate());
			if (!(periodType == (null))) {
				dateRange = new DateRangeDto();
				dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
			}
			criteriaSearch();

		} else if (renderComponents.get(RenderAttributes.BALANCEFILTER.toString())) {
			System.out.println("Ingresos o gastos " + movementCriteria.getIncomesOrExpenses());

			System.out.println("Since " + movementCriteria.getBalanceRange().getBalanceSince());
			System.out.println("To " + movementCriteria.getBalanceRange().getBalanceTo());
		} else if (renderComponents.get(RenderAttributes.INCOMEOREXPENSESFILTER.toString())) {

		} else if (renderComponents.get(RenderAttributes.MOVEMENTSFILTER.toString())) {

		}

	}

	@Override
	public void oneSelectDate() {
		System.out.println("Method oneSelectDate");

		renderComponents.put(RenderAttributes.FILTERDATE.toString(), true);

		if (getSelectDate().equals(CONCRETE_DATE)) {
			renderComponents.put(RenderAttributes.CALENDAR.toString(), false);
			renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);

		} else {
			renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
			renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);

		}
	}

	/***
	 * @param event
	 */
	@Override
	public void setBalanceRange(final ActionEvent event) {
		System.out.println("Method setBalance");
		renderComponents.put(RenderAttributes.BALANCEFILTER.toString(), true);
		setSinceText(SINCE_TITLE + ": ");
		setToText(TO_TITLE + ": ");
		System.out.println(SINCE_TITLE + movementCriteria.getBalanceRange().getBalanceSince());
		System.out.println(TO_TITLE + ": " + movementCriteria.getBalanceRange().getBalanceTo());
	}

	@Override
	public void setIncomeExpensesFilter(final ActionEvent event) {
		System.out.println("Method searchINcome expenses filter");
		renderComponents.put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), true);
		System.out.println(movementCriteria.getIncomesOrExpenses());
	}

	@Override
	public void cleanFilters() {
		System.out.println("limpias");
		movementCriteria = new MovementCriteriaDto();
		renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
		renderComponents.put(RenderAttributes.BUTTONDATE.toString(), true);
		renderComponents.put(RenderAttributes.BUTTONBALANCE.toString(), true);
		// Filtros
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), false);
		renderComponents.put(RenderAttributes.BALANCEFILTER.toString(), false);
		renderComponents.put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), false);
		renderComponents.put(RenderAttributes.MOVEMENTSFILTER.toString(), false);

	}

	@Override
	public void buildMessage() {
		messageBalance = new StringBuilder(BALANCE_TITLE);
		messageBalance.append(movementCriteria.getBalanceRange().getBalanceSince() + "$");
	}

	@Override
	public void balanceValidator() {

		if ((movementCriteria.getBalanceRange().getBalanceSince() != (null) && movementCriteria.getBalanceRange()
				.getBalanceTo() != (null))) {

			if (movementCriteria.getBalanceRange().getBalanceSince()
					.compareTo(movementCriteria.getBalanceRange().getBalanceTo()) == -1) {

				renderComponents.put(RenderAttributes.BUTTONBALANCE.toString(), false);
				messageBalance = new StringBuilder("Se mostrarán los resultados mayores de "
						+ movementCriteria.getBalanceRange().getBalanceSince() + "$" + " y menores de "
						+ movementCriteria.getBalanceRange().getBalanceTo() + "$");

			} else {
				renderComponents.put(RenderAttributes.BUTTONBALANCE.toString(), true);
				buildMessage();
			}
		} else {
			messageBalance = new StringBuilder();
		}
	}

	@Override
	public void setCustomDate(final ActionEvent event) {
		System.out.println("setCustomDate");
		renderComponents.put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), true);

		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		if (!(getSinceDate() == (null)) && !(getToDate() == (null))) {
			sinceDatestr = SINCE_TITLE + ": " + dateFormat.format(getSinceDate());
			toDatestr = TO_TITLE + ": " + dateFormat.format(getToDate());
		} else {
			sinceDatestr = getSelectDate();
		}
	}

	/**
	 * @return the dateFormat
	 */
	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	/**
	 * @param dateFormat the dateFormat to set
	 */
	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	/**
	 * @return the messageBalance
	 */
	public StringBuilder getMessageBalance() {
		return messageBalance;
	}

	/**
	 * @param messageBalance the messageBalance to set
	 */
	public void setMessageBalance(StringBuilder messageBalance) {
		this.messageBalance = messageBalance;
	}

	/**
	 * @return the sinceText
	 */
	public String getSinceText() {
		return sinceText;
	}

	/**
	 * @param sinceText the sinceText to set
	 */
	public void setSinceText(String sinceText) {
		this.sinceText = sinceText;
	}

	/**
	 * @return the toText
	 */
	public String getToText() {
		return toText;
	}

	/**
	 * @param toText the toText to set
	 */
	public void setToText(String toText) {
		this.toText = toText;
	}

	/**
	 * @return the selectDate
	 */
	public String getSelectDate() {
		return selectDate;
	}

	/**
	 * @param selectDate the selectDate to set
	 */
	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
	}

	/**
	 * @return the sinceDatestr
	 */
	public String getSinceDatestr() {
		return sinceDatestr;
	}

	/**
	 * @param sinceDatestr the sinceDatestr to set
	 */
	public void setSinceDatestr(String sinceDatestr) {
		this.sinceDatestr = sinceDatestr;
	}

	/**
	 * @return the toDatestr
	 */
	public String getToDatestr() {
		return toDatestr;
	}

	/**
	 * @param toDatestr the toDatestr to set
	 */
	public void setToDatestr(String toDatestr) {
		this.toDatestr = toDatestr;
	}

	/**
	 * @return the sinceDate
	 */
	public Date getSinceDate() {
		return sinceDate;
	}

	/**
	 * @param sinceDate the sinceDate to set
	 */
	public void setSinceDate(Date sinceDate) {
		this.sinceDate = sinceDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the movementCriteria
	 */
	public MovementCriteriaDto getMovementCriteria() {
		return movementCriteria;
	}

	/**
	 * @param movementCriteria the movementCriteria to set
	 */
	public void setMovementCriteria(MovementCriteriaDto movementCriteria) {
		this.movementCriteria = movementCriteria;
	}

	/**
	 * @return the balanceRange
	 */
	public BalanceRangeDto getBalanceRange() {
		return balanceRange;
	}

	/**
	 * @param balanceRange the balanceRange to set
	 */
	public void setBalanceRange(BalanceRangeDto balanceRange) {
		this.balanceRange = balanceRange;
	}

	/**
	 * @return the dateRange
	 */
	public DateRangeDto getDateRange() {
		return dateRange;
	}

	/**
	 * @param dateRange the dateRange to set
	 */
	public void setDateRange(DateRangeDto dateRange) {
		this.dateRange = dateRange;
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
	 * @return the movementsFacade
	 */
	public MovementsAccountFacade getMovementsFacade() {
		return movementsFacade;
	}

	/**
	 * @param movementsFacade the movementsFacade to set
	 */
	public void setMovementsFacade(MovementsAccountFacade movementsFacade) {
		this.movementsFacade = movementsFacade;
	}

	/**
	 * @return the movementsList
	 */
	public List<MovementDto> getMovementsList() {
		return movementsList;
	}

	/**
	 * @param movementsList the movementsList to set
	 */
	public void setMovementsList(List<MovementDto> movementsList) {
		this.movementsList = movementsList;
	}

	public GraphicLineDelegate getGraphicLineDelegate() {
		return graphicLineDelegate;
	}

	public void setGraphicLineDelegate(GraphicLineDelegate graphicLineDelegate) {
		this.graphicLineDelegate = graphicLineDelegate;
	}

	public LineConfigUI getGraphicLineMovements() {
		return graphicLineMovements;
	}

	public void setGraphicLineMovements(LineConfigUI graphicLineMovements) {
		this.graphicLineMovements = graphicLineMovements;
	}

	/**
	 * @return the renderComponents
	 */
	public Map<String, Boolean> getRenderComponents() {
		return renderComponents;
	}

	/**
	 * @param renderComponents the renderComponents to set
	 */
	public void setRenderComponents(Map<String, Boolean> renderComponents) {
		this.renderComponents = renderComponents;
	}

	/**
	 * @return the movementDetail
	 */
	public MovementDetailDto getMovementDetail() {
		return movementDetail;
	}

	/**
	 * @param movementDetail the movementDetail to set
	 */
	public void setMovementDetail(MovementDetailDto movementDetail) {
		this.movementDetail = movementDetail;
	}
}