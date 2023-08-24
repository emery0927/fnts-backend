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
	private Integer activity_id;
	private String activity_name;
	private Integer activity_value_success;
	private boolean activity_active;
	
	@ManyToOne
	@JoinColumn (name = "course_id")
	private Courses course_id;

	/**
	 * @param activity_name
	 * @param activity_value_success
	 * @param activity_active
	 * @param course_id
	 */
	public Activities(String activity_name, Integer activity_value_success, boolean activity_active,
			Courses course_id) {
		super();
		this.activity_name = activity_name;
		this.activity_value_success = activity_value_success;
		this.activity_active = activity_active;
		this.course_id = course_id;
	}
	
	

}
