package com.bbva.net.back.model.turnsClient;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class turnsClientDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date dateOperation;

	private String advance;

	private String operation;

	private String negotiationType;

	private String divisa;

	private Money amount;

	private String valuation;

	private String stateOperation;

	private String beneficiary;

	/**
	 * 
	 */
	public turnsClientDto() {
	}

	/**
	 * @param dateOperation
	 * @param advance
	 * @param operation
	 * @param negosationType
	 * @param divisa
	 * @param amount
	 * @param valuation
	 * @param stateOperation
	 * @param beneficiary
	 */
	public turnsClientDto(Date dateOperation, String advance, String operation, String negotiationType, String divisa,
			Money amount, String valuation, String stateOperation, String beneficiary) {
		this.dateOperation = dateOperation;
		this.advance = advance;
		this.operation = operation;
		this.negotiationType = negotiationType;
		this.divisa = divisa;
		this.amount = amount;
		this.valuation = valuation;
		this.stateOperation = stateOperation;
		this.beneficiary = beneficiary;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDateOperation()).append(getAdvance()).append(getAmount())
				.append(getBeneficiary()).append(getDivisa()).append(getStateOperation()).append(getValuation())
				.append(getNegotiationType()).append(getOperation()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof turnsClientDto)
				&& (this.getDateOperation() != null && ((turnsClientDto)obj).getDateOperation() != null)
				&& (this.getAdvance() != null && ((turnsClientDto)obj).getAdvance() != null)
				&& (this.getAmount() != null && ((turnsClientDto)obj).getAmount() != null)
				&& (this.getBeneficiary() != null && ((turnsClientDto)obj).getBeneficiary() != null)
				&& (this.getDivisa() != null && ((turnsClientDto)obj).getDivisa() != null)
				&& (this.getStateOperation() != null && ((turnsClientDto)obj).getStateOperation() != null)
				&& (this.getNegotiationType() != null && ((turnsClientDto)obj).getNegotiationType() != null)
				&& (this.getOperation() != null && ((turnsClientDto)obj).getOperation() != null)
				&& (this.getValuation() != null && ((turnsClientDto)obj).getValuation() != null);

	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("dateOperation", getDateOperation()).append("advance", getAdvance())
				.append("amount", getAmount()).append("beneficiary", getBeneficiary()).append("divisa", getDivisa())
				.append("stateOperation", getStateOperation()).append("valuation", getValuation())
				.append("negotiationType", getNegotiationType()).append("operation", getOperation()).toString();
	}

	// Setters and getters

	/**
	 * @return the dateOperation
	 */
	public Date getDateOperation() {
		return dateOperation;
	}

	/**
	 * @param dateOperation the dateOperation to set
	 */
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	/**
	 * @return the advance
	 */
	public String getAdvance() {
		return advance;
	}

	/**
	 * @param advance the advance to set
	 */
	public void setAdvance(String advance) {
		this.advance = advance;
	}

	/**
	 * @return the divisa
	 */
	public String getDivisa() {
		return divisa;
	}

	/**
	 * @param divisa the divisa to set
	 */
	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}

	/**
	 * @return the amount
	 */
	public Money getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Money amount) {
		this.amount = amount;
	}

	/**
	 * @return the valuation
	 */
	public String getValuation() {
		return valuation;
	}

	/**
	 * @param valuation the valuation to set
	 */
	public void setValuation(String valuation) {
		this.valuation = valuation;
	}

	/**
	 * @return the stateOperation
	 */
	public String getStateOperation() {
		return stateOperation;
	}

	/**
	 * @param stateOperation the stateOperation to set
	 */
	public void setStateOperation(String stateOperation) {
		this.stateOperation = stateOperation;
	}

	/**
	 * @return the beneficiary
	 */
	public String getBeneficiary() {
		return beneficiary;
	}

	/**
	 * @param beneficiary the beneficiary to set
	 */
	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * @return the negosationType
	 */
	public String getNegotiationType() {
		return negotiationType;
	}

	/**
	 * @param negosationType the negosationType to set
	 */
	public void setNegotiationType(String negotiationType) {
		this.negotiationType = negotiationType;
	}

}
