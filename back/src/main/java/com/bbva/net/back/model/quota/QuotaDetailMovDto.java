/**
 * 
 */
package com.bbva.net.back.model.quota;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.movements.PersonalizeAccountDTO;

/**
 * @author User
 */
public class QuotaDetailMovDto implements Dto {

	private static final long serialVersionUID = 1L;

	private String red;

	private String city;

	private BigDecimal consignmentNumber;

	private String situation;

	private Money saleValue;

	private Money valueTip;

	private Money commission;

	private Money chargeReFuente;

	private BigDecimal code;

	private Date dateConsignment;

	private String typeConsignment;

	private BigDecimal numberDtos;

	private Money ivaValue;

	private Money consumptionValue;

	private Money chargeIva;

	private String charge;

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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("red", getRed()).append("city", getCity())
				.append("consignmentNumber", getConsignmentNumber()).append("situation", getSituation())
				.append("saleValue", getSaleValue()).append("valueTip", getValueTip())
				.append("commission", getCommission()).append("chargeReFuente", getChargeReFuente())
				.append("code", getCode()).append("dateConsignment", getDateConsignment())
				.append("typeConsignment", getTypeConsignment()).append("numberDtos", getNumberDtos())
				.append("ivaValue", getIvaValue()).append("consumptionValue", getConsumptionValue())
				.append("chargeIva", getChargeIva()).append("charge", getCharge()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getRed()).append(getCity()).append(getConsignmentNumber())
				.append(getSituation()).append(getSaleValue()).append(getValueTip()).append(getCommission())
				.append(getChargeReFuente()).append(getCode()).append(getDateConsignment())
				.append(getTypeConsignment()).append(getNumberDtos()).append(getIvaValue())
				.append(getConsumptionValue()).append(getChargeIva()).append(getCharge()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof QuotaDetailMovDto)
				&& this.getChargeReFuente().equals(((QuotaDetailMovDto)obj).getChargeReFuente())
				&& this.getCity().equals(((QuotaDetailMovDto)obj).getCity())
				&& this.getRed().equals(((QuotaDetailMovDto)obj).getRed())
				&& this.getConsignmentNumber().equals(((QuotaDetailMovDto)obj).getConsignmentNumber())
				&& this.getSituation().equals(((QuotaDetailMovDto)obj).getSituation())
				&& this.getSaleValue().equals(((QuotaDetailMovDto)obj).getSaleValue())
				&& this.getValueTip().equals(((QuotaDetailMovDto)obj).getValueTip())
				&& this.getCommission().equals(((QuotaDetailMovDto)obj).getCommission())
				&& this.getCode().equals(((QuotaDetailMovDto)obj).getCode())
				&& this.getDateConsignment().equals(((QuotaDetailMovDto)obj).getDateConsignment())
				&& this.getTypeConsignment().equals(((QuotaDetailMovDto)obj).getTypeConsignment())
				&& this.getNumberDtos().equals(((QuotaDetailMovDto)obj).getNumberDtos())
				&& this.getIvaValue().equals(((QuotaDetailMovDto)obj).getIvaValue())
				&& this.getConsumptionValue().equals(((QuotaDetailMovDto)obj).getConsumptionValue())
				&& this.getChargeIva().equals(((QuotaDetailMovDto)obj).getChargeIva())
				&& this.getCharge().equals(((QuotaDetailMovDto)obj).getCharge());

	}
}
