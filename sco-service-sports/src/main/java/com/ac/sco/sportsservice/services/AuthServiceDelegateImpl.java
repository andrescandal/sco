package com.ac.sco.sportsservice.services;

import com.ac.sco.auth.api.AuthServiceApi;
import com.ac.sco.auth.api.impl.AuthServiceApiImpl;
import com.ac.sco.auth.dtos.AuthDto;
import com.ac.sco.sportsservice.api.dtos.AuthApiInput;
import com.ac.sco.sportsservice.exception.AuthenticationFailedException;

public class AuthServiceDelegateImpl implements AuthServiceDelegate {

	private String authServiceEndpointUrl;
	private String serviceId;
	
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceId() {
		return serviceId;
	}
	
	/**
	 * @return the authServiceEndpointUrl
	 */
	public String getAuthServiceEndpointUrl() {
		return authServiceEndpointUrl;
	}

	/**
	 * @param authServiceEndpointUrl the authServiceEndpointUrl to set
	 */
	public void setAuthServiceEndpointUrl(String authServiceEndpointUrl) {
		this.authServiceEndpointUrl = authServiceEndpointUrl;
	}

	public void authenticate(AuthApiInput authInput) throws AuthenticationFailedException {
		AuthServiceApi service = new AuthServiceApiImpl(authServiceEndpointUrl);
		AuthDto authResult = service.authenticate(authInput.getUserKey(), serviceId);
		if (!authResult.getAuthenticated()) {
			throw new AuthenticationFailedException("User not authorized for using the service" , authResult);
		}
	}
}
