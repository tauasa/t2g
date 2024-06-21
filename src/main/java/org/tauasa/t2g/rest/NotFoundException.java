package org.tauasa.t2g.rest;

import java.util.Date;

public class NotFoundException extends RuntimeException {

	public NotFoundException() {
	}
	public NotFoundException(Long id) {
		super("Could not find entity for " + id);
	}

	public NotFoundException(Long id1, Date id2, Long id3) {
		super("Could not find entity for " + id1+"."+id2+"."+id3);
	}
}
