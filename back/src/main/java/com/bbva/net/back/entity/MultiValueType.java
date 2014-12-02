/**
 * 
 */
package com.bbva.net.back.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author User
 *
 */
@Entity(name = "MULTVALUETYPE")
public class MultiValueType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "TYPE")
	private String type;

	@OneToMany(mappedBy = "multiValueType")
	private List<MultiValueGroup> multiValueGroup;

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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the multiValueGroup
	 */
	public List<MultiValueGroup> getMultiValueGroup() {
		return multiValueGroup;
	}

	/**
	 * @param multiValueGroup the multiValueGroup to set
	 */
	public void setMultiValueGroup(List<MultiValueGroup> multiValueGroup) {
		this.multiValueGroup = multiValueGroup;
	}	
}