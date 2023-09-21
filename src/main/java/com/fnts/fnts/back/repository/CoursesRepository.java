/**
 * 
 */
package com.fnts.fnts.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fnts.fnts.back.model.Courses;
import com.fnts.fnts.back.model.CoursesDTO;

/**
 * @author Emery Estupiñan
 *
 */
public interface CoursesRepository extends JpaRepository<Courses, Long> {

	@Query("SELECT new com.fnts.fnts.back.model.CoursesDTO(c.id, c.name, c.description) FROM Courses c")
	public List<CoursesDTO> findAllCourses();
}
