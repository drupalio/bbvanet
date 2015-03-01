package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.mapper.QuotaDetailMapper;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.loan.LoanService;

@Facade(value = "quotaDetailFacade")
public class QuotaDetailFacadeImpl extends AbstractBbvaFacade implements QuotaDetailFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource(name = "quotaDetailMapper")
	private QuotaDetailMapper mapper;

	// CLIENTE REST
	@Resource(name = "loanService")
	private LoanService loanService;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	@Value("${fiql.productMovements.date}")
	private String transaccionDate;

	@Override
	public QuotaDetailDto getDetailRotaryQuota(String idLoan) {
		LOGGER.debug("Llamando al servicio de getRotaryQuota" + " Loan Id: " + idLoan);
		final Loan response = this.loanService.getRotaryQuota(idLoan);
		LOGGER.info("Comenzando mapeo del servicio getRotaryQuota (Loan -> QuotaDetailDto)");
		return mapper.mapQuota(response);
	}

	@Override
	public MovementDetailDto getRotaryQuotaMovement(String idLoan, String idMovement) {
		LOGGER.info("Llamando al servicio de getRotaryQuotaMovement" + " Loan Id: " + idLoan + " Movement Id: "
				+ idMovement);
		final RotaryQuotaMove response = this.loanService.getRotaryQuotaMovement(idLoan, idMovement);
		LOGGER.info("Comenzando mapeo del servicio getRotaryQuotaMovement (RotaryQuotaMove -> MovementDetailDto)");
		return mapper.mapQuotaMove(response);
	}

	@Override
	public List<MovementDto> listRotaryQuotaMovements(String loanId, DateRangeDto dateRange, Integer paginationKey,
			Integer pageSize) {

		String filter = dateRange != null ? fiqlService.getFiqlQueryByDateRange(dateRange, transaccionDate,
				transaccionDate) : StringUtils.EMPTY;
		if (dateRange != null)
			LOGGER.info("Creando fql dateRange" + " DateSince: " + dateRange.getDateSince() + " DateTo: "
					+ dateRange.getDateTo());
		LOGGER.info("Llamando al servicio de listRotaryQuotaMovements" + " Loan Id: " + loanId + " Filtro: " + filter);
		final List<Movement> response = this.loanService.listRotaryQuotaMovements(loanId, paginationKey, pageSize,
				filter);
		LOGGER.info("Comenzando mapeo del servicio listRotaryQuotaMovements (List<Movement> -> List<MovementDto>)");
		return mapper.listRotaryQuotaMovements(response);
	}

	public void setMapper(QuotaDetailMapper mapper) {
		this.mapper = mapper;
	}

	public void setLoanService(LoanService loanService) {
		this.loanService = loanService;
	}
}
