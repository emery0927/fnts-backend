/**
 * 
 */
package com.fnts.fnts.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fnts.fnts.back.model.UserCourseActivity;


/**
 * @author Emery Estupiñan
 *
 */
public interface UserCourseActivityRepository extends JpaRepository<UserCourseActivity, Long> {
	

}
