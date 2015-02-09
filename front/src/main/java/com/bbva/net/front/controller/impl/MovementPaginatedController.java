package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.facade.MovementsAccountFacade;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.core.PaginationController;

public class MovementPaginatedController extends PaginationController<MovementDto> {

	private static final long serialVersionUID = 1L;

	List<MovementDto> movementsList = null;

	@Resource(name = "movementsAccountFacade")
	private transient MovementsAccountFacade movementsFacade;

	@Override
	protected List<MovementDto> getNextPage(int paginantionKey, int psize) {
		movementsList = new ArrayList<MovementDto>();
		movementsList = this.movementsFacade.listMovements(
				"00130073000296247953"/* getSelectedProduct().getProductId() */, getCurrentUser(), null, null, null, 1,
				10);

		return movementsList;
	}

}
