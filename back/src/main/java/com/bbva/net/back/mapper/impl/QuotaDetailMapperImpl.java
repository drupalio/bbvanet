package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.QuotaDetailMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.mapper.converter.StringToDateConverter;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;

@Mapper(value = "quotaDetailMapper")
public class QuotaDetailMapperImpl extends ConfigurableMapper implements QuotaDetailMapper {

	/**
	 *
	 */
	@Override
	protected void configure(MapperFactory factory) {

		factory.getConverterFactory().registerConverter(new MoneyConverter());
		// Map Loan QuotaDetailDto

		factory.getConverterFactory().registerConverter(new StringToDateConverter("yyyy-MM-dd"));

		factory.classMap(Loan.class, QuotaDetailDto.class).field("payment.numbersOfQuota", "numberOfShares")
				.field("id", "id").field("payment.shortDate", "datePrevious").field("payment.dueDate", "dateMaturity")
				.field("payment.paymentDate", "datePayment").field("status", "state")
				.field("payment.minimumPayment", "minimumPayment").field("payment.fees", "feeCollection")
				.field("balance.availableBalance", "availableBalance").field("balance.total", "balancePrevious")
				.field("debt.availableBalance", "outstandingBalance").field("debt.total", "amountRequested")
				.byDefault().register();

		factory.classMap(RotaryQuotaMove.class, MovementDetailDto.class).field("id", "id").field("concept", "concept")
				.field("transactionDate", "operationDate").field("deb.availableBalance", "valueslope")
				.field("numbersOfQuotas", "numbersOfQuota").field("remainingQuotas", "remainingQuotas").byDefault()
				.register();

		factory.classMap(Movement.class, MovementDto.class).field("id", "movementId")
				.field("concept", "movementConcept").field("transactionDate", "movementDate")
				.field("operation.code", "movementDetailDto.operationCode")
				.field("operation.description", "movementDetailDto.operationDescription").field("status", "status")
				.field("value", "movementValue").field("balance", "totalBalance").byDefault().register();

	}

	@Override
	public QuotaDetailDto mapQuota(final Loan loan) {
		final QuotaDetailDto quotaDetailDto = map(loan, QuotaDetailDto.class);
		return quotaDetailDto;
	}

	@Override
	public MovementDetailDto mapQuotaMove(final RotaryQuotaMove rotaryQuotaMove) {
		final MovementDetailDto quotaMoveDetailDto = map(rotaryQuotaMove, MovementDetailDto.class);
		return quotaMoveDetailDto;

	}

	@Override
	public List<MovementDto> listRotaryQuotaMovements(final List<Movement> movement) {
		final List<MovementDto> quotaMovementsDto = mapAsList(movement, MovementDto.class);
		return quotaMovementsDto;
	}
}
