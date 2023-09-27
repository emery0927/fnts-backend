/**
 * 
 */
package com.fnts.fnts.back.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Emery Estupiñan
 *
 */

@Getter @Setter @NoArgsConstructor
public class UpdateUserDTO {
	
	private String emailActual;
	
	private String emailNuevo;
	
	private String username;

	/**
	 * @param emailActual
	 * @param emailNuevo
	 * @param username
	 */
	public UpdateUserDTO(String emailActual, String emailNuevo, String username) {
		super();
		this.emailActual = emailActual;
		this.emailNuevo = emailNuevo;
		this.username = username;
	}
	
	

}
