package com.bbva.net.back.model.globalposition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class GlobalProductsDto implements Serializable {

	private final static long serialVersionUID = 1L;

	private List<AccountDto> accounts;

	private List<RotatingAccountDto> rotatingAccounts;

	private List<LeasingDto> leasings;

	private List<FundDto> funds;

	private List<CreditCardDto> creditCards;

	private List<DepositDto> electronicDeposits;

	private List<AdquirenceAccountDto> adquirencia;

	private List<LoanDto> loan;

	public GlobalProductsDto() {

		this.accounts = new ArrayList<AccountDto>();
		this.rotatingAccounts = new ArrayList<RotatingAccountDto>();
		this.leasings = new ArrayList<LeasingDto>();
		this.funds = new ArrayList<FundDto>();
		this.creditCards = new ArrayList<CreditCardDto>();
		this.electronicDeposits = new ArrayList<DepositDto>();
		this.adquirencia = new ArrayList<AdquirenceAccountDto>();
		this.loan = new ArrayList<LoanDto>();
	}

	public List<AccountDto> getAccounts() {
		return this.accounts;
	}

	public boolean isSetAccounts() {
		return CollectionUtils.isEmpty(this.accounts);
	}

	public void unsetAccounts() {
		this.accounts = null;
	}

	public List<RotatingAccountDto> getRotatingAccounts() {
		return this.rotatingAccounts;
	}

	public boolean isSetRotatingAccounts() {
		return CollectionUtils.isEmpty(this.rotatingAccounts);
	}

	public void unsetRotatingAccounts() {
		this.rotatingAccounts = null;
	}

	public List<LeasingDto> getLeasings() {
		return this.leasings;
	}

	public boolean isSetLeasings() {
		return CollectionUtils.isEmpty(this.leasings);
	}

	public void unsetLeasings() {
		this.leasings = null;
	}

	public List<FundDto> getFunds() {
		return this.funds;
	}

	public boolean isSetFunds() {
		return CollectionUtils.isEmpty(this.funds);
	}

	public void unsetFunds() {
		this.funds = null;
	}

	public List<CreditCardDto> getCreditCards() {
		return this.creditCards;
	}

	public boolean isSetCreditCards() {
		return CollectionUtils.isEmpty(this.creditCards);
	}

	public void unsetCreditCards() {
		this.creditCards = null;
	}

	public List<DepositDto> getElectronicDeposits() {
		return this.electronicDeposits;
	}

	public boolean isSetElectronicDeposits() {
		return CollectionUtils.isEmpty(this.electronicDeposits);
	}

	public void unsetElectronicDeposits() {
		this.electronicDeposits = null;
	}

	public void setAccounts(List<AccountDto> accounts) {
		this.accounts = accounts;
	}

	public void setRotatingAccounts(List<RotatingAccountDto> rotatingAccounts) {
		this.rotatingAccounts = rotatingAccounts;
	}

	public void setLeasings(List<LeasingDto> leasings) {
		this.leasings = leasings;
	}

	public void setFunds(List<FundDto> funds) {
		this.funds = funds;
	}

	public void setCreditCards(List<CreditCardDto> creditCards) {
		this.creditCards = creditCards;
	}

	public void setElectronicDeposits(List<DepositDto> electronicDeposits) {
		this.electronicDeposits = electronicDeposits;
	}

	public List<LoanDto> getLoan() {
		return loan;
	}

	public void setLoan(List<LoanDto> loan) {
		this.loan = loan;
	}

	public List<AdquirenceAccountDto> getAdquirencia() {
		return adquirencia;
	}

	public void setAdquirencia(List<AdquirenceAccountDto> adquirencia) {
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
