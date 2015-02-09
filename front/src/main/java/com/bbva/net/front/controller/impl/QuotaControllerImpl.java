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

	@Resource(name = "TermsFacade")
	private transient TermasAccountsFacade detallesCuenta;

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	private QuotaDetailDto quotaDetailDto = new QuotaDetailDto();

	private MovementDetailDto quotaMoveDetailDto = new MovementDetailDto();

	private ProductDto productDto = new ProductDto();

	// complemento

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date");

	private Map<String, Boolean> renderComponents = new HashMap<String, Boolean>();

	private MovementDto movementDto = new MovementDto();

	private List<MovementDto> movenDtos = new ArrayList<MovementDto>();

	private DateRangeDto dateRange = new DateRangeDto();

	private Date sinceDate, toDate;

	private String sinceDatestr, toDatestr, selectDate;

	SimpleDateFormat dateFormat = new SimpleDateFormat();

	@PostConstruct
	public void init() {
		this.productDto = super.getSelectedProduct();
		this.quotaDetailDto = this.quotaDetailFacade.getDetailRotaryQuota(this.productDto.getProductId());
		renderComponents.put(RenderAttributes.MOVEMENTSTABLE.toString(), true);

		clean();
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
		this.quotaMoveDetailDto = this.quotaDetailFacade.getRotaryQuotaMovement(productDto.getProductId(), "556475");
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

	@Override
	public void setCustomDate(final ActionEvent event) {
		System.out.println("setCustomDate");

		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		if (!(getSinceDate() == (null)) && !(getToDate() == (null))) {
			sinceDatestr = "Desde: " + dateFormat.format(getSinceDate());
			toDatestr = "Hasta: " + dateFormat.format(getToDate());
		} else {
			sinceDatestr = getSelectDate();
		}
	}

	@Override
	public void clean() {

		renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
		renderComponents.put(RenderAttributes.BUTTONDATE.toString(), true);

		renderComponents.put(RenderAttributes.STATUS.toString(), true);
		renderComponents.put(RenderAttributes.BUTTONBOOK.toString(), true);

		renderComponents.put(RenderAttributes.FILTERSTATUS.toString(), false);
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), false);

	}

	// Setters and Getters

	/**
	 * @return the quotaDetailDto
	 */
	public QuotaDetailDto getQuotaDetailDto() {
		return quotaDetailDto;
	}

	/**
	 * @param quotaDetailDto the quotaDetailDto to set
	 */
	public void setQuotaDetailDto(QuotaDetailDto quotaDetailDto) {
		this.quotaDetailDto = quotaDetailDto;
	}

	/**
	 * @return the quotaMoveDetilDto
	 */
	public MovementDetailDto getQuotaMoveDetailDto() {
		return quotaMoveDetailDto;
	}

	/**
	 * @param quotaMoveDetailDto the quotaMoveDetailDto to set
	 */
	public void setQuotaMoveDetailDto(MovementDetailDto quotaMoveDetailDto) {
		this.quotaMoveDetailDto = quotaMoveDetailDto;
	}

	/**
	 * @return the productDto
	 */
	public ProductDto getProductDto() {
		return productDto;
	}

	/**
	 * @param productDto the productDto to set
	 */
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	/**
	 * @return the detallesCuenta
	 */
	public TermasAccountsFacade getDetallesCuenta() {
		return detallesCuenta;
	}

	/**
	 * @param detallesCuenta the detallesCuenta to set
	 */
	public void setDetallesCuenta(TermasAccountsFacade detallesCuenta) {
		this.detallesCuenta = detallesCuenta;
	}

	/**
	 * @return the quotaDetailFacade
	 */
	public QuotaDetailFacade getQuotaDetailFacade() {
		return quotaDetailFacade;
	}

	/**
	 * @param quotaDetailFacade the quotaDetailFacade to set
	 */
	public void setQuotaDetailFacade(QuotaDetailFacade quotaDetailFacade) {
		this.quotaDetailFacade = quotaDetailFacade;
	}

	public MovementDto getMovementDto() {
		return movementDto;
	}

	public void setMovementDto(MovementDto movementDto) {
		this.movementDto = movementDto;
	}

	public List<MovementDto> getMovenDtos() {
		return movenDtos;
	}

	public void setMovenDtos(List<MovementDto> movenDtos) {
		this.movenDtos = movenDtos;
	}

	public Map<String, Boolean> getRenderComponents() {
		return renderComponents;
	}

	public void setRenderComponents(Map<String, Boolean> renderComponents) {
		this.renderComponents = renderComponents;
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
}
