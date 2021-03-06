package com.bbva.net.front.delegate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.EnumFundsType;
import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.back.model.commons.Money;
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
import com.bbva.net.back.service.ProductService;
import com.bbva.net.front.delegate.impl.GraphicPieDelegateImpl;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;
import com.bbva.net.front.ui.globalposition.SituationPiesUI;
import com.bbva.net.front.ui.pie.PieConfigUI;

public class GraphicPieDelegateTest extends AbstractBbvaControllerTest {

	private GraphicPieDelegateImpl graphicPie;

	@Resource(name = "productService")
	private ProductService productService;

	private GlobalProductsDto globalProducts;

	private List<ProductDto> listProduct;

	private Money money;

	@Before
	public void init() {

		this.globalProducts = new GlobalProductsDto();
		this.listProduct = new ArrayList<ProductDto>();

		this.graphicPie = new GraphicPieDelegateImpl();
		this.productService = Mockito.mock(ProductService.class);
		this.graphicPie.setProductService(productService);

		this.money = new Money();
		this.money.setAmount(new BigDecimal(10));
		this.money.setCurrency("$");

		// Mocks Dto
		AccountDto accountDto = Mockito.mock(AccountDto.class);
		RotatingAccountDto rotatingAccountDto = Mockito.mock(RotatingAccountDto.class);
		LeasingDto leasingDto = Mockito.mock(LeasingDto.class);
		FundDto fundDto = Mockito.mock(FundDto.class);
		CreditCardDto creditCardDto = Mockito.mock(CreditCardDto.class);
		DepositDto depositDto = Mockito.mock(DepositDto.class);
		AdquirenceAccountDto adquirenceAccountDto = Mockito.mock(AdquirenceAccountDto.class);
		LoanDto loanDto = Mockito.mock(LoanDto.class);

		// Prepara Listas con los Mocks de Dto
		List<AccountDto> accounts = new ArrayList<AccountDto>();
		accounts.add(accountDto);
		globalProducts.setAccounts(accounts);

		List<RotatingAccountDto> rotatingAccounts = new ArrayList<RotatingAccountDto>();
		rotatingAccounts.add(rotatingAccountDto);
		globalProducts.setRotatingAccounts(rotatingAccounts);

		List<LeasingDto> leasings = new ArrayList<LeasingDto>();
		leasings.add(leasingDto);
		globalProducts.setLeasings(leasings);

		List<FundDto> funds = new ArrayList<FundDto>();
		funds.add(fundDto);
		globalProducts.setFunds(funds);

		List<CreditCardDto> creditCards = new ArrayList<CreditCardDto>();
		creditCards.add(creditCardDto);
		globalProducts.setCreditCards(creditCards);

		List<DepositDto> electronicDeposits = new ArrayList<DepositDto>();
		electronicDeposits.add(depositDto);
		globalProducts.setElectronicDeposits(electronicDeposits);

		List<AdquirenceAccountDto> adquirencia = new ArrayList<AdquirenceAccountDto>();
		adquirencia.add(adquirenceAccountDto);
		globalProducts.setAdquirencia(adquirencia);

		List<LoanDto> loan = new ArrayList<LoanDto>();
		loan.add(loanDto);
		globalProducts.setLoan(loan);

		ProductDto productDto = new ProductDto();

		List<ProductDto> listProduct = new ArrayList<ProductDto>();
		listProduct.add(productDto);

	}

	@Test
	public void checkGetCardGraphic() {
		CardsChargesDto cadsCharges = new CardsChargesDto();
		cadsCharges.setCategorie("ocio");
		cadsCharges.setAmmount(money);
		List<CardsChargesDto> listCardCharges = new ArrayList<CardsChargesDto>();
		listCardCharges.add(cadsCharges);

		PieConfigUI pieConfig = graphicPie.getCardGraphic(listCardCharges);

		Assert.assertNotNull(pieConfig);

	}

