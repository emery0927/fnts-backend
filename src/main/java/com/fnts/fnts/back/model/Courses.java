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
@Table (name = "courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer course_id;
	private String course_name;
	private boolean course_active;
	private String course_description;
	private boolean course_success;
	
	/**
	 * @param course_name
	 * @param course_active
	 * @param course_description
	 * @param course_success
	 */
	public Courses(String course_name, boolean course_active, String course_description, boolean course_success) {
		super();
		this.course_name = course_name;
		this.course_active = course_active;
		this.course_description = course_description;
		this.course_success = course_success;
	}
	
	
	
	
}
