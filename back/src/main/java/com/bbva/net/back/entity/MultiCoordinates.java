/**
 * 
 */
package com.bbva.net.back.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author User
 */
@Entity(name = "COORDINATES")
public class MultiCoordinates implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6546234100971806967L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "OFFICE")
	private String office;

	@Column(name = "LONGITUDE")
	private String length;

	@Column(name = "LATITUDE")
	private String latitude;

	@Column(name = "CITY")
	private String city;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getOffice() {
		return office;
	}

	/**
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}

	/**
	 * @return
	 */
	public String getLength() {
		return length;
	}

	/**
	 * @param length
	 */
	public void setLength(String length) {
		this.length = length;
	}

	/**
	 * @return
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

}