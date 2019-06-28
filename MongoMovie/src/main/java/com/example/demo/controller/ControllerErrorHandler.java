package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerErrorHandler {

	@ExceptionHandler(Exception.class)
	//@ResponseBody
public ResponseEntity<ErrorResponse> handleError(Exception e){
		ErrorResponse errorResp =  new ErrorResponse();
		errorResp.setReasonCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResp.setErrmessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errorResp, HttpStatus.INTERNAL_SERVER_ERROR);
}
}

