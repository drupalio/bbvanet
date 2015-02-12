package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.metadata.TypeFactory;

import org.apache.commons.logging.Log;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.Product;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
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

	protected static final Log LOGGER = I18nLogFactory.getLog(GlobalPositionMapperImpl.class);

	/**
	 * 
	 * 
	 */
	@Override
	public GlobalProductsDto map(final List<Product> products) {

		LOGGER.info("MAPEANDO PRODUCTOS: " + products.size());

		final GlobalProductsDto globalProducts = new GlobalProductsDto();

		new ProductVisitorCommand(products) {

			@Override
			public void executeRotatingAccount(final Product rotatingAccount) {

				LOGGER.info("Mapeando Rotating Account: " + rotatingAccount.getId());
				RotatingAccountDto product = map(rotatingAccount, RotatingAccountDto.class);
				product.setTypeProd(EnumProductType.RQ);
				globalProducts.getRotatingAccounts().add(product);
			}

			@Override
			public void executeLoan(final Product loan) {

				LOGGER.info("Mapeando Loan: " + loan.getId());

				LoanDto product = map(loan, RotatingAccountDto.class);
				product.setTypeProd(EnumProductType.LO);
				globalProducts.getLoan().add(product);
			}

			@Override
			public void executeLeasing(final Product leasing) {

				LOGGER.info("Mapeando Leasing: " + leasing.getId());

				LeasingDto product = map(leasing, LeasingDto.class);
				product.setTypeProd(EnumProductType.LI);
				globalProducts.getLeasings().add(product);
			}

			@Override
			public void executeFund(final Product fund) {

				LOGGER.info("Mapeando Fund: " + fund.getId());

				FundDto product = map(fund, FundDto.class);
				product.setTypeProd(EnumProductType.SI);
				globalProducts.getFunds().add(product);

			}

			@Override
			public void executeDeposit(final Product deposit) {

				LOGGER.info("Mapeando Deposit: " + deposit.getId());

				DepositDto product = map(deposit, DepositDto.class);
				product.setTypeProd(EnumProductType.ED);
				globalProducts.getElectronicDeposits().add(product);

			}

			@Override
			public void executeCredictCard(final Product creditCard) {

				LOGGER.info("Mapeando CreditCard: " + creditCard.getId());

				CreditCardDto product = map(creditCard, CreditCardDto.class);
				product.setTypeProd(EnumProductType.TC);
				globalProducts.getCreditCards().add(product);

			}

			@Override
			public void executeAdquirenceAccount(final Product adquirenceAccount) {

				LOGGER.info("Mapeando Adquiriencia: " + adquirenceAccount.getId());

				AdquirenceAccountDto product = map(adquirenceAccount, AdquirenceAccountDto.class);
				product.setTypeProd(EnumProductType.AQ);
				globalProducts.getAdquirencia().add(product);

			}

			@Override
			public void executeAccount(final Product account) {

				LOGGER.info("Mapeando Account: " + account.getId());

				AccountDto product = map(account, AccountDto.class);
				product.setTypeProd(EnumProductType.PC);
				globalProducts.getAccounts().add(product);
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
		factory.classMap(Product.class, ProductDto.class).field("alias", "alias").field("operable", "operationOnline")
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
