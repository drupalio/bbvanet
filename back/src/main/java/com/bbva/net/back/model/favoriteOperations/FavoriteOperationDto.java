package com.bbva.net.back.model.favoriteOperations;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class FavoriteOperationDto implements Dto {

    // <!-- Entelgy / GP13137 / 17112015 / INICIO -->
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

    private String numberOCard;

    private String bankCodeOccc;

    private String branchCodeOccc;

    private String controlOccc;

    private String accountNumberOccc;

    private String bankCodeOCa;

    private String regionCodeOCa;

    private String accountNumberOCa;

    private String controlDigitOCa;

    private String numberOMo;

    private String numberOCre;

    private String numberDCard;

    private String bankCodeDccc;

    private String branchCodeDccc;

    private String controlDigitDccc;

    private String accountNumberDccc;

    private String bankCodeDCa;

    private String regionCodeDCa;

    private String accountNumberDCa;

    private String controlDigitDCa;

    private String numberDMo;

    private String numberDCre;

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

    public String getNumberOCard() {
        return numberOCard;
    }

    public void setNumberOCard(String numberOCard) {
        this.numberOCard = numberOCard;
    }

    public String getBankCodeOccc() {
        return bankCodeOccc;
    }

    public void setBankCodeOccc(String bankCodeOccc) {
        this.bankCodeOccc = bankCodeOccc;
    }

    public String getBranchCodeOccc() {
        return branchCodeOccc;
    }

    public void setBranchCodeOccc(String branchCodeOccc) {
        this.branchCodeOccc = branchCodeOccc;
    }

    public String getControlOccc() {
        return controlOccc;
    }

    public void setControlOccc(String controlOccc) {
        this.controlOccc = controlOccc;
    }

    public String getAccountNumberOccc() {
        return accountNumberOccc;
    }

    public void setAccountNumberOccc(String accountNumberOccc) {
        this.accountNumberOccc = accountNumberOccc;
    }

    public String getBankCodeOCa() {
        return bankCodeOCa;
    }

    public void setBankCodeOCa(String bankCodeOCa) {
        this.bankCodeOCa = bankCodeOCa;
    }

    public String getRegionCodeOCa() {
        return regionCodeOCa;
    }

    public void setRegionCodeOCa(String regionCodeOCa) {
        this.regionCodeOCa = regionCodeOCa;
    }

    public String getAccountNumberOCa() {
        return accountNumberOCa;
    }

    public void setAccountNumberOCa(String accountNumberOCa) {
        this.accountNumberOCa = accountNumberOCa;
    }

    public String getControlDigitOCa() {
        return controlDigitOCa;
    }

    public void setControlDigitOCa(String controlDigitOCa) {
        this.controlDigitOCa = controlDigitOCa;
    }

    public String getNumberOMo() {
        return numberOMo;
    }

    public void setNumberOMo(String numberOMo) {
        this.numberOMo = numberOMo;
    }

    public String getNumberOCre() {
        return numberOCre;
    }

    public void setNumberOCre(String numberOCre) {
        this.numberOCre = numberOCre;
    }

    public String getNumberDCard() {
        return numberDCard;
    }

    public void setNumberDCard(String numberDCard) {
        this.numberDCard = numberDCard;
    }

    public String getBankCodeDccc() {
        return bankCodeDccc;
    }

    public void setBankCodeDccc(String bankCodeDccc) {
        this.bankCodeDccc = bankCodeDccc;
    }

    public String getBranchCodeDccc() {
        return branchCodeDccc;
    }

    public void setBranchCodeDccc(String branchCodeDccc) {
        this.branchCodeDccc = branchCodeDccc;
    }

    public String getControlDigitDccc() {
        return controlDigitDccc;
    }

    public void setControlDigitDccc(String controlDigitDccc) {
        this.controlDigitDccc = controlDigitDccc;
    }

    public String getAccountNumberDccc() {
        return accountNumberDccc;
    }

    public void setAccountNumberDccc(String accountNumberDccc) {
        this.accountNumberDccc = accountNumberDccc;
    }

    public String getBankCodeDCa() {
        return bankCodeDCa;
    }

    public void setBankCodeDCa(String bankCodeDCa) {
        this.bankCodeDCa = bankCodeDCa;
    }

    public String getRegionCodeDCa() {
        return regionCodeDCa;
    }

    public void setRegionCodeDCa(String regionCodeDCa) {
        this.regionCodeDCa = regionCodeDCa;
    }

    public String getAccountNumberDCa() {
        return accountNumberDCa;
    }

    public void setAccountNumberDCa(String accountNumberDCa) {
        this.accountNumberDCa = accountNumberDCa;
    }

    public String getControlDigitDCa() {
        return controlDigitDCa;
    }

    public void setControlDigitDCa(String controlDigitDCa) {
        this.controlDigitDCa = controlDigitDCa;
    }

    public String getNumberDMo() {
        return numberDMo;
    }

    public void setNumberDMo(String numberDMo) {
        this.numberDMo = numberDMo;
    }

    public String getNumberDCre() {
        return numberDCre;
    }

    public void setNumberDCre(String numberDCre) {
        this.numberDCre = numberDCre;
    }
    // <!-- Entelgy / GP13137 / 17112015 / FIN -->
}
