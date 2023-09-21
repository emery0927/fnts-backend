/**
 * 
 */
package com.fnts.fnts.back.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fnts.fnts.back.model.ActivityContent;
import com.fnts.fnts.back.model.CourseActivity;
import com.fnts.fnts.back.model.Courses;
import com.fnts.fnts.back.model.CoursesDTO;
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
	
	@GetMapping("/get/")
    public List<CoursesDTO> getCourses(){
        return coursesService.getAllCourses();
	}
	
	@PutMapping("/actualiza-curso-usuario/"+"{email}")
	public void updateUserCourse(@PathVariable("email") String email) throws Exception {
		Users user = usersService.obtenerUsuarioPorEmail(email);
		coursesService.updateCourseSuccess(user);
	}
	
	@PostMapping("/save")
	public void saveCourse(@RequestBody Courses course) throws JsonMappingException, JsonProcessingException {
		coursesService.saveCourse(course);
	}
	
//	@GetMapping("/actividades")
//    public List<Courses> consultarCursosConActividades() {
//        return coursesService.consultarCursosConActividades();
//    }
	
	@GetMapping("/")
    public ArrayList<CourseActivity> getActivityContent() throws JsonProcessingException {
        return coursesService.obtenerContenidoActividad();
	}
    
	@PutMapping("/actualizar-estado-actividad/"+"{email}")
    public void actualizarEstadoActividad(@PathVariable("email") String email) {
    	Users user = usersService.obtenerUsuarioPorEmail(email);
    	coursesService.activitySuccessChangeState(user);
    }
	
	@PutMapping("/actualizar-estado-curso/"+"{email}")
    public void actualizarEstadoCurso(@PathVariable("email") String email) {
    	Users user = usersService.obtenerUsuarioPorEmail(email);
    	coursesService.courseSuccessChangeState(user);
    }
	
	@PutMapping("/actualizar-actividad/"+"{email}")
    public void actualizarActividad(@PathVariable("email") String email) {
    	Users user = usersService.obtenerUsuarioPorEmail(email);
    	coursesService.updateActivitySuccess(user);
    }
	
	@PutMapping("/actualizar-curso/"+"{email}")
    public void actualizarCurso(@PathVariable("email") String email) {
    	Users user = usersService.obtenerUsuarioPorEmail(email);
    	coursesService.updateCourseSuccess(user);
    }
}
