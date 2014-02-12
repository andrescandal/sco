package com.ac.sco.sportsservice.api.dtos;

/**
 * Output dto.
 * @author GTeolis
 */
public class SportsApiOutput {

	private ApiResult apiResult = new ApiResult();

	public void setApiResult(ApiResult apiResult) {
		this.apiResult = apiResult;
	}

	public ApiResult getApiResult() {
		return apiResult;
	}
	

}
