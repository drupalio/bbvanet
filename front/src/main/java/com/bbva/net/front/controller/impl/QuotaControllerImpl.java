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

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ToggleEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.facade.TermasAccountsFacade;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.front.controller.QuotaController;
import com.bbva.net.front.helper.MessagesHelper;

/**
 * @author User
 */

@Controller(value = "quotaController")
@Scope(value = "globalSession")
public class QuotaControllerImpl extends CheckPaginatedController implements QuotaController {

	private static final long serialVersionUID = 1L;

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date");

	private static final String SINCE_TITLE = MessagesHelper.INSTANCE.getString("text.since");

	private static final String TO_TITLE = MessagesHelper.INSTANCE.getString("text.to");

	private QuotaDetailDto quotaDetailDto = new QuotaDetailDto();

	private MovementDetailDto quotaMoveDetailDto = new MovementDetailDto();

	private ProductDto productDto = new ProductDto();

	private Map<String, Boolean> renderComponents = new HashMap<String, Boolean>();

	private List<MovementDto> quotamovenDtos;

	private DateRangeDto dateRange = new DateRangeDto();

	private Date sinceDate, toDate;

	private String sinceText, toText, sinceDatestr, toDatestr, selectDate, moveDate, maturityDate, previousDate,
			paymentDate;

	SimpleDateFormat dateFormat = new SimpleDateFormat(MessagesHelper.INSTANCE.getStringI18("date.pattner.dd.mm.yyyy"));

	@Resource(name = "TermsFacade")
	private transient TermasAccountsFacade detallesCuenta;

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	@PostConstruct
	public void init() {
		this.productDto = super.getSelectedProduct();
		this.quotaDetailDto = this.quotaDetailFacade.getDetailRotaryQuota("00130073000296247953");
		maturityDate = dateFormat.format(this.quotaDetailDto.getDateMaturity());
		previousDate = dateFormat.format(this.quotaDetailDto.getDatePrevious());
		paymentDate = dateFormat.format(this.quotaDetailDto.getDatePayment());

		if (quotamovenDtos == null) {
			getAllQuotamovenDtos();
		}

		clean();
	}

	@Override
	public List<MovementDto> getAllQuotamovenDtos() {
		System.out.println("llenando los movimientos");
		this.quotamovenDtos = this.quotaDetailFacade.listRotaryQuotaMovements("00130073000296247953", null, 1, 10);
		return quotamovenDtos;
	}

	@Override
	public void setSelectedProduct(ProductDto selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

	@Override
	public TermsAccountsDto getAllConditions() {
		TermsAccountsDto detalle = this.detallesCuenta.getAllConditions("00130073000296247953");
		return detalle;
	}

	public void onRowToggle(ToggleEvent event) {
		System.out.println("data onRowToggle");
		this.quotaMoveDetailDto = this.quotaDetailFacade.getRotaryQuotaMovement("00130073000296247953", "556475");
		this.moveDate = dateFormat.format(this.quotaMoveDetailDto.getOperationDate());
	}

	@Override
	public void oneSelectDate() {

		System.out.println("onSelecDate de Quota");

		renderComponents.put(RenderAttributes.FILTERDATE.toString(), true);

		if (getSelectDate().equals(CONCRETE_DATE)) {
			renderComponents.put(RenderAttributes.CALENDAR.toString(), false);
			renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);

		} else {
			renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
			renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);

		}
	}

	@Override
	public void setCustomDate(final ActionEvent event) {

		System.out.println("setCustomDate de quota");

		renderComponents.put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), true);

		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		if (!(getSinceDate() == (null)) && !(getToDate() == (null))) {
			this.sinceText = SINCE_TITLE + ": ";
			this.toText = TO_TITLE + ": ";
			this.sinceDatestr = dateFormat.format(getSinceDate());
			this.toDatestr = dateFormat.format(getToDate());
		} else {
			sinceDatestr = getSelectDate();
		}
	}

	@Override
	public void searchQuotaByFilter(final ActionEvent event) {

		System.out.println("searchQuotaByFilter");

		renderComponents.get(RenderAttributes.FILTERDATE.toString());
	}

	private void clean() {
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
}
