package com.bbva.net.back.model.turnsClient;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class turnsClientDetailDto implements Dto {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Date operationDate;

    private String operationNumber;

    private Date operationHour;

    private String referenceOper;

    private String transferDescription;

    private String amountLetter;

    private String advanceNumber;

    private ContactDto beneficiary;

    private ContactDto ordenant;

    private BankDto bankIntermediary;

    private FormCurrencyDto formCurrency;

    private QuotationMoneyDto rates;

    private String stateOperation;

    /**
     *
     */
    public turnsClientDetailDto() {
    }

    /**
     * @param operationDate
     * @param operationNumber
     * @param operationHour
     * @param referenceOper
     * @param transferDescription
     * @param amountLetter
     * @param advanceNumber
     * @param beneficiary
     * @param ordenant
     * @param bankIntermediary
     * @param formCurrency
     * @param rates
     */
    public turnsClientDetailDto(Date operationDate, String operationNumber, Date operationHour, String referenceOper, String transferDescription,
            String amountLetter, String advanceNumber, ContactDto beneficiary, ContactDto ordenant, BankDto bankIntermediary,
            FormCurrencyDto formCurrency, QuotationMoneyDto rates, String stateOperation) {
        this.operationDate = operationDate;
        this.operationNumber = operationNumber;
        this.operationHour = operationHour;
        this.referenceOper = referenceOper;
        this.transferDescription = transferDescription;
        this.amountLetter = amountLetter;
        this.advanceNumber = advanceNumber;
        this.beneficiary = beneficiary;
        this.ordenant = ordenant;
        this.bankIntermediary = bankIntermediary;
        this.formCurrency = formCurrency;
        this.rates = rates;
        this.stateOperation = stateOperation;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getOperationDate()).append(getOperationNumber()).append(getOperationHour())
                .append(getReferenceOper()).append(getTransferDescription()).append(getAmountLetter()).append(getAdvanceNumber())
                .append(getBeneficiary()).append(getOrdenant()).append(getBankIntermediary()).append(getFormCurrency())
                .append(getRates()).append(getStateOperation()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null)
                && (obj instanceof turnsClientDetailDto)
                && (this.getOperationDate() != null && ((turnsClientDetailDto)obj).getOperationDate() != null)
                && (this.getOperationNumber() != null && ((turnsClientDetailDto)obj).getOperationNumber() != null)
                && (this.getOperationHour() != null && ((turnsClientDetailDto)obj).getOperationHour() != null)
                && (this.getReferenceOper() != null && ((turnsClientDetailDto)obj).getReferenceOper() != null)
                && (this.getTransferDescription() != null && ((turnsClientDetailDto)obj).getTransferDescription() != null)
                && (this.getAmountLetter() != null && ((turnsClientDetailDto)obj).getAmountLetter() != null)
                && (this.getAdvanceNumber() != null && ((turnsClientDetailDto)obj).getAdvanceNumber() != null)
                && (this.getBeneficiary() != null && ((turnsClientDetailDto)obj).getBeneficiary() != null)
                && (this.getOrdenant() != null && ((turnsClientDetailDto)obj).getOrdenant() != null)
                && (this.getBankIntermediary() != null && ((turnsClientDetailDto)obj).getBankIntermediary() != null)
                && (this.getFormCurrency() != null && ((turnsClientDetailDto)obj).getFormCurrency() != null)
                && (this.getRates() != null && ((turnsClientDetailDto)obj).getRates() != null)
                && (this.getStateOperation() != null && ((turnsClientDetailDto)obj).getStateOperation() != null);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("fecha operacion", getOperationDate()).append("cod operacion", getOperationNumber())
                .append("tasas", getStateOperation()).append("referencia", getReferenceOper())
                .append("hora operacion", getOperationHour()).append("valor letras", getAmountLetter())
                .append("descripcion", getTransferDescription()).append("beneficiario", getBeneficiary())
                .append("avance", getAdvanceNumber()).append("banco intermediario", getBankIntermediary())
                .append("ordenate", getOrdenant()).append("formulario cambiario", getFormCurrency())
                .append("tasas", getRates()).toString();
    }

    // Setters and getters

    /**
     * @return the operationDate
     */
    public Date getOperationDate() {
        return operationDate;
    }

    /**
     * @param operationDate the operationDate to set
     */
    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
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
     * @return the referenceOper
     */
    public String getReferenceOper() {
        return referenceOper;
    }

    /**
     * @param referenceOper the referenceOper to set
     */
    public void setReferenceOper(String referenceOper) {
        this.referenceOper = referenceOper;
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
     * @return the beneficiary
     */
    public ContactDto getBeneficiary() {
        return beneficiary;
    }

    /**
     * @param beneficiary the beneficiary to set
     */
    public void setBeneficiary(ContactDto beneficiary) {
        this.beneficiary = beneficiary;
    }

    /**
     * @return the ordenant
     */
    public ContactDto getOrdenant() {
        return ordenant;
    }

    /**
     * @param ordenant the ordenant to set
     */
    public void setOrdenant(ContactDto ordenant) {
        this.ordenant = ordenant;
    }

    /**
     * @return the bankIntermediary
     */
    public BankDto getBankIntermediary() {
        return bankIntermediary;
    }

    /**
     * @param bankIntermediary the bankIntermediary to set
     */
    public void setBankIntermediary(BankDto bankIntermediary) {
        this.bankIntermediary = bankIntermediary;
    }

    /**
     * @return the formCurrency
     */
    public FormCurrencyDto getFormCurrency() {
        return formCurrency;
    }

    /**
     * @param formCurrency the formCurrency to set
     */
    public void setFormCurrency(FormCurrencyDto formCurrency) {
        this.formCurrency = formCurrency;
    }

    /**
     * @return the rates
     */
    public QuotationMoneyDto getRates() {
        return rates;
    }

    /**
     * @param rates the rates to set
     */
    public void setRates(QuotationMoneyDto rates) {
        this.rates = rates;
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
}
