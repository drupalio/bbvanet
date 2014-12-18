/**
 * 
 */
package com.bbva.net.back.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.springframework.stereotype.Service;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.command.ProductVisitorCommand;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.CreditCardDTO;
import com.bbva.net.back.model.globalposition.DepositDTO;
import com.bbva.net.back.model.globalposition.FundDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;
import com.bbva.net.back.predicate.AssetPredicated;
import com.bbva.net.back.predicate.ProductTypePredicate;
import com.bbva.net.back.service.ProductService;
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

	@SuppressWarnings("unchecked")
	@Override
	public Money getTotalProductsByType(final List<ProductDTO> products, final EnumProductType productType) {

		final List<ProductDTO> productsByType = (List<ProductDTO>)CollectionUtils.select(products,
				new ProductTypePredicate(productType));

		return getTotalCash(productsByType);
	}

	public boolean hasProductByType(GlobalProductsDTO globalProducts, final String producType) {

		if (producType.equals("Cuantas")) {
			return !CollectionUtils.isEmpty(globalProducts.getAccounts());
		}
		return false;
	}

	@Override
	public List<ProductDTO> getProducts(GlobalProductsDTO globalProduct) {

		List<ProductDTO> products = new ProductVisitorCommand<AccountDTO>(globalProduct.getAccounts()) {

			@Override
			protected ProductDTO getProduct(AccountDTO account) {
				return account.getProduct();
			}

		}.add(new ProductVisitorCommand<FundDTO>(globalProduct.getFunds()) {

			@Override
			protected ProductDTO getProduct(FundDTO fund) {
				return fund.getProduct();
			}
		}).add(new ProductVisitorCommand<RotatingAccountDTO>(globalProduct.getRotatingAccounts()) {

			@Override
			protected ProductDTO getProduct(RotatingAccountDTO rotatingAccount) {

				return rotatingAccount.getLoan().getProduct();
			}
		}).add(new ProductVisitorCommand<LeasingDTO>(globalProduct.getLeasings()) {

			@Override
			protected ProductDTO getProduct(LeasingDTO leasing) {
				return leasing.getLoan().getProduct();
			}
		}).add(new ProductVisitorCommand<CreditCardDTO>(globalProduct.getCreditCards()) {

			@Override
			protected ProductDTO getProduct(CreditCardDTO creditCard) {
				return creditCard.getProduct();
			}
		}).add(new ProductVisitorCommand<DepositDTO>(globalProduct.getElectronicDeposits()) {

			@Override
			protected ProductDTO getProduct(DepositDTO deposit) {
				return deposit.getProduct();
			}
		}).getProducts();

		return products;
	}

}
