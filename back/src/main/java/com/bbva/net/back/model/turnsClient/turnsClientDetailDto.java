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

    private Date operationDate;

    private String operationNumber;

    private BasicPersonDto ordered;

    private Date operationHour;

    private String referenceOper;

    private String transferDescription;

    private BasicPersonDto beneficiary;

    private BasicBankDto baneficiaryBank;

    private BasicBankDto intermediaryBank;

    private String moneyType;

    private String typeBussiness;

    private String accountNumberDebit;

    private Money divisaValuation;

    private Money divisaValuationPeso;

    private String formChangeNum;

    private String amountLetter;

    private Money amount;

    private String advanceNumber;

    private Money divisaValuUSDPeso;

    private Money equivalentValue;

    private String numberCambiario;

    /**
     *
     */
    public turnsClientDetailDto() {
    }

    /**
     * @param operationDate
     * @param operationNumber
     * @param ordered
     * @param operationHour
     * @param referenceOper
     * @param transferDescription
     * @param beneficiary
     * @param baneficiaryBank
     * @param intermediaryBank
     * @param moneyType
     * @param typeBussiness
     * @param accountNumberDebit
     * @param divisaValuation
     * @param divisaValuationPeso
     * @param formChangeNum
     * @param amountLetter
     * @param amount
     * @param advanceNumber
     * @param divisaValuUSDPeso
     * @param equivalentValue
     * @param numberCambiario
     */
    public turnsClientDetailDto(Date operationDate, String operationNumber, BasicPersonDto ordered, Date operationHour, String referenceOper,
            String transferDescription, BasicPersonDto beneficiary, BasicBankDto baneficiaryBank, BasicBankDto intermediaryBank, String moneyType,
            String typeBussiness, String accountNumberDebit, Money divisaValuation, Money divisaValuationPeso, String formChangeNum,
            String amountLetter, Money amount, String advanceNumber, Money divisaValuUSDPeso, Money equivalentValue, String numberCambiario) {
        this.operationDate = operationDate;
        this.operationNumber = operationNumber;
        this.ordered = ordered;
        this.operationHour = operationHour;
        this.referenceOper = referenceOper;
        this.transferDescription = transferDescription;
        this.beneficiary = beneficiary;
        this.baneficiaryBank = baneficiaryBank;
        this.intermediaryBank = intermediaryBank;
        this.moneyType = moneyType;
        this.typeBussiness = typeBussiness;
        this.accountNumberDebit = accountNumberDebit;
        this.divisaValuation = divisaValuation;
        this.divisaValuationPeso = divisaValuationPeso;
        this.formChangeNum = formChangeNum;
        this.amountLetter = amountLetter;
        this.amount = amount;
        this.advanceNumber = advanceNumber;
        this.divisaValuUSDPeso = divisaValuUSDPeso;
        this.equivalentValue = equivalentValue;
        this.numberCambiario = numberCambiario;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getAdvanceNumber()).append(getAmountLetter()).append(getDivisaValuation())
                .append(getEquivalentValue()).append(getFormChangeNum()).append(getMoneyType()).append(getReferenceOper())
                .append(getOperationHour()).append(getOperationNumber()).append(getOrdered()).append(getTypeBussiness())
                .append(getTransferDescription()).append(getBaneficiaryBank()).append(getAmount()).append(getAccountNumberDebit())
                .append(getBeneficiary()).append(getDivisaValuationPeso()).append(getDivisaValuUSDPeso())
                .append(getIntermediaryBank()).append(getNumberCambiario()).append(getOperationDate()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null)
                && (obj instanceof turnsClientDetailDto)
                && (this.getAdvanceNumber() != null && ((turnsClientDetailDto)obj).getAdvanceNumber() != null)
                && (this.getAmountLetter() != null && ((turnsClientDetailDto)obj).getAmountLetter() != null)
                && (this.getDivisaValuation() != null && ((turnsClientDetailDto)obj).getDivisaValuation() != null)
                && (this.getEquivalentValue() != null && ((turnsClientDetailDto)obj).getEquivalentValue() != null)
                && (this.getFormChangeNum() != null && ((turnsClientDetailDto)obj).getFormChangeNum() != null)
                && (this.getMoneyType() != null && ((turnsClientDetailDto)obj).getMoneyType() != null)
                && (this.getOperationHour() != null && ((turnsClientDetailDto)obj).getOperationHour() != null)
                && (this.getOperationNumber() != null && ((turnsClientDetailDto)obj).getOperationNumber() != null)
                && (this.getOrdered() != null && ((turnsClientDetailDto)obj).getOrdered() != null)
                && (this.getTransferDescription() != null && ((turnsClientDetailDto)obj).getTransferDescription() != null)
                && (this.getAccountNumberDebit() != null && ((turnsClientDetailDto)obj).getAccountNumberDebit() != null)
                && (this.getAmount() != null && ((turnsClientDetailDto)obj).getAmount() != null)
                && (this.getBaneficiaryBank() != null && ((turnsClientDetailDto)obj).getBaneficiaryBank() != null)
                && (this.getBeneficiary() != null && ((turnsClientDetailDto)obj).getBeneficiary() != null)
                && (this.getTypeBussiness() != null && ((turnsClientDetailDto)obj).getTypeBussiness() != null)
                && (this.getOperationDate() != null && ((turnsClientDetailDto)obj).getOperationDate() != null)
                && (this.getIntermediaryBank() != null && ((turnsClientDetailDto)obj).getIntermediaryBank() != null)
                && (this.getNumberCambiario() != null && ((turnsClientDetailDto)obj).getNumberCambiario() != null)
                && (this.getDivisaValuUSDPeso() != null && ((turnsClientDetailDto)obj).getDivisaValuUSDPeso() != null)
                && (this.getDivisaValuationPeso() != null && ((turnsClientDetailDto)obj).getDivisaValuationPeso() != null)
                && (this.getReferenceOper() != null && ((turnsClientDetailDto)obj).getReferenceOper() != null);

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("advance", getAdvanceNumber()).append("amouts", getAmountLetter())
                .append("divisaTasa", getDivisaValuation()).append("equvalentValue", getEquivalentValue())
                .append("formulario cambiario", getFormChangeNum()).append("moneda", getMoneyType())
                .append("hora", getOperationHour()).append("number", getOperationNumber())
                .append("ordenate", getOrdered()).append("description", getTransferDescription())
                .append("account debit", getAccountNumberDebit()).append("amount", getAmount())
                .append("banco beneficiario", getBaneficiaryBank()).append("beneficiario", getBeneficiary())
                .append("tipo negocio", getTypeBussiness()).append("banco intermediario", getIntermediaryBank())
                .append("fecha operacion", getOperationDate()).append("referencia", getReferenceOper())
                .append("divisa Peso", getDivisaValuationPeso()).append("divisa Peso", getDivisaValuUSDPeso())
                .append("numero cambiario", getNumberCambiario()).toString();
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
     * @return the ordered
     */
    public BasicPersonDto getOrdered() {
        return ordered;
    }

    /**
     * @param ordered the ordered to set
     */
    public void setOrdered(BasicPersonDto ordered) {
        this.ordered = ordered;
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
     * @return the beneficiary
     */
    public BasicPersonDto getBeneficiary() {
        return beneficiary;
    }

    /**
     * @param beneficiary the beneficiary to set
     */
    public void setBeneficiary(BasicPersonDto beneficiary) {
        this.beneficiary = beneficiary;
    }

    /**
     * @return the baneficiaryBank
     */
    public BasicBankDto getBaneficiaryBank() {
        return baneficiaryBank;
    }

    /**
     * @param baneficiaryBank the baneficiaryBank to set
     */
    public void setBaneficiaryBank(BasicBankDto baneficiaryBank) {
        this.baneficiaryBank = baneficiaryBank;
    }

    /**
     * @return the intermediaryBank
     */
    public BasicBankDto getIntermediaryBank() {
        return intermediaryBank;
    }

    /**
     * @param intermediaryBank the intermediaryBank to set
     */
    public void setIntermediaryBank(BasicBankDto intermediaryBank) {
        this.intermediaryBank = intermediaryBank;
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
     * @return the typeBussiness
     */
    public String getTypeBussiness() {
        return typeBussiness;
    }

    /**
     * @param typeBussiness the typeBussiness to set
     */
    public void setTypeBussiness(String typeBussiness) {
        this.typeBussiness = typeBussiness;
    }

    /**
     * @return the accountNumberDebit
     */
    public String getAccountNumberDebit() {
        return accountNumberDebit;
    }

    /**
     * @param accountNumberDebit the accountNumberDebit to set
     */
    public void setAccountNumberDebit(String accountNumberDebit) {
        this.accountNumberDebit = accountNumberDebit;
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
     * @return the divisaValuationPeso
     */
    public Money getDivisaValuationPeso() {
        return divisaValuationPeso;
    }

    /**
     * @param divisaValuationPeso the divisaValuationPeso to set
     */
    public void setDivisaValuationPeso(Money divisaValuationPeso) {
        this.divisaValuationPeso = divisaValuationPeso;
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
     * @return the divisaValuUSDPeso
     */
    public Money getDivisaValuUSDPeso() {
        return divisaValuUSDPeso;
    }

    /**
     * @param divisaValuUSDPeso the divisaValuUSDPeso to set
     */
    public void setDivisaValuUSDPeso(Money divisaValuUSDPeso) {
        this.divisaValuUSDPeso = divisaValuUSDPeso;
    }

    /**
     * @return the equivalentValue
     */
    public Money getEquivalentValue() {
        return equivalentValue;
    }

    /**
     * @param equivalentValue the equivalentValue to set
     */
    public void setEquivalentValue(Money equivalentValue) {
        this.equivalentValue = equivalentValue;
    }

    /**
     * @return the numberCambiario
     */
    public String getNumberCambiario() {
        return numberCambiario;
    }

    /**
     * @param numberCambiario the numberCambiario to set
     */
    public void setNumberCambiario(String numberCambiario) {
        this.numberCambiario = numberCambiario;
    }
}
