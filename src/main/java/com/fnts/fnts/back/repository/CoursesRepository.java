/**
 * 
 */
package com.fnts.fnts.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fnts.fnts.back.model.Courses;

/**
 * @author Emery Estupiñan
 *
 */
public interface CoursesRepository extends JpaRepository<Courses, Long> {

}
