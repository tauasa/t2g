package org.tauasa.t2g.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
/**
 * Hole attributes par, distance and handicap. 
*/
public class Hole implements Serializable{

	private int par, distance, hdcp;

	public Hole() {}

	public Hole(int par, int distance, int hdcp) {
		this.par = par;
		this.distance = distance;
		this.hdcp = hdcp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Hole))
			return false;
		Hole hole = (Hole) o;
		return Objects.equals(this.par, hole.par) && Objects.equals(this.distance, hole.distance) && Objects.equals(this.hdcp, hole.hdcp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.par, this.distance, this.hdcp);
	}

	@Override
	public String toString() {
		return String.format("Hole{par: %d, dist: %d, hdcp: %d}", this.par, this.distance, this.hdcp);
	}
	
}
