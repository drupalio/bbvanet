/**
 * 
 */
package com.bbva.net.back.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.springframework.stereotype.Service;

import co.com.bbva.services.transactions.globalposition.schema.Account;
import co.com.bbva.services.transactions.globalposition.schema.CreditCard;
import co.com.bbva.services.transactions.globalposition.schema.Deposit;
import co.com.bbva.services.transactions.globalposition.schema.Fund;
import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;
import co.com.bbva.services.transactions.globalposition.schema.Leasing;
import co.com.bbva.services.transactions.globalposition.schema.Product;
import co.com.bbva.services.transactions.globalposition.schema.RotatingAccount;

import com.bbva.net.back.command.ProductVisitorCommand;
import com.bbva.net.back.model.commons.Money;
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
	public Money getTotalCash(final List<Product> products) {
		return new Money(CollectionBbvaUtils.calculateTotal(products, "totalCash"));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Money getTotalAssets(final List<Product> products) {

		// Get only asset productos
		final List<Product> assetsProduct = (List<Product>)CollectionUtils.select(products, new AssetPredicated());

		// Calculate total cash from asset products
		return getTotalCash(assetsProduct);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Money getTotalFinanciacion(final List<Product> products) {

		// Get only asset productos
		final List<Product> assetsProduct = (List<Product>)CollectionUtils.select(products,
				PredicateUtils.notPredicate(new AssetPredicated()));

		// Calculate total cash from asset products
		return getTotalCash(assetsProduct);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Money getTotalProductsByType(final List<Product> products, final String productType) {

		final List<Product> productsByType = (List<Product>)CollectionUtils.select(products, new ProductTypePredicate(
				productType));

		return getTotalCash(productsByType);
	}

	
	public boolean hasProductByType(GlobalProducts globalProducts, final String producType){
		
		if(producType.equals("Cuantas")){
			return !CollectionUtils.isEmpty(globalProducts.getAccounts());
		}		
		return false;		
	}

	@Override
	public List<Product> getProducts(GlobalProducts globalProduct) {

		List<Product> products = new ProductVisitorCommand<Account>(globalProduct.getAccounts()) {

			@Override
			protected Product getProduct(Account account) {
				return account.getProduct();
			}

		}.add(new ProductVisitorCommand<Fund>(globalProduct.getFunds()) {

			@Override
			protected Product getProduct(Fund fund) {
				return fund.getProduct();
			}
		}).add(new ProductVisitorCommand<RotatingAccount>(globalProduct.getRotatingAccounts()) {

			@Override
			protected Product getProduct(RotatingAccount rotatingAccount) {
				return rotatingAccount.getLoan().getProduct();
			}
		}).add(new ProductVisitorCommand<Leasing>(globalProduct.getLeasings()) {

			@Override
			protected Product getProduct(Leasing leasing) {
				return leasing.getLoan().getProduct();
			}
		}).add(new ProductVisitorCommand<CreditCard>(globalProduct.getCreditCards()) {

			@Override
			protected Product getProduct(CreditCard creditCard) {
				return creditCard.getProduct();
			}
		}).add(new ProductVisitorCommand<Deposit>(globalProduct.getElectronicDeposits()) {

			@Override
			protected Product getProduct(Deposit deposit) {
				return deposit.getProduct();
			}
		}).getProducts();

		return products;
	}

}
