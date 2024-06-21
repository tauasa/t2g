package org.tauasa.t2g.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ScorecardId implements Serializable{

	@NotNull
	private Long teeId;
	@NotNull
	private Date teeTime;
	@NotNull
	private Long golferId;

	public ScorecardId(){}

	public ScorecardId(Long teeId, Date teeTime, Long golferId){
		this.teeId=teeId;
		this.teeTime=teeTime;
		this.golferId=golferId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ScorecardId))
			return false;
		ScorecardId id = (ScorecardId) o;
		return Objects.equals(this.teeId, id.teeId) && 
			Objects.equals(this.teeTime, id.teeTime) && 
			Objects.equals(this.golferId, id.golferId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.teeId, this.teeTime, this.golferId);
	}

	@Override
	public String toString() {
		return String.format("ScorecardId{teeId: %d, teeTime: %s, golferId: %d}", this.teeId, this.teeTime, this.golferId);
	}
	
}
