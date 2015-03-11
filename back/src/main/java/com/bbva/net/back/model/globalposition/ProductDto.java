package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

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

	private String subTypeProd;

	private EnumProductType typeProd;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String value) {
		this.productId = value;
	}

	public boolean isSetProductId() {
		return (this.productId != null);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String value) {
		this.productName = value;
	}

	public boolean isSetProductName() {
		return (this.productName != null);
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String value) {
		this.productNumber = value;
	}

	public boolean isSetProductNumber() {
		return (this.productNumber != null);
	}

	public Boolean isAsset() {
		return asset;
	}

	public void setAsset(Boolean value) {
		this.asset = value;
	}

	public Boolean isSetAsset() {
		return true;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String value) {
		this.alias = value;
	}

	public boolean isSetAlias() {
		return (this.alias != null);
	}

	public Money getTotalCash() {
		return totalCash;
	}

	public void setTotalCash(Money value) {
		this.totalCash = value;
	}

	public boolean isSetTotalCash() {
		return (this.totalCash != null);
	}

	public Money getCashAvailable() {
		return cashAvailable;
	}

	public void setCashAvailable(Money value) {
		this.cashAvailable = value;
	}

	public boolean isSetCashAvailable() {
		return (this.cashAvailable != null);
	}

	public Boolean isVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
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
