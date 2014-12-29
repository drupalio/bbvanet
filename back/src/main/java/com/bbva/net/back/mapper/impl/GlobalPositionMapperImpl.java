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
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDTO;
import com.bbva.net.back.model.globalposition.CreditCardDTO;
import com.bbva.net.back.model.globalposition.DepositDTO;
import com.bbva.net.back.model.globalposition.FundDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.LoanDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;

@Mapper(value = "globalPositionMapper")
public class GlobalPositionMapperImpl extends ConfigurableMapper implements GlobalPositionMapper {

	/**
	 * 
	 * 
	 */
	@Override
	public GlobalProductsDTO map(final List<Product> products) {

		final GlobalProductsDTO globalProducts = new GlobalProductsDTO();

		new ProductVisitorCommand(products) {

			@Override
			public void executeRotatingAccount(final Product rotatingAccount) {
				globalProducts.getRotatingAccounts().add(map(rotatingAccount, RotatingAccountDTO.class));
			}

			@Override
			public void executeLoan(final Product loan) {
				globalProducts.getLoan().add(map(loan, LoanDTO.class));
			}

			@Override
			public void executeLeasing(final Product leasing) {
				globalProducts.getLeasings().add(map(leasing, LeasingDTO.class));
			}

			@Override
			public void executeFund(final Product fund) {
				globalProducts.getFunds().add(map(fund, FundDTO.class));
			}

			@Override
			public void executeDeposit(final Product deposit) {
				globalProducts.getElectronicDeposits().add(map(deposit, DepositDTO.class));
			}

			@Override
			public void executeCredictCard(final Product creditCard) {
				globalProducts.getCreditCards().add(map(creditCard, CreditCardDTO.class));
			}

			@Override
			public void executeAdquirenceAccount(final Product adquirenceAccount) {
				globalProducts.getAdquirencia().add(map(adquirenceAccount, AdquirenceAccountDTO.class));

			}

			@Override
			public void executeAccount(final Product account) {
				globalProducts.getAccounts().add(map(account, AccountDTO.class));
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
		factory.registerObjectFactory(new ProductDTOFactory(), TypeFactory.<ProductDTO> valueOf(ProductDTO.class));

		// Add Money Converter
		factory.getConverterFactory().registerConverter(new MoneyConverter());

		// Financial State Converter
		factory.getConverterFactory().registerConverter(new FinancialStateConverter());
		factory.getConverterFactory().registerConverter(new AssetConverter());

		// Map parent Product DTO
		factory.classMap(Product.class, ProductDTO.class).field("alias", "alias")
				.field("balance.availableBalance", "cashAvailable").field("id", "productId")
				.field("name", "productName").field("id", "productNumber").field("balance.total", "totalCash")
				.field("financialState", "asset").field("type", "typeProd").field("visible", "visible").byDefault()
				.register();

		// Map Loan DTO
		factory.classMap(Product.class, LoanDTO.class).field("balance.availableBalance", "totalDue")
				.field("balance.total", "totalDebt").byDefault().register();

		// Map RotatingAccount DTO
		factory.classMap(Product.class, RotatingAccountDTO.class)
				.field("balance.availableBalance", "quota.availableQuota")
				.field("balance.total", "quota.totalQuotaDebt").byDefault().register();

		// Map CreditCard DTO
		factory.classMap(Product.class, CreditCardDTO.class).field("balance.availableBalance", "quota.availableQuota")
				.field("balance.total", "quota.totalQuotaDebt").byDefault().register();
	}

}
