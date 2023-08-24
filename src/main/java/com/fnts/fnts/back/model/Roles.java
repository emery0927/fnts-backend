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
	private Integer role_id;
	
	private String tipo_rol;
	/**
	 * @param tipo_rol
	 */
	public Roles(String tipo_rol) {
		super();
		this.tipo_rol = tipo_rol;
	}
	
	

}
