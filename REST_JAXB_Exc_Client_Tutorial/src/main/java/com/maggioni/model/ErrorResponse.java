package com.maggioni.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author magang
 */
@XmlRootElement(name = "errorResponse")
public class ErrorResponse {

	private String errorCode;
	private int errorId;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorId() {
		return errorId;
	}

	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

}
