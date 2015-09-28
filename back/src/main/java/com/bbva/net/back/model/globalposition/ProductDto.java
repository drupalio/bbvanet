package com.bbva.net.back.model.globalposition;

import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.header.PhoneNumbers;

public class ProductDto implements Dto {

    private final static long serialVersionUID = 1L;

    private String productId;

    private String productName;

    private String productNumber;

    private Boolean asset;

    private Boolean operationOnline;

    private Boolean visible;

    private String alias;

    private Money totalCash;

    private Money cashAvailable;

    private Money tradeCash;

    private String subTypeProd;

    private EnumProductType typeProd;

    private String contract;

    private List<PhoneNumbers> phoneNumbers;

    public ProductDto() {
    }

    /**
     * @param productId
     * @param productName
     * @param productNumber
     * @param asset
     * @param operationOnline
     * @param visible
     * @param alias
     * @param totalCash
     * @param cashAvailable
     * @param subTypeProd
     * @param typeProd
     */
    public ProductDto(String productId, String productName, String productNumber, Boolean asset,
            Boolean operationOnline, Boolean visible, String alias, Money totalCash, Money cashAvailable,
            Money tradeCash, String contract, String subTypeProd, EnumProductType typeProd) {
        this.productId = productId;
        this.productName = productName;
        this.productNumber = productNumber;
        this.asset = asset;
        this.operationOnline = operationOnline;
        this.visible = visible;
        this.alias = alias;
        this.totalCash = totalCash;
        this.tradeCash = tradeCash;
        this.cashAvailable = cashAvailable;
        this.subTypeProd = subTypeProd;
        this.contract = contract;
        this.typeProd = typeProd;
    }

    public ProductDto(String productId, String productName, String productNumber, Boolean asset,
            Boolean operationOnline, Boolean visible, String alias, Money totalCash, Money cashAvailable,
            String subTypeProd, EnumProductType typeProd, List<PhoneNumbers> phoneNumbers) {
        this.productId = productId;
        this.productName = productName;
        this.productNumber = productNumber;
        this.asset = asset;
        this.operationOnline = operationOnline;
        this.visible = visible;
        this.alias = alias;
        this.totalCash = totalCash;
        this.cashAvailable = cashAvailable;
        this.subTypeProd = subTypeProd;
        this.typeProd = typeProd;
        this.phoneNumbers = phoneNumbers;
    }

    // Setters and getters

    /**
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return
     */
    public boolean isSetProductId() {
        return (this.productId != null);
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return
     */
    public boolean isSetProductName() {
        return (this.productName != null);
    }

    /**
     * @return the productNumber
     */
    public String getProductNumber() {
        return productNumber;
    }

    /**
     * @param productNumber the productNumber to set
     */
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    /**
     * @return
     */
    public boolean isSetProductNumber() {
        return (this.productNumber != null);
    }

    /**
     * @return the asset
     */
    public Boolean isAsset() {
        return asset;
    }

    /**
     * @param asset the asset to set
     */
    public void setAsset(Boolean asset) {
        this.asset = asset;
    }

    /**
     * @return
     */
    public Boolean isSetAsset() {
        return true;
    }

    /**
     * @return the visible
     */
    public Boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @return
     */
    public boolean isSetAlias() {
        return (this.alias != null);
    }

    /**
     * @return the totalCash
     */
    public Money getTotalCash() {
        return totalCash;
    }

    /**
     * @param totalCash the totalCash to set
     */
    public void setTotalCash(Money totalCash) {
        this.totalCash = totalCash;
    }

    /**
     * @return
     */
    public boolean isSetTotalCash() {
        return (this.totalCash != null);
    }

    /**
     * @return the cashAvailable
     */
    public Money getCashAvailable() {
        return cashAvailable;
    }

    /**
     * @param cashAvailable the cashAvailable to set
     */
    public void setCashAvailable(Money cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    /**
     * @return
     */
    public boolean isSetCashAvailable() {
        return (this.cashAvailable != null);
    }

    /**
     * @return the tradeCash
     */
    public Money getTradeCash() {
        return tradeCash;
    }

    /**
     * @param tradeCash the tradeCash to set
     */
    public void setTradeCash(Money tradeCash) {
        this.tradeCash = tradeCash;
    }

    /**
     * @return the operationOnline
     */
    public Boolean getOperationOnline() {
        return operationOnline;
    }

    /**
     * @param operationOnline the operationOnline to set
     */
    public void setOperationOnline(Boolean operationOnline) {
        this.operationOnline = operationOnline;
    }

    public EnumProductType getTypeProd() {
        return typeProd;
    }

    public void setTypeProd(EnumProductType typeProd) {
        this.typeProd = typeProd;
    }

    /**
     * @return the subTypeProd
     */
    public String getSubTypeProd() {
        return subTypeProd;
    }

    /**
     * @return the contract
     */
    public String getContract() {
        return contract;
    }

    /**
     * @param contract the contract to set
     */
    public void setContract(String contract) {
        this.contract = contract;
    }

    public List<PhoneNumbers> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumbers> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    /**
     * @param subTypeProd the subTypeProd to set
     */
    public void setSubTypeProd(String subTypeProd) {
        this.subTypeProd = subTypeProd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("productId", getProductId())
                .append("productNumber", getProductNumber()).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getProductId()).append(getProductNumber()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        return (obj != null) && (obj instanceof ProductDto)
                && (this.getProductId() != null && ((ProductDto)obj).getProductId() != null)
                && this.getProductId().equals(((ProductDto)obj).getProductId());

    }
}
