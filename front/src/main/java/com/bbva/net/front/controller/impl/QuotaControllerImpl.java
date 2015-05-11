/**
 * 
 */
package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.util.DateUtils;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.QuotaController;
import com.bbva.net.front.helper.MessagesHelper;

/**
 * @author User
 */

public class QuotaControllerImpl extends QuotaPaginatedController implements QuotaController {

	private static final long serialVersionUID = 1L;

	private QuotaDetailDto quotaDetailDto;

	private MovementDetailDto quotaMoveDetailDto;

	private MovementDto quotaMove;

	private ProductDto productDto;

	private DateRangeDto dateRange;

	private List<MovementDto> quotamovenDtos;

	private MovementCriteriaDto movementCriteria;

	private Map<String, Boolean> renderComponents;

	private Date sinceDate = null, toDate = null;

	private String sinceText, toText, sinceDatestr, toDatestr, selectDate = StringUtils.EMPTY;

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date");

	private static final String SINCE_TITLE = MessagesHelper.INSTANCE.getString("text.since");

	private static final String TO_TITLE = MessagesHelper.INSTANCE.getString("text.to");

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	@Override
	public void init() {
		LOGGER.info("QuotaControllerImpl Super Initialize");
		super.init();
		LOGGER.info("QuotaControllerImpl Initialize QuotaController");
		// inicializar variables
		this.quotaDetailDto = new QuotaDetailDto();
		this.quotamovenDtos = new ArrayList<MovementDto>();
		this.quotaMoveDetailDto = new MovementDetailDto();
		this.productDto = new ProductDto();
		this.dateRange = new DateRangeDto();
		this.movementCriteria = new MovementCriteriaDto();
		this.renderComponents = new HashMap<String, Boolean>();
		// obtener el producto
		this.productDto = super.getSelectedProduct();
		if (productDto != null && productDto.getProductId() != null) {
			LOGGER.info("Datos del producto Seleccionado Terminado " + " Product Id: " + productDto.getProductId());
			this.quotaDetailDto = this.quotaDetailFacade.getDetailRotaryQuota(this.productDto.getProductId());
			LOGGER.info("Datos del quotaDetailDto Terminados" + " Product Id: " + quotaDetailDto.getId());
		} else {
			LOGGER.info("Datos del producto Seleccionado Vacio (null)");
			this.productDto = new ProductDto();
		}
		cleanFilters();
	}

	@Override
	public ProductDto getSelectedProduct() {
		return super.getSelectedProduct();
	}

