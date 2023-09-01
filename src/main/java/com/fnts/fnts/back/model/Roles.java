/**
 * 
 */
package com.fnts.fnts.back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Emery Estupiñan
 *
 */
@Entity
@Getter @Setter @NoArgsConstructor
@Table (name = "roles")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rol_id;
	
	private String rol_type;
	/**
	 * @param tipo_rol
	 */
	public Roles(Integer rol_id, String rol_type) {
		super();
		this.rol_id = rol_id;
		this.rol_type = rol_type;
	}
	
	

}
