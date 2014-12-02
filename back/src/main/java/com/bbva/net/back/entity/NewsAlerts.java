/**
 * 
 */
package com.bbva.net.back.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author User
 *
 */
@Entity(name="newsAndAlerts")
public class NewsAlerts implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private Long id;

	
}
