/**
 * 
 */
package com.fnts.fnts.back.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	private String user_name;
	private String user_lastname;
	private String user_email;
	private String user_password;
	private String user_nickname;
	private Integer user_level;
	private Integer user_score;
	
	@ManyToOne
	@JoinColumn (name = "role_id")
	private Roles role_id;

	/**
	 * @param user_name
	 * @param user_lastname
	 * @param user_email
	 * @param user_password
	 * @param user_nickname
	 * @param user_level
	 * @param user_score
	 * @param role_id
	 */
	public Users(String user_name, String user_lastname, String user_email, String user_password, String user_nickname,
			Integer user_level, Integer user_score, Roles role_id) {
		super();
		this.user_name = user_name;
		this.user_lastname = user_lastname;
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_nickname = user_nickname;
		this.user_level = user_level;
		this.user_score = user_score;
		this.role_id = role_id;
	}
	
	
	
	

}
