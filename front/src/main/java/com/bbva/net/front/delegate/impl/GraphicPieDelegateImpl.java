package com.bbva.net.front.delegate.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;
import co.com.bbva.services.transactions.globalposition.schema.Product;

import com.bbva.net.back.service.ProductService;
import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.globalposition.SituationPiesUI;
import com.bbva.net.front.ui.pie.PieConfigUI;
import com.bbva.net.front.ui.pie.PieItemUI;

/**
 * Delegate to draw UIGraphic Pies
 * 
 * @author Entelgy
 */
@Delegate(value = "graphicPieDelegate")
public class GraphicPieDelegateImpl implements GraphicPieDelegate {

	@Resource(name = "productService")
	private ProductService productService;

	@Override
	public SituationPiesUI getSituationGlobalProducts(final GlobalProducts globalProducts) {

		final SituationPiesUI situationPiesUI = new SituationPiesUI();
		final List<Product> productList = productService.getProducts(globalProducts);

		situationPiesUI.setSituation(getSituationPieConfig(productList));
		situationPiesUI.setAssets(getAssetPieConfig(productList));
		situationPiesUI.setFinancing(getFinanciationPieConfig(productList));

		situationPiesUI.setTotalAssets((productService.getTotalAssets(productList).getAmount()));
		situationPiesUI.setTotalFinancing((productService.getTotalFinanciacion(productList).getAmount()));

		return situationPiesUI;
	}

	/**
	 * Method to draws a Situation Pie graphic
	 * 
	 * @param List<Product> products
	 * @return PieConfigUI
	 */
	public PieConfigUI getSituationPieConfig(final List<Product> products) {

		final PieConfigUI situationPie = new PieConfigUI();
		situationPie.setHeader("Tu Situación");

		final List<PieItemUI> situationPieItems = new ArrayList<PieItemUI>();

		final PieItemUI assetPieItem = new PieItemUI("el color", "Activos", this.productService
				.getTotalAssets(products).getAmount());

		final PieItemUI financiationPieItem = new PieItemUI("el color", "Financiación", this.productService
				.getTotalFinanciacion(products).getAmount());

		situationPieItems.add(assetPieItem);
		situationPieItems.add(financiationPieItem);
		situationPie.setPieItemUIList(situationPieItems);

		return situationPie;

	}

	/**
	 * Method to draws a Situation Asset Pie graphic
	 * 
	 * @param List<Product> products
	 * @return PieConfigUI
	 */
	public PieConfigUI getAssetPieConfig(final List<Product> products) {

		final PieConfigUI assetPie = new PieConfigUI();
		assetPie.setHeader("Activos " + productService.getTotalAssets(products).getAmount().toString());

		final List<PieItemUI> assetPieItems = new ArrayList<PieItemUI>();

		final PieItemUI accountPieItem = new PieItemUI("el color", "Account", this.productService
				.getTotalProductsByType(products, "Account").getAmount());

		final PieItemUI fundPieItem = new PieItemUI("el color", "Fund", this.productService.getTotalProductsByType(
				products, "Fund").getAmount());

		final PieItemUI depositPieItem = new PieItemUI("el color", "Deposit", this.productService
				.getTotalProductsByType(products, "Deposit").getAmount());

		final PieItemUI rotatingAccountPieItem = new PieItemUI("el color", "Rotating Account", this.productService
				.getTotalProductsByType(products, "Rotating Account").getAmount());

		assetPieItems.add(accountPieItem);
		assetPieItems.add(fundPieItem);
		assetPieItems.add(depositPieItem);
		assetPieItems.add(rotatingAccountPieItem);
		assetPie.setPieItemUIList(assetPieItems);

		return assetPie;

	}

	/**
	 * Method to draws a Situation Asset Pie graphic
	 * 
	 * @param List<Product> products
	 * @return PieConfigUI
	 */
	public PieConfigUI getFinanciationPieConfig(final List<Product> products) {

		final PieConfigUI financiationPie = new PieConfigUI();
		financiationPie.setHeader("Financiación " + productService.getTotalFinanciacion(products).getAmount().toString());

		final List<PieItemUI> financiationPieItems = new ArrayList<PieItemUI>();

		final PieItemUI fundPieItem = new PieItemUI("el color", "Credit Card", this.productService
				.getTotalProductsByType(products, "Credit Card").getAmount());

		final PieItemUI depositPieItem = new PieItemUI("el color", "Leasing", this.productService
				.getTotalProductsByType(products, "Leasing").getAmount());

		final PieItemUI rotatingAccountPieItem = new PieItemUI("el color", "Loan", this.productService
				.getTotalProductsByType(products, "Loan").getAmount());

		financiationPieItems.add(fundPieItem);
		financiationPieItems.add(depositPieItem);
		financiationPieItems.add(rotatingAccountPieItem);
		financiationPie.setPieItemUIList(financiationPieItems);

		return financiationPie;
	}

	/**
	 * @param productService the productService to set
	 */
	public void setProductService(final ProductService productService) {
		this.productService = productService;
	}
}