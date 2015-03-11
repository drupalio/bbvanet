package com.bbva.net.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Foo")
public class Foo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long quantity;

	private Integer value;

	private String description;

	public Foo() {
	}

	public Foo(Long quantity, Integer value, String description) {
		super();
		this.quantity = quantity;
		this.value = value;
		this.description = description;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}