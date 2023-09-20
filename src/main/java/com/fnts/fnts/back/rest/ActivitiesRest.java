/**
 * 
 */
package com.fnts.fnts.back.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fnts.fnts.back.model.Activities;
import com.fnts.fnts.back.model.ActivityContent;
import com.fnts.fnts.back.service.ActivitiesService;

/**
 * @author Emery Estupiñan
 *
 */
@RestController
@RequestMapping ("/activities")
@CrossOrigin("*")
public class ActivitiesRest {
	
	@Autowired
	private ActivitiesService activitiesService;
	
	@PostMapping("/save")
	public void saveActivity(@RequestBody Activities activity) {
		activitiesService.guardarActividad(activity);
	}

}
