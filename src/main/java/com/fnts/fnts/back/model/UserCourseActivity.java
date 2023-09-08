/**
 * 
 */
package com.fnts.fnts.back.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table (name = "user_course_activity")
public class UserCourseActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_course_activity_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Users user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Courses course;
	
	private Date course_date_init;

	/**
	 * @param user_id
	 * @param course_id
	 * @param course_date_init
	 */
	public UserCourseActivity(Users user_id, Courses course_id, Date course_date_init) {
		super();
		this.user = user_id;
		this.course = course_id;
		this.course_date_init = course_date_init;
	}
	
	

}
