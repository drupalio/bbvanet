package com.bbva.net.back.mapper.impl;

import java.util.List;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.GlobalPositionMapper;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDTO;
import com.bbva.net.back.model.globalposition.CreditCardDTO;
import com.bbva.net.back.model.globalposition.DepositDTO;
import com.bbva.net.back.model.globalposition.FundDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.LoanDTO;
import com.bbva.net.back.model.globalposition.QuotaDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;

@Mapper(value = "globalPositionMapper")
public class GlobalPositionMapperImpl implements GlobalPositionMapper {

	@Override
	public GlobalProductsDTO map(List<Product> response) {

		GlobalProductsDTO globalProducts = new GlobalProductsDTO();

		List<AccountDTO> accountList = globalProducts.getAccounts();
		List<CreditCardDTO> creditCardList = globalProducts.getCreditCards();
		List<RotatingAccountDTO> rotatingList = globalProducts.getRotatingAccounts();
		List<LeasingDTO> leasingList = globalProducts.getLeasings();
		List<LoanDTO> loanList = globalProducts.getLoan();
		List<DepositDTO> depositList = globalProducts.getElectronicDeposits();
		List<FundDTO> fundList = globalProducts.getFunds();
		List<AdquirenceAccountDTO> adquirenciaList = globalProducts.getAdquirencia();

		for (int i = 0; i < response.size(); i++) {

			// 1 Cuenta personal
			if (response.get(i).getType().equals(EnumProductType.PC)) {
				AccountDTO account = new AccountDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				account.setAlias(response.get(i).getAlias());
				account.setCashAvailable(money);
				account.setProductId(response.get(i).getId());
				account.setProductName(response.get(i).getName());
				account.setProductNumber(response.get(i).getId());
				account.setTotalCash(money);
				account.setTypeProd(response.get(i).getType());
				account.setAsset(response.get(i).isVisible());
				account.setVisible(response.get(i).isVisible());
				accountList.add(account);
			}
			// 2 Cuenta de adquiriencia
			if (response.get(i).getType().equals(EnumProductType.AQ)) {

				AdquirenceAccountDTO adquirenciaAccount = new AdquirenceAccountDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				adquirenciaAccount.setAlias(response.get(i).getAlias());
				adquirenciaAccount.setCashAvailable(money);
				adquirenciaAccount.setProductId(response.get(i).getId());
				adquirenciaAccount.setProductName(response.get(i).getName());
				adquirenciaAccount.setProductNumber(response.get(i).getId());
				adquirenciaAccount.setTotalCash(money);
				adquirenciaAccount.setTypeProd(response.get(i).getType());
				adquirenciaAccount.setAsset(response.get(i).isVisible());
				adquirenciaAccount.setVisible(response.get(i).isVisible());
				;
				adquirenciaList.add(adquirenciaAccount);
			}
			// 3 Tarjetas de crédito
			if (response.get(i).getType().equals(EnumProductType.TDC)) {
				QuotaDTO quota = new QuotaDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				CreditCardDTO creditCard = new CreditCardDTO();
				quota.setAvailableQuota(money);
				quota.setTotalQuotaDebt(money);

				creditCard.setAlias(response.get(i).getAlias());
				creditCard.setCashAvailable(money);
				creditCard.setProductId(response.get(i).getId());
				creditCard.setProductName(response.get(i).getName());
				creditCard.setProductNumber(response.get(i).getId());
				creditCard.setTotalCash(money);
				creditCard.setTypeProd(response.get(i).getType());
				creditCard.setVisible(response.get(i).isVisible());

				creditCard.setQuota(quota);

				creditCardList.add(creditCard);
			}
			// 4 Cupo rotativo
			if (response.get(i).getType().equals(EnumProductType.RQ)) {

				QuotaDTO quota = new QuotaDTO();
				RotatingAccountDTO rotating = new RotatingAccountDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				rotating.setAlias(response.get(i).getAlias());
				rotating.setCashAvailable(money);
				rotating.setProductId(response.get(i).getId());
				rotating.setProductName(response.get(i).getName());
				rotating.setProductNumber(response.get(i).getId());
				rotating.setTotalCash(money);
				rotating.setTypeProd(response.get(i).getType());
				rotating.setAsset(response.get(i).isVisible());
				rotating.setVisible(response.get(i).isVisible());

				quota.setAvailableQuota(money);
				quota.setTotalQuotaDebt(money);

				rotating.setTotalDebt(money);
				rotating.setTotalDue(money);

				rotating.setQuota(quota);

				rotatingList.add(rotating);
			}
			// 5 Leasing
			if (response.get(i).getType().equals(EnumProductType.LI)) {

				LeasingDTO leasing = new LeasingDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				leasing.setAlias(response.get(i).getAlias());
				leasing.setCashAvailable(money);
				leasing.setProductId(response.get(i).getId());
				leasing.setProductName(response.get(i).getName());
				leasing.setProductNumber(response.get(i).getId());
				leasing.setTotalCash(money);
				leasing.setTypeProd(response.get(i).getType());
				leasing.setTotalDebt(money);
				leasing.setTotalDue(money);
				leasing.setVisible(response.get(i).isVisible());

				leasingList.add(leasing);
			}
			// 6 Préstamos
			if (response.get(i).getType().equals(EnumProductType.LO)) {

				LoanDTO loan = new LoanDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				loan.setAlias(response.get(i).getAlias());
				loan.setCashAvailable(money);
				loan.setProductId(response.get(i).getId());
				loan.setProductName(response.get(i).getName());
				loan.setProductNumber(response.get(i).getId());
				loan.setTotalCash(money);
				loan.setTypeProd(response.get(i).getType());
				loan.setVisible(response.get(i).isVisible());

				loan.setTotalDebt(money);
				loan.setTotalDue(money);

				loanList.add(loan);
			}
			// 7 Fondos de Inversion
			if (response.get(i).getType().equals(EnumProductType.SI)) {

				FundDTO fund = new FundDTO();
				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				fund.setAlias(response.get(i).getAlias());
				fund.setCashAvailable(money);
				fund.setProductId(response.get(i).getId());
				fund.setProductName(response.get(i).getName());
				fund.setProductNumber(response.get(i).getId());
				fund.setTotalCash(money);
				fund.setTypeProd(response.get(i).getType());
				fund.setAsset(response.get(i).isVisible());
				fund.setVisible(response.get(i).isVisible());

				fundList.add(fund);
			}
			// 8 Depósitos
			if (response.get(i).getType().equals(EnumProductType.ED)) {
				DepositDTO deposit = new DepositDTO();

				Money money = new Money(response.get(i).getBalance().getAvailableBalance().getAmount(), response.get(i)
						.getBalance().getAvailableBalance().getCurrency());

				deposit.setAlias(response.get(i).getAlias());
				deposit.setCashAvailable(money);
				deposit.setProductId(response.get(i).getId());
				deposit.setProductName(response.get(i).getName());
				deposit.setProductNumber(response.get(i).getId());
				deposit.setTotalCash(money);
				deposit.setTypeProd(response.get(i).getType());
				deposit.setAsset(response.get(i).isVisible());
				deposit.setVisible(response.get(i).isVisible());
				depositList.add(deposit);
			}

		}

		globalProducts.setAccounts(accountList);
		globalProducts.setAdquirencia(adquirenciaList);
		globalProducts.setCreditCards(creditCardList);
		globalProducts.setElectronicDeposits(depositList);
		globalProducts.setLeasings(leasingList);
		globalProducts.setRotatingAccounts(rotatingList);
		globalProducts.setFunds(fundList);
		globalProducts.setLoan(loanList);

		return globalProducts;

	}
}
