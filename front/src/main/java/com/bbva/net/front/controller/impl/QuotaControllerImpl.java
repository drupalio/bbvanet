/**
 * 
 */
package com.bbva.net.front.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.facade.TermasAccountsFacade;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.QuotaController;

/**
 * @author User
 */

public class QuotaControllerImpl extends CheckPaginatedController implements QuotaController {

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

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	// private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date");
	//
	// private static final String SINCE_TITLE = MessagesHelper.INSTANCE.getString("text.since");
	//
	// private static final String TO_TITLE = MessagesHelper.INSTANCE.getString("text.to");

	@Resource(name = "TermsFacade")
	private transient TermasAccountsFacade detallesCuenta;

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	@PostConstruct
	public void init() {
		LOGGER.info("Initialize QuotaController");
		this.productDto = super.getSelectedProduct();
		if (productDto != null) {
			LOGGER.info("Datos del producto Seleccionado Terminado " + " Product Id: " + productDto.getProductId());
		} else {
			this.productDto = new ProductDto();
			LOGGER.info("Datos del producto Seleccionado Vacio (null)");
		}

		this.quotaDetailDto = this.quotaDetailFacade.getDetailRotaryQuota(this.productDto.getProductId());
		LOGGER.info("Datos del quotaDetailDto Terminados" + " Product Id: " + quotaDetailDto.getId());
		maturityDate = dateFormat.format(this.quotaDetailDto.getDateMaturity());
		previousDate = dateFormat.format(this.quotaDetailDto.getDatePrevious());
		paymentDate = dateFormat.format(this.quotaDetailDto.getDatePayment());
		LOGGER.info("Finalizado formateo de fechas del producto");

		if (quotamovenDtos == null) {
			getAllQuotamovenDtos();
		}

		clean();
	}

	public DateRangeDto calculateQuotaFilters(String date) {
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

	@Override
	public List<MovementDto> getAllQuotamovenDtos() {
		DateRangeDto dateRanget = calculateQuotaFilters("Último mes");
		this.quotamovenDtos = this.quotaDetailFacade.listRotaryQuotaMovements(this.productDto.getProductId(),
				dateRanget, 1, 10);
		LOGGER.info("Datos de los movimientos llenos ");
		return quotamovenDtos;
	}

	@Override
	public void setSelectedProduct(ProductDto selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

	@Override
	public TermsAccountsDto getAllConditions() {
		TermsAccountsDto detalle = this.detallesCuenta.getAllConditions("00130073000296247953");
		LOGGER.info("Datos del detalle de la cuenta: " + this.productDto.getProductId() + " Llenos");
		return detalle;
	}

	public void onRowToggle(SelectEvent event) {
		super.onMovementSelected(event);
		this.quotaMoveDetailDto = this.quotaDetailFacade.getRotaryQuotaMovement(this.productDto.getProductId(),
				getSelectedMovements().getMovementId());
		LOGGER.info("Movimiento Seleccionado " + quotaMoveDetailDto.getId());
		this.moveDate = dateFormat.format(this.quotaMoveDetailDto.getOperationDate());
		LOGGER.info("Finalizado formateo de fechas del movimiento");
	}

	@Override
	public void oneSelectDate() {

		LOGGER.info("Método oneSelectDate");

		// renderComponents.put(RenderAttributes.FILTERDATE.toString(), true);
		//
		// if (getSelectDate().equals(CONCRETE_DATE)) {
		// renderComponents.put(RenderAttributes.CALENDAR.toString(), false);
		// renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);
		//
		// } else {
		// renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
		// renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);
		//
		// }
	}

	@Override
	public void setCustomDate(final ActionEvent event) {

		LOGGER.info("Método setCustomDate");
		//
		// this.dateRange.setDateSince(getSinceDate());
		// this.dateRange.setDateTo(getToDate());
		// if (!(getSinceDate() == (null)) && !(getToDate() == (null))) {
		// this.sinceText = SINCE_TITLE + ": ";
		// this.toText = TO_TITLE + ": ";
		// this.sinceDatestr = dateFormat.format(getSinceDate());
		// this.toDatestr = dateFormat.format(getToDate());
		// } else {
		// sinceDatestr = getSelectDate();
		// }
	}

	@Override
	public void searchQuotaByFilter(final ActionEvent event) {

		LOGGER.info("Método searchQuotaByFilter");

		renderComponents.get(RenderAttributes.FILTERDATE.toString());
	}

	private void clean() {
		LOGGER.info("Método clean");
		renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
		renderComponents.put(RenderAttributes.BUTTONDATE.toString(), true);
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

	public QuotaDetailFacade getQuotaDetailFacade() {
		return quotaDetailFacade;
	}

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

	/**
	 * @return the quotaMove
	 */
	public MovementDto getQuotaMove() {
		return quotaMove;
	}

	/**
	 * @param quotaMove the quotaMove to set
	 */
	public void setQuotaMove(MovementDto quotaMove) {
		this.quotaMove = quotaMove;
	}
}
