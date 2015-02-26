package com.bbva.net.front.controller.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.apache.commons.collections.CollectionUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.MovementsAccountFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.predicate.ConceptMovementPredicate;
import com.bbva.net.back.predicate.ExpensesPredicate;
import com.bbva.net.back.predicate.IncomesPredicate;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.MovementCriteriaController;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.line.LineConfigUI;

/**
 * @author User
 */
public class MovementCriteriaControllerImpl extends MovementPaginatedController implements MovementCriteriaController {

	private static final long serialVersionUID = 1L;

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date"),
			BALANCE_TITLE = MessagesHelper.INSTANCE.getString("msg.message.balance"),
			SINCE_TITLE = MessagesHelper.INSTANCE.getString("text.since"), TO_TITLE = MessagesHelper.INSTANCE
					.getString("text.to");

	SimpleDateFormat dateFormat = new SimpleDateFormat(MessagesHelper.INSTANCE.getStringI18("date.pattner.dd.mm.yyyy"));

	private StringBuilder messageBalance;

	private String sinceText, toText, selectDate = "3", sinceDatestr, toDatestr, titleInOrExp;

	private Date sinceDate, toDate;

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	private BalanceRangeDto balanceRange;

	private DateRangeDto dateRange;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@Resource(name = "movementsAccountFacade")
	private transient MovementsAccountFacade movementsFacade;

	private List<MovementDto> movementsList;

	@Resource(name = "graphicLineDelegate")
	private transient GraphicLineDelegate graphicLineDelegate;

	private LineConfigUI graphicLineMovements;

	private MovementDetailDto movementDetail;

	private List valuesLinesGraphic;

	@Override
	public void init() {
		super.init();
		LOGGER.info("Initialize MovementsAccountController");
	}

	@Override
	public void clean() {
		movementCriteria = new MovementCriteriaDto();
		movementCriteria.setBalanceRange(new BalanceRangeDto());
		movementCriteria.setDateRange(new DateRangeDto());
		setSinceText(new String());
		setToText(new String());
		setSinceDatestr(new String());
		setToDatestr(new String());
		setTitleInOrExp(new String());
		messageBalance = new StringBuilder();
		sinceDate = null;
		toDate = null;
		selectDate = new String();
		dateRange = null;
		balanceRange = null;
	}

	@Override
	public void cleanFilters(ActionEvent event) {
		LOGGER.info("MovementsAccountController clean Filters");
		clean();
	}

	public void criteriaSearch() {
		LOGGER.info("MovementsAccountController criteriaSearch");
		if (getRenderComponents().get(RenderAttributes.FILTERDATE.toString())) {
			setDateRangePc(this.dateRange);
		}
		if (getRenderComponents().get(RenderAttributes.BALANCEFILTER.toString())) {
			setBalanceRangePc(this.balanceRange);
		}
		setProductTypePc(getSelectedProduct().getSubTypeProd());
		LOGGER.info("MovementsAccountController criteriaSearch productType:  " + getSelectedProduct().getSubTypeProd());
		LOGGER.info("MovementsAccountController criteriaSearch productId:  " + getSelectedProduct().getProductId());
		super.init();
		search();
		this.movementsList = getCurrentList();
		setShowMoreStatus();
		RequestContext.getCurrentInstance().update("detailAccounts:tableMovements:formMovesDetail:movAccount");

	}

	public void handleDateSelect(final SelectEvent event) {
		if (event.getObject() != null) {
			setSinceDate((Date)event.getObject());

		}
	}

