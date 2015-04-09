package com.bbva.net.back.model.favoriteOperations;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class FavoriteOperationDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7006948194722492379L;

	private Date transactionDate;

	private Money amount;

	private String origin;

	private String destination;

	private String contractId;

	private String idOperation;

	private String name;

	private String transactionReference;

	public FavoriteOperationDto() {
	}

	/**
	 * @param transactionDate
	 * @param amount
	 * @param origin
	 * @param destination
	 * @param contractId
	 * @param idOperation
	 * @param name
	 * @param transactionReference
	 */
	public FavoriteOperationDto(Date transactionDate, Money amount, String origin, String destination,
			String contractId, String idOperation, String name, String transactionReference) {
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.origin = origin;
		this.destination = destination;
		this.contractId = contractId;
		this.idOperation = idOperation;
		this.name = name;
		this.transactionReference = transactionReference;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getTransactionDate()).append(getAmount()).append(getOrigin())
				.append(getDestination()).append(getContractId()).append(getIdOperation()).append(getName())
				.append(getTransactionReference()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof FavoriteOperationDto)
				&& this.getTransactionDate().equals(((FavoriteOperationDto)obj).getTransactionDate())
				&& this.getAmount().equals(((FavoriteOperationDto)obj).getAmount());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("transactionDate", getTransactionDate()).append("ammount", getAmount())
				.append("origin", getOrigin()).append("destination", getDestination())
				.append("contractId", getContractId()).append("idOperation", getIdOperation())
				.append("name", getName()).append("transactionReference", getTransactionReference()).toString();
	}

	// Setters and getters

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the contractId
	 */
	public String getContractId() {
		return contractId;
	}

	/**
	 * @param contractId the contractId to set
	 */
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	/**
	 * @return the idOperation
	 */
	public String getIdOperation() {
		return idOperation;
	}

	/**
	 * @param idOperation the idOperation to set
	 */
	public void setIdOperation(String idOperation) {
		this.idOperation = idOperation;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the transactionReference
	 */
	public String getTransactionReference() {
		return transactionReference;
	}

	/**
	 * @param transactionReference the transactionReference to set
	 */
	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}

}
