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

	@Value("${fiql.productMovements.date}")
	private String VALUE;
	
	@Value("${fiql.productMovements.customerId}")
	private String CUSTOMERID;
	
	@Value("${fiql.productMovements.productType}")
	private String PRODUCTTYPE;
	
	@Override
	public List<MovementDto> listMovements(String productId, String customerId, String productType, DateRangeDto dateRange,BalanceRangeDto balanceRange, Integer paginationKey, Integer pageSize) {
		String filter;
		if(dateRange == null & balanceRange == null){
			filter = fiqlService.getFiqlQueryByCustomerIdAndProductType(customerId, productType, CUSTOMERID, PRODUCTTYPE);
		}else		
		 filter = dateRange == null ? fiqlService.getFiqlQueryByCustomerIdAndProductType(customerId, productType, CUSTOMERID, PRODUCTTYPE)+fiqlService.getFiqlQueryByBalanceRange(balanceRange, VALUE, VALUE) :
			fiqlService.getFiqlQueryByCustomerIdAndProductType(customerId, productType, CUSTOMERID, PRODUCTTYPE)+fiqlService.getFiqlQueryByDateRange(dateRange, DATE, DATE);
		
		final List<Movement> movementList = this.productsService.listMovements(productId, filter, paginationKey, pageSize);
		return movementMapper.mapMovementDtoList(movementList);
	}

	@Override
	public MovementDetailDto getMovement(String productId, String customerId,String productType, String movementId) {
		String filter;
		filter =  fiqlService.getFiqlQueryByCustomerIdAndProductType(customerId, productType, CUSTOMERID, PRODUCTTYPE);
		Movement movement = this.productsService.getMovement(productId, movementId, filter);
		return movementMapper.mapMovement(movement);			
	}
}
