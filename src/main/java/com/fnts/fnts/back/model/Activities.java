/**
 * 
 */
package com.fnts.fnts.back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table (name = "activities")
public class Activities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer activity_value_success;
	private boolean activity_active;
	
	@ManyToOne
	@JoinColumn (name = "course_id")
	private Courses course_id;

	/**
	 * @param id
	 * @param name
	 * @param activityValueSuccess
	 * @param activityActive
	 */
	public Activities(Integer id, String name, Integer activity_value_success, boolean activity_active) {
		super();
		this.id = id;
		this.name = name;
		this.activity_value_success = activity_value_success;
		this.activity_active = activity_active;
	}

	
	
	

}
