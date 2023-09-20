/**
 * 
 */
package com.fnts.fnts.back.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table (name = "courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private boolean active;
	private String description;
	private String activity_json;
	
	@OneToMany(mappedBy = "course")
    private List<Activities> activities;
	
	/**
	 * @param id
	 * @param name
	 * @param active
	 * @param description
	 * @param success
	 */
	public Courses(Integer id, String name, boolean active, String description, String activity_json) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
		this.description = description;
		this.activity_json = activity_json;
	}
	
	
	
	
	
	
}
