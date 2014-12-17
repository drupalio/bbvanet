package com.bbva.net.front.delegate.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;
import co.com.bbva.services.transactions.globalposition.schema.Product;

import com.bbva.net.back.service.ProductService;
import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.PieItemUI;
import com.bbva.net.front.ui.SituationPiesConfigUI;
import com.bbva.net.front.ui.SituationPiesUI;

/**
 * Delegate to draw UIGraphic Pies
 * 
 * @author Entelgy
 */
@Delegate(value = "graphicPieDelegate")
public class GraphicPieDelegateImpl implements GraphicPieDelegate {

	SituationPiesUI situationPiesUI = new SituationPiesUI();

	ProductService productService;

	@Override
	public SituationPiesUI getSituationGlobalProducts(GlobalProducts globalProducts) {

		return getSitiationPiesUI(globalProducts);
	}

	public SituationPiesUI getSitiationPiesUI(GlobalProducts globalProducts) {
		List<Product> productList = productService.getProducts(globalProducts);
		situationPiesUI.setSituation(getSituationPieConfig(globalProducts));
		situationPiesUI.setAssets(getAssetPieConfig(globalProducts));
		situationPiesUI.setFinancing(getFinanciationPieConfig(globalProducts));

		situationPiesUI.setTotalAssets((productService.getTotalAssets(productList).getAmount()));
		situationPiesUI.setTotalFinancing((productService.getTotalFinanciacion(productList).getAmount()));

		return situationPiesUI;
	}

	public SituationPiesConfigUI getSituationPieConfig(GlobalProducts globalProducts) {

		SituationPiesConfigUI situation = new SituationPiesConfigUI();

		List<Product> productList = productService.getProducts(globalProducts);
		situation.setHeader("Tu Situación");
		situation.setPieItemUIList(getPieSituationItemUIList(productList));

		return situation;

	}

	public SituationPiesConfigUI getAssetPieConfig(GlobalProducts globalProducts) {
		SituationPiesConfigUI asset = new SituationPiesConfigUI();

		List<Product> productList = productService.getProducts(globalProducts);
		asset.setHeader("Activos " + productService.getTotalAssets(productList).getAmount().toString());
		asset.setPieItemUIList(getPieAssetItemUIList(productList));

		return asset;

	}

	public SituationPiesConfigUI getFinanciationPieConfig(GlobalProducts globalProducts) {
		SituationPiesConfigUI financiation = new SituationPiesConfigUI();
		List<Product> productList = productService.getProducts(globalProducts);
		financiation.setHeader("Financiación "
				+ (productService.getTotalFinanciacion(productList).getAmount().toString()));
		financiation.setPieItemUIList(getPieFinanciationItemUIList(productList));
		return financiation;
	}

	/**
	 * Method to draws a generic Pie graphic
	 * 
	 * @param productList
	 * @param color
	 * @param currency
	 * @param textLegend
	 * @param productType
	 * @return PieItemUI
	 */
	public PieItemUI drawGraphic(List<Product> productList, String color, char currency, String textLegend,
			String productType) {
		PieItemUI pieItemUI = new PieItemUI();
		pieItemUI.setColor(color);
		pieItemUI.setCurrency(currency);
		pieItemUI.setTextLengend(textLegend);
		if (textLegend.equals("Activos") || textLegend.equals("Financiación")) {
			pieItemUI.setValue(textLegend.equals("Activos") ? productService.getTotalAssets(productList).getAmount()
					: productService.getTotalFinanciacion(productList).getAmount());
		} else {
			pieItemUI.setValue(productService.getTotalProductsByType(productList, productType).getAmount());
		}
		return pieItemUI;
	}

	/**
	 * Method to draws a Situation Pie graphic
	 * 
	 * @param productList
	 * @return pieItemUIList
	 */
	private List<PieItemUI> getPieSituationItemUIList(List<Product> productList) {

		List<PieItemUI> pieItemUIList = new ArrayList<PieItemUI>();

		List<String> legendList = new ArrayList<String>();
		legendList.add("Activos");
		legendList.add("Financiación Account");

		for (String str : legendList) {
			PieItemUI pieItemUI = new PieItemUI();
			pieItemUI = drawGraphic(productList, "green", '$', str, str);
			pieItemUIList.add(pieItemUI);
		}

		return pieItemUIList;
	}

	/**
	 * Method to draws a Situation Asset Pie graphic
	 * 
	 * @param productList
	 * @return pieItemUIList
	 */
	private List<PieItemUI> getPieAssetItemUIList(List<Product> productList) {
		List<PieItemUI> pieItemUIList = new ArrayList<PieItemUI>();

		List<String> legendList = new ArrayList<String>();
		legendList.add("Accounts");
		legendList.add("Rotating Account");
		legendList.add("Deposit");
		legendList.add("Fund");

		for (String str : legendList) {
			PieItemUI pieItemUI = new PieItemUI();
			pieItemUI = drawGraphic(productList, "green", '$', str, str);
			pieItemUIList.add(pieItemUI);
		}
		return pieItemUIList;
	}

	/**
	 * Method to draws a Financiation Pie graphic
	 * 
	 * @param productList
	 * @return pieItemUIList
	 */
	private List<PieItemUI> getPieFinanciationItemUIList(List<Product> productList) {
		List<PieItemUI> pieItemUIList = new ArrayList<PieItemUI>();

		List<String> legendList = new ArrayList<String>();
		legendList.add("Credit Card");
		legendList.add("Leasing");
		legendList.add("Loan");

		for (String str : legendList) {
			PieItemUI pieItemUI = new PieItemUI();
			pieItemUI = drawGraphic(productList, "green", '$', str, str);
			pieItemUIList.add(pieItemUI);
		}
		return pieItemUIList;

	}
}