/**
 * 
 */
package com.fnts.fnts.back.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Emery Estupiñan
 *
 */
@Getter @Setter @NoArgsConstructor @ToString
public class Quiz {
	
	private String pregunta;
	private String imagen;
	private String opcion1;
	private String opcion2;
	private String opcion3;
	private String opcion4;
	private Integer respuestaCorrecta;

}
