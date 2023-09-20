/**
 * 
 */
package com.fnts.fnts.back.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnts.fnts.back.model.Activities;
import com.fnts.fnts.back.model.ActivityContent;
import com.fnts.fnts.back.model.Courses;
import com.fnts.fnts.back.model.Users;
import com.fnts.fnts.back.repository.ActivitiesRepository;

/**
 * @author Emery Estupiñan
 *
 */
@Service
public class ActivitiesService {
	
	@Autowired
	private ActivitiesRepository activitiesRepository;
	
	public List<Activities> getAllActivities() {
		return activitiesRepository.findAll();
		}
	
	public void guardarActividad(Activities activity) {
		activitiesRepository.save(activity);
	}
	
	

}
