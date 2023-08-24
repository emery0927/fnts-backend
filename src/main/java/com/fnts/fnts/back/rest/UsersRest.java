/**
 * 
 */
package com.fnts.fnts.back.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fnts.fnts.back.model.Users;
import com.fnts.fnts.back.service.UsersService;

/**
 * @author Emery Estupiñan
 *
 */
@RestController
@RequestMapping ("/users/")
public class UsersRest {
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping
	private ResponseEntity<List<Users>> getUser() {
		return ResponseEntity.ok(usersService.findAll());
		
	}
	
	@PostMapping
	private ResponseEntity<Users> saveUser(@RequestBody Users user) {
		Users userSaved = usersService.save(user);
		try {
			return ResponseEntity.created(new URI("/users/" + userSaved.getUser_id())).body(userSaved);
		} catch (URISyntaxException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
