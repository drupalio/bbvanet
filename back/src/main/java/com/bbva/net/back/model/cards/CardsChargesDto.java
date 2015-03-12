package com.bbva.net.back.model.cards;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

/**
 * @author Entelgy
 */
public class CardsChargesDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4343825249261438191L;

	/**
	 * 
	 */
	private String categorie;

	/**
	 * 
	 */
	private Money ammount;

	/**
	 * 
	 */
	public CardsChargesDto() {
	}

	/**
	 * @param categorie
	 * @param ammount
	 */
	public CardsChargesDto(final String categorie, final Money ammount) {
		this.categorie = categorie;
		this.ammount = ammount;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getCategorie()).append(getAmmount()).toHashCode();
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(final Object obj) {
		return (obj != null) && (obj instanceof CardsChargesDto)
				&& this.getCategorie().equals(((CardsChargesDto)obj).getCategorie())
				&& this.getAmmount().equals(((CardsChargesDto)obj).getAmmount());
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("categoria", getCategorie()).append("ammount", getAmmount()).toString();
	}

	// Setters and getters

	/**
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(final String categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the ammount
	 */
	public Money getAmmount() {
		return ammount;
	}

	/**
	 * @param ammount the ammount to set
	 */
	public void setAmmount(final Money ammount) {
		this.ammount = ammount;
	}

}
