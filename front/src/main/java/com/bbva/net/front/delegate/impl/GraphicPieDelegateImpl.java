package com.bbva.net.front.delegate.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import com.bbva.czic.dto.net.EnumCardChargeCategory;
import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.model.cards.CardsChargesDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.back.service.ProductService;
import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.globalposition.SituationPiesUI;
import com.bbva.net.front.ui.pie.PieConfigUI;
import com.bbva.net.front.ui.pie.PieItemUI;

/**
 * @author Entelgy
 */
@Delegate(value = "graphicPieDelegate")
public class GraphicPieDelegateImpl implements GraphicPieDelegate {

	@Resource(name = "productService")
	private ProductService productService;
	
	@Resource(name = "cardsFacade")
	private CardsFacade cardsFacade;

	public PieConfigUI getCardGraphicByUser(final String customerId) {

		final PieConfigUI assetPie = new PieConfigUI();
		assetPie.setHeaderCenter("Pesos ($)");
		final List<PieItemUI> assetPieItems = new ArrayList<PieItemUI>();
		final List<CardsChargesDTO> cardsCharges = cardsFacade.getCardsChargesByUser(customerId);
		
		final PieItemUI salesPieItem = new PieItemUI("el color", cardsCharges.get(0).getCategorie(), cardsCharges.get(0).getAmmount().getAmount());
		final PieItemUI clothesPieItem = new PieItemUI("el color",cardsCharges.get(1).getCategorie(), cardsCharges.get(1).getAmmount().getAmount());
		final PieItemUI othersPieItem = new PieItemUI("el color",cardsCharges.get(2).getCategorie(), cardsCharges.get(2).getAmmount().getAmount());
		final PieItemUI leisurePieItem = new PieItemUI("el color",cardsCharges.get(3).getCategorie(), cardsCharges.get(3).getAmmount().getAmount());
		final PieItemUI booksPieItem = new PieItemUI("el color",cardsCharges.get(4).getCategorie(), cardsCharges.get(4).getAmmount().getAmount());
		final PieItemUI commercePieItem = new PieItemUI("#197AC4",cardsCharges.get(5).getCategorie(), cardsCharges.get(5).getAmmount().getAmount());
		
		assetPieItems.add(salesPieItem);
		assetPieItems.add(clothesPieItem);
		assetPieItems.add(othersPieItem);
		assetPieItems.add(leisurePieItem);
		assetPieItems.add(booksPieItem);
		assetPieItems.add(commercePieItem);
		assetPie.setPieItemUIList(assetPieItems);

		return assetPie;

	}

	@Override
	public SituationPiesUI getSituationGlobalProducts(final GlobalProductsDTO globalProducts) {

		final SituationPiesUI situationPiesUI = new SituationPiesUI();
		final List<ProductDTO> productList = productService.getProducts(globalProducts);

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
	public PieConfigUI getSituationPieConfig(final List<ProductDTO> products) {

		final PieConfigUI situationPie = new PieConfigUI();

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
	public PieConfigUI getAssetPieConfig(final List<ProductDTO> products) {

		final PieConfigUI assetPie = new PieConfigUI();
		assetPie.setHeaderLeft(" Activos ");
		assetPie.setHeaderRight(productService.getTotalAssets(products).getAmount().toString());

		final List<PieItemUI> assetPieItems = new ArrayList<PieItemUI>();

		final PieItemUI accountPieItem = new PieItemUI("el color", "Cuentas Personales", this.productService
				.getTotalProductsByType(products, EnumProductType.PC).getAmount());

		final PieItemUI fundPieItem = new PieItemUI("el color", "Fondos de Inversión", this.productService
				.getTotalProductsByType(products, EnumProductType.SI).getAmount());

		final PieItemUI depositPieItem = new PieItemUI("el color", "Depósitos", this.productService
				.getTotalProductsByType(products, EnumProductType.ED).getAmount());

		final PieItemUI rotatingAccountPieItem = new PieItemUI("el color", "Cupo Rotativo", this.productService
				.getTotalProductsByType(products, EnumProductType.RQ).getAmount());

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
	public PieConfigUI getFinanciationPieConfig(final List<ProductDTO> products) {

		final PieConfigUI financiationPie = new PieConfigUI();
		DecimalFormat myFormatter = new DecimalFormat(ResourceBundle.getBundle("i18n_es").getString(
				"number.format.decimals"));
		String str = myFormatter.format(productService.getTotalFinanciacion(products).getAmount());
		System.out.println(str);
		financiationPie.setHeaderCenter(productService.getTotalFinanciacion(products).getAmount().toString());

		final List<PieItemUI> financiationPieItems = new ArrayList<PieItemUI>();

		final PieItemUI cardsPieItem = new PieItemUI("el color", "Tarjetas de Crédito", this.productService
				.getTotalProductsByType(products, EnumProductType.TDC).getAmount());

		final PieItemUI leasingPieItem = new PieItemUI("el color", "Leasing", this.productService
				.getTotalProductsByType(products, EnumProductType.LI).getAmount());

		final PieItemUI fundsPieItem = new PieItemUI("el color", "Préstamos", this.productService
				.getTotalProductsByType(products, EnumProductType.LO).getAmount());

		financiationPieItems.add(cardsPieItem);
		financiationPieItems.add(leasingPieItem);
		financiationPieItems.add(fundsPieItem);
		financiationPie.setPieItemUIList(financiationPieItems);

		return financiationPie;
	}

	@Override
	public PieConfigUI getAccountsfundsProducts(final GlobalProductsDTO globalProducts) {

		final PieConfigUI fundsPie = new PieConfigUI();

		final List<PieItemUI> fundsPieItems = new ArrayList<PieItemUI>();
		final List<ProductDTO> products = productService.getProducts(globalProducts);

		final PieItemUI valorPieItem = new PieItemUI("#197AC4", "Valor plus", this.productService
				.getTotalProductsByType(products, EnumProductType.SI).getAmount());

		final PieItemUI garantPieItem = new PieItemUI("#83C030", "Garantizado selección Consumo", this.productService
				.getTotalProductsByType(products, EnumProductType.SI).getAmount());

		fundsPieItems.add(garantPieItem);
		fundsPieItems.add(valorPieItem);
		fundsPie.setPieItemUIList(fundsPieItems);

		return fundsPie;
	}

	/**
	 * @param productService the productService to set
	 */
	public void setProductService(final ProductService productService) {
		this.productService = productService;
	}
}
