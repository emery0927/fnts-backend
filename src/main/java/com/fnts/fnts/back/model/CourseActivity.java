/**
 * 
 */
package com.fnts.fnts.back.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Emery Estupiñan
 *
 */
@Getter @Setter @NoArgsConstructor @ToString
public class CourseActivity {
	
	private ArrayList<ActivityContent> activities;

}
