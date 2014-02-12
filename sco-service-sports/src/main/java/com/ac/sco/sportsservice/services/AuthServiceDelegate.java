package com.ac.sco.sportsservice.services;

import com.ac.sco.sportsservice.api.dtos.AuthApiInput;
import com.ac.sco.sportsservice.exception.AuthenticationFailedException;

/**
 * Delegate for accessing the Authentication service. 
 *
 */
public interface AuthServiceDelegate {

	void authenticate(AuthApiInput authInput) throws AuthenticationFailedException;
}
