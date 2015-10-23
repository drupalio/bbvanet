package com.bbva.net.back.model.favoriteOperations;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class FavoriteOperationDto implements Dto {


	// <!-- Entelgy / GP13137 / 22102015 / INICIO -->
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

    private String bankCodeOrigin;

    private String controlDigitOrigin;

    private String accountNumberOrigin;

    private String branchCodeOrigin;

    private String regionCodeOrigin;

    private String numberOrigin;

    private String bankCodeDest;

    private String controlDigitDest;

    private String accountNumberDest;

    private String branchCodeDest;

    private String regionCodeDest;

    private String numberDest;

    // RESPONSE
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
    
    /**
     * @return the bankCodeOrigin
     */
    public String getBankCodeOrigin() {
        return bankCodeOrigin;
    }
    
    /**
     * @param bankCodeOrigin the bankCodeOrigin to set
     */
    public void setBankCodeOrigin(String bankCodeOrigin) {
        this.bankCodeOrigin = bankCodeOrigin;
    }
    
    /**
     * @return the controlDigitOrigin
     */
    public String getControlDigitOrigin() {
        return controlDigitOrigin;
    }
    
    /**
     * @param controlDigitOrigin the controlDigitOrigin to set
     */
    public void setControlDigitOrigin(String controlDigitOrigin) {
        this.controlDigitOrigin = controlDigitOrigin;
    }
    
    /**
     * @return the accountNumberOrigin
     */
    public String getAccountNumberOrigin() {
        return accountNumberOrigin;
    }
    
    /**
     * @param accountNumberOrigin the accountNumberOrigin to set
     */
    public void setAccountNumberOrigin(String accountNumberOrigin) {
        this.accountNumberOrigin = accountNumberOrigin;
    }
    
    /**
     * @return the branchCodeOrigin
     */
    public String getBranchCodeOrigin() {
        return branchCodeOrigin;
    }
    
    /**
     * @param branchCodeOrigin the branchCodeOrigin to set
     */
    public void setBranchCodeOrigin(String branchCodeOrigin) {
        this.branchCodeOrigin = branchCodeOrigin;
    }
    
    /**
     * @return the regionCodeOrigin
     */
    public String getRegionCodeOrigin() {
        return regionCodeOrigin;
    }
    
    /**
     * @param regionCodeOrigin the regionCodeOrigin to set
     */
    public void setRegionCodeOrigin(String regionCodeOrigin) {
        this.regionCodeOrigin = regionCodeOrigin;
    }
    
    /**
     * @return the numberOrigin
     */
    public String getNumberOrigin() {
        return numberOrigin;
    }
    
    /**
     * @param numberOrigin the numberOrigin to set
     */
    public void setNumberOrigin(String numberOrigin) {
        this.numberOrigin = numberOrigin;
    }
    
    /**
     * @return the bankCodeDest
     */
    public String getBankCodeDest() {
        return bankCodeDest;
    }
    
    /**
     * @param bankCodeDest the bankCodeDest to set
     */
    public void setBankCodeDest(String bankCodeDest) {
        this.bankCodeDest = bankCodeDest;
    }
    
    /**
     * @return the controlDigitDest
     */
    public String getControlDigitDest() {
        return controlDigitDest;
    }
    
    /**
     * @param controlDigitDest the controlDigitDest to set
     */
    public void setControlDigitDest(String controlDigitDest) {
        this.controlDigitDest = controlDigitDest;
    }
    
    /**
     * @return the accountNumberDest
     */
    public String getAccountNumberDest() {
        return accountNumberDest;
    }
    
    /**
     * @param accountNumberDest the accountNumberDest to set
     */
    public void setAccountNumberDest(String accountNumberDest) {
        this.accountNumberDest = accountNumberDest;
    }
    
    /**
     * @return the branchCodeDest
     */
    public String getBranchCodeDest() {
        return branchCodeDest;
    }
    
    /**
     * @param branchCodeDest the branchCodeDest to set
     */
    public void setBranchCodeDest(String branchCodeDest) {
        this.branchCodeDest = branchCodeDest;
    }
    
    /**
     * @return the regionCodeDest
     */
    public String getRegionCodeDest() {
        return regionCodeDest;
    }
    
    /**
     * @param regionCodeDest the regionCodeDest to set
     */
    public void setRegionCodeDest(String regionCodeDest) {
        this.regionCodeDest = regionCodeDest;
    }
    
    /**
     * @return the numberDest
     */
    public String getNumberDest() {
        return numberDest;
    }
    
    /**
     * @param numberDest the numberDest to set
     */
    public void setNumberDest(String numberDest) {
        this.numberDest = numberDest;
    }
	// <!-- Entelgy / GP13137 / 22102015 / FIN -->
}
