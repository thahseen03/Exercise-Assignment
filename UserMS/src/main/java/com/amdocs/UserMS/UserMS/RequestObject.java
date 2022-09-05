/**
 * 
 */
package com.amdocs.UserMS.UserMS;

import java.io.Serializable;

/**
 * @author ikramshariff
 *
 */
public class RequestObject implements Serializable {
	
	String username;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
