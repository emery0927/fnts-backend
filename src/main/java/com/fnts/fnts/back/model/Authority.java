/**
 * 
 */
package com.fnts.fnts.back.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Emery Estupiñan
 *
 */
public class Authority implements GrantedAuthority {
	
	private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
    
}
