package org.tauasa.t2g.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Location implements Serializable{

    private String city, state;

    public Location(){

    }

    public Location(String city, String state){
        this.city=city;
        this.state=state;
    }

    @Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Location))
			return false;
        Location loc = (Location) o;
		return Objects.equals(this.city, loc.city) && Objects.equals(this.state, loc.state);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.city, this.state);
	}

	@Override
	public String toString() {
		return String.format("Location{city: %s, state: %s}", this.city, this.state);
	}

}
