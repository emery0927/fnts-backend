/**
 * 
 */
package com.fnts.fnts.back.model;

import java.util.Date;

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
@Table (name = "user_course_activity")
public class UserCourseActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_course_activity_id;
	
	@ManyToOne
	@JoinColumn (name = "user_id")
	private Users user_id;
	
	@ManyToOne
	@JoinColumn (name = "course_id")
	private Courses course_id;
	
	private Date course_date_init;

	/**
	 * @param user_id
	 * @param course_id
	 * @param course_date_init
	 */
	public UserCourseActivity(Users user_id, Courses course_id, Date course_date_init) {
		super();
		this.user_id = user_id;
		this.course_id = course_id;
		this.course_date_init = course_date_init;
	}
	
	

}
