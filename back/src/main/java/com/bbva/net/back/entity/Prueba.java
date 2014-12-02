package com.bbva.net.back.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="PRUEBA")
public class Prueba implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private Long id;

	@Column(name="NOMBRE")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

}
