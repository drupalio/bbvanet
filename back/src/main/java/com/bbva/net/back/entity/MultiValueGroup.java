/**
 * 
 */
package com.bbva.net.back.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author User
 *
 */
@Entity(name="MULTVALUEGROUP")
public class MultiValueGroup implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;

	@Column(name="VALUE")
	private String value;
		
	@ManyToOne
    @JoinColumn(name="ID", insertable=false, updatable=false )
    private MultiValueType multiValueType;

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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the multiValueType
	 */
	public MultiValueType getMultiValueType() {
		return multiValueType;
	}

	/**
	 * @param multiValueType the multiValueType to set
	 */
	public void setMultiValueType(MultiValueType multiValueType) {
		this.multiValueType = multiValueType;
	}
}