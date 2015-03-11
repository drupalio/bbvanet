package com.bbva.eiaq.commons.v01;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para ccc complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ccc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="branchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="controlDigit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ccc", propOrder = { "bankCode", "branchCode", "controlDigit", "accountNumber" })
public class Ccc implements Serializable {

	private static final long serialVersionUID = -6720592556689569623L;

	protected String bankCode;

	protected String branchCode;

	protected String controlDigit;

	protected String accountNumber;

	/**
	 * Obtiene el valor de la propiedad bankCode.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * Define el valor de la propiedad bankCode.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setBankCode(String value) {
		this.bankCode = value;
	}

	/**
	 * Obtiene el valor de la propiedad branchCode.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * Define el valor de la propiedad branchCode.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setBranchCode(String value) {
		this.branchCode = value;
	}

	/**
	 * Obtiene el valor de la propiedad controlDigit.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getControlDigit() {
		return controlDigit;
	}

	/**
	 * Define el valor de la propiedad controlDigit.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setControlDigit(String value) {
		this.controlDigit = value;
	}

	/**
	 * Obtiene el valor de la propiedad accountNumber.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Define el valor de la propiedad accountNumber.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAccountNumber(String value) {
		this.accountNumber = value;
	}

}
