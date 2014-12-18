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
	public Money getTotalCash(final List<ProductDTO> products) {
		return new Money(CollectionBbvaUtils.calculateTotal(products, "totalCash.amount"));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Money getTotalAssets(final List<ProductDTO> products) {

		// Get only asset productos
		final List<ProductDTO> assetsProduct = (List<ProductDTO>)CollectionUtils
				.select(products, new AssetPredicated());

		// Calculate total cash from asset products
		return getTotalCash(assetsProduct);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Money getTotalFinanciacion(final List<ProductDTO> products) {

		// Get only asset productos
		final List<ProductDTO> assetsProduct = (List<ProductDTO>)CollectionUtils.select(products,
				PredicateUtils.notPredicate(new AssetPredicated()));

		// Calculate total cash from asset products
		return getTotalCash(assetsProduct);

	}

	@Override
	public Map<EnumProductType, Money> getTotals(GlobalProductsDTO globalProducts) {

		final Map<EnumProductType, Money> totals = new HashMap<EnumProductType, Money>();

		totals.put(EnumProductType.PC, getTotal(globalProducts.getAccounts()));
		totals.put(EnumProductType.AQ, getTotal(globalProducts.getAdquirencia()));
		totals.put(EnumProductType.TDC, getTotal(globalProducts.getCreditCards()));
		totals.put(EnumProductType.RQ, getTotal(globalProducts.getRotatingAccounts()));
		totals.put(EnumProductType.LI, getTotal(globalProducts.getLeasings()));
		totals.put(EnumProductType.LO, getTotal(globalProducts.getLoan()));
		totals.put(EnumProductType.SI, getTotal(globalProducts.getFunds()));
		totals.put(EnumProductType.ED, getTotal(globalProducts.getElectronicDeposits()));

		return totals;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Money getTotalProductsByType(final List<ProductDTO> products, final EnumProductType productType) {

		final List<ProductDTO> productsByType = (List<ProductDTO>)CollectionUtils.select(products,
				new ProductTypePredicate(productType));

		return getTotalCash(productsByType);
	}

	/**
	 * 
	 */
	@Override
	public List<ProductDTO> getProducts(GlobalProductsDTO globalProduct) {

		final List<ProductDTO> products = new ArrayList<ProductDTO>();

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
	public GlobalProductsDTO select(final GlobalProductsDTO globalProducts, final BbvaPredicate<ProductDTO> predicate) {

		final GlobalProductsDTO result = new GlobalProductsDTO();

		result.setAccounts((List<AccountDTO>)CollectionUtils.select(globalProducts.getAccounts(), predicate));
		result.setAdquirencia((List<AdquirenceAccountDTO>)CollectionUtils.select(globalProducts.getAdquirencia(),
				predicate));
		result.setCreditCards((List<CreditCardDTO>)CollectionUtils.select(globalProducts.getCreditCards(), predicate));
		result.setElectronicDeposits((List<DepositDTO>)CollectionUtils.select(globalProducts.getElectronicDeposits(),
				predicate));
		result.setFunds((List<FundDTO>)CollectionUtils.select(globalProducts.getFunds(), predicate));
		result.setLeasings((List<LeasingDTO>)CollectionUtils.select(globalProducts.getLeasings(), predicate));
		result.setLoan((List<LoanDTO>)CollectionUtils.select(globalProducts.getLoan(), predicate));
		result.setRotatingAccounts((List<RotatingAccountDTO>)CollectionUtils.select(
				globalProducts.getRotatingAccounts(), predicate));

		return result;

	}

	/**
	 * @param products
	 * @return
	 */
	private <T extends ProductDTO> Money getTotal(final List<T> products) {
		return getTotal(products);
	}

}
