package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.bbva.czic.dto.net.Extracto;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.ExtractFacade;
import com.bbva.net.back.mapper.ExtractMapper;
import com.bbva.net.back.model.comboFilter.EnumMonthType;
import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.back.service.FiqlService;
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

	/**
	 * 
	 */
	@Resource(name = "fiqlService")
	protected FiqlService fiqlService;

	private List<ExtractDto> monthList = new ArrayList<ExtractDto>();

	/**
	 * 
	 */
	@Override
	public List<ExtractDto> getExtractAvailable(final String productId) {
		String cta18 = productId.substring(0, 8) + productId.substring(10,20);
		final List<Extracto> monthLi = this.productsService.listExtracts(cta18, StringUtils.EMPTY);
		List<ExtractDto> listMapped = this.extractMapper.map(monthLi);
		getMonthForInt(listMapped);
		return monthList;
	}

	@Override
	public List<ExtractDto> getDocumentExtract(final String productId, final ExtractDto $extract) {
		String cta18 = productId.substring(0, 8) + productId.substring(10,20);
		final String filter = $extract == null ? StringUtils.EMPTY : fiqlService.getFiqlQueryByExtract($extract);
		final List<Extracto> monthList = this.productsService.listExtracts(cta18, filter);
		return this.extractMapper.map(monthList);

	}

	/**
	 * convierte la lista de meses que llegan como valores enteros a su correspondiente nombre de mes, para mostrar en el
	 * combo mes en la vista de extrctos
	 * 
	 * @param listMont
	 */
	public void getMonthForInt(final List<ExtractDto> listMont) {

		for (ExtractDto extracto : listMont) {
			String monthIn = extracto.getMonth();
			extracto.setMonth(EnumMonthType.valueOfValue(monthIn).name());
			monthList.add(extracto);
		}

	}

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	public void setExtractMapper(ExtractMapper extractMapper) {
		this.extractMapper = extractMapper;
	}

}
