package com.bbva.net.front.controller.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.MovementsAccountFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.controller.MovementCriteriaController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.line.LineConfigUI;

/**
 * @author User
 */
@Controller(value = "movementsCriteriaController")
@Scope(value = "globalSession")
public class MovementCriteriaControllerImpl extends AbstractBbvaController implements MovementCriteriaController {

	private static final long serialVersionUID = 1L;

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date");

	SimpleDateFormat dateFormat = new SimpleDateFormat(MessagesHelper.INSTANCE.getStringI18("date.pattner.dd.mm.yyyy"));

	private boolean disabledButtonBalance = true;

	private boolean disabledCalendar = true;

	private boolean disabledButtonDate = true;

	private StringBuilder messageBalance;

	private String sinceText;

	private String toText;

	private String selectDate;

	private String sinceDatestr;

	private String toDatestr;

	private Date sinceDate;

	private Date toDate;

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	private BalanceRangeDto balanceRange = new BalanceRangeDto();

	private DateRangeDto dateRange = new DateRangeDto();

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@Resource(name = "movementsAccountFacade")
	private transient MovementsAccountFacade movementsFacade;

	private List<MovementDto> movementsList = null;

	@Resource(name = "graphicLineDelegate")
	private transient GraphicLineDelegate graphicLineDelegate;

	private LineConfigUI graphicLineMovements;

	@PostConstruct
	public void init() {
		LOGGER.info("Initialize MovementesAccountController");
		if (movementsList == null) {
			getAllMovements();
		}
		this.graphicLineMovements = graphicLineDelegate.getMovementAccount(getAllMovements());
	}

	@Override
	public List<MovementDto> getAllMovements() {
		movementsList = new ArrayList<MovementDto>();
		movementsList = this.movementsFacade.listMovements("00130073000296247953"/* getProduct().getProductId() */,
				getCurrentUser(), null, null, null, 1, 10);
		return movementsList;
	}

	@Override
	public void setSelectedProduct(ProductDto selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

	public ProductDto getProduct() {
		return super.getSelectedProduct();
	}

	/***
	 * @param event
	 */
	@Override
	public void searchMovementByFilter(final ActionEvent event) {
		System.out.println("Movimeintos x criteria \n");
		System.out.println("Ingresos o gastos " + movementCriteria.getIncomesOrExpenses());
		System.out.println(" selectDate " + movementCriteria.getSelectDate());
		System.out.println("Since " + movementCriteria.getBalanceRange().getBalanceSince());
		System.out.println("To " + movementCriteria.getBalanceRange().getBalanceTo());
	}

	/***
	 *
	 */
	@Override
	public void oneSelectDate() {
		System.out.println("Method oneSelectDate");
		if (getSelectDate().equals(CONCRETE_DATE)) {
			setDisabledCalendar(false);
			setDisabledButtonDate(false);
			System.out.println("if " + isDisabledCalendar() + isDisabledButtonDate());
		} else {
			setDisabledCalendar(true);
			setDisabledButtonDate(false);
			System.out.println("else" + isDisabledCalendar() + isDisabledButtonDate());
		}
	}

	/***
	 * @param event
	 */
	@Override
	public void setBalanceRange(final ActionEvent event) {
		System.out.println("Method setBalance");
		setSinceText("Desde: ");
		setToText("Hasta: ");
		System.out.println("Since " + movementCriteria.getBalanceRange().getBalanceSince());
		System.out.println("To " + movementCriteria.getBalanceRange().getBalanceTo());
	}

	/***
	 * @param event
	 */
	@Override
	public void setIncomeExpensesFilter(final ActionEvent event) {
		System.out.println("Method searchINcome expenses filter");
		System.out.println(movementCriteria.getIncomesOrExpenses());
	}

	@Override
	public void cleanFilters() {
		System.out.println("Clean");
		movementCriteria = new MovementCriteriaDto();

	}

	@Override
	public void buildMessage() {
		messageBalance = new StringBuilder("Se mostrarán los resultados mayores de ");
		messageBalance.append(movementCriteria.getBalanceRange().getBalanceSince() + "$");
	}

	@Override
	public void balanceValidator() {

		if ((movementCriteria.getBalanceRange().getBalanceSince() != (null) && movementCriteria.getBalanceRange()
				.getBalanceTo() != (null))) {

			if (movementCriteria.getBalanceRange().getBalanceSince()
					.compareTo(movementCriteria.getBalanceRange().getBalanceTo()) == -1) {

				setDisabledButtonBalance(false);
				messageBalance = new StringBuilder("Se mostrarán los resultados mayores de "
						+ movementCriteria.getBalanceRange().getBalanceSince() + "$" + " y menores de "
						+ movementCriteria.getBalanceRange().getBalanceTo() + "$");

			} else {
				setDisabledButtonBalance(true);
				buildMessage();
			}
		} else {
			messageBalance = new StringBuilder();
		}
	}

	@Override
	public void setCustomDate(final ActionEvent event) {
		System.out.println("setCustomDate");
		movementCriteria.setSelectDate(getSelectDate());
		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		movementCriteria.setDateRange(dateRange);
		if (!(getSinceDate() == (null)) && !(getToDate() == (null))) {
			sinceDatestr = "Desde: " + dateFormat.format(getSinceDate());
			toDatestr = "Hasta: " + dateFormat.format(getToDate());
		} else {
			sinceDatestr = getSelectDate();
		}
		System.out.println(movementCriteria.getSelectDate());
		System.out.println(sinceDatestr);
		System.out.println(toDatestr);
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
	 * @return the disabledButtonBalance
	 */
	public boolean isDisabledButtonBalance() {
		return disabledButtonBalance;
	}

	/**
	 * @param disabledButtonBalance the disabledButtonBalance to set
	 */
	public void setDisabledButtonBalance(boolean disabledButtonBalance) {
		this.disabledButtonBalance = disabledButtonBalance;
	}

	/**
	 * @return the disabledCalendar
	 */
	public boolean isDisabledCalendar() {
		return disabledCalendar;
	}

	/**
	 * @param disabledCalendar the disabledCalendar to set
	 */
	public void setDisabledCalendar(boolean disabledCalendar) {
		this.disabledCalendar = disabledCalendar;
	}

	/**
	 * @return the disabledButtonDate
	 */
	public boolean isDisabledButtonDate() {
		return disabledButtonDate;
	}

	/**
	 * @param disabledButtonDate the disabledButtonDate to set
	 */
	public void setDisabledButtonDate(boolean disabledButtonDate) {
		this.disabledButtonDate = disabledButtonDate;
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
}