package com.mdf.firstRestApi.Mi_first_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CourseApiException extends RuntimeException{
	
	private HttpStatus status;
	private String message;
	
	public CourseApiException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
	
	

}
