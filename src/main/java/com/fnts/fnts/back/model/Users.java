/**
 * 
 */
package com.fnts.fnts.back.model;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Emery Estupiñan
 *
 */
@Entity
@Getter @Setter @NoArgsConstructor
@Table (name = "users")
public class Users implements UserDetails {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String lastname;
	private String email;
	private String password;
	private String name;
	private Integer level;
	private Integer score;
	private String urlPicProfile;
	private boolean enabled = true;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    private Set<UserRol> userRoles = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    private Set<UserCourseActivity> userCourseActivity = new HashSet<>();
	

	/**
	 * @param id
	 * @param username
	 * @param lastname
	 * @param email
	 * @param password
	 * @param nickname
	 * @param level
	 * @param score
	 * @param enabled
	 */
	public Users(Long id, String username, String lastname, String email, String password, String name,
			Integer level, Integer score, boolean enabled, String perfil) {
		super();
		this.id = id;
		this.username = username;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.name = name;
		this.level = level;
		this.score = score;
		this.enabled = enabled;
		this.urlPicProfile = perfil;
	}
	
	@Override
	public String getUsername() {
		return username;
	}


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autoridades = new HashSet<>();
        this.userRoles.forEach(userRol -> {
            autoridades.add(new Authority(userRol.getRol().getRol_type()));
        });
    	return autoridades;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


}
