package com.mdf.firstRestApi.Mi_first_app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mdf.firstRestApi.Mi_first_app.payloads.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CourseApiException.class)
	@ResponseBody
	public ResponseEntity<ErrorDetails> handleCourseApiExceptions(CourseApiException exception,WebRequest wbr){
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage() );
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	

}
