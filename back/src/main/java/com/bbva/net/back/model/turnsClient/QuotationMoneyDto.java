package com.bbva.net.back.model.turnsClient;

import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author Entelgy
 */
public class QuotationMoneyDto implements Dto {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String money;

    private String amount;

    private String numberAccount;

    private String typeOperation;

    private String divisaTasUSD;

    private String divisaTasPes;

    private String divisaTasPesUSD;

    private String equivalentPeso;
    
    public QuotationMoneyDto() {
    
    }
    
    /**
     * @param money
     * @param moneyList
     * @param amount
     * @param numberAccount
     * @param typeOperation
     * @param divisaTasUSD
     * @param divisaTasPes
     * @param divisaTasPesUSD
     * @param equivalentPeso
     */
    public QuotationMoneyDto(String money, List<String> moneyList, String amount, String numberAccount, String typeOperation, String divisaTasUSD,
            String divisaTasPes, String divisaTasPesUSD, String equivalentPeso) {
        super();
        this.money = money;
        this.amount = amount;
        this.numberAccount = numberAccount;
        this.typeOperation = typeOperation;
        this.divisaTasUSD = divisaTasUSD;
        this.divisaTasPes = divisaTasPes;
        this.divisaTasPesUSD = divisaTasPesUSD;
        this.equivalentPeso = equivalentPeso;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getAmount()).append(getDivisaTasPes()).append(getDivisaTasPesUSD())
                .append(getDivisaTasUSD()).append(getEquivalentPeso()).append(getMoney())
                .append(getNumberAccount()).append(getTypeOperation()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null)
                && (obj instanceof QuotationMoneyDto)
                && (this.getAmount() != null && ((QuotationMoneyDto)obj).getAmount() != null)
                && (this.getDivisaTasPes() != null && ((QuotationMoneyDto)obj).getDivisaTasPes() != null)
                && (this.getDivisaTasPesUSD() != null && ((QuotationMoneyDto)obj).getDivisaTasPesUSD() != null)
                && (this.getDivisaTasUSD() != null && ((QuotationMoneyDto)obj).getDivisaTasUSD() != null)
                && (this.getEquivalentPeso() != null && ((QuotationMoneyDto)obj).getEquivalentPeso() != null)
                && (this.getMoney() != null && ((QuotationMoneyDto)obj).getMoney() != null)
                && (this.getNumberAccount() != null && ((QuotationMoneyDto)obj).getNumberAccount() != null)
                && (this.getTypeOperation() != null && ((QuotationMoneyDto)obj).getTypeOperation() != null);

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("Amount", getAmount()).append("divisaTasaPeso", getDivisaTasPes())
                .append("divisaTasaPesoUSD", getDivisaTasPesUSD()).append("divisaTasaUSD", getDivisaTasUSD())
                .append("equivalenteEnPesos", getEquivalentPeso()).append("monedaSeleccionado", getMoney())
                .append("numeroCuenta", getNumberAccount()).append("tipodeOperacion", getTypeOperation()).toString();
    }

    // Setters and getters

    /**
     * @return the money
     */
    public String getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(String money) {
        this.money = money;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the numberAccount
     */
    public String getNumberAccount() {
        return numberAccount;
    }

    /**
     * @param numberAccount the numberAccount to set
     */
    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    /**
     * @return the typeOperation
     */
    public String getTypeOperation() {
        return typeOperation;
    }

    /**
     * @param typeOperation the typeOperation to set
     */
    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    /**
     * @return the divisaTasUSD
     */
    public String getDivisaTasUSD() {
        return divisaTasUSD;
    }

    /**
     * @param divisaTasUSD the divisaTasUSD to set
     */
    public void setDivisaTasUSD(String divisaTasUSD) {
        this.divisaTasUSD = divisaTasUSD;
    }

    /**
     * @return the divisaTasPes
     */
    public String getDivisaTasPes() {
        return divisaTasPes;
    }

    /**
     * @param divisaTasPes the divisaTasPes to set
     */
    public void setDivisaTasPes(String divisaTasPes) {
        this.divisaTasPes = divisaTasPes;
    }

    /**
     * @return the divisaTasPesUSD
     */
    public String getDivisaTasPesUSD() {
        return divisaTasPesUSD;
    }

    /**
     * @param divisaTasPesUSD the divisaTasPesUSD to set
     */
    public void setDivisaTasPesUSD(String divisaTasPesUSD) {
        this.divisaTasPesUSD = divisaTasPesUSD;
    }

    /**
     * @return the equivalentPeso
     */
    public String getEquivalentPeso() {
        return equivalentPeso;
    }

    /**
     * @param equivalentPeso the equivalentPeso to set
     */
    public void setEquivalentPeso(String equivalentPeso) {
        this.equivalentPeso = equivalentPeso;
    }
}
