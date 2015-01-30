package com.bbva.net.front.delegate.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import com.bbva.czic.dto.net.EnumFundsType;
import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.service.ProductService;
import com.bbva.net.back.utils.ProductUtils;
import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.helper.MessagesHelper;
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

	/**
	 * @param cardsCharges
	 * @return
	 */
	@Override
	public PieConfigUI getCardGraphic(final List<CardsChargesDto> cardsCharges) {
		final PieConfigUI assetPie = new PieConfigUI();
		assetPie.setHeaderCenter("Pesos ($)");
		final List<PieItemUI> assetPieItems = new ArrayList<PieItemUI>();

		final PieItemUI leisurePieItem = new PieItemUI("el color",
				MessagesHelper.INSTANCE.getString("categorie.leisure"), cardsCharges.get(0).getAmmount().getAmount());
		final PieItemUI giftsPieItem = new PieItemUI("el color", MessagesHelper.INSTANCE.getString("categorie.gifts"),
				cardsCharges.get(1).getAmmount().getAmount());
		final PieItemUI booksPieItem = new PieItemUI("el color", MessagesHelper.INSTANCE.getString("categorie.books"),
				cardsCharges.get(2).getAmmount().getAmount());
		final PieItemUI diskPieItem = new PieItemUI("el color", MessagesHelper.INSTANCE.getString("categorie.disk"),
				cardsCharges.get(3).getAmmount().getAmount());
		final PieItemUI commercePieItem = new PieItemUI("el color",
				MessagesHelper.INSTANCE.getString("categorie.commerce"), cardsCharges.get(4).getAmmount().getAmount());
		final PieItemUI clothesPieItem = new PieItemUI("el color",
				MessagesHelper.INSTANCE.getString("categorie.clothes"), cardsCharges.get(5).getAmmount().getAmount());
		final PieItemUI choosePieItem = new PieItemUI("el color",
				MessagesHelper.INSTANCE.getString("categorie.choose"), cardsCharges.get(6).getAmmount().getAmount());
		final PieItemUI othersPieItem = new PieItemUI("el color",
				MessagesHelper.INSTANCE.getString("categorie.others"), cardsCharges.get(7).getAmmount().getAmount());
		final PieItemUI shoppingPieItem = new PieItemUI("el color",
				MessagesHelper.INSTANCE.getString("categorie.shopping"), cardsCharges.get(8).getAmmount().getAmount());

		assetPieItems.add(leisurePieItem);
		assetPieItems.add(giftsPieItem);
		assetPieItems.add(booksPieItem);
		assetPieItems.add(diskPieItem);
		assetPieItems.add(commercePieItem);
		assetPieItems.add(clothesPieItem);
		assetPieItems.add(choosePieItem);
		assetPieItems.add(othersPieItem);
		assetPieItems.add(shoppingPieItem);
		assetPie.setPieItemUIList(assetPieItems);

		return assetPie;
	}

	@Override
	public SituationPiesUI getSituationGlobalProducts(final GlobalProductsDto globalProducts) {

		final SituationPiesUI situationPiesUI = new SituationPiesUI();
		final List<ProductDto> productList = productService.getProducts(globalProducts);

		situationPiesUI.setSituation(getSituationPieConfig(productList));
		situationPiesUI.setAssets(getAssetPieConfig(productList));
		situationPiesUI.setFinancing(getFinanciationPieConfig(productList));

		situationPiesUI.setTotalAssets((productService.getTotalAssets(productList)));
		situationPiesUI.setTotalFinancing((productService.getTotalFinanciacion(productList)));

		return situationPiesUI;
	}

	/**
	 * Method to draws a Situation Pie graphic
	 * 
	 * @param List <Product> products
	 * @return PieConfigUI
	 */
	public PieConfigUI getSituationPieConfig(final List<ProductDto> products) {

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
	 * @param List <Product> products
	 * @return PieConfigUI
	 */
	public PieConfigUI getAssetPieConfig(final List<ProductDto> products) {

		final PieConfigUI assetPie = new PieConfigUI();
		DecimalFormat myFormatter = new DecimalFormat(ResourceBundle.getBundle("i18n_es").getString(
				"number.format.decimals"));
		String totalAssets = myFormatter.format(productService.getTotalAssets(products).getAmount());

		assetPie.setHeaderLeft(" Activos ");
		assetPie.setHeaderRight(totalAssets);
		assetPie.setHeaderCenter("COP");
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
	 * @param List <Product> products
	 * @return PieConfigUI
	 */
	public PieConfigUI getFinanciationPieConfig(final List<ProductDto> products) {

		final PieConfigUI financiationPie = new PieConfigUI();
		DecimalFormat myFormatter = new DecimalFormat(ResourceBundle.getBundle("i18n_es").getString(
				"number.format.decimals"));
		String totalFinancing = myFormatter.format(productService.getTotalFinanciacion(products).getAmount());
		financiationPie.setHeaderCenter(" COP ");
		financiationPie.setHeaderRight(totalFinancing);

		final List<PieItemUI> financiationPieItems = new ArrayList<PieItemUI>();

		final PieItemUI cardsPieItem = new PieItemUI("el color", "Tarjetas de Crédito", this.productService
				.getTotalProductsByType(products, EnumProductType.TC).getAmount());

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
	public PieConfigUI getAccountsfundsProducts(final GlobalProductsDto globalProducts) {

		final PieConfigUI fundsPie = new PieConfigUI();
		final List<PieItemUI> fundsPieItems = new ArrayList<PieItemUI>();

		final List<ProductDto> productList = productService.getProducts(globalProducts);

		final PieItemUI graphicFundsFa = new PieItemUI("#197AC4", MessagesHelper.INSTANCE.getString("graphicFunds.fa"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.FA.name()).getAmount());
		final PieItemUI graphicFundsBd = new PieItemUI("#83C030", MessagesHelper.INSTANCE.getString("graphicFunds.bd"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.BD.name()).getAmount());
		final PieItemUI graphicFundsBf = new PieItemUI("#1874CD", MessagesHelper.INSTANCE.getString("graphicFunds.bf"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.BF.name()).getAmount());
		final PieItemUI graphicFundsPa = new PieItemUI("#104E8B", MessagesHelper.INSTANCE.getString("graphicFunds.pa"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.PA.name()).getAmount());
		final PieItemUI graphicFundsBp = new PieItemUI("#A2CD5A", MessagesHelper.INSTANCE.getString("graphicFunds.bp"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.BP.name()).getAmount());
		final PieItemUI graphicFundsFn = new PieItemUI("#698B22", MessagesHelper.INSTANCE.getString("graphicFunds.fn"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.FN.name()).getAmount());
		final PieItemUI graphicFundsFc = new PieItemUI("#FFC125", MessagesHelper.INSTANCE.getString("graphicFunds.fc"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.FC.name()).getAmount());
		final PieItemUI graphicFundsFe = new PieItemUI("#EE7600", MessagesHelper.INSTANCE.getString("graphicFunds.fe"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.FE.name()).getAmount());
		final PieItemUI graphicFundsFz = new PieItemUI("#2E9AFE", MessagesHelper.INSTANCE.getString("graphicFunds.fz"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.FZ.name()).getAmount());
		final PieItemUI graphicFundsAn = new PieItemUI("#FFFF00", MessagesHelper.INSTANCE.getString("graphicFunds.an"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.AN.name()).getAmount());
		final PieItemUI graphicFundsFg = new PieItemUI("#04B45F", MessagesHelper.INSTANCE.getString("graphicFunds.fg"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.FG.name()).getAmount());
		final PieItemUI graphicFundsMd = new PieItemUI("#8904B1", MessagesHelper.INSTANCE.getString("graphicFunds.md"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.MD.name()).getAmount());
		final PieItemUI graphicFundsFr = new PieItemUI("#DF7401", MessagesHelper.INSTANCE.getString("graphicFunds.fr"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.FR.name()).getAmount());
		final PieItemUI graphicFundsFb = new PieItemUI("#868A08", MessagesHelper.INSTANCE.getString("graphicFunds.fb"),
				this.productService.getTotalProductsBySubType(productList, EnumFundsType.FB.name()).getAmount());

		fundsPieItems.add(graphicFundsFa);
		fundsPieItems.add(graphicFundsBd);
		fundsPieItems.add(graphicFundsBf);
		fundsPieItems.add(graphicFundsPa);
		fundsPieItems.add(graphicFundsBp);
		fundsPieItems.add(graphicFundsFn);
		fundsPieItems.add(graphicFundsFc);
		fundsPieItems.add(graphicFundsFe);
		fundsPieItems.add(graphicFundsFz);
		fundsPieItems.add(graphicFundsAn);
		fundsPieItems.add(graphicFundsFg);
		fundsPieItems.add(graphicFundsMd);
		fundsPieItems.add(graphicFundsFr);
		fundsPieItems.add(graphicFundsFb);

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
