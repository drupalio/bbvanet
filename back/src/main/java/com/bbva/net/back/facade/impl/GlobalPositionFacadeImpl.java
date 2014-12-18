package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.client.RestClientException;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.GlobalPositionFacade;
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
import com.bbva.net.back.model.globalposition.QuotaDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

// import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "globalPositionFacade")
public class GlobalPositionFacadeImpl extends AbstractBbvaFacade implements GlobalPositionFacade {

	private static final long serialVersionUID = -8133045188591147282L;

	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;

	@Override
	public GlobalProductsDTO getGlobalProductsByUser(String user) throws RestClientException {

		GlobalProductsDTO globalProducts = new GlobalProductsDTO();

		List<AccountDTO> accountList = new ArrayList<AccountDTO>();
		List<CreditCardDTO> creditCardList = new ArrayList<CreditCardDTO>();
		List<RotatingAccountDTO> rotatingList = new ArrayList<RotatingAccountDTO>();
		List<LeasingDTO> leasingList = new ArrayList<LeasingDTO>();
		List<LoanDTO> loanList = new ArrayList<LoanDTO>();
		List<DepositDTO> depositList = new ArrayList<DepositDTO>();
		List<FundDTO> fundList = new ArrayList<FundDTO>();
		List<AdquirenceAccountDTO> adquirenciaList = new ArrayList<AdquirenceAccountDTO>();

		List<Product> response = this.globalPositionService.getExtractGlobalBalance(user, null, null, null, null);

		for (int i = 0; i < response.size(); i++) {

			if (response.get(i).getType().equals(EnumProductType.PC)) {
				ProductDTO product = new ProductDTO();
				AccountDTO account = new AccountDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				product.setAlias(response.get(i).getAlias());
				product.setCashAvailable(money);
				product.setProductId(response.get(i).getId());
				product.setProductName(response.get(i).getName());
				product.setProductNumber(response.get(i).getId());
				product.setTotalCash(money);
				product.setTypeProd(response.get(i).getType());
				account.setProduct(product);
				accountList.add(account);
			}
			if (response.get(i).getType().equals(EnumProductType.AQ)) {
				ProductDTO product = new ProductDTO();
				AdquirenceAccountDTO adquirenciaAccount = new AdquirenceAccountDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				product.setAlias(response.get(i).getAlias());
				product.setCashAvailable(money);
				product.setProductId(response.get(i).getId());
				product.setProductName(response.get(i).getName());
				product.setProductNumber(response.get(i).getId());
				product.setTotalCash(money);
				product.setTypeProd(response.get(i).getType());
				adquirenciaAccount.setProduct(product);
				adquirenciaList.add(adquirenciaAccount);
			}
			if (response.get(i).getType().equals(EnumProductType.TDC)) {
				ProductDTO product = new ProductDTO();
				QuotaDTO quota = new QuotaDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				CreditCardDTO creditCard = new CreditCardDTO();
				quota.setAvailableQuota(money);
				quota.setTotalQuotaDebt(money);

				product.setAlias(response.get(i).getAlias());
				product.setCashAvailable(money);
				product.setProductId(response.get(i).getId());
				product.setProductName(response.get(i).getName());
				product.setProductNumber(response.get(i).getId());
				product.setTotalCash(money);
				product.setTypeProd(response.get(i).getType());

				creditCard.setProduct(product);
				creditCard.setQuota(quota);

				creditCardList.add(creditCard);
			}
			if (response.get(i).getType().equals(EnumProductType.RQ)) {

				ProductDTO product = new ProductDTO();
				QuotaDTO quota = new QuotaDTO();
				LoanDTO loan = new LoanDTO();
				RotatingAccountDTO rotating = new RotatingAccountDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				product.setAlias(response.get(i).getAlias());
				product.setCashAvailable(money);
				product.setProductId(response.get(i).getId());
				product.setProductName(response.get(i).getName());
				product.setProductNumber(response.get(i).getId());
				product.setTotalCash(money);
				product.setTypeProd(response.get(i).getType());

				quota.setAvailableQuota(money);
				quota.setTotalQuotaDebt(money);

				loan.setProduct(product);
				loan.setTotalDebt(money);
				loan.setTotalDue(money);

				rotating.setLoan(loan);
				rotating.setQuota(quota);

				rotatingList.add(rotating);
			}
			if (response.get(i).getType().equals(EnumProductType.LI)) {

				ProductDTO product = new ProductDTO();
				LoanDTO loan = new LoanDTO();
				LeasingDTO leasing = new LeasingDTO();
				AccountDTO account = new AccountDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				product.setAlias(response.get(i).getAlias());
				product.setCashAvailable(money);
				product.setProductId(response.get(i).getId());
				product.setProductName(response.get(i).getName());
				product.setProductNumber(response.get(i).getId());
				product.setTotalCash(money);
				product.setTypeProd(response.get(i).getType());
				account.setProduct(product);

				loan.setProduct(product);
				loan.setTotalDebt(money);
				loan.setTotalDue(money);

				leasing.setLoan(loan);
				leasingList.add(leasing);
			}

			if (response.get(i).getType().equals(EnumProductType.LO)) {

				ProductDTO product = new ProductDTO();
				LoanDTO loan = new LoanDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				product.setAlias(response.get(i).getAlias());
				product.setCashAvailable(money);
				product.setProductId(response.get(i).getId());
				product.setProductName(response.get(i).getName());
				product.setProductNumber(response.get(i).getId());
				product.setTotalCash(money);
				product.setTypeProd(response.get(i).getType());

				loan.setProduct(product);
				loan.setTotalDebt(money);
				loan.setTotalDue(money);

				loanList.add(loan);
			}
			if (response.get(i).getType().equals(EnumProductType.SI)) {

				ProductDTO product = new ProductDTO();
				FundDTO fund = new FundDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				product.setAlias(response.get(i).getAlias());
				product.setCashAvailable(money);
				product.setProductId(response.get(i).getId());
				product.setProductName(response.get(i).getName());
				product.setProductNumber(response.get(i).getId());
				product.setTotalCash(money);
				product.setTypeProd(response.get(i).getType());

				fund.setProduct(product);
				fundList.add(fund);
			}
			if (response.get(i).getType().equals(EnumProductType.ED)) {
				DepositDTO deposit = new DepositDTO();
				ProductDTO product = new ProductDTO();

				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				product.setAlias(response.get(i).getAlias());
				product.setCashAvailable(money);
				product.setProductId(response.get(i).getId());
				product.setProductName(response.get(i).getName());
				product.setProductNumber(response.get(i).getId());
				product.setTotalCash(money);
				product.setTypeProd(response.get(i).getType());
				deposit.setProduct(product);
				depositList.add(deposit);
			}

		}
		globalProducts.setAccounts(accountList);
		globalProducts.setCreditCards(creditCardList);
		globalProducts.setElectronicDeposits(depositList);
		globalProducts.setLeasings(leasingList);
		globalProducts.setRotatingAccounts(rotatingList);
		globalProducts.setFunds(fundList);
		globalProducts.setLoan(loanList);

		return globalProducts;

	}

