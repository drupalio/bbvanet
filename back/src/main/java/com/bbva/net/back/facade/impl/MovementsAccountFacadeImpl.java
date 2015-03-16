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

@Facade(value = "movementsAccountFacade")
public class MovementsAccountFacadeImpl extends AbstractBbvaFacade implements MovementsAccountFacade {

	private static final long serialVersionUID = 1L;

	// CLIENTE REST
	@Resource(name = "productsService")
	private ProductsService productsService;

	@Resource(name = "movementsMapper")
	private MovementsMapper movementMapper;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	@Value("${fiql.productMovements.date}")
	private String DATE;

	@Value("${fiql.productMovements.value}")
	private String VALUE;

	@Value("${fiql.productMovements.customerId}")
	private String CUSTOMERID;

	@Value("${fiql.productMovements.productType}")
	private String PRODUCTTYPE;

	@Override
	public List<MovementDto> listMovements(String productId, String productType, DateRangeDto dateRange,
			BalanceRangeDto balanceRange, Integer paginationKey, Integer pageSize) {
		String filter;
		if (dateRange == null & balanceRange == null) {
			filter = fiqlService.getFiqlQueryByCustomerIdAndProductType(productType, PRODUCTTYPE);
		} else
			filter = dateRange == null ? fiqlService.getFiqlQueryByCustomerIdAndProductType(productType, PRODUCTTYPE)
					+ ";" + fiqlService.getFiqlQueryByBalanceRange(balanceRange, VALUE, VALUE) : fiqlService
					.getFiqlQueryByCustomerIdAndProductType(productType, PRODUCTTYPE)
					+ ";"
					+ fiqlService.getFiqlQueryByDateRange(dateRange, DATE, DATE);

		final List<Movement> movementList = this.productsService.listMovements(productId, filter, paginationKey,
				pageSize);
		return movementMapper.mapMovementDtoList(movementList);
	}

	@Override
	public MovementDetailDto getMovement(String productId, String productType, String movementId) {
		final String filter = fiqlService.getFiqlQueryByCustomerIdAndProductType(productType, PRODUCTTYPE);
		Movement movement = this.productsService.getMovement(productId, movementId, filter);
		return movementMapper.mapMovement(movement);
	}

	/**
	 * @param productsService the productsService to set
	 */
	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	/**
	 * @param movementMapper the movementMapper to set
	 */
	public void setMovementMapper(MovementsMapper movementMapper) {
		this.movementMapper = movementMapper;
	}

	/**
	 * @param fiqlService the fiqlService to set
	 */
	public void setFiqlService(FiqlService fiqlService) {
		this.fiqlService = fiqlService;
	}
}