	@Override
	public void cleanFilters() {
		LOGGER.info(" QuotaControllerImpl cleanFilters");
		renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
		renderComponents.put(RenderAttributes.BUTTONDATE.toString(), true);
		// Filtros
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), false);
		// Atr
		this.movementCriteria = new MovementCriteriaDto();
		this.movementCriteria.setDateRange(new DateRangeDto());
		setSinceText(new String());
		setToText(new String());
		setSinceDatestr(new String());
		setToDatestr(new String());
		setSinceDate(null);
		setToDate(null);
		setSelectDate(new String());
	}

	@Override
	public void cleanFilters(ActionEvent event) {
		LOGGER.info(" QuotaControllerImpl cleanFilters ActionEvent");
		cleanFilters();
	}

	private void calculateDate(final String date) {
		LOGGER.info("QuotaControllerImpl calculateDate ");
		EnumPeriodType periodType = EnumPeriodType.valueOfLabel(date);
		if (!(periodType == (null))) {
			this.dateRange = new DateRangeDto();
			this.dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		}
	}

	private void setShowMoreStatus() {
		LOGGER.info("QuotaControllerImpl setShowMoreStatus ");
		if (this.quotamovenDtos.size() >= 10)
			getRenderComponents().put(RenderAttributes.FOOTERTABLEQUOTA.toString(), true);
		else
			getRenderComponents().put(RenderAttributes.FOOTERTABLEQUOTA.toString(), false);
	}

	@Override
	public List<MovementDto> getAllQuotamovenDtos() {
		LOGGER.info("QuotaControllerImpl getAllQuotamovenDtos ");
		calculateDate(MessagesHelper.INSTANCE.getString("select.radio.last.month"));
		setDateRangePControl(this.dateRange);
		super.setQuotaDetailFacade(quotaDetailFacade);
		try {
			next();
		} catch (final Exception e) {

			final List<MovementDto> result = new ArrayList<MovementDto>();
			setCurrentList(result);
		}
		this.quotamovenDtos = getCurrentList();
		LOGGER.info("Datos de los movimientos llenos ");
		setShowMoreStatus();
		return quotamovenDtos;
	}

	@Override
	public void setSelectedProduct(final ProductDto selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

	public void onRowToggle(final SelectEvent event) {
		LOGGER.info("QuotaControllerImpl onRowToggle");
		this.quotaMove = new MovementDto();
		super.onMovementSelected(event);
		this.quotaMove = super.getSelectedMovements();
		String identify = String.format("%06d", Integer.valueOf(quotaMove.getMovementId())) + ""
				+ String.format("%04d", Integer.valueOf(quotaMove.getExtractNumber()));
		this.quotaMoveDetailDto = this.quotaDetailFacade.getRotaryQuotaMovement(this.productDto.getProductId(),
				identify);
		LOGGER.info("Movimiento Seleccionado " + quotaMoveDetailDto.getId());
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
	public void searchQuotaByFilter(final ActionEvent event) {
		LOGGER.info("QuotaControllerImpl searchQuotaByFilter ");
		if (renderComponents.get(RenderAttributes.FILTERDATE.toString())) {
			calculateDate(this.getSelectDate());
			criteriaSearch();
			LOGGER.info("Mostrando resultados de filtros " + "Date Since: " + dateRange.getDateSince() + "Date To: "
					+ dateRange.getDateTo());
		}
	}

	@Override
	public void nextPage(final ActionEvent event) {
		LOGGER.info("QuotaControllerImpl nextPage ");
		super.setQuotaDetailFacade(quotaDetailFacade);
		next();
		this.quotamovenDtos = getCurrentList();
	}

	@Override
	public void criteriaSearch() {
		LOGGER.info("QuotaControllerImpl criteriaSearch ");
		if (renderComponents.get(RenderAttributes.FILTERDATE.toString())) {
			setDateRangePControl(this.dateRange);
			LOGGER.info("date Range: " + " sinceDate: " + this.dateRange.getDateSince() + " toDate: "
					+ this.dateRange.getDateTo());
		}
		super.init();
		super.setQuotaDetailFacade(quotaDetailFacade);
		search();
		this.quotamovenDtos = getCurrentList();
		setShowMoreStatus();
		cleanFilters();
	}

	// Setters and Getters
	public QuotaDetailDto getQuotaDetailDto() {
		return quotaDetailDto;
	}

	public void setQuotaDetailDto(QuotaDetailDto quotaDetailDto) {
		this.quotaDetailDto = quotaDetailDto;
	}

	public MovementDetailDto getQuotaMoveDetailDto() {
		return quotaMoveDetailDto;
	}

	public void setQuotaMoveDetailDto(MovementDetailDto quotaMoveDetailDto) {
		this.quotaMoveDetailDto = quotaMoveDetailDto;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	public Map<String, Boolean> getRenderComponents() {
		return renderComponents;
	}

	public void setRenderComponents(Map<String, Boolean> renderComponents) {
		this.renderComponents = renderComponents;
	}

	public List<MovementDto> getQuotamovenDtos() {
		return quotamovenDtos;
	}

	public void setQuotamovenDtos(List<MovementDto> quotamovenDtos) {
		this.quotamovenDtos = quotamovenDtos;
	}

	public DateRangeDto getDateRange() {
		return dateRange;
	}

	public void setDateRange(DateRangeDto dateRange) {
		this.dateRange = dateRange;
	}

	public Date getSinceDate() {
		return sinceDate;
	}

	public void setSinceDate(Date sinceDate) {
		this.sinceDate = sinceDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getSinceDatestr() {
		return sinceDatestr;
	}

	public void setSinceDatestr(String sinceDatestr) {
		this.sinceDatestr = sinceDatestr;
	}

	public String getToDatestr() {
		return toDatestr;
	}

	public void setToDatestr(String toDatestr) {
		this.toDatestr = toDatestr;
	}

	public String getSelectDate() {
		return selectDate;
	}

	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
	}

	public String getSinceText() {
		return sinceText;
	}

	public void setSinceText(String sinceText) {
		this.sinceText = sinceText;
	}

	public String getToText() {
		return toText;
	}

	public void setToText(String toText) {
		this.toText = toText;
	}

	@Override
	public void setQuotaDetailFacade(QuotaDetailFacade quotaDetailFacade) {
		this.quotaDetailFacade = quotaDetailFacade;
	}

	public MovementDto getQuotaMove() {
		return quotaMove;
	}

	public void setQuotaMove(MovementDto quotaMove) {
		this.quotaMove = quotaMove;
	}
}
