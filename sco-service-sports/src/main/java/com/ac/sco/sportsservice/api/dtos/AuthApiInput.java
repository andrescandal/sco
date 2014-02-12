package com.ac.sco.sportsservice.api.dtos;

/**
 * Auth Info to validate authentication.
 * @author MIsola
 */
public class AuthApiInput {
	
	/**
	 * Key for the user accessing the system
	 */
	private String userKey;

	/**
	 * @return the userKey
	 */
	public String getUserKey() {
		return userKey;
	}

	/**
	 * @param userKey the userKey to set
	 */
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	
}