	public void setGlobalPositionService(GlobalPositionService globalPositionService) {

		this.globalPositionService = globalPositionService;

	}

	@Override
	public GlobalProductsDTO getGlobalProductsByUserVisible(String defaultUser, boolean b) {

		// final GlobalProductsDTO globalProducts = globalPositionService.get(defaultUser);
		//
		// PersonalAccountDTO acc = new PersonalAccountDTO();
		// acc.setAlias("Cuenta 1");
		// acc.setProductID("1234");
		// List pr = new ArrayList();
		// pr.add(acc);
		// acc = new PersonalAccountDTO();
		// acc.setAlias("Cuenta 2");
		// acc.setProductID("12345");
		// pr.add(acc);
		// acc = new PersonalAccountDTO();
		// acc.setAlias("Cuenta 3");
		// acc.setProductID("19");
		// pr.add(acc);
		// acc = new PersonalAccountDTO();
		// acc.setAlias("Cuenta 4");
		// acc.setProductID("12346");
		// pr.add(acc);
		//
		// HiddenProductPredicate predicate = new HiddenProductPredicate();
		// List aList = (List)CollectionUtils.select(pr, predicate);
		// System.out.println(" tamaño de sublista despues del predicado " + aList.size());
		// acc = (PersonalAccountDTO)aList.get(0);
		// System.out.println(acc.getAlias() + " tamaño de sublista despues del predicado " + aList.size());
		//
		// // List aList = (List) CollectionUtils.select(globalPositionService.get(defaultUser).getAccounts(), predicate);
		// // Account product=(Account) aList.get(0);
		// // System.out.println(product.getProduct().getAlias()+" tamaño de sublista despues del predicado "+aList.size());
		//
		// /*
		// * HiddenProductPredicate<ProductDTO> predicate = new HiddenProductPredicate<ProductDTO>();List aList = (List)
		// * CollectionUtils.select(globalPositionService.get(defaultUser).getAccounts(), predicate);
		// * globalProducts.setAccounts((List) CollectionUtils.select(globalPositionService.get(defaultUser).getAccounts(),
		// * predicate)); globalProducts.setCreditCards((List)
		// * CollectionUtils.select(globalPositionService.get(defaultUser).getCreditCards(), predicate));
		// * globalProducts.setElectronicDeposits((List)
		// * CollectionUtils.select(globalPositionService.get(defaultUser).getElectronicDeposits(), predicate));
		// * globalProducts.setFunds((List) CollectionUtils.select(globalPositionService.get(defaultUser).getFunds(),
		// * predicate)); globalProducts.setLeasings((List)
		// * CollectionUtils.select(globalPositionService.get(defaultUser).getLeasings(), predicate));
		// * globalProducts.setRotatingAccounts((List)
		// * CollectionUtils.select(globalPositionService.get(defaultUser).getRotatingAccounts(), predicate));
		// */
		// return this.globalPositionService.get(defaultUser);

		return null;
	}

}
