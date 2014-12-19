package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class ProductDTO implements Dto {

	private final static long serialVersionUID = 1L;

	private String productId;

	private String productName;

	private String productNumber;

	private boolean asset;

	private boolean visible;

	private String alias;

	private Money totalCash;

	private Money cashAvailable;

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

	public boolean isAsset() {
		return asset;
	}

	private boolean visibility;

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public void setAsset(boolean value) {
		this.asset = value;
	}

	public boolean isSetAsset() {
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public EnumProductType getTypeProd() {
		return typeProd;
	}

	public void setTypeProd(EnumProductType typeProd) {
		this.typeProd = typeProd;
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
		return (obj instanceof ProductDTO) && this.getProductId().equals(((ProductDTO)obj).getProductId())
				&& this.getProductNumber().equals(((ProductDTO)obj).getProductNumber());
	}

}
