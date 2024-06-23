package org.tauasa.t2g.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Embeddable
public class HoleScore implements Serializable{

	private int strokes, drive, putts, penalties, mulligans;
	private boolean fairway, gir, sandy;

	public HoleScore() {}

	public HoleScore(int strokes, int drive, int putts, int penalties, int mulligans, boolean fairway, boolean gir, boolean sandy) {
		this.strokes=strokes;
		this.drive=drive;
		this.putts=putts;
		this.penalties=penalties;
		this.mulligans=mulligans;
		this.fairway=fairway;
		this.gir=gir;
		this.sandy=sandy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof HoleScore))
			return false;
		HoleScore score = (HoleScore) o;
		return Objects.equals(this.strokes, score.strokes) && 
			Objects.equals(this.drive, score.drive) && 
			Objects.equals(this.putts, score.putts) &&
			Objects.equals(this.penalties, score.penalties) &&
			Objects.equals(this.mulligans, score.mulligans) &&
			Objects.equals(this.fairway, score.fairway) &&
			Objects.equals(this.gir, score.gir) &&
			Objects.equals(this.sandy, score.sandy);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.strokes, this.drive, this.putts,
							this.penalties, this.mulligans, this.fairway,
							this.gir, this.sandy);
	}

	@Override
	public String toString() {
		return String.format("HoleScore{strokes: %d, putts: %d}", this.strokes, this.putts);
	}

	
}
