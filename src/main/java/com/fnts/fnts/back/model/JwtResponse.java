/**
 * 
 */
package com.fnts.fnts.back.model;

/**
 * @author Emery Estupiñan
 *
 */
public class JwtResponse {
	
	private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public JwtResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
