package com.bbva.net.front.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

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
import com.bbva.net.front.controller.TurnsOperationController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.line.LineConfigUI;

public class TurnsOperationControllerImpl extends AbstractBbvaController implements TurnsOperationController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private turnsClientDetailDto turnsDetail;

	private List<turnsClientDto> turnsGeneral;

	private List<turnsClientDto> turnsClientOutside;

	private List<turnsClientDto> turnsClientRecived;

	private LineConfigUI graphicLineMovements;

	private Map<String, Boolean> renderComponents;

	private DateRangeDto dateRange;

	private Date sinceDate = null, toDate = null;

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date");

	private static final String SINCE_TITLE = MessagesHelper.INSTANCE.getString("text.since");

	private static final String TO_TITLE = MessagesHelper.INSTANCE.getString("text.to");

	private String sinceText, toText, sinceDatestr, toDatestr, selectDate = StringUtils.EMPTY;

	@Resource(name = "graphicLineDelegate")
	private transient GraphicLineDelegate graphicLineDelegate;

	@Override
	public ProductDto getSelectedProduct() {
		return super.getSelectedProduct();
	}

	@Override
	public List<turnsClientDto> getAllMovementsInitial() {
		LOGGER.info("TurnsOperationController getAllMovementsInitial");
		this.turnsGeneral = new ArrayList<turnsClientDto>();
		if (getSelectedProduct() != null && getSelectedProduct().getProductId() != null
				&& getSelectedProduct().isVisible() != null) {
			if (getSelectedProduct().isVisible()) {
				turnsClientDto turn = new turnsClientDto();
				turn.setAmount(new Money(new BigDecimal(10000000)));
				turn.setOperation("Compra carro");
				turn.setDateOperation(new Date());
				turn.setStateOperation("Proceso");
				this.turnsGeneral.add(turn);
			}
		}
		this.graphicLineMovements = graphicLineDelegate.getMovementDivisa(this.turnsGeneral);
		return this.turnsGeneral;
	}

	@Override
	public List<turnsClientDto> allTurnsClientOutside() {
		this.turnsClientOutside = new ArrayList<turnsClientDto>();
		turnsClientDto turns = new turnsClientDto(new Date(), "1234841", "Compra carro", "NL", "023", new Money(
				new BigDecimal(10000000)), "2.136.423", "Realizado", "Olga Lucia Calderon");
		this.turnsClientOutside.add(turns);
		return turnsClientOutside;
	}

	@Override
	public List<turnsClientDto> allTurnsClientRecived() {
		this.turnsClientRecived = new ArrayList<turnsClientDto>();
		turnsClientDto turns = new turnsClientDto(new Date(), "", "", "", "", new Money(new BigDecimal(5000)), "", "",
				"");
		this.turnsClientRecived.add(turns);
		return turnsClientRecived;
	}

	@Override
	public void onTurnDetail(SelectEvent selectEvent) {
		turnsDetail = new turnsClientDetailDto("", "", new Date(), new Date(), "", "", "", new Money(new BigDecimal(
				2000)), "", "", "", "", "", "", "", "", "");
	}

	@Override
	public void oneSelectDate() {
		LOGGER.info("Method oneSelectDate");
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), true);
		if (getSelectDate().equals(CONCRETE_DATE)) {
			renderComponents.put(RenderAttributes.CALENDAR.toString(), false);
			renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);
			LOGGER.info("Fecha Concreta: " + " Calendar: " + renderComponents.get(RenderAttributes.CALENDAR.toString())
					+ " Boton: " + renderComponents.get(RenderAttributes.BUTTONDATE.toString()));
		} else {
			renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
			renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);
			LOGGER.info("Radio Button: " + " Calendar: " + renderComponents.get(RenderAttributes.CALENDAR.toString())
					+ " Boton: " + renderComponents.get(RenderAttributes.BUTTONDATE.toString()));
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
	public void searchTurnsByFilter(final ActionEvent event) {
		LOGGER.info("QuotaControllerImpl searchQuotaByFilter ");
		if (renderComponents.get(RenderAttributes.FILTERDATE.toString())) {
			calculateDate(this.getSelectDate());

			LOGGER.info("Mostrando resultados de filtros " + "Date Since: " + dateRange.getDateSince() + "Date To: "
					+ dateRange.getDateTo());
		}
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

	public void setFalseCheckComponents() {
		getRenderComponents().put(RenderAttributes.TITLEMOVES.name(), false);
		getRenderComponents().put(RenderAttributes.CHECKTABLE.toString(), false);
		getRenderComponents().put(RenderAttributes.FOOTERTABLECHEKS.toString(), false);
	}

	public void setFalseCheckBookComponents() {
		getRenderComponents().put(RenderAttributes.TITLECHECKBOOKS.name(), false);
		getRenderComponents().put(RenderAttributes.CHECKBOOKTABLE.name(), false);
		getRenderComponents().put(RenderAttributes.FOOTERTABLECHECKBOOK.name(), false);
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
}
