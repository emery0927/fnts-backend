/**
 * 
 */
package com.fnts.fnts.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fnts.fnts.back.model.Users;
import com.fnts.fnts.back.repository.UsersRepository;

/**
 * @author Emery Estupiñan
 *
 */
@Service
public class UsersDetailService implements UserDetailsService {
	
	@Autowired
    private UsersRepository usersRepository;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users usuario = this.usersRepository.findByUsername(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }

}
