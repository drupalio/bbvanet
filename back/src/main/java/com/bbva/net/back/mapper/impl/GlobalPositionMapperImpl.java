package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.metadata.TypeFactory;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.command.ProductVisitorCommand;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.GlobalPositionMapper;
import com.bbva.net.back.mapper.converter.AssetConverter;
import com.bbva.net.back.mapper.converter.FinancialStateConverter;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.mapper.factory.ProductDTOFactory;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDto;
import com.bbva.net.back.model.globalposition.CreditCardDto;
import com.bbva.net.back.model.globalposition.DepositDto;
import com.bbva.net.back.model.globalposition.FundDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;

@Mapper(value = "globalPositionMapper")
public class GlobalPositionMapperImpl extends ConfigurableMapper implements GlobalPositionMapper {

	/**
	 * 
	 * 
	 */
	@Override
	public GlobalProductsDto map(final List<Product> products) {

		final GlobalProductsDto globalProducts = new GlobalProductsDto();

		new ProductVisitorCommand(products) {

			@Override
			public void executeRotatingAccount(final Product rotatingAccount) {
				globalProducts.getRotatingAccounts().add(map(rotatingAccount, RotatingAccountDto.class));
			}

			@Override
			public void executeLoan(final Product loan) {
				globalProducts.getLoan().add(map(loan, LoanDto.class));
			}

			@Override
			public void executeLeasing(final Product leasing) {
				globalProducts.getLeasings().add(map(leasing, LeasingDto.class));
			}

			@Override
			public void executeFund(final Product fund) {
				globalProducts.getFunds().add(map(fund, FundDto.class));
			}

			@Override
			public void executeDeposit(final Product deposit) {
				globalProducts.getElectronicDeposits().add(map(deposit, DepositDto.class));
			}

			@Override
			public void executeCredictCard(final Product creditCard) {
				globalProducts.getCreditCards().add(map(creditCard, CreditCardDto.class));
			}

			@Override
			public void executeAdquirenceAccount(final Product adquirenceAccount) {
				globalProducts.getAdquirencia().add(map(adquirenceAccount, AdquirenceAccountDto.class));

			}

			@Override
			public void executeAccount(final Product account) {
				globalProducts.getAccounts().add(map(account, AccountDto.class));
			}
		};

		return globalProducts;
	}

	/**
	 * 
	 */
	@Override
	protected void configure(MapperFactory factory) {

		// Add ProductDTO Factory
		factory.registerObjectFactory(new ProductDTOFactory(), TypeFactory.<ProductDto> valueOf(ProductDto.class));

		// Add Money Converter
		factory.getConverterFactory().registerConverter(new MoneyConverter());

		// Financial State Converter
		factory.getConverterFactory().registerConverter(new FinancialStateConverter());
		factory.getConverterFactory().registerConverter(new AssetConverter());

		// Map parent Product DTO
		factory.classMap(Product.class, ProductDto.class).field("alias", "alias")
				.field("balance.availableBalance", "cashAvailable").field("id", "productId")
				.field("name", "productName").field("id", "productNumber").field("balance.total", "totalCash")
				.field("financialState", "asset").field("type", "subTypeProd").field("visible", "visible").byDefault()
				.register();

		// Map Loan DTO
		factory.classMap(Product.class, LoanDto.class).field("balance.availableBalance", "totalDue")
				.field("balance.total", "totalDebt").byDefault().register();

		// Map RotatingAccount DTO
		factory.classMap(Product.class, RotatingAccountDto.class)
				.field("balance.availableBalance", "quota.availableQuota")
				.field("balance.total", "quota.totalQuotaDebt").byDefault().register();

		// Map CreditCard DTO
		factory.classMap(Product.class, CreditCardDto.class).field("balance.availableBalance", "quota.availableQuota")
				.field("balance.total", "quota.totalQuotaDebt").byDefault().register();
	}

}
