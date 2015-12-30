package com.bbva.net.front.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.util.DateUtils;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.turnsClient.turnsClientDetailDto;
import com.bbva.net.back.model.turnsClient.turnsClientDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.TurnsOutwardsController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.line.LineConfigUI;

public class TurnsOutwardsControllerImpl extends AbstractBbvaController implements TurnsOutwardsController {

	/**
     *
     */
	private static final long serialVersionUID = 1L;

	private turnsClientDetailDto turnsDetail;

	private List<turnsClientDto> turnsGeneral;

	private List<turnsClientDto> turnsClientOutside;

	private List<turnsClientDto> turnsClientRecived;

	private LineConfigUI graphicLineMovements;

	private DateRangeDto dateRange;

	private Date sinceDate = null, toDate = null;

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date");

	private static final String SINCE_TITLE = MessagesHelper.INSTANCE.getString("text.since");

	private static final String TO_TITLE = MessagesHelper.INSTANCE.getString("text.to");

	private String sinceText, toText, sinceDatestr, toDatestr, selectDate = StringUtils.EMPTY;

	@Resource(name = "graphicLineDelegate")
	private transient GraphicLineDelegate graphicLineDelegate;

	@Override
	public List<turnsClientDto> allTurnsClientOutside() {
		this.turnsClientOutside = new ArrayList<turnsClientDto>();
		turnsClientDto turns = new turnsClientDto("T00283", new Date(05102015), "STD", "EUR", new Money(new BigDecimal(
				7600000)), "23,655.0000", "Liberado / Efectuado", "IN", "");
		turnsClientDto turns2 = new turnsClientDto("T002370", new Date(14092015), "STD1", "USD", new Money(
				new BigDecimal(100456123)), "21,965.0000", "Proceso", "1898", "");
		this.turnsClientOutside.add(turns);
		this.turnsClientOutside.add(turns2);
		return turnsClientOutside;
	}

	@Override
	public void onTurnDetail(SelectEvent selectEvent) {
		turnsDetail = new turnsClientDetailDto("", "", new Date(), new Date(), "", "", "", new Money(new BigDecimal(
				2000)), "", "", "", "", "", "", "", "", "");
	}

	@Override
	public void oneSelectDate() {
		LOGGER.info("Method oneSelectDate");
		getRenderComponents().put(RenderAttributes.FILTERDATE.toString(), true);
		if (getSelectDate().equals(CONCRETE_DATE)) {
			getRenderComponents().put(RenderAttributes.CALENDAROUT.toString(), false);
		} else {
			getRenderComponents().put(RenderAttributes.CALENDAROUT.toString(), true);
		}
	}

	@Override
	public void setCustomDate(final AjaxBehaviorEvent event) {
		LOGGER.info("TurnsOutwardsControllerImpl setCustomDate");
		getRenderComponents().put(RenderAttributes.FILTERDATE.toString(), true);
		this.dateRange = new DateRangeDto();
		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		if (!(getSinceDate() == (null)) && !(getToDate() == (null)) && getSelectDate().equals(CONCRETE_DATE)) {
			this.sinceText = SINCE_TITLE + ": ";
			this.toText = TO_TITLE + ": ";
			sinceDatestr = DateUtils.format(getSinceDate(), "dd/MM/yyyy");
			toDatestr = DateUtils.format(getToDate(), "dd/MM/yyyy");
		} else {
			this.sinceText = "";
			this.toText = "";
			this.sinceDatestr = getSelectDate();
			this.toDatestr = "";
			setSinceDate(null);
			setToDate(null);
		}
	}

	@Override
	public void searchTurnsByFilter(final AjaxBehaviorEvent event) {
		LOGGER.info("TurnsOutwardsControllerImpl searchQuotaByFilter ");
		appendOudSide();
		if (getRenderComponents().get(RenderAttributes.FILTERDATE.toString())) {
			calculateDate(this.getSelectDate());
			LOGGER.info("Mostrando resultados de filtros " + "Date Since: " + dateRange.getDateSince() + "Date To: "
					+ dateRange.getDateTo());
		}
	}

	public DateRangeDto calculateDate(String date) {
		LOGGER.info("TurnsOutwardsControllerImpl calculateDate ");

		EnumPeriodType periodType = EnumPeriodType.valueOfLabel(date);
		if (!(periodType == (null))) {
			this.dateRange = new DateRangeDto();
			this.dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		}
		return dateRange;
	}

