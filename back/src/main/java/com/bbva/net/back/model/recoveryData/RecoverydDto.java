package com.bbva.net.back.model.recoveryData;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class RecoverydDto implements Dto {

	private static final long serialVersionUID = 1L;

	private String user;

	private Integer binCard;

	private Integer cardNumber;

	private Integer cardKey;

	private String typeIdentification;

	private Integer identification;

	private Integer newKey;

	private boolean conditions = false;

	public RecoverydDto() {
	}

	/**
	 * @param user
	 * @param binCard
	 * @param cardNumber
	 * @param cardKey
	 * @param typeIdentification
	 * @param identification
	 * @param newKey
	 * @param conditions
	 */

	public RecoverydDto(String user, Integer binCard, Integer cardNumber, Integer cardKey, String typeIdentification,
			Integer identification, Integer newKey, boolean conditions) {
		this.user = user;
		this.binCard = binCard;
		this.cardNumber = cardNumber;
		this.cardKey = cardKey;
		this.typeIdentification = typeIdentification;
		this.identification = identification;
		this.newKey = newKey;
		this.conditions = conditions;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("user", getUser()).append("binCard", getBinCard())
				.append("cardNumber", getCardNumber()).append("cardKey", getCardKey())
				.append("typeIdentification", getTypeIdentification()).append("identification", getIdentification())
				.append("newKey", getNewKey()).append("conditions", isConditions()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getUser()).append(getBinCard()).append(getCardNumber())
				.append(getCardKey()).append(getTypeIdentification()).append(getIdentification()).append(getNewKey())
				.append(isConditions()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj != null) && (obj instanceof RecoverydDto) && this.getUser().equals(((RecoverydDto)obj).getUser())
				&& this.getTypeIdentification().equals(((RecoverydDto)obj).getTypeIdentification())
				&& this.getIdentification() == (((RecoverydDto)obj).getIdentification());
	}

	// Setters and getters

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the binCard
	 */
	public Integer getBinCard() {
		return binCard;
	}

	/**
	 * @param binCard the binCard to set
	 */
	public void setBinCard(Integer binCard) {
		this.binCard = binCard;
	}

	/**
	 * @return the cardNumber
	 */
	public Integer getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the cardKey
	 */
	public Integer getCardKey() {
		return cardKey;
	}

	/**
	 * @param cardKey the cardKey to set
	 */
	public void setCardKey(Integer cardKey) {
		this.cardKey = cardKey;
	}

	/**
	 * @return the typeIdentification
	 */
	public String getTypeIdentification() {
		return typeIdentification;
	}

	/**
	 * @param typeIdentification the typeIdentification to set
	 */
	public void setTypeIdentification(String typeIdentification) {
		this.typeIdentification = typeIdentification;
	}

	/**
	 * @return the identification
	 */
	public Integer getIdentification() {
		return identification;
	}

	/**
	 * @param identification the identification to set
	 */
	public void setIdentification(Integer identification) {
		this.identification = identification;
	}

	/**
	 * @return the newKey
	 */
	public Integer getNewKey() {
		return newKey;
	}

	/**
	 * @param newKey the newKey to set
	 */
	public void setNewKey(Integer newKey) {
		this.newKey = newKey;
	}

	/**
	 * @return the conditions
	 */
	public boolean isConditions() {
		return conditions;
	}

	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(boolean conditions) {
		this.conditions = conditions;
	}
}