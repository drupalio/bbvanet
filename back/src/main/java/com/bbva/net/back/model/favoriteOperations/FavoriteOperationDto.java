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

	private Money ammount;

	private String origin;

	private String destination;

	private String contractId;

	private String idOperation;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Money getAmmount() {
		return ammount;
	}

	public void setAmmount(Money ammount) {
		this.ammount = ammount;
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

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof FavoriteOperationDto)
				&& this.getTransactionDate().equals(((FavoriteOperationDto)obj).getTransactionDate())
				&& this.getAmmount().equals(((FavoriteOperationDto)obj).getAmmount());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getTransactionDate()).append(getAmmount()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("transactionDate", getTransactionDate())
				.append("ammount", getAmmount()).toString();
	}

}
