package com.ac.sco.sportsservice.api.dtos;

public class ApiResult {

	public static final String OK = "00";
	public static final String OK_DESCRIPTION = "Service successfull.";
	
	private static final String ERROR_INPUT = "01";
	private static final String ERROR_INPUT_DESCRIPTION = "Input parameters Error.";
	
	public static final String INVALID_AUTH = "03";
	public static final String INVALID_AUTH_DESCRIPTION = "Service Authentication failed.";
	
	private String errorCode;

	private String errorDescription;

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param errorDescription the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public void setServiceOk() {
		setErrorCode(OK);
		setErrorDescription(OK_DESCRIPTION);
	}

	public void setServiceErrorInput(String technicalErrorMessage) {
		setErrorCode(ERROR_INPUT);
		setErrorDescription(ERROR_INPUT_DESCRIPTION + "Technical data: " + technicalErrorMessage);
	}
	
	public void setServiceErrorAuth(String authenticationError) {
		setErrorCode(INVALID_AUTH);
		setErrorDescription(INVALID_AUTH_DESCRIPTION + ": " + authenticationError);
	}
	
}