	@Override
	public void cleanFilters(AjaxBehaviorEvent event) {
		LOGGER.info("MovementsAccountController clean Filters");
		allTurnsClientOutside();
		clean();

	}

	public void clean() {
		setSinceText(new String());
		setToText(new String());
		setSinceDatestr(new String());
		setToDatestr(new String());
		sinceDate = null;
		toDate = null;
		selectDate = StringUtils.EMPTY;
		dateRange = null;
		setSelectDate(new String());
		getRenderComponents().put(RenderAttributes.CALENDAROUT.toString(), true);
	}

	public void appendOudSide() {
		// Init
		getRenderComponents().put(RenderAttributes.TITLEDIVISAINI.name(), false);
		getRenderComponents().put(RenderAttributes.DIVISAINITABLE.name(), false);
		// Inside
		getRenderComponents().put(RenderAttributes.TITLEMRECIVED.name(), false);
		getRenderComponents().put(RenderAttributes.RECIVEDTABLE.name(), false);
		getRenderComponents().put(RenderAttributes.FOOTERRECIVED.name(), false);
		// Outside
		getRenderComponents().put(RenderAttributes.TITLEMOUTSIDE.name(), true);
		getRenderComponents().put(RenderAttributes.OUTSIDETABLE.name(), true);
	}

	@Override
	public ProductDto getSelectedProduct() {
		return super.getSelectedProduct();
	}

	/**
     *
     */
	@Override
	public void onProductTurnsSelected(final SelectEvent selectEvent) {
		super.onProductSelected(selectEvent);
		this.sendAction("turnSelect");

	}

	// Setters and getters

	/**
	 * @return the turnsDetail
	 */
	public turnsClientDetailDto getTurnsDetail() {
		return turnsDetail;
	}

	/**
	 * @param turnsDetail the turnsDetail to set
	 */
	public void setTurnsDetail(turnsClientDetailDto turnsDetail) {
		this.turnsDetail = turnsDetail;
	}

	/**
	 * @return the turnsClientOutside
	 */
	public List<turnsClientDto> getTurnsClientOutside() {
		return turnsClientOutside;
	}

	/**
	 * @param turnsClientOutside the turnsClientOutside to set
	 */
	public void setTurnsClientOutside(List<turnsClientDto> turnsClientOutside) {
		this.turnsClientOutside = turnsClientOutside;
	}

	/**
	 * @return the turnsClientRecived
	 */
	public List<turnsClientDto> getTurnsClientRecived() {
		return turnsClientRecived;
	}

	/**
	 * @param turnsClientRecived the turnsClientRecived to set
	 */
	public void setTurnsClientRecived(List<turnsClientDto> turnsClientRecived) {
		this.turnsClientRecived = turnsClientRecived;
	}

	/**
	 * @return the graphicLineMovements
	 */
	public LineConfigUI getGraphicLineMovements() {
		return graphicLineMovements;
	}

	/**
	 * @param graphicLineMovements the graphicLineMovements to set
	 */
	public void setGraphicLineMovements(LineConfigUI graphicLineMovements) {
		this.graphicLineMovements = graphicLineMovements;
	}

	/**
	 * @return the turnsGeneral
	 */
	public List<turnsClientDto> getTurnsGeneral() {
		return turnsGeneral;
	}

	/**
	 * @param turnsGeneral the turnsGeneral to set
	 */
	public void setTurnsGeneral(List<turnsClientDto> turnsGeneral) {
		this.turnsGeneral = turnsGeneral;
	}

	/**
	 * @return the graphicLineDelegate
	 */
	public GraphicLineDelegate getGraphicLineDelegate() {
		return graphicLineDelegate;
	}

	/**
	 * @param graphicLineDelegate the graphicLineDelegate to set
	 */
	public void setGraphicLineDelegate(GraphicLineDelegate graphicLineDelegate) {
		this.graphicLineDelegate = graphicLineDelegate;
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
	 * @return the concreteDate
	 */
	public static String getConcreteDate() {
		return CONCRETE_DATE;
	}

	/**
	 * @return the sinceTitle
	 */
	public static String getSinceTitle() {
		return SINCE_TITLE;
	}

	/**
	 * @return the toTitle
	 */
	public static String getToTitle() {
		return TO_TITLE;
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
	 * @return the renderComponents
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Boolean> getRenderComponents() {
		return (Map<String, Boolean>)getViewVarView("renderComponents");
	}
}
