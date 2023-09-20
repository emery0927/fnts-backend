/**
 * 
 */
package com.fnts.fnts.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fnts.fnts.back.model.Activities;

/**
 * @author Emery Estupiñan
 *
 */
public interface ActivitiesRepository extends JpaRepository<Activities, Long> {
	
	public List<Activities> findByCourseId(Integer curso_id);

}
