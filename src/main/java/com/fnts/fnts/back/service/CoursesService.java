/**
 * 
 */
package com.fnts.fnts.back.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnts.fnts.back.model.Activities;
import com.fnts.fnts.back.model.ActivityContent;
import com.fnts.fnts.back.model.CourseActivity;
import com.fnts.fnts.back.model.Courses;
import com.fnts.fnts.back.model.CoursesDTO;
import com.fnts.fnts.back.model.UserCourseActivity;
import com.fnts.fnts.back.model.UserCourseActivityDTO;
import com.fnts.fnts.back.model.Users;
import com.fnts.fnts.back.repository.ActivitiesRepository;
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
	
	@Autowired
	private ActivitiesRepository activitiesRepository;

	
	/*
	 * Encaragdo de realizar la consulta de todos los cursos.
	 */
	public List<CoursesDTO> getAllCourses() {
		return coursesRepository.findAllCourses();
	}
	
	public List<Courses> getCourses() {
		return coursesRepository.findAll();
	}
	
	public List<UserCourseActivityDTO> getUserCourse() {

		List<UserCourseActivity> userCourse = userCourseActivityRepository.findAll();
		
		List<UserCourseActivityDTO> userDto = new ArrayList<>();

		for (int i = 0; i < userCourse.size(); i++) {
			UserCourseActivityDTO uca = new UserCourseActivityDTO();
			uca.setActivity_id(userCourse.get(i).getActivity().getId());
			uca.setCourse_id(userCourse.get(i).getCourse().getId());
			
			userDto.add(uca);
		}
		return userDto;
	}
	
	/*
	 * Encaragdo de realizar la actualización de la relación del curso con el usuario.
	 */
	public void updateCourseSuccess(Users user) {
		List<UserCourseActivity> userCourse = userCourseActivityRepository.findAll();
		//Fixed
		for (int i = 0; i < userCourse.size(); i++) {
			List<Courses> courses = getCourses();
			if (!(i==courses.size())) {
				Integer f = userCourse.get(i).getCourse().getId();
				if (userCourse.get(i).getUser().getId() == user.getId() && userCourse.get(i).isCourse_success()) {
					List<Activities> activities = activitiesRepository.findByCourseId(courses.get(f).getId());
					UserCourseActivity userCourseActivity = userCourse.get(i);
					
					userCourseActivity.setUser(userCourse.get(i).getUser());
					userCourseActivity.setUser_course_activity_id(userCourse.get(i).getUser_course_activity_id());
					userCourseActivity.setCourse_date_init(userCourse.get(i).getCourse_date_init());
					userCourseActivity.setCourse(courses.get(userCourse.get(i).getCourse().getId()));
					userCourseActivity.setActivity(activities.get(0));
					userCourseActivity.setActivity_success(false);
					userCourseActivity.setCourse_success(false);
					userCourseActivityRepository.save(userCourseActivity);
					break;
				
				}
			}
		}		

	}
	
	/*
	 * Encaragdo de realizar la actualización de la relación del curso con el usuario.
	 */
	public void updateActivitySuccess(Users user) {
		List<UserCourseActivity> userCourse = userCourseActivityRepository.findAll();
		
		for (int i = 0; i < userCourse.size(); i++) {
			if (userCourse.get(i).getUser().getId() == user.getId() && userCourse.get(i).isActivity_success()) {
				UserCourseActivity userCourseActivity = userCourse.get(i);
				List<Activities> activities = activitiesRepository.findByCourseId(userCourse.get(i).getCourse().getId());
				for (int j = 0; j < activities.size(); j++) {
					if (userCourse.get(i).getActivity().getId()==activities.get(j).getId()) {
						if (j==(activities.size()-1)) {
							courseSuccessChangeState(user);
						} else {
							userCourseActivity.setActivity(activities.get(j+1));
							userCourseActivity.setActivity_success(false);
							userCourseActivityRepository.save(userCourseActivity);
							break;
						}
					}
				}
				
			
			}
		}		

	}
	
//	public List<Courses> consultarCursosConActividades() {
//        return coursesRepository.findAllCursosWithActividades();
//    }
//	
	public void saveCourse(Courses course) throws JsonProcessingException, JsonMappingException  {

		List<ActivityContent> listaActividades = new ArrayList<>();

		List<CourseActivity> listaCursosActividades = new ArrayList<>();

		
		
		try {
			coursesRepository.save(course);
			
			ObjectMapper objectMapper = new ObjectMapper();
			listaActividades = objectMapper.readValue(course.getActivity_json(),
					new TypeReference<List<ActivityContent>>() {
					});
			for (int i = 0; i < listaActividades.size(); i++) {
				Activities activity = new Activities();
				if (i==0) {
					activity.setActivity_active(true);
				} else {
					activity.setActivity_active(false);
				}
				activity.setCourse(course);
				activity.setName(listaActividades.get(i).getNombreActividad());
				
				activitiesRepository.save(activity);
				
			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public ArrayList<CourseActivity> obtenerContenidoActividad() throws JsonProcessingException {

		try {
			List<Courses> course = coursesRepository.findAll();
			ArrayList<ActivityContent> listaActividades = new ArrayList<>();
			
			ArrayList<CourseActivity> listaCursosActividades = new ArrayList<>();
			
			for (int i = 0; i < course.size(); i++) {
				ObjectMapper objectMapper = new ObjectMapper();
				listaActividades = objectMapper.readValue(course.get(i).getActivity_json(), new TypeReference<ArrayList<ActivityContent>>() {});
				
				CourseActivity cA = new CourseActivity();
				cA.setActivities(listaActividades);
				listaCursosActividades.add(cA);
			}

			return listaCursosActividades;
		} catch (JsonMappingException e) {
			throw e;
		} catch (JsonProcessingException es) {
			throw es;
		}

	}
	
	public void activitySuccessChangeState(Users user) {
		List<UserCourseActivity> userCourse = userCourseActivityRepository.findAll();
		
		for (int i = 0; i < userCourse.size(); i++) {
			if (userCourse.get(i).getUser().getId() == user.getId()) {
				UserCourseActivity userCourseActivity = userCourse.get(i);
				userCourseActivity.setActivity_success(true);
				userCourseActivityRepository.save(userCourseActivity);
			
			}
		}
	}
	
	public void courseSuccessChangeState(Users user) {
		List<UserCourseActivity> userCourse = userCourseActivityRepository.findAll();
		
		for (int i = 0; i < userCourse.size(); i++) {
			if (userCourse.get(i).getUser().getId() == user.getId()) {
				UserCourseActivity userCourseActivity = userCourse.get(i);
				userCourseActivity.setCourse_success(true);
				userCourseActivityRepository.save(userCourseActivity);
			
			}
		}
		
	}

}
