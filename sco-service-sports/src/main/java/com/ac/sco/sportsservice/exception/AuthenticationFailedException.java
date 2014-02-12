package com.ac.sco.sportsservice.exception;

import com.ac.sco.auth.dtos.AuthDto;

public class AuthenticationFailedException extends Exception {

	private AuthDto authResult;
	
	public void setAuthResult(AuthDto authResult) {
		this.authResult = authResult;
	}
	public AuthDto getAuthResult() {
		return authResult;
	}
	
	public AuthenticationFailedException(String message, AuthDto authResult) {
		super(message);
		setAuthResult(authResult);
	}

}
