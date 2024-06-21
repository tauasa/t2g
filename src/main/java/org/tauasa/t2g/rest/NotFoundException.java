package org.tauasa.t2g.rest;

public class NotFoundException extends RuntimeException {

	public NotFoundException() {
	}
	public NotFoundException(Long id) {
		super("Could not find entity for " + id);
	}

	public NotFoundException(Long teeId, String teeTime, Long golferId) {
		super("Could not find score for "+teeId+"."+teeTime+"."+golferId);
	}
}
