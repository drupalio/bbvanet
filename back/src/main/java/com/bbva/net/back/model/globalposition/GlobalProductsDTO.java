package com.bbva.net.back.model.globalposition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

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

	public GlobalProductsDTO() {

		this.accounts = new ArrayList<AccountDTO>();
		this.rotatingAccounts = new ArrayList<RotatingAccountDTO>();
		this.leasings = new ArrayList<LeasingDTO>();
		this.funds = new ArrayList<FundDTO>();
		this.creditCards = new ArrayList<CreditCardDTO>();
		this.electronicDeposits = new ArrayList<DepositDTO>();
		this.adquirencia = new ArrayList<AdquirenceAccountDTO>();
		this.loan = new ArrayList<LoanDTO>();
	}

	public List<AccountDTO> getAccounts() {
		return this.accounts;
	}

	public boolean isSetAccounts() {
		return CollectionUtils.isEmpty(this.accounts);
	}

	public void unsetAccounts() {
		this.accounts = null;
	}

	public List<RotatingAccountDTO> getRotatingAccounts() {
		return this.rotatingAccounts;
	}

	public boolean isSetRotatingAccounts() {
		return CollectionUtils.isEmpty(this.rotatingAccounts);
	}

	public void unsetRotatingAccounts() {
		this.rotatingAccounts = null;
	}

	public List<LeasingDTO> getLeasings() {
		return this.leasings;
	}

	public boolean isSetLeasings() {
		return CollectionUtils.isEmpty(this.leasings);
	}

	public void unsetLeasings() {
		this.leasings = null;
	}

	public List<FundDTO> getFunds() {
		return this.funds;
	}

	public boolean isSetFunds() {
		return CollectionUtils.isEmpty(this.funds);
	}

	public void unsetFunds() {
		this.funds = null;
	}

	public List<CreditCardDTO> getCreditCards() {
		return this.creditCards;
	}

	public boolean isSetCreditCards() {
		return CollectionUtils.isEmpty(this.creditCards);
	}

	public void unsetCreditCards() {
		this.creditCards = null;
	}

	public List<DepositDTO> getElectronicDeposits() {
		return this.electronicDeposits;
	}

	public boolean isSetElectronicDeposits() {
		return CollectionUtils.isEmpty(this.electronicDeposits);
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

	@Override
	public String toString() {

		return new ToStringBuilder(this).append("accounts", getAccounts())
				.append("rotatingAccounts", getRotatingAccounts()).append("leasings", getLeasings())
				.append("funds", getFunds()).append("creditCards", getCreditCards())
				.append("electronicDeposits", getElectronicDeposits()).append("adquirencia", getAdquirencia())
				.append("loan", getLoan()).toString();
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder().append(getAccounts()).append(getRotatingAccounts()).append(getLeasings())
				.append(getFunds()).append(getCreditCards()).append(getElectronicDeposits()).append(getAdquirencia())
				.append(getLoan()).toHashCode();
	}

}
