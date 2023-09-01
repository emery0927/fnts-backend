/**
 * 
 */
package com.fnts.fnts.back.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.fnts.fnts.back.model.UserRol;
import com.fnts.fnts.back.model.Users;
import com.fnts.fnts.back.repository.RolesRepository;
import com.fnts.fnts.back.repository.UsersRepository;

/**
 * @author Emery Estupiñan
 *
 */
@Service
public class UsersService implements IUserService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private RolesRepository rolRepository;
	
	
	@Override
    public Users saveUser(Users user, Set<UserRol> usuarioRoles) throws Exception {
		Users localUser = usersRepository.findByUsername(user.getUsername());
        if(localUser != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            for(UserRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            user.getUserRoles().addAll(usuarioRoles);
            localUser = usersRepository.save(user);
        }
        return localUser;
    }
	
	@Override
    public Users obtenerUsuario(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usersRepository.deleteById(id);
    }
	

}
