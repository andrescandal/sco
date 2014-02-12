package com.ac.sco.sportsservice.api.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Input dto.
 * @author GTeolis
 */
@XmlRootElement
public class SportsApiInput {

	private AuthApiInput authApiInput = new AuthApiInput();
	
	public void setAuthInput(AuthApiInput authApiInput) {
		this.authApiInput = authApiInput;
	}

	public AuthApiInput getAuthInput() {
		return authApiInput;
	}

}