	@Test
	public void checkGetSituationGlobalProducts() {

		GlobalProductsDto globalProducts = new GlobalProductsDto();

		// // Mocks Dto
		// AccountDto accountDto = Mockito.mock(AccountDto.class);
		// RotatingAccountDto rotatingAccountDto = Mockito.mock(RotatingAccountDto.class);
		// LeasingDto leasingDto = Mockito.mock(LeasingDto.class);
		// FundDto fundDto = Mockito.mock(FundDto.class);
		// CreditCardDto creditCardDto = Mockito.mock(CreditCardDto.class);
		// DepositDto depositDto = Mockito.mock(DepositDto.class);
		// AdquirenceAccountDto adquirenceAccountDto = Mockito.mock(AdquirenceAccountDto.class);
		// LoanDto loanDto = Mockito.mock(LoanDto.class);
		//
		// // Prepara Listas con los Mocks de Dto
		// List<AccountDto> accounts = new ArrayList<AccountDto>();
		// accounts.add(accountDto);
		// globalProducts.setAccounts(accounts);
		//
		// List<RotatingAccountDto> rotatingAccounts = new ArrayList<RotatingAccountDto>();
		// rotatingAccounts.add(rotatingAccountDto);
		// globalProducts.setRotatingAccounts(rotatingAccounts);
		//
		// List<LeasingDto> leasings = new ArrayList<LeasingDto>();
		// leasings.add(leasingDto);
		// globalProducts.setLeasings(leasings);
		//
		// List<FundDto> funds = new ArrayList<FundDto>();
		// funds.add(fundDto);
		// globalProducts.setFunds(funds);
		//
		// List<CreditCardDto> creditCards = new ArrayList<CreditCardDto>();
		// creditCards.add(creditCardDto);
		// globalProducts.setCreditCards(creditCards);
		//
		// List<DepositDto> electronicDeposits = new ArrayList<DepositDto>();
		// electronicDeposits.add(depositDto);
		// globalProducts.setElectronicDeposits(electronicDeposits);
		//
		// List<AdquirenceAccountDto> adquirencia = new ArrayList<AdquirenceAccountDto>();
		// adquirencia.add(adquirenceAccountDto);
		// globalProducts.setAdquirencia(adquirencia);
		//
		// List<LoanDto> loan = new ArrayList<LoanDto>();
		// loan.add(loanDto);
		// globalProducts.setLoan(loan);
		//
		// ProductDto productDto = new ProductDto();
		//
		// List<ProductDto> listProduct = new ArrayList<ProductDto>();
		// listProduct.add(productDto);

		// Prepara Mock para ProductService
		Mockito.when(productService.getProducts(globalProducts)).thenReturn(listProduct);
		Mockito.when(productService.getTotalAssets(listProduct)).thenReturn(money);
		Mockito.when(productService.getTotalFinanciacion(listProduct)).thenReturn(money);
		Mockito.when(productService.getTotalAssets(listProduct)).thenReturn(money);
		Mockito.when(productService.getTotalProductsByType(listProduct, EnumProductType.PC)).thenReturn(money);
		Mockito.when(productService.getTotalProductsByType(listProduct, EnumProductType.SI)).thenReturn(money);
		Mockito.when(productService.getTotalProductsByType(listProduct, EnumProductType.ED)).thenReturn(money);
		Mockito.when(productService.getTotalProductsByType(listProduct, EnumProductType.TC)).thenReturn(money);
		Mockito.when(productService.getTotalProductsByType(listProduct, EnumProductType.LI)).thenReturn(money);
		Mockito.when(productService.getTotalProductsByType(listProduct, EnumProductType.LO)).thenReturn(money);
		Mockito.when(productService.getTotalProductsByType(listProduct, EnumProductType.ED)).thenReturn(money);
		Mockito.when(productService.getTotalProductsByType(listProduct, EnumProductType.RQ)).thenReturn(money);

		SituationPiesUI situation = graphicPie.getSituationGlobalProducts(globalProducts);

		Assert.assertNotNull(situation);
		Mockito.verify(this.productService, Mockito.atLeastOnce()).getProducts(globalProducts);
		Mockito.verify(this.productService, Mockito.atLeastOnce()).getTotalAssets(listProduct);
		Mockito.verify(this.productService, Mockito.atLeastOnce()).getTotalFinanciacion(listProduct);

	}

	@Test
	public void checkgetAccountsfundsProducts() {

		// Prepara Mock para productService
		Mockito.when(productService.getProducts(globalProducts)).thenReturn(listProduct);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.FA.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.BD.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.BF.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.PA.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.BP.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.FN.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.FC.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.FE.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.FZ.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.AN.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.FG.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.MD.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.FR.name())).thenReturn(money);
		Mockito.when(productService.getTotalProductsBySubType(listProduct, EnumFundsType.FB.name())).thenReturn(money);

		PieConfigUI pieConfig = graphicPie.getAccountsfundsProducts(globalProducts);

		Assert.assertNotNull(pieConfig);
		Mockito.verify(this.productService, Mockito.atLeastOnce()).getProducts(globalProducts);
	}

}
