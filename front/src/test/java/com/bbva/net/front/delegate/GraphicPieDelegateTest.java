package com.bbva.net.front.delegate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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

	private Money money;

	@Before
	public void init() {

		this.graphicPie = new GraphicPieDelegateImpl();
		this.productService = Mockito.mock(ProductService.class);
		this.graphicPie.setProductService(productService);
		this.money = Mockito.mock(Money.class);
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

	public void checkGetSituationGlobalProducts() {

		GlobalProductsDto globalProducts = new GlobalProductsDto();

		// Mocks Dto
		AccountDto accountDto = Mockito.mock(AccountDto.class);
		RotatingAccountDto rotatingAccountDto = Mockito.mock(RotatingAccountDto.class);
		LeasingDto leasingDto = Mockito.mock(LeasingDto.class);
		FundDto fundDto = Mockito.mock(FundDto.class);
		CreditCardDto creditCardDto = Mockito.mock(CreditCardDto.class);
		DepositDto depositDto = Mockito.mock(DepositDto.class);
		AdquirenceAccountDto adquirenceAccountDto = Mockito.mock(AdquirenceAccountDto.class);
		LoanDto loanDto = Mockito.mock(LoanDto.class);

		// Prepara Listas
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
		productDto.setTypeProd(EnumProductType.PC);
		productDto.setCashAvailable(money);
		productDto.setTotalCash(money);

		@SuppressWarnings("unchecked")
		List<ProductDto> listProduct = Mockito.mock(List.class);
		List<ProductDto> listaProduct = new ArrayList<ProductDto>();
		listaProduct.add(productDto);

		// Prepara Mock para ProductServico
		Mockito.when(productService.getProducts(globalProducts)).thenReturn(listProduct);
		Mockito.when(productService.getTotalAssets(listProduct)).thenReturn(money);
		Mockito.when(productService.getTotalFinanciacion(listProduct)).thenReturn(money);
		Mockito.when(productService.getTotalAssets(listProduct).getAmount()).thenReturn(Mockito.mock(BigDecimal.class));
		// Mockito.when(productService.getTotalProductsByType(listProduct, EnumProductType.PC).getAmount()).thenReturn(
		// new BigDecimal("0"));

		SituationPiesUI situation = graphicPie.getSituationGlobalProducts(globalProducts);

		Assert.assertNotNull(situation);

	}

}
