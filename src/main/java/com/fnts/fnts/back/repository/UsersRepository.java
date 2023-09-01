/**
 * 
 */
package com.fnts.fnts.back.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fnts.fnts.back.model.UserRol;
import com.fnts.fnts.back.model.Users;

/**
 * @author Emery Estupiñan
 *
 */
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	public Users findByUsername(String username);

}
