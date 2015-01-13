package com.bbva.net.back.model.UserData;

import com.bbva.net.back.core.pattern.dto.Dto;

public class ForgotPasswordDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String user;

	private int cardNumber;

	private int cardKey;

	private String identification;

	private String typeIdentification;

	private int newKey;

	private int newConfirrmKey;

	private boolean conditions;

	/**
	 * 
	 */
	public ForgotPasswordDto() {
	}

	/**
	 * @param user
	 * @param cardNumber
	 * @param cardKey
	 * @param identification
	 * @param typeIdentification
	 * @param newKey
	 * @param newConfirrmKey
	 * @param conditions
	 */
	public ForgotPasswordDto(String user, int cardNumber, int cardKey, String identification,
			String typeIdentification, int newKey, int newConfirrmKey, boolean conditions) {
		super();
		this.user = user;
		this.cardNumber = cardNumber;
		this.cardKey = cardKey;
		this.identification = identification;
		this.typeIdentification = typeIdentification;
		this.newKey = newKey;
		this.newConfirrmKey = newConfirrmKey;
		this.conditions = conditions;
	}

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
	 * @return the cardNumber
	 */
	public int getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the cardKey
	 */
	public int getCardKey() {
		return cardKey;
	}

	/**
	 * @param cardKey the cardKey to set
	 */
	public void setCardKey(int cardKey) {
		this.cardKey = cardKey;
	}

	/**
	 * @return the identification
	 */
	public String getIdentification() {
		return identification;
	}

	/**
	 * @param identification the identification to set
	 */
	public void setIdentification(String identification) {
		this.identification = identification;
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
	 * @return the newKey
	 */
	public int getNewKey() {
		return newKey;
	}

	/**
	 * @param newKey the newKey to set
	 */
	public void setNewKey(int newKey) {
		this.newKey = newKey;
	}

	/**
	 * @return the newConfirrmKey
	 */
	public int getNewConfirrmKey() {
		return newConfirrmKey;
	}

	/**
	 * @param newConfirrmKey the newConfirrmKey to set
	 */
	public void setNewConfirrmKey(int newConfirrmKey) {
		this.newConfirrmKey = newConfirrmKey;
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
