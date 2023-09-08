/**
 * 
 */
package com.fnts.fnts.back.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fnts.fnts.back.model.Users;

/**
 * @author Emery Estupiñan
 *
 */
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	public Users findByUsername(String username);
	
	public Users findByEmail(String email);

}
