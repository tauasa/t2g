package org.tauasa.t2g.model;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class HoleScore{

	private int strokes, drive, putts, penalties, mulligans;
	private boolean fairway, gir, sandy;

	public HoleScore() {}

	public HoleScore(int strokes, int drive, int putts, int penalties, int mulligans,
					boolean fairway, boolean gir, boolean sandy) {
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
		if (!(o instanceof Tee))
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
		return "HoleScore{" + "strokes='" + this.strokes + '\''  + ", drive='" + this.drive + '\'' + ", putts='" + this.putts + "'}";
	}

	public int getStrokes() {
		return strokes;
	}

	public void setStrokes(int strokes) {
		this.strokes = strokes;
	}

	public int getDrive() {
		return drive;
	}

	public void setDrive(int drive) {
		this.drive = drive;
	}

	public int getPutts() {
		return putts;
	}

	public void setPutts(int putts) {
		this.putts = putts;
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}

	public int getMulligans() {
		return mulligans;
	}

	public void setMulligans(int mulligans) {
		this.mulligans = mulligans;
	}

	public boolean isFairway() {
		return fairway;
	}

	public void setFairway(boolean fairway) {
		this.fairway = fairway;
	}

	public boolean isGir() {
		return gir;
	}

	public void setGir(boolean gir) {
		this.gir = gir;
	}

	public boolean isSandy() {
		return sandy;
	}

	public void setSandy(boolean sandy) {
		this.sandy = sandy;
	}
	
}
