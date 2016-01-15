package com.bbva.net.back.model.turnsClient;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

/**
 * @author Entelgy
 */
public class QuotationMoneyDto implements Dto {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private DivisaDto money;

    private Money amount;

    private String numberAccount;

    private String typeBussiness;

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
    public QuotationMoneyDto(DivisaDto money, Money amount, String numberAccount, String typeBussiness, String divisaTasUSD,
            String divisaTasPes, String divisaTasPesUSD, String equivalentPeso) {
        this.money = money;
        this.amount = amount;
        this.numberAccount = numberAccount;
        this.typeBussiness = typeBussiness;
        this.divisaTasUSD = divisaTasUSD;
        this.divisaTasPes = divisaTasPes;
        this.divisaTasPesUSD = divisaTasPesUSD;
        this.equivalentPeso = equivalentPeso;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getAmount()).append(getDivisaTasPes()).append(getDivisaTasPesUSD())
                .append(getDivisaTasUSD()).append(getEquivalentPeso()).append(getMoney())
                .append(getNumberAccount()).append(getTypeBussiness()).toHashCode();
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
                && (this.getTypeBussiness() != null && ((QuotationMoneyDto)obj).getTypeBussiness() != null);

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("Amount", getAmount()).append("divisaTasaPeso", getDivisaTasPes())
                .append("divisaTasaPesoUSD", getDivisaTasPesUSD()).append("divisaTasaUSD", getDivisaTasUSD())
                .append("equivalenteEnPesos", getEquivalentPeso()).append("monedaSeleccionado", getMoney())
                .append("numeroCuenta", getNumberAccount()).append("tipodeOperacion", getTypeBussiness()).toString();
    }

    // Setters and getters

    /**
     * @return the money
     */
    public DivisaDto getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(DivisaDto money) {
        this.money = money;
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
}
