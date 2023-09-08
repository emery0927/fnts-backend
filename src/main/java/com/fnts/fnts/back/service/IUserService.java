/**
 * 
 */
package com.fnts.fnts.back.service;

import java.util.Set;

import com.fnts.fnts.back.model.UserCourseActivity;
import com.fnts.fnts.back.model.UserRol;
import com.fnts.fnts.back.model.Users;

/**
 * @author Emery Estupiñan
 *
 */
public interface IUserService {

	public Users saveUser(Users usuario, Set<UserRol> user, Set<UserCourseActivity> userCourseActivity) throws Exception;

    public Users obtenerUsuario(String username);

    public void eliminarUsuario(Long id);
    
    public Users obtenerUsuarioPorEmail(String email);
}
