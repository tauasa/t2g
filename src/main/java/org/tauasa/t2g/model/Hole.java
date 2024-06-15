package org.tauasa.t2g.model;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Hole {

	private int par, distance, hdcp;

	public Hole() {}

	public Hole(int par, int distance, int hdcp) {
		this.par = par;
		this.distance = distance;
		this.hdcp = hdcp;
	}

	public int getPar() {
		return par;
	}

	public void setPar(int par) {
		this.par = par;
	}

	public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getHdcp() {
        return hdcp;
    }

    public void setHdcp(int hdcp) {
        this.hdcp = hdcp;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Tee))
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
		return "Hole{" + "par='" + this.par + '\''  + ", distance='" + this.distance + '\'' + ", hdcp='" + this.hdcp + "}'";
	}
	
}
