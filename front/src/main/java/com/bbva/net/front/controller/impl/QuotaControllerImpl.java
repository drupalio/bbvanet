/**
 * 
 */
package com.bbva.net.front.controller.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang.StringUtils;
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

	private QuotaDetailDto quotaDetailDto = new QuotaDetailDto();

	private MovementDetailDto quotaMoveDetailDto = new MovementDetailDto();

	private ProductDto productDto = new ProductDto();

	private MovementDto quotaMove = new MovementDto();

	private Map<String, Boolean> renderComponents = new HashMap<String, Boolean>();

	private List<MovementDto> quotamovenDtos;

	private DateRangeDto dateRange = new DateRangeDto();

	private Date sinceDate, toDate;

	private String sinceText, toText, sinceDatestr, toDatestr, selectDate, moveDate, maturityDate, previousDate,
			paymentDate;

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	SimpleDateFormat dateFormat = new SimpleDateFormat(MessagesHelper.INSTANCE.getStringI18("date.pattner.dd.mm.yyyy"));

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date");

	private static final String SINCE_TITLE = MessagesHelper.INSTANCE.getString("text.since");

	private static final String TO_TITLE = MessagesHelper.INSTANCE.getString("text.to");

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	@Override
	public void init() {
		super.init();
		LOGGER.info("Initialize QuotaController");
		this.productDto = getSelectProduct();
		if (productDto != null && productDto.getProductId() != null) {
			LOGGER.info("Datos del producto Seleccionado Terminado " + " Product Id: " + productDto.getProductId());
			this.quotaDetailDto = this.quotaDetailFacade.getDetailRotaryQuota(this.productDto.getProductId());
			LOGGER.info("Datos del quotaDetailDto Terminados" + " Product Id: " + quotaDetailDto.getId());
		} else {
			LOGGER.info("Datos del producto Seleccionado Vacio (null)");
		}

		if (quotaDetailDto.getDateMaturity() != null && quotaDetailDto.getDatePayment() != null
				&& quotaDetailDto.getDatePrevious() != null) {
			maturityDate = dateFormat.format(this.quotaDetailDto.getDateMaturity());
			previousDate = dateFormat.format(this.quotaDetailDto.getDatePrevious());
			paymentDate = dateFormat.format(this.quotaDetailDto.getDatePayment());
			LOGGER.info("Finalizado formateo de fechas del producto");
		} else {
			LOGGER.info("Error datos nulos " + "Fecha de vencimento  " + quotaDetailDto.getDateMaturity()
					+ " Fecha de pago " + quotaDetailDto.getDatePayment() + " Fecha de corte anterior "
					+ quotaDetailDto.getDatePrevious());
		}

		// setTitle(MessagesHelper.INSTANCE.getString("text.last.movments"));
		cleanFilters();
	}

	@Override
	public ProductDto getSelectProduct() {
		return super.getSelectedProduct();
	}

	@Override
	public void cleanFilters() {
		LOGGER.info("Limpiando filtros");
		renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
		renderComponents.put(RenderAttributes.BUTTONDATE.toString(), true);
		// Filtros
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), false);

	}

	@Override
	public void cleanFilters(ActionEvent event) {
		LOGGER.info("Restaurando filtros");
		movementCriteria = new MovementCriteriaDto();
		movementCriteria.setDateRange(new DateRangeDto());
		setSinceText(new String());
		setToText(new String());
		setSinceDatestr(new String());
		setToDatestr(new String());
		sinceDate = new Date();
		toDate = new Date();
		selectDate = new String();
		cleanFilters();
	}

	private DateRangeDto calculateQuotaFilters(final String date) {
		DateRangeDto dateRangeInit = new DateRangeDto();
		LOGGER.info("Buscando el EnumPeriodType: " + date);
		EnumPeriodType periodTypeFilter = EnumPeriodType.valueOfLabel(date);
		if (!(periodTypeFilter == null)) {
			dateRangeInit = new DateFilterServiceImpl().getPeriodFilter(periodTypeFilter);
			LOGGER.info("Realizado el rango de fechas: " + " DateSince: " + dateRangeInit.getDateSince() + " DateTo: "
					+ dateRangeInit.getDateTo());
		}
		return dateRangeInit;
	}

	private void setShowMoreStatus(final List<MovementCriteriaDto> movementsList) {
		if (movementsList.size() >= 10)
			getRenderComponents().put(RenderAttributes.FOOTERTABLEQUOTA.toString(), true);
		else
			getRenderComponents().put(RenderAttributes.FOOTERTABLEQUOTA.toString(), false);
	}

	@Override
	public List<MovementDto> getAllQuotamovenDtos() {

		DateRangeDto dateRanget = calculateQuotaFilters(MessagesHelper.INSTANCE.getString("select.radio.last.month"));
		try {
			this.quotamovenDtos = this.quotaDetailFacade.listRotaryQuotaMovements(this.productDto.getProductId(),
					dateRanget, 1, 10);
		} catch (final Exception e) {
			return new ArrayList<MovementDto>();
		}
		LOGGER.info("Datos de los movimientos llenos ");
		return quotamovenDtos;
	}

	@Override
	public void setSelectedProduct(ProductDto selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

	public void onRowToggle(SelectEvent event) {
		super.onMovementSelected(event);
		this.quotaMoveDetailDto = this.quotaDetailFacade.getRotaryQuotaMovement(this.productDto.getProductId(),
				getSelectedMovements().getMovementId());
		LOGGER.info("Movimiento Seleccionado " + quotaMoveDetailDto.getId());

		if (!(quotaMoveDetailDto.getOperationDate() == null)) {
			this.moveDate = dateFormat.format(this.quotaMoveDetailDto.getOperationDate());
			LOGGER.info("Finalizado formateo de fechas del movimiento");
		} else {
			LOGGER.info("Error en formateo de fechas del movimiento " + quotaMoveDetailDto.getOperationDate());
		}
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

		LOGGER.info("Método setCustomDate");
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), true);

		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		if (!(getSinceDate() == (null)) && !(getToDate() == (null)) && getSelectDate().equals(CONCRETE_DATE)) {
			this.sinceText = SINCE_TITLE + ": ";
			this.toText = TO_TITLE + ": ";
			this.sinceDatestr = dateFormat.format(getSinceDate());
			this.toDatestr = dateFormat.format(getToDate());
			LOGGER.info(SINCE_TITLE + " " + sinceDatestr + " " + TO_TITLE + " " + toDatestr);
		} else {
			sinceDatestr = getSelectDate();
			toDatestr = StringUtils.EMPTY;
			LOGGER.info("RadioButton escogido: " + getSelectDate());
		}
	}

	@Override
	public void searchQuotaByFilter(final ActionEvent event) {
		if (renderComponents.get(RenderAttributes.FILTERDATE.toString())) {
			this.dateRange = calculateQuotaFilters(this.getSelectDate());
			criteriaSearch();
			LOGGER.info("Mostrando resultados de filtros " + "Date Since: " + dateRange.getDateSince() + "Date To: "
					+ dateRange.getDateTo());
		}
	}

	@Override
	public void nextPage(ActionEvent event) {
		LOGGER.info("Buscando mas resultados");
		next();
		this.quotamovenDtos = getCurrentList();
	}

	@Override
	public void criteriaSearch() {

		LOGGER.info("Method criteriaSearch");

		if (this.dateRange != null) {
			setDateRangePControl(this.dateRange);
			LOGGER.info("date Range: " + " sinceDate: " + this.dateRange.getDateSince() + " toDate: "
					+ this.dateRange.getDateTo());
		}
		setProductIdPControl(getSelectedProduct().getProductId());
		super.init();
		search();
		this.quotamovenDtos = getCurrentList();
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
	public QuotaDetailFacade getQuotaDetailFacade() {
		return quotaDetailFacade;
	}

	@Override
	public void setQuotaDetailFacade(QuotaDetailFacade quotaDetailFacade) {
		this.quotaDetailFacade = quotaDetailFacade;
	}

	public String getMoveDate() {
		return moveDate;
	}

	public void setMoveDate(String moveDate) {
		this.moveDate = moveDate;
	}

	public String getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getPreviousDate() {
		return previousDate;
	}

	public void setPreviousDate(String previousDate) {
		this.previousDate = previousDate;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public MovementDto getQuotaMove() {
		return quotaMove;
	}

	public void setQuotaMove(MovementDto quotaMove) {
		this.quotaMove = quotaMove;
	}
}
