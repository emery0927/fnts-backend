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
public class CoursesDTO {

	private Integer id;
	private String name;
    private String description;

    public CoursesDTO(Integer id, String nombre, String descripcion) {
    	this.id = id;
        this.name = nombre;
        this.description = descripcion;
    }
}
