/**
 * 
 */
package com.bbva.net.back.model.quota;

import java.math.BigDecimal;
import java.util.Date;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

/**
 * @author User
 */
public class QuotaDetailMovDto implements Dto {

	private static final long serialVersionUID = 1L;

	String red;

	String city;

	BigDecimal consignmentNumber;

	String situation;

	Money saleValue;

	Money valueTip;

	Money commission;

	Money chargeReFuente;

	BigDecimal code;

	Date dateConsignment;

	String typeConsignment;

	BigDecimal numberDtos;

	Money ivaValue;

	Money consumptionValue;

	Money chargeIva;

	String charge;

	/**
	 * 
	 */
	public QuotaDetailMovDto() {
	}

	/**
	 * @param red
	 * @param city
	 * @param consignmentNumber
	 * @param situation
	 * @param saleValue
	 * @param valueTip
	 * @param commission
	 * @param chargeReFuente
	 * @param code
	 * @param dateConsignment
	 * @param typeConsignment
	 * @param numberDtos
	 * @param ivaValue
	 * @param consumptionValue
	 * @param chargeIva
	 * @param charge
	 */
	public QuotaDetailMovDto(String red, String city, BigDecimal consignmentNumber, String situation, Money saleValue,
			Money valueTip, Money commission, Money chargeReFuente, BigDecimal code, Date dateConsignment,
			String typeConsignment, BigDecimal numberDtos, Money ivaValue, Money consumptionValue, Money chargeIva,
			String charge) {
		this.red = red;
		this.city = city;
		this.consignmentNumber = consignmentNumber;
		this.situation = situation;
		this.saleValue = saleValue;
		this.valueTip = valueTip;
		this.commission = commission;
		this.chargeReFuente = chargeReFuente;
		this.code = code;
		this.dateConsignment = dateConsignment;
		this.typeConsignment = typeConsignment;
		this.numberDtos = numberDtos;
		this.ivaValue = ivaValue;
		this.consumptionValue = consumptionValue;
		this.chargeIva = chargeIva;
		this.charge = charge;
	}

	
	/**
	 * @return the red
	 */
	public String getRed() {
		return red;
	}

	
	/**
	 * @param red the red to set
	 */
	public void setRed(String red) {
		this.red = red;
	}

	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	
	/**
	 * @return the consignmentNumber
	 */
	public BigDecimal getConsignmentNumber() {
		return consignmentNumber;
	}

	
	/**
	 * @param consignmentNumber the consignmentNumber to set
	 */
	public void setConsignmentNumber(BigDecimal consignmentNumber) {
		this.consignmentNumber = consignmentNumber;
	}

	
	/**
	 * @return the situation
	 */
	public String getSituation() {
		return situation;
	}

	
	/**
	 * @param situation the situation to set
	 */
	public void setSituation(String situation) {
		this.situation = situation;
	}

	
	/**
	 * @return the saleValue
	 */
	public Money getSaleValue() {
		return saleValue;
	}

	
	/**
	 * @param saleValue the saleValue to set
	 */
	public void setSaleValue(Money saleValue) {
		this.saleValue = saleValue;
	}

	
	/**
	 * @return the valueTip
	 */
	public Money getValueTip() {
		return valueTip;
	}

	
	/**
	 * @param valueTip the valueTip to set
	 */
	public void setValueTip(Money valueTip) {
		this.valueTip = valueTip;
	}

	
	/**
	 * @return the commission
	 */
	public Money getCommission() {
		return commission;
	}

	
	/**
	 * @param commission the commission to set
	 */
	public void setCommission(Money commission) {
		this.commission = commission;
	}

	
	/**
	 * @return the chargeReFuente
	 */
	public Money getChargeReFuente() {
		return chargeReFuente;
	}

	
	/**
	 * @param chargeReFuente the chargeReFuente to set
	 */
	public void setChargeReFuente(Money chargeReFuente) {
		this.chargeReFuente = chargeReFuente;
	}

	
	/**
	 * @return the code
	 */
	public BigDecimal getCode() {
		return code;
	}

	
	/**
	 * @param code the code to set
	 */
	public void setCode(BigDecimal code) {
		this.code = code;
	}

	
	/**
	 * @return the dateConsignment
	 */
	public Date getDateConsignment() {
		return dateConsignment;
	}

	
	/**
	 * @param dateConsignment the dateConsignment to set
	 */
	public void setDateConsignment(Date dateConsignment) {
		this.dateConsignment = dateConsignment;
	}

	
	/**
	 * @return the typeConsignment
	 */
	public String getTypeConsignment() {
		return typeConsignment;
	}

	
	/**
	 * @param typeConsignment the typeConsignment to set
	 */
	public void setTypeConsignment(String typeConsignment) {
		this.typeConsignment = typeConsignment;
	}

	
	/**
	 * @return the numberDtos
	 */
	public BigDecimal getNumberDtos() {
		return numberDtos;
	}

	
	/**
	 * @param numberDtos the numberDtos to set
	 */
	public void setNumberDtos(BigDecimal numberDtos) {
		this.numberDtos = numberDtos;
	}

	
	/**
	 * @return the ivaValue
	 */
	public Money getIvaValue() {
		return ivaValue;
	}

	
	/**
	 * @param ivaValue the ivaValue to set
	 */
	public void setIvaValue(Money ivaValue) {
		this.ivaValue = ivaValue;
	}

	
	/**
	 * @return the consumptionValue
	 */
	public Money getConsumptionValue() {
		return consumptionValue;
	}

	
	/**
	 * @param consumptionValue the consumptionValue to set
	 */
	public void setConsumptionValue(Money consumptionValue) {
		this.consumptionValue = consumptionValue;
	}

	
	/**
	 * @return the chargeIva
	 */
	public Money getChargeIva() {
		return chargeIva;
	}

	
	/**
	 * @param chargeIva the chargeIva to set
	 */
	public void setChargeIva(Money chargeIva) {
		this.chargeIva = chargeIva;
	}

	
	/**
	 * @return the charge
	 */
	public String getCharge() {
		return charge;
	}

	
	/**
	 * @param charge the charge to set
	 */
	public void setCharge(String charge) {
		this.charge = charge;
	}
}
