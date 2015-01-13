/**
 * 
 */
package com.bbva.net.back.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.springframework.stereotype.Service;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDto;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.CreditCardDto;
import com.bbva.net.back.model.globalposition.DepositDto;
import com.bbva.net.back.model.globalposition.FundDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;
import com.bbva.net.back.predicate.AssetPredicated;
import com.bbva.net.back.predicate.ProductTypePredicate;
import com.bbva.net.back.service.ProductService;
import com.bbva.net.core.collection.BbvaPredicate;
import com.bbva.net.core.utils.CollectionBbvaUtils;

/**
 * @author User
 */
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

	@Override
	public <T extends ProductDto> Money getTotal(final List<T> products) {
		return new Money(CollectionBbvaUtils.calculateTotal(products, "totalCash.amount"));
	}

	@Override
	public <T extends ProductDto> Money getTotalAvailable(final List<T> products) {
		return new Money(CollectionBbvaUtils.calculateTotal(products, "cashAvailable.amount"));
	}

	@Override
	public <T extends ProductDto> List<String> getNameProduct(final List<T> products) {
		return new ArrayList<String>(CollectionBbvaUtils.nameProduct(products, "productId"));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Money getTotalAssets(final List<ProductDto> products) {

		// Get only asset productos
		final List<ProductDto> assetsProduct = (List<ProductDto>)CollectionUtils
				.select(products, new AssetPredicated());

		// Calculate total cash from asset products
		return getTotal(assetsProduct);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Money getTotalFinanciacion(final List<ProductDto> products) {

		// Get only asset productos
		final List<ProductDto> assetsProduct = (List<ProductDto>)CollectionUtils.select(products,
				PredicateUtils.notPredicate(new AssetPredicated()));

		// Calculate total cash from asset products
		return getTotal(assetsProduct);

	}

	@Override
	public Map<String, BalanceDto> getTotals(final GlobalProductsDto globalProducts) {

		final Map<String, BalanceDto> totals = new HashMap<String, BalanceDto>();

		totals.put(EnumProductType.PC.name(), new BalanceDto(getTotalAvailable(globalProducts.getAccounts()),
				getTotal(globalProducts.getAccounts())));

		totals.put(EnumProductType.AQ.name(), new BalanceDto(getTotalAvailable(globalProducts.getAdquirencia()),
				getTotal(globalProducts.getAdquirencia())));

		totals.put(EnumProductType.TC.name(), new BalanceDto(getTotalAvailable(globalProducts.getCreditCards()),
				getTotal(globalProducts.getCreditCards())));

		totals.put(EnumProductType.RQ.name(), new BalanceDto(getTotalAvailable(globalProducts.getRotatingAccounts()),
				getTotal(globalProducts.getRotatingAccounts())));

		totals.put(EnumProductType.LI.name(), new BalanceDto(getTotalAvailable(globalProducts.getLeasings()),
				getTotal(globalProducts.getLeasings())));

		totals.put(EnumProductType.LO.name(), new BalanceDto(getTotalAvailable(globalProducts.getLoan()),
				getTotal(globalProducts.getLoan())));

		totals.put(EnumProductType.SI.name(), new BalanceDto(getTotalAvailable(globalProducts.getFunds()),
				getTotal(globalProducts.getFunds())));

		totals.put(EnumProductType.ED.name(), new BalanceDto(getTotalAvailable(globalProducts.getElectronicDeposits()),
				getTotal(globalProducts.getElectronicDeposits())));

		return totals;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Money getTotalProductsByType(final List<ProductDto> products, final EnumProductType productType) {

		final List<ProductDto> productsByType = (List<ProductDto>)CollectionUtils.select(products,
				new ProductTypePredicate(productType));

		return getTotal(productsByType);
	}

	/**
	 * 
	 */
	@Override
	public List<ProductDto> getProducts(final GlobalProductsDto globalProduct) {

		final List<ProductDto> products = new ArrayList<ProductDto>();

		products.addAll(globalProduct.getAccounts());
		products.addAll(globalProduct.getAdquirencia());
		products.addAll(globalProduct.getCreditCards());
		products.addAll(globalProduct.getElectronicDeposits());
		products.addAll(globalProduct.getFunds());
		products.addAll(globalProduct.getLeasings());
		products.addAll(globalProduct.getLoan());
		products.addAll(globalProduct.getRotatingAccounts());

		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public GlobalProductsDto select(final GlobalProductsDto globalProducts, final BbvaPredicate<ProductDto> predicate) {

		final GlobalProductsDto result = new GlobalProductsDto();

		result.setAccounts((List<AccountDto>)CollectionUtils.select(globalProducts.getAccounts(), predicate));
		result.setAdquirencia((List<AdquirenceAccountDto>)CollectionUtils.select(globalProducts.getAdquirencia(),
				predicate));
		result.setCreditCards((List<CreditCardDto>)CollectionUtils.select(globalProducts.getCreditCards(), predicate));
		result.setElectronicDeposits((List<DepositDto>)CollectionUtils.select(globalProducts.getElectronicDeposits(),
				predicate));
		result.setFunds((List<FundDto>)CollectionUtils.select(globalProducts.getFunds(), predicate));
		result.setLeasings((List<LeasingDto>)CollectionUtils.select(globalProducts.getLeasings(), predicate));
		result.setLoan((List<LoanDto>)CollectionUtils.select(globalProducts.getLoan(), predicate));
		result.setRotatingAccounts((List<RotatingAccountDto>)CollectionUtils.select(
				globalProducts.getRotatingAccounts(), predicate));

		return result;

	}

	@Override
	public Map<String, List<String>> getProductsName(GlobalProductsDto globalProducts) {

		final Map<String, List<String>> totals = new HashMap<String, List<String>>();

		totals.put(EnumProductType.PC.name(), getNameProduct(globalProducts.getAccounts()));

		totals.put(EnumProductType.AQ.name(), getNameProduct(globalProducts.getAdquirencia()));

		totals.put(EnumProductType.TC.name(), getNameProduct(globalProducts.getCreditCards()));

		totals.put(EnumProductType.RQ.name(), getNameProduct(globalProducts.getRotatingAccounts()));

		totals.put(EnumProductType.LI.name(), getNameProduct(globalProducts.getLeasings()));

		totals.put(EnumProductType.LO.name(), getNameProduct(globalProducts.getLoan()));

		totals.put(EnumProductType.SI.name(), getNameProduct(globalProducts.getFunds()));

		totals.put(EnumProductType.ED.name(), getNameProduct(globalProducts.getElectronicDeposits()));

		return totals;
	}

}
