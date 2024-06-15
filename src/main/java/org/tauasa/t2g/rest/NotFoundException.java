package org.tauasa.t2g.rest;

public class NotFoundException extends RuntimeException {

	public NotFoundException(Long id) {
		super("Could not find entity for " + id);
	}
}
