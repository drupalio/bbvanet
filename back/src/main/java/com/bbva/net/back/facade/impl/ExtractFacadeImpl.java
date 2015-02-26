package com.bbva.net.back.facade.impl;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hsqldb.lib.StringUtil;

import com.bbva.czic.dto.net.Extracto;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.ExtractFacade;
import com.bbva.net.back.mapper.ExtractMapper;
import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.webservices.products.ProductsService;

/**
 * @author Entelgy
 */
@Facade(value = "extractFacade")
public class ExtractFacadeImpl extends AbstractBbvaFacade implements ExtractFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3532178233798826755L;

	/**
	 * 
	 */
	@Resource(name = "productsService")
	protected ProductsService productsService;

	/**
	 * 
	 */
	@Resource(name = "extractMapper")
	protected ExtractMapper extractMapper;

	private List<Extracto> monthList = new ArrayList<Extracto>();

	/**
	 * 
	 */
	@Override
	public List<ExtractDto> getExtractAvailablePeriod(final String productId, final String $filter) {

		final String filter = StringUtils.isEmpty($filter) ? StringUtils.EMPTY : "fiqlService.getFiqlQuery";
		final List<Extracto> monthList = this.productsService.listExtracts(productId, filter);
		if (!StringUtil.isEmpty(filter)) getMonthForInt(monthList);
		return this.extractMapper.map(monthList);
	}

	/**
	 * convierte la lista de meses que llegan como valores enteros a su correspondiente nombre de mes, para mostrar en el
	 * combo mes en la vista de extrctos
	 * 
	 * @param listMont
	 */
	public void getMonthForInt(final List<Extracto> listMont) {

		String[] months = new DateFormatSymbols().getMonths();

		for (Extracto extracto : listMont) {
			extracto.setMonth(months[Integer.parseInt(extracto.getMonth()) - 1]);
			monthList.add(extracto);
			System.out.println();
		}
	}

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	public void setExtractMapper(ExtractMapper extractMapper) {
		this.extractMapper = extractMapper;
	}

	public List<Extracto> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<Extracto> monthList) {
		this.monthList = monthList;
	}

}
