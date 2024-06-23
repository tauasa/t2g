package org.tauasa.t2g.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.tauasa.t2g.util.Utils;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "score", uniqueConstraints = { @UniqueConstraint(columnNames = { "golfer_pk", "tee_pk", "tee_time" }) })
public class Score implements Serializable{

	@Id 
	@GeneratedValue 
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "golfer_pk")
	private Golfer golfer;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tee_pk")
	private Tee tee;

	@Column(name="tee_time")
	private Date teeTime;

	@Embedded
	@AttributeOverrides({
  		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
  		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
  		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole1_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
	})
	@NotNull
	private HoleScore holeScore1;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole2_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole2_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole2_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole2_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole2_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole2_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole2_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole2_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole2_sandy"))
  	})
	@NotNull
	private HoleScore holeScore2;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole3_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole3_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole3_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole3_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole3_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole3_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole3_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole3_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole3_sandy"))
  	})
	@NotNull
	private HoleScore holeScore3;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole4_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole4_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole4_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole4_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole4_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole4_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole4_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole4_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole4_sandy"))
  	})
	@NotNull
	private HoleScore holeScore4;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole5_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole5_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole5_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole5_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole5_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole5_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole5_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole5_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole5_sandy"))
  	})
	@NotNull
	private HoleScore holeScore5;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole6_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole6_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole6_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole6_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole6_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole6_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole6_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole6_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole6_sandy"))
  	})
	@NotNull
	private HoleScore holeScore6;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole7_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole7_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole7_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole7_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole7_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole7_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole7_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole7_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole7_sandy"))
  	})
	@NotNull
	private HoleScore holeScore7;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole8_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole8_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole8_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole8_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole8_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole8_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole8_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole8_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole8_sandy"))
  	})
	@NotNull
	private HoleScore holeScore8;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole9_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole9_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole9_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole9_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole9_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole9_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole9_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole9_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole9_sandy"))
  	})
	@NotNull
	private HoleScore holeScore9;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole10_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole10_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole10_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole10_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole10_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole10_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole10_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole10_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole10_sandy"))
  	})
	@NotNull
	private HoleScore holeScore10;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole11_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole11_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole11_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole11_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole11_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole11_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole11_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole11_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole11_sandy"))
  	})
	@NotNull
	private HoleScore holeScore11;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole12_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole12_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole12_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole12_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole12_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole12_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole12_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole12_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole12_sandy"))
  	})
	@NotNull
	private HoleScore holeScore12;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole13_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole13_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole13_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole13_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole13_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole13_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole13_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole13_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole13_sandy"))
  	})
	@NotNull
	private HoleScore holeScore13;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole14_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole14_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole14_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole14_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole14_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole14_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole14_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole14_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole14_sandy"))
  	})
	@NotNull
	private HoleScore holeScore14;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole15_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole15_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole15_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole15_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole15_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole15_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole15_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole15_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole15_sandy"))
  	})
	@NotNull
	private HoleScore holeScore15;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole16_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole16_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole16_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole16_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole16_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole16_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole16_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole16_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole16_sandy"))
  	})
	@NotNull
	private HoleScore holeScore16;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole17_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole17_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole17_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole17_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole17_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole17_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole17_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole17_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole17_sandy"))
  	})
	@NotNull
	private HoleScore holeScore17;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole18_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole18_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole18_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole18_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole18_mulligans")),
		@AttributeOverride(name = "skins", column = @Column(name = "hole18_skins")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole18_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole18_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole18_sandy"))
  	})
	@NotNull
	private HoleScore holeScore18;

	public Score() {}

	public Score(Golfer golfer, Tee tee, Date teeTime) {
		this.golfer = golfer;
		this.tee = tee;
		this.teeTime = teeTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.golfer, 
		this.holeScore1, holeScore2, holeScore3,
		holeScore4, holeScore5, holeScore6, holeScore7, holeScore8, holeScore9, holeScore10, holeScore11,
		holeScore12, holeScore13, holeScore14, holeScore15, holeScore16, holeScore17, holeScore18);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Score))
			return false;
		Score score = (Score) o;
		return Objects.equals(this.golfer, score.golfer)
			&& Objects.equals(this.holeScore1, score.holeScore1)
			&& Objects.equals(this.holeScore2, score.holeScore2)
			&& Objects.equals(this.holeScore3, score.holeScore3)
			&& Objects.equals(this.holeScore4, score.holeScore4)
			&& Objects.equals(this.holeScore5, score.holeScore5)
			&& Objects.equals(this.holeScore6, score.holeScore6)
			&& Objects.equals(this.holeScore7, score.holeScore7)
			&& Objects.equals(this.holeScore8, score.holeScore8)
			&& Objects.equals(this.holeScore9, score.holeScore9)
			&& Objects.equals(this.holeScore10, score.holeScore10)
			&& Objects.equals(this.holeScore11, score.holeScore11)
			&& Objects.equals(this.holeScore12, score.holeScore12)
			&& Objects.equals(this.holeScore13, score.holeScore13)
			&& Objects.equals(this.holeScore14, score.holeScore14)
			&& Objects.equals(this.holeScore15, score.holeScore15)
			&& Objects.equals(this.holeScore16, score.holeScore16)
			&& Objects.equals(this.holeScore17, score.holeScore17)
			&& Objects.equals(this.holeScore18, score.holeScore18); 
	}

	public int calculateScore(){
		int score = 0;
		score += holeScore1.getStrokes();
		score += holeScore2.getStrokes();
		score += holeScore3.getStrokes();
		score += holeScore4.getStrokes();
		score += holeScore5.getStrokes();
		score += holeScore6.getStrokes();
		score += holeScore7.getStrokes();
		score += holeScore8.getStrokes();
		score += holeScore9.getStrokes();
		score += holeScore10.getStrokes();
		score += holeScore11.getStrokes();
		score += holeScore12.getStrokes();
		score += holeScore13.getStrokes();
		score += holeScore14.getStrokes();
		score += holeScore15.getStrokes();
		score += holeScore16.getStrokes();
		score += holeScore17.getStrokes();
		score += holeScore18.getStrokes();
		return score;
	}

	public int calculatePutts(){
		int putts = 0;
		putts += holeScore1.getPutts();
		putts += holeScore2.getPutts();
		putts += holeScore3.getPutts();
		putts += holeScore4.getPutts();
		putts += holeScore5.getPutts();
		putts += holeScore6.getPutts();
		putts += holeScore7.getPutts();
		putts += holeScore8.getPutts();
		putts += holeScore9.getPutts();
		putts += holeScore10.getPutts();
		putts += holeScore11.getPutts();
		putts += holeScore12.getPutts();
		putts += holeScore13.getPutts();
		putts += holeScore14.getPutts();
		putts += holeScore15.getPutts();
		putts += holeScore16.getPutts();
		putts += holeScore17.getPutts();
		putts += holeScore18.getPutts();
		return putts;
	}

	public int calculatePenalties(){
		int penalties = 0;
		penalties += holeScore1.getPenalties();
		penalties += holeScore2.getPenalties();
		penalties += holeScore3.getPenalties();
		penalties += holeScore4.getPenalties();
		penalties += holeScore5.getPenalties();
		penalties += holeScore6.getPenalties();
		penalties += holeScore7.getPenalties();
		penalties += holeScore8.getPenalties();
		penalties += holeScore9.getPenalties();
		penalties += holeScore10.getPenalties();
		penalties += holeScore11.getPenalties();
		penalties += holeScore12.getPenalties();
		penalties += holeScore13.getPenalties();
		penalties += holeScore14.getPenalties();
		penalties += holeScore15.getPenalties();
		penalties += holeScore16.getPenalties();
		penalties += holeScore17.getPenalties();
		penalties += holeScore18.getPenalties();
		return penalties;
	}

	public int calculateFairways(){
		int fairways = 0;
		fairways += holeScore1.isFairway() ? 1 : 0;
		fairways += holeScore2.isFairway() ? 1 : 0;
		fairways += holeScore3.isFairway() ? 1 : 0;
		fairways += holeScore4.isFairway() ? 1 : 0;
		fairways += holeScore5.isFairway() ? 1 : 0;
		fairways += holeScore6.isFairway() ? 1 : 0;
		fairways += holeScore7.isFairway() ? 1 : 0;
		fairways += holeScore8.isFairway() ? 1 : 0;
		fairways += holeScore9.isFairway() ? 1 : 0;
		fairways += holeScore10.isFairway() ? 1 : 0;
		fairways += holeScore11.isFairway() ? 1 : 0;
		fairways += holeScore12.isFairway() ? 1 : 0;
		fairways += holeScore13.isFairway() ? 1 : 0;
		fairways += holeScore14.isFairway() ? 1 : 0;
		fairways += holeScore15.isFairway() ? 1 : 0;
		fairways += holeScore16.isFairway() ? 1 : 0;
		fairways += holeScore17.isFairway() ? 1 : 0;
		fairways += holeScore18.isFairway() ? 1 : 0;
		return fairways;
	}

	public int calculateGirs(){
		int girs = 0;
		girs += holeScore1.isGir() ? 1 : 0;
		girs += holeScore2.isGir() ? 1 : 0;
		girs += holeScore3.isGir() ? 1 : 0;
		girs += holeScore4.isGir() ? 1 : 0;
		girs += holeScore5.isGir() ? 1 : 0;
		girs += holeScore6.isGir() ? 1 : 0;
		girs += holeScore7.isGir() ? 1 : 0;
		girs += holeScore8.isGir() ? 1 : 0;
		girs += holeScore9.isGir() ? 1 : 0;
		girs += holeScore10.isGir() ? 1 : 0;
		girs += holeScore11.isGir() ? 1 : 0;
		girs += holeScore12.isGir() ? 1 : 0;
		girs += holeScore13.isGir() ? 1 : 0;
		girs += holeScore14.isGir() ? 1 : 0;
		girs += holeScore15.isGir() ? 1 : 0;
		girs += holeScore16.isGir() ? 1 : 0;
		girs += holeScore17.isGir() ? 1 : 0;
		girs += holeScore18.isGir() ? 1 : 0;
		return girs;
	}

	@Override
	public String toString() {
		return String.format("Score{id: %s, tee: %s, teeTime: %s, golfer: %s, score: %d, putts: %d}", 
			this.id, this.tee.getId(), Utils.formatTeeTime(this.getTeeTime()), this.golfer, this.calculateScore(), this.calculatePutts());
	}

}
