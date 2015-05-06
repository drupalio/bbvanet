package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.Movement;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.MovementsAccountFacade;
import com.bbva.net.back.mapper.MovementsMapper;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.products.ProductsService;

/**
 * @author Entelgy
 */
@Facade(value = "movementsAccountFacade")
public class MovementsAccountFacadeImpl extends AbstractBbvaFacade implements MovementsAccountFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ClIENTE REST
	 */
	@Resource(name = "productsService")
	private ProductsService productsService;

	/**
	 * 
	 */
	@Resource(name = "movementsMapper")
	private MovementsMapper movementMapper;

	/**
	 * 
	 */
	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	/**
	 * 
	 */
	@Value("${fiql.productMovements.date}")
	private String DATE;

	/**
	 * 
	 */
	@Value("${fiql.productMovements.value}")
	private String VALUE;

	/**
	 * 
	 */
	@Value("${fiql.productMovements.customerId}")
	private String CUSTOMERID;

	/**
	 * 
	 */
	@Value("${fiql.productMovements.productType}")
	private String PRODUCTTYPE;

	/**
	 * 
	 */
	@Override
	public List<MovementDto> listMovements(final String productId, final String productType,
			final DateRangeDto dateRange, final BalanceRangeDto balanceRange, final Integer paginationKey,
			final Integer pageSize) {
		String filter;
		if (dateRange == null) {
			filter = fiqlService.getFiqlQueryByCustomerIdAndProductType(productType, PRODUCTTYPE);
		} else {
			filter = fiqlService.getFiqlQueryByCustomerIdAndProductType(productType, PRODUCTTYPE) + ";"
					+ fiqlService.getFiqlQueryByDateRange(dateRange, DATE, DATE);
		}
		final List<Movement> movementList = this.productsService.listMovements(productId, filter, paginationKey,
				pageSize);
		return movementMapper.mapMovementDtoList(movementList);
	}

	/**
	 * 
	 */
	@Override
	public MovementDetailDto getMovement(final String productId, final String productType, final String movementId) {
		final String filter = fiqlService.getFiqlQueryByCustomerIdAndProductType(productType, PRODUCTTYPE);
		final Movement movement = this.productsService.getMovement(productId, movementId, filter);
		return movementMapper.mapMovement(movement);
	}

	/**
	 * @param productsService the productsService to set
	 */
	public void setProductsService(final ProductsService productsService) {
		this.productsService = productsService;
	}

	/**
	 * @param movementMapper the movementMapper to set
	 */
	public void setMovementMapper(final MovementsMapper movementMapper) {
		this.movementMapper = movementMapper;
	}

	/**
	 * @param fiqlService the fiqlService to set
	 */
	public void setFiqlService(final FiqlService fiqlService) {
		this.fiqlService = fiqlService;
	}
}