	public void nextPage(ActionEvent event) {
		getRenderComponents().put(RenderAttributes.TITLEMOVES.name(), true);
		getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.name(), true);
		setFalseCheckComponents();
		next();
		this.movementsList = getCurrentList();
	}

	public DateRangeDto calculateDate(String date) {
		LOGGER.info("MovementsAccountController calculateDate ");

		EnumPeriodType periodType = EnumPeriodType.valueOfLabel(date);
		if (!(periodType == (null))) {
			this.dateRange = new DateRangeDto();
			this.dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		}
		return dateRange;
	}

	/**
	 * Method to evaluate if the list has more elements
	 * 
	 * @param movementsList
	 */
	public void setShowMoreStatus() {
		if (this.movementsList.size() >= 10)
			getRenderComponents().put(RenderAttributes.FOOTERTABLEMOVEMENT.name(), true);
		else
			getRenderComponents().put(RenderAttributes.FOOTERTABLEMOVEMENT.name(), false);
	}

	@Override
	public List<MovementDto> getAllMovements() {
		LOGGER.info("MovementsAccountController getAllMovements");
		this.movementsList = new ArrayList<MovementDto>();
		dateRange = calculateDate(MessagesHelper.INSTANCE.getString("select.radio.last.month"));

		setDateRangePc(dateRange);
		setBalanceRangePc(null);
		// TODO oroductId
		LOGGER.info("MovementsAccountController getAllMovements productId:  " + getSelectedProduct().getProductId());
		next();
		this.movementsList = getCurrentList();
		this.graphicLineMovements = graphicLineDelegate.getMovementAccount(this.movementsList);
		this.valuesLinesGraphic = valuesLinesGraphic(graphicLineMovements);

		return this.movementsList;
	}

	@Override
	public void onMovementSelected(SelectEvent selectEvent) {
		LOGGER.info("MovementsAccountController onMovementSelected");
		super.onMovementSelected(selectEvent);
		movementDetail = new MovementDetailDto();
		LOGGER.info("MovementsAccountController onMovementSelected movementId:  "
				+ getSelectedMovements().getMovementId());
		movementDetail = this.movementsFacade.getMovement(getSelectedProduct().getProductId(), getSelectedProduct()
				.getTypeProd().value(), getSelectedMovements().getMovementId());
		System.out.println("mov id selected: " + getSelectedMovements().getMovementId());
	}

	public void setFalseCheckComponents() {
		getRenderComponents().put(RenderAttributes.TITLECHECKS.name(), false);
		getRenderComponents().put(RenderAttributes.CHECKTABLE.toString(), false);
		getRenderComponents().put(RenderAttributes.FOOTERTABLECHEKS.toString(), false);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void searchMovementByFilter(final ActionEvent event) {
		LOGGER.info("MovementsAccountController searchMovementByFilter");
		getRenderComponents().put(RenderAttributes.TITLEMOVES.name(), true);
		getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.toString(), true);
		setFalseCheckComponents();

		if (getRenderComponents().get(RenderAttributes.FILTERDATE.toString())) {
			// Get movements by date
			LOGGER.info("MovementsAccountController searchMovementByFilterDate");
			this.dateRange = calculateDate(this.getSelectDate());
			criteriaSearch();

		} else if (getRenderComponents().get(RenderAttributes.BALANCEFILTER.toString())) {
			// Get movements by balance
			LOGGER.info("MovementsAccountController searchMovementByBalanceFilter");
			this.balanceRange = new BalanceRangeDto();
			this.balanceRange.setBalanceSince(movementCriteria.getBalanceRange().getBalanceSince());
			this.balanceRange.setBalanceTo(movementCriteria.getBalanceRange().getBalanceTo());

			criteriaSearch();

		}

		if (getRenderComponents().get(RenderAttributes.INCOMEOREXPENSESFILTER.toString())) {
			// Get only movements by income or expenses
			LOGGER.info("MovementsAccountController searchMovementByIncomeOrExpensesFilter");
			getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.toString(), true);

			if (movementCriteria.getIncomesOrExpenses() != null && movementCriteria.getIncomesOrExpenses().equals("1")) {
				// Income Movements
				LOGGER.info("MovementsAccountController searchMovementByIncomeOrExpensesFilter incomeMovements");
				final List<MovementDto> incomeMovements = (List<MovementDto>)CollectionUtils.select(this.movementsList,
						new IncomesPredicate());
				this.movementsList = incomeMovements;
				setShowMoreStatus();
			}

			if (movementCriteria.getIncomesOrExpenses() != null && movementCriteria.getIncomesOrExpenses().equals("2")) {
				// Expense Movements
				LOGGER.info("MovementsAccountController searchMovementByIncomeOrExpensesFilter expensesMovements");
				final List<MovementDto> expensesMovements = (List<MovementDto>)CollectionUtils.select(
						this.movementsList, new ExpensesPredicate());
				this.movementsList = expensesMovements;
				setShowMoreStatus();

			}
			RequestContext.getCurrentInstance().update(":detailAccounts:tableMovements:formMovesDetail:movAccount");
		}

		if (getRenderComponents().get(RenderAttributes.MOVEMENTSFILTER.toString())) {
			LOGGER.info("MovementsAccountController searchMovementByMovementFilter");
			// Get only movements by concept
			final List<MovementDto> movementsByConcept = (List<MovementDto>)CollectionUtils.select(this.movementsList,
					new ConceptMovementPredicate(movementCriteria.getMovement()));
			this.movementsList = movementsByConcept;
			setShowMoreStatus();
			getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.toString(), true);

		}
		clean();

	}

	@Override
	public void selectDateSince(SelectEvent event) {
		LOGGER.info("MovementCriteriaController Since Date Selected");
		// final Date date = (Date)event.getObject();
		// this.sinceDate = date;
	}

	@Override
	public void selectDateTo(SelectEvent event) {
		LOGGER.info("MovementCriteriaController To Date Selected");
		// final Date date = (Date)event.getObject();
		// this.toDate = date;
	}

	@Override
	public void oneSelectDate() {
		LOGGER.info("MovementsAccountController oneSelectDate");

		getRenderComponents().put(RenderAttributes.FILTERDATE.toString(), true);

		if (getSelectDate().equals(CONCRETE_DATE)) {
			getRenderComponents().put(RenderAttributes.CALENDAR.toString(), false);
			getRenderComponents().put(RenderAttributes.BUTTONDATE.toString(), false);

		} else {
			getRenderComponents().put(RenderAttributes.CALENDAR.toString(), true);
			getRenderComponents().put(RenderAttributes.BUTTONDATE.toString(), false);
		}
	}

	@Override
	public void setBalanceRange(final ActionEvent event) {
		LOGGER.info("MovementsAccountController setBalanceRange");
		getRenderComponents().put(RenderAttributes.BALANCEFILTER.toString(), true);
		setSinceText(SINCE_TITLE + ": ");
		setToText(TO_TITLE + ": ");
	}

	@Override
	public void setIncomeExpensesFilter(final ActionEvent event) {
		LOGGER.info("MovementsAccountController setIncomeExpensesFilter");
		getRenderComponents().put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), true);
		if (movementCriteria.getIncomesOrExpenses().equals("1"))
			setTitleInOrExp(MessagesHelper.INSTANCE.getString("select.radio.in"));
		else if (movementCriteria.getIncomesOrExpenses().equals("2"))
			setTitleInOrExp(MessagesHelper.INSTANCE.getString("select.radio.out"));
		else
			setTitleInOrExp(MessagesHelper.INSTANCE.getString("select.radio.in.out"));
		System.out.println(movementCriteria.getIncomesOrExpenses());
	}

	@Override
	public void setMovementConcept(final ActionEvent event) {
		LOGGER.info("MovementsAccountController setMovementConcept");
		getRenderComponents().put(RenderAttributes.MOVEMENTSFILTER.toString(), true);
	}

	@Override
	public void buildMessage() {
		LOGGER.info("MovementsAccountController buildMessage");
		messageBalance = new StringBuilder(BALANCE_TITLE);
		messageBalance.append(movementCriteria.getBalanceRange().getBalanceSince() + "$");
	}

	@Override
	public void balanceValidator() {
		LOGGER.info("MovementsAccountController balanceValidator");
		if ((movementCriteria.getBalanceRange().getBalanceSince() != (null) && movementCriteria.getBalanceRange()
				.getBalanceTo() != (null))) {

			if (movementCriteria.getBalanceRange().getBalanceSince()
					.compareTo(movementCriteria.getBalanceRange().getBalanceTo()) == -1) {

				getRenderComponents().put(RenderAttributes.BUTTONBALANCE.toString(), false);
				messageBalance = new StringBuilder("Se mostrarán los resultados mayores de "
						+ movementCriteria.getBalanceRange().getBalanceSince() + "$" + " y menores de "
						+ movementCriteria.getBalanceRange().getBalanceTo() + "$");

			} else {
				getRenderComponents().put(RenderAttributes.BUTTONBALANCE.toString(), true);
				buildMessage();
			}
		} else {
			messageBalance = new StringBuilder();
		}
	}

	@Override
	public void setCustomDate(final ActionEvent event) {
		LOGGER.info("MovementsAccountController setCustomDate");
		getRenderComponents().put(RenderAttributes.FILTERDATE.toString(), true);
		this.dateRange = new DateRangeDto();
		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		if (!(getSinceDate() == (null)) && !(getToDate() == (null)) && getSelectDate().equals(CONCRETE_DATE)) {
			sinceDatestr = SINCE_TITLE + ": " + dateFormat.format(getSinceDate());
			toDatestr = TO_TITLE + ": " + dateFormat.format(getToDate());
		} else {
			sinceDatestr = getSelectDate();
			toDatestr = "";
		}
	}

	@Override
	public ProductDto getSelectedProduct() {
		return super.getSelectedProduct();
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
	public void setSinceText(final String sinceText) {
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

	public List<MovementDto> getMovementsList() {
		return movementsList;
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
	public void setToDatestr(final String toDatestr) {
		this.toDatestr = toDatestr;
	}

	/**
	 * @return the titleInOrExp
	 */
	public String getTitleInOrExp() {
		return titleInOrExp;
	}

	/**
	 * @param titleInOrExp the titleInOrExp to set
	 */
	public void setTitleInOrExp(String titleInOrExp) {
		this.titleInOrExp = titleInOrExp;
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
	@Override
	public MovementsAccountFacade getMovementsFacade() {
		return movementsFacade;
	}

	public GraphicLineDelegate getGraphicLineDelegate() {
		return graphicLineDelegate;
	}

	public LineConfigUI getGraphicLineMovements() {
		return graphicLineMovements;
	}

	/**
	 * @return the renderComponents
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Boolean> getRenderComponents() {
		return (Map<String, Boolean>)getViewVarView("renderComponents");
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

	public List getValuesLinesGraphic() {
		return valuesLinesGraphic;
	}

	public void setValuesLinesGraphic(List valuesLinesGraphic) {
		this.valuesLinesGraphic = valuesLinesGraphic;
	}

	@Override
	public List<BigDecimal> valuesLinesGraphic(LineConfigUI valuesLines) {
		BigDecimal menor = new BigDecimal(0);
		BigDecimal mayor = new BigDecimal(0);
		BigDecimal total = new BigDecimal(0);
		List<BigDecimal> values = new ArrayList<BigDecimal>();
		menor = valuesLines.getLineItemUIList().get(0).getValue().getAmount();
		for (int i = 0; i < valuesLines.getLineItemUIList().size(); i++) {
			if (valuesLines.getLineItemUIList().get(i).getValue().getAmount().compareTo(menor) == -1)
				menor = valuesLines.getLineItemUIList().get(i).getValue().getAmount();
			if (valuesLines.getLineItemUIList().get(i).getValue().getAmount().compareTo(mayor) == 1)
				mayor = valuesLines.getLineItemUIList().get(i).getValue().getAmount();
			total = total.add(valuesLines.getLineItemUIList().get(i).getValue().getAmount());
		}
		total = (mayor.subtract(menor)).divide(new BigDecimal(8));
		for (int i = 0; i <= 8; i++) {
			values.add(menor);
			menor = menor.add(total);
		}
		values.add(menor);
		return values;
	}
}