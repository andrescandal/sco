package com.ceop.pd.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RequestResponse")
public class RequestResponse {

	private String status;
	private String code;
	private String description;

	public RequestResponse() {
	}

	public RequestResponse(String status, String code, String description) {
		this.status = status;
		this.code = code;
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(status).append("#").append(code).append("#").append(description);
				
		return sb.toString();
	}

}
