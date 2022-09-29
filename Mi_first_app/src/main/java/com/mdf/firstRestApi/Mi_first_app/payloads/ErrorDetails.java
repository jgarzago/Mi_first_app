package com.mdf.firstRestApi.Mi_first_app.payloads;

import java.util.Date;

public class ErrorDetails {
	
	private Date TimeStamp;
	private String message;

	
	public ErrorDetails(Date timeStamp, String message) {
		TimeStamp = timeStamp;
		this.message = message;
	}

	public Date getTimeStamp() {
		return TimeStamp;
	}

	public String getMessage() {
		return message;
	}

	

}
