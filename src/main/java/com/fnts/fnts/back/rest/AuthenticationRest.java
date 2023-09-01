/**
 * 
 */
package com.fnts.fnts.back.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.fnts.fnts.back.configuration.JwtUtils;
import com.fnts.fnts.back.model.JwtRequest;
import com.fnts.fnts.back.model.JwtResponse;
import com.fnts.fnts.back.model.Users;
import com.fnts.fnts.back.service.UsersDetailService;

import java.security.Principal;

/**
 * @author Emery Estupiñan
 *
 */
@RestController
@CrossOrigin("*")
public class AuthenticationRest {

	 	@Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UsersDetailService userDetailsService;

	    @Autowired
	    private JwtUtils jwtUtils;

	    @PostMapping("/generate-token")
	    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
	        try{
	            autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());
	        }catch (Exception exception){
	            exception.printStackTrace();
	            throw new Exception("Usuario no encontrado");
	        }

	        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
	        String token = this.jwtUtils.generateToken(userDetails);
	        return ResponseEntity.ok(new JwtResponse(token));
	    }

	    private void autenticar(String username,String password) throws Exception {
	        try{
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
	        }catch (DisabledException exception){
	            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
	        }catch (BadCredentialsException e){
	            throw  new Exception("Credenciales invalidas " + e.getMessage());
	        }
	    }

	    @GetMapping("/actual-usuario")
	    public Users obtenerUsuarioActual(Principal principal){
	        return (Users) this.userDetailsService.loadUserByUsername(principal.getName());
	    }
}
