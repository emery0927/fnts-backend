/**
 * 
 */
package com.fnts.fnts.back.rest;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fnts.fnts.back.model.Activities;
import com.fnts.fnts.back.model.Courses;
import com.fnts.fnts.back.model.Roles;
import com.fnts.fnts.back.model.UpdateUserDTO;
import com.fnts.fnts.back.model.UserCourseActivity;
import com.fnts.fnts.back.model.UserRol;
import com.fnts.fnts.back.model.Users;
import com.fnts.fnts.back.service.ActivitiesService;
import com.fnts.fnts.back.service.CoursesService;
import com.fnts.fnts.back.service.UsersService;

/**
 * @author Emery Estupiñan
 *
 */
@RestController
@RequestMapping ("/users")
@CrossOrigin("*")
public class UsersRest {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private CoursesService courseService;
	
	@Autowired
	private ActivitiesService activitiesService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	@PostMapping("/")
    public Users saveUser(@RequestBody Users user) throws Exception{
        Set<UserRol> usuarioRoles = new HashSet<>();
        Set<UserCourseActivity> usuarioCurso = new HashSet<>();
        
        List<Courses> courses = courseService.getCourses();
        List<Activities> activities = activitiesService.getAllActivities();
        
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        UserCourseActivity userCourseActivity = new UserCourseActivity();
        userCourseActivity.setCourse(courses.get(0));
        userCourseActivity.setActivity(activities.get(0));
        userCourseActivity.setUser(user);
        userCourseActivity.setCourse_success(false);
        userCourseActivity.setActivity_success(false);
        userCourseActivity.setCourse_date_init(new Date());
        
        usuarioCurso.add(userCourseActivity);
        
        Roles rol = new Roles();
        rol.setRol_id(1);
        rol.setRol_type("NORMAL");

        UserRol usuarioRol = new UserRol();
        usuarioRol.setUser(user);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        return usersService.saveUser(user,usuarioRoles, usuarioCurso);
    }


    @GetMapping("/{username}")
    public Users getUser(@PathVariable("username") String username){
        return usersService.obtenerUsuario(username);
    }
    
    @PutMapping("/modificar-datos")
    public void modificarDatos(@RequestBody UpdateUserDTO user) {
    	Users userd = usersService.obtenerUsuarioPorEmail(user.getEmailActual());
    	usersService.actualizarDatosUsuario(userd, user);
    }
    
    @PutMapping("/modificar-password")
    public void modificarPassword(@RequestBody Users user) {
    	Users userd = usersService.obtenerUsuarioPorEmail(user.getEmail());
    	usersService.actualizarPasswordUsuario(userd, user);
    }

    @DeleteMapping("/{id}")
    public void deleterUser(@PathVariable("id") Long id){
        usersService.eliminarUsuario(id);
    }
    
    @PutMapping("/sumar-puntos/"+"{email}")
    public void sumarPuntos(@PathVariable("email") String email) {
    	Users user = usersService.obtenerUsuarioPorEmail(email);
    	usersService.sumarPuntos(user);
    }
    
    @PutMapping("/aumentar-level/"+"{email}")
    public void aumentarLevel(@PathVariable("email") String email) {
    	Users user = usersService.obtenerUsuarioPorEmail(email);
    	usersService.aumentarLevel(user);
    }

}
