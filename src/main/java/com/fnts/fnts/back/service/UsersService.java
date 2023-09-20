/**
 * 
 */
package com.fnts.fnts.back.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnts.fnts.back.model.UserCourseActivity;
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
    public Users saveUser(Users user, Set<UserRol> usuarioRoles, Set<UserCourseActivity> userCourseActivity) throws Exception {
		Users localUser = usersRepository.findByUsername(user.getUsername());
        if(localUser != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            for(UserRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            user.getUserCourseActivity().addAll(userCourseActivity);
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

	@Override
	public Users obtenerUsuarioPorEmail(String email) {
		return usersRepository.findByEmail(email);
	}
	
	public void sumarPuntos(Users user) {
		user.setScore(user.getScore()+10);
		
		usersRepository.save(user);
		
	}
	
	public void aumentarLevel(Users user) {
		user.setLevel(user.getLevel()+1);
		
		usersRepository.save(user);
		
	}
	

}
