package com.bbva.net.back.model.turnsClient;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class turnsClientDetailDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String accountNumber;

	private String operationNumber;

	private Date valueDate;

	private Date operationHour;

	private String amountLetter;

	private String moneyType;

	private String advanceNumber;

	private Money divisaValuation;

	private String valuationUSDValue;

	private String equivalentValue;

	private String formChangeNum;

	private String transferDescription;

	private String ordered;

	private String beneficiaryBank;

	private String country;

	private String swift;

	private String aba;

	/**
	 * 
	 */
	public turnsClientDetailDto() {
	}

	/**
	 * @param accountNumber
	 * @param operationNumber
	 * @param operationDate
	 * @param valueDate
	 * @param operationHour
	 * @param amount
	 * @param amountLetter
	 * @param moneyType
	 * @param advanceNumber
	 * @param negotiationType
	 * @param divisaValuation
	 * @param valuationUSDValue
	 * @param equivalentValue
	 * @param formChangeNum
	 * @param transferDescription
	 * @param ordered
	 * @param beneficiary
	 * @param beneficiaryBank
	 * @param country
	 * @param swift
	 * @param aBA
	 */
	public turnsClientDetailDto(String accountNumber, String operationNumber, Date valueDate, Date operationHour,
			String amountLetter, String moneyType, String advanceNumber, Money divisaValuation,
			String valuationUSDValue, String equivalentValue, String formChangeNum, String transferDescription,
			String ordered, String beneficiaryBank, String country, String swift, String aBA) {
		this.accountNumber = accountNumber;
		this.operationNumber = operationNumber;
		this.valueDate = valueDate;
		this.operationHour = operationHour;
		this.amountLetter = amountLetter;
		this.moneyType = moneyType;
		this.advanceNumber = advanceNumber;
		this.divisaValuation = divisaValuation;
		this.valuationUSDValue = valuationUSDValue;
		this.equivalentValue = equivalentValue;
		this.formChangeNum = formChangeNum;
		this.transferDescription = transferDescription;
		this.ordered = ordered;
		this.beneficiaryBank = beneficiaryBank;
		this.country = country;
		this.swift = swift;
		this.aba = aBA;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getAba()).append(getAccountNumber()).append(getAdvanceNumber())
				.append(getAmountLetter()).append(getBeneficiaryBank()).append(getCountry())
				.append(getDivisaValuation()).append(getEquivalentValue()).append(getFormChangeNum())
				.append(getMoneyType()).append(getOperationHour()).append(getOperationNumber()).append(getOrdered())
				.append(getSwift()).append(getTransferDescription()).append(getValuationUSDValue())
				.append(getValueDate()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null)
				&& (obj instanceof turnsClientDetailDto)
				&& (this.getAba() != null && ((turnsClientDetailDto)obj).getAba() != null)
				&& (this.getAccountNumber() != null && ((turnsClientDetailDto)obj).getAccountNumber() != null)
				&& (this.getAdvanceNumber() != null && ((turnsClientDetailDto)obj).getAdvanceNumber() != null)
				&& (this.getAmountLetter() != null && ((turnsClientDetailDto)obj).getAmountLetter() != null)
				&& (this.getBeneficiaryBank() != null && ((turnsClientDetailDto)obj).getBeneficiaryBank() != null)
				&& (this.getCountry() != null && ((turnsClientDetailDto)obj).getCountry() != null)
				&& (this.getDivisaValuation() != null && ((turnsClientDetailDto)obj).getDivisaValuation() != null)
				&& (this.getEquivalentValue() != null && ((turnsClientDetailDto)obj).getEquivalentValue() != null)
				&& (this.getFormChangeNum() != null && ((turnsClientDetailDto)obj).getFormChangeNum() != null)
				&& (this.getMoneyType() != null && ((turnsClientDetailDto)obj).getMoneyType() != null)
				&& (this.getOperationHour() != null && ((turnsClientDetailDto)obj).getOperationHour() != null)
				&& (this.getOperationNumber() != null && ((turnsClientDetailDto)obj).getOperationNumber() != null)
				&& (this.getOrdered() != null && ((turnsClientDetailDto)obj).getOrdered() != null)
				&& (this.getSwift() != null && ((turnsClientDetailDto)obj).getSwift() != null)
				&& (this.getTransferDescription() != null && ((turnsClientDetailDto)obj).getTransferDescription() != null)
				&& (this.getMoneyType() != null && ((turnsClientDetailDto)obj).getMoneyType() != null)
				&& (this.getValueDate() != null && ((turnsClientDetailDto)obj).getValueDate() != null)
				&& (this.getValuationUSDValue() != null && ((turnsClientDetailDto)obj).getValuationUSDValue() != null);

	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("ABA", getAba()).append("accountNumber", getAccountNumber())
				.append("advanceNumber", getAdvanceNumber()).append("amountLetter", getAmountLetter())
				.append("beneficiaryBank", getBeneficiaryBank()).append("country", getCountry())
				.append("divisaValuation", getDivisaValuation()).append("equivalentValue", getEquivalentValue())
				.append("formChangeNum", getFormChangeNum()).append("moneyType", getMoneyType())
				.append("operationNumber", getOperationNumber()).append("operationHour", getOperationHour())
				.append("ordered", getOrdered()).append("swift", getSwift())
				.append("transferDesp", getTransferDescription()).append("valuationUSD", getValuationUSDValue())
				.append("valuationDate", getValueDate()).toString();
	}

	// Setters and getters

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the operationNumber
	 */
	public String getOperationNumber() {
		return operationNumber;
	}

	/**
	 * @param operationNumber the operationNumber to set
	 */
	public void setOperationNumber(String operationNumber) {
		this.operationNumber = operationNumber;
	}

	/**
	 * @return the valueDate
	 */
	public Date getValueDate() {
		return valueDate;
	}

	/**
	 * @param valueDate the valueDate to set
	 */
	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	/**
	 * @return the operationHour
	 */
	public Date getOperationHour() {
		return operationHour;
	}

	/**
	 * @param operationHour the operationHour to set
	 */
	public void setOperationHour(Date operationHour) {
		this.operationHour = operationHour;
	}

	/**
	 * @return the amountLetter
	 */
	public String getAmountLetter() {
		return amountLetter;
	}

	/**
	 * @param amountLetter the amountLetter to set
	 */
	public void setAmountLetter(String amountLetter) {
		this.amountLetter = amountLetter;
	}

	/**
	 * @return the moneyType
	 */
	public String getMoneyType() {
		return moneyType;
	}

	/**
	 * @param moneyType the moneyType to set
	 */
	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}

	/**
	 * @return the advanceNumber
	 */
	public String getAdvanceNumber() {
		return advanceNumber;
	}

	/**
	 * @param advanceNumber the advanceNumber to set
	 */
	public void setAdvanceNumber(String advanceNumber) {
		this.advanceNumber = advanceNumber;
	}

	/**
	 * @return the divisaValuation
	 */
	public Money getDivisaValuation() {
		return divisaValuation;
	}

	/**
	 * @param divisaValuation the divisaValuation to set
	 */
	public void setDivisaValuation(Money divisaValuation) {
		this.divisaValuation = divisaValuation;
	}

	/**
	 * @return the valuationUSDValue
	 */
	public String getValuationUSDValue() {
		return valuationUSDValue;
	}

	/**
	 * @param valuationUSDValue the valuationUSDValue to set
	 */
	public void setValuationUSDValue(String valuationUSDValue) {
		this.valuationUSDValue = valuationUSDValue;
	}

	/**
	 * @return the equivalentValue
	 */
	public String getEquivalentValue() {
		return equivalentValue;
	}

	/**
	 * @param equivalentValue the equivalentValue to set
	 */
	public void setEquivalentValue(String equivalentValue) {
		this.equivalentValue = equivalentValue;
	}

	/**
	 * @return the formChangeNum
	 */
	public String getFormChangeNum() {
		return formChangeNum;
	}

	/**
	 * @param formChangeNum the formChangeNum to set
	 */
	public void setFormChangeNum(String formChangeNum) {
		this.formChangeNum = formChangeNum;
	}

	/**
	 * @return the transferDescription
	 */
	public String getTransferDescription() {
		return transferDescription;
	}

	/**
	 * @param transferDescription the transferDescription to set
	 */
	public void setTransferDescription(String transferDescription) {
		this.transferDescription = transferDescription;
	}

	/**
	 * @return the ordered
	 */
	public String getOrdered() {
		return ordered;
	}

	/**
	 * @param ordered the ordered to set
	 */
	public void setOrdered(String ordered) {
		this.ordered = ordered;
	}

	/**
	 * @return the beneficiaryBank
	 */
	public String getBeneficiaryBank() {
		return beneficiaryBank;
	}

	/**
	 * @param beneficiaryBank the beneficiaryBank to set
	 */
	public void setBeneficiaryBank(String beneficiaryBank) {
		this.beneficiaryBank = beneficiaryBank;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the swift
	 */
	public String getSwift() {
		return swift;
	}

	/**
	 * @param swift the swift to set
	 */
	public void setSwift(String swift) {
		this.swift = swift;
	}

	/**
	 * @return the aBA
	 */
	public String getAba() {
		return aba;
	}

	/**
	 * @param aBA the aBA to set
	 */
	public void setAba(String aba) {
		this.aba = aba;
	}
}
