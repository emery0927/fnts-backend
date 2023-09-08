/**
 * 
 */
package com.fnts.fnts.back.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fnts.fnts.back.model.Courses;
import com.fnts.fnts.back.model.Users;
import com.fnts.fnts.back.service.CoursesService;
import com.fnts.fnts.back.service.UsersService;

/**
 * @author Emery Estupiñan
 *
 */

@RestController
@RequestMapping ("/courses")
@CrossOrigin("*")
public class CoursesRest {

	@Autowired
	private CoursesService coursesService;
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/")
    public List<Courses> getCourses(){
        return coursesService.getAllCourses();
	}
	
	@PostMapping("/actualiza-curso-usuario/"+"{email}")
	public void updateUserCourse(@PathVariable("email") String email) throws Exception {
		Users user = usersService.obtenerUsuarioPorEmail(email);
		coursesService.updateCourseSuccess(user);
	}
    
}
