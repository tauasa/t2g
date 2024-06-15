package org.tauasa.t2g.rest;

public class GolferNotFoundException extends RuntimeException {

	public GolferNotFoundException(Long id) {
		super("Could not find golfer " + id);
	}
}
