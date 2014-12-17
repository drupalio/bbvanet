/**
 * 
 */
package com.bbva.net.back.model.globalposition;

import java.util.List;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.movements.MovementDTO;

/**
 * @author Entelgy
 */
public class ProductDTO implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2514624454193123475L;

	private String alias;

	private String productID;

	private String name;
	
	private boolean visibility;

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	private List<MovementDTO> movementList;

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovementDTO> getMovementList() {
		return movementList;
	}

	public void setMovementList(List<MovementDTO> movementList) {
		this.movementList = movementList;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("productID", getProductID()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getProductID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof ProductDTO) && this.getProductID().equals(((ProductDTO)obj).getProductID());
	}

}
