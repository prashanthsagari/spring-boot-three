package com.example.spring3.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ProblemDetail onRuntimeException(RuntimeException re) {
		ProblemDetail details = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, re.getMessage());
		return details;
	}
}
