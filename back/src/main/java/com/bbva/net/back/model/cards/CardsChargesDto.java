package com.bbva.net.back.model.cards;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class CardsChargesDto implements Dto {



	/**
	 * 
	 */
	private static final long serialVersionUID = 4343825249261438191L;

	private String categorie;

	private Money ammount;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Money getAmmount() {
		return ammount;
	}

	public void setAmmount(Money ammount) {
		this.ammount = ammount;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof CardsChargesDto) && this.getCategorie().equals(((CardsChargesDto)obj).getCategorie())
				&& this.getAmmount().equals(
						((CardsChargesDto) obj).getAmmount());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getCategorie()).append(getAmmount()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("categorie", getCategorie()).append("ammount", getAmmount()).toString();
	}

}
