package org.tauasa.t2g.rest;

public class CourseNotFoundException extends RuntimeException {

	public CourseNotFoundException(Long id) {
		super("Could not find course " + id);
	}
}
