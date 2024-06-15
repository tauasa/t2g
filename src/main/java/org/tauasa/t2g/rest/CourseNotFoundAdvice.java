package org.tauasa.t2g.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CourseNotFoundAdvice {

	@ExceptionHandler(GolferNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String courseNotFoundHandler(CourseNotFoundException ex) {
		return ex.getMessage();
	}
}
