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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(String idOperation) {
		this.idOperation = idOperation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof FavoriteOperationDto)
				&& this.getTransactionDate().equals(((FavoriteOperationDto)obj).getTransactionDate())
				&& this.getAmount().equals(((FavoriteOperationDto)obj).getAmount());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getTransactionDate()).append(getAmount()).append(getOrigin())
				.append(getDestination()).append(getContractId()).append(getIdOperation()).append(getName())
				.append(getTransactionReference()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("transactionDate", getTransactionDate()).append("ammount", getAmount())
				.append("origin", getOrigin()).append("destination", getDestination())
				.append("contractId", getContractId()).append("idOperation", getIdOperation())
				.append("name", getName()).append("transactionReference", getTransactionReference()).toString();
	}

}
