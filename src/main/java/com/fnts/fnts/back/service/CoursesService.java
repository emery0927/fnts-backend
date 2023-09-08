/**
 * 
 */
package com.fnts.fnts.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnts.fnts.back.model.Courses;
import com.fnts.fnts.back.model.UserCourseActivity;
import com.fnts.fnts.back.model.Users;
import com.fnts.fnts.back.repository.CoursesRepository;
import com.fnts.fnts.back.repository.UserCourseActivityRepository;

/**
 * @author Emery Estupiñan
 *
 */
@Service
public class CoursesService {
	
	@Autowired
	private CoursesRepository coursesRepository;
	
	@Autowired
	private UserCourseActivityRepository userCourseActivityRepository;

	
	/*
	 * Encaragdo de realizar la consulta de todos los cursos.
	 */
	public List<Courses> getAllCourses() {
		return coursesRepository.findAll();
	}
	
	/*
	 * Encaragdo de realizar la actualización de la relación del curso con el usuario.
	 */
	public void updateCourseSuccess(Users user) {
		List<UserCourseActivity> userCourse = userCourseActivityRepository.findAll();
		
		for (int i = 0; i < userCourse.size(); i++) {
			if (userCourse.get(i).getUser().getId() == user.getId()) {
				UserCourseActivity userCourseActivity = new UserCourseActivity();
				List<Courses> courses = getAllCourses();
				userCourseActivity.setUser(userCourse.get(i).getUser());
				userCourseActivity.setUser_course_activity_id(userCourse.get(i).getUser_course_activity_id());
				userCourseActivity.setCourse_date_init(userCourse.get(i).getCourse_date_init());
				userCourseActivity.setCourse(courses.get(1));
				userCourseActivityRepository.save(userCourseActivity);
				
			}
		}		

	}

}
