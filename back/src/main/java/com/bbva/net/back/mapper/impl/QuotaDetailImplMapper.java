package com.bbva.net.back.mapper.impl;

import com.bbva.czic.dto.net.Loan;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.QuotaDetailMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.model.quota.QuotaDetailDto;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Mapper(value = "quotaDetailMapper")
public class QuotaDetailImplMapper extends ConfigurableMapper
		implements
			QuotaDetailMapper {

	public QuotaDetailDto map(final Loan loan) {
		QuotaDetailDto quotaDetailDto = new QuotaDetailDto();
		quotaDetailDto = map(loan, QuotaDetailDto.class);
		return quotaDetailDto;
	}
	/**
	 *
	 */
	@Override
	protected void configure(MapperFactory factory) {

		factory.getConverterFactory().registerConverter(new MoneyConverter());
		// Map Loan QuotaDetailDto

		factory.classMap(Loan.class, QuotaDetailDto.class)
				.field("payment.numbersOfQuota", "numberOfShares")
				.field("id", "id").field("payment.shortDate", "datePrevious")
				.field("payment.dueDate", "dateMaturity")
				.field("payment.paymentDate", "datePayment")
				.field("status", "state")
				.field("payment.minimumPayment", "minimumPayment")
				.field("payment.fees", "feeCollection")
				.field("balance.availableBalance", "outstandingBalance")
				.field("balance.total", "amountRequested")
				.field("debt.availableBalance", "availableBalance")
				.field("debt.total", "balancePrevious").byDefault().register();

	}
}
