package com.fnts.fnts.back.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserCourseActivityDTO {
	
	Long  activity_id;
	Integer course_id;
	Boolean course_state;
	
	public UserCourseActivityDTO(Long activity_id, Integer course_id, Boolean course_state) {
		this.activity_id = activity_id;
		this.course_id =  course_id;
		this.course_state = course_state;
	}

}
