package com.bbva.net.back.model.globalposition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GlobalProductsDTO implements Serializable {

	private final static long serialVersionUID = 1L;

	private List<AccountDTO> accounts;

	private List<RotatingAccountDTO> rotatingAccounts;

	private List<LeasingDTO> leasings;

	private List<FundDTO> funds;

	private List<CreditCardDTO> creditCards;

	private List<DepositDTO> electronicDeposits;

	private List<AdquirenceAccountDTO> adquirencia;

	private List<LoanDTO> loan;

	public List<AccountDTO> getAccounts() {
		if (accounts == null) {
			accounts = new ArrayList<AccountDTO>();
		}
		return this.accounts;
	}

	public boolean isSetAccounts() {
		return ((this.accounts != null) && (!this.accounts.isEmpty()));
	}

	public void unsetAccounts() {
		this.accounts = null;
	}

	public List<RotatingAccountDTO> getRotatingAccounts() {
		if (rotatingAccounts == null) {
			rotatingAccounts = new ArrayList<RotatingAccountDTO>();
		}
		return this.rotatingAccounts;
	}

	public boolean isSetRotatingAccounts() {
		return ((this.rotatingAccounts != null) && (!this.rotatingAccounts.isEmpty()));
	}

	public void unsetRotatingAccounts() {
		this.rotatingAccounts = null;
	}

	public List<LeasingDTO> getLeasings() {
		if (leasings == null) {
			leasings = new ArrayList<LeasingDTO>();
		}
		return this.leasings;
	}

	public boolean isSetLeasings() {
		return ((this.leasings != null) && (!this.leasings.isEmpty()));
	}

	public void unsetLeasings() {
		this.leasings = null;
	}

	public List<FundDTO> getFunds() {
		if (funds == null) {
			funds = new ArrayList<FundDTO>();
		}
		return this.funds;
	}

	public boolean isSetFunds() {
		return ((this.funds != null) && (!this.funds.isEmpty()));
	}

	public void unsetFunds() {
		this.funds = null;
	}

	public List<CreditCardDTO> getCreditCards() {
		if (creditCards == null) {
			creditCards = new ArrayList<CreditCardDTO>();
		}
		return this.creditCards;
	}

	public boolean isSetCreditCards() {
		return ((this.creditCards != null) && (!this.creditCards.isEmpty()));
	}

	public void unsetCreditCards() {
		this.creditCards = null;
	}

	public List<DepositDTO> getElectronicDeposits() {
		if (electronicDeposits == null) {
			electronicDeposits = new ArrayList<DepositDTO>();
		}
		return this.electronicDeposits;
	}

	public boolean isSetElectronicDeposits() {
		return ((this.electronicDeposits != null) && (!this.electronicDeposits.isEmpty()));
	}

	public void unsetElectronicDeposits() {
		this.electronicDeposits = null;
	}

	public void setAccounts(List<AccountDTO> accounts) {
		this.accounts = accounts;
	}

	public void setRotatingAccounts(List<RotatingAccountDTO> rotatingAccounts) {
		this.rotatingAccounts = rotatingAccounts;
	}

	public void setLeasings(List<LeasingDTO> leasings) {
		this.leasings = leasings;
	}

	public void setFunds(List<FundDTO> funds) {
		this.funds = funds;
	}

	public void setCreditCards(List<CreditCardDTO> creditCards) {
		this.creditCards = creditCards;
	}

	public void setElectronicDeposits(List<DepositDTO> electronicDeposits) {
		this.electronicDeposits = electronicDeposits;
	}

	public List<LoanDTO> getLoan() {
		return loan;
	}

	public void setLoan(List<LoanDTO> loan) {
		this.loan = loan;
	}

	public List<AdquirenceAccountDTO> getAdquirencia() {
		return adquirencia;
	}

	public void setAdquirencia(List<AdquirenceAccountDTO> adquirencia) {
		this.adquirencia = adquirencia;
	}

}
