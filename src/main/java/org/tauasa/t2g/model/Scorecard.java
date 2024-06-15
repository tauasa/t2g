package org.tauasa.t2g.model;

import java.util.Objects;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "scorecard")
public class Scorecard {

	@Id 
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Tee tee;

	@ManyToOne(fetch = FetchType.EAGER)
	private Golfer golfer;

	@Embedded
	@AttributeOverrides({
  		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
  		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
  		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
	})
	private HoleScore holeScore1;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole2_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole2_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole2_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole2_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole2_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole2_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole2_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole2_sandy"))
  	})
	private HoleScore holeScore2;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole3_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole3_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole3_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole3_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole3_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole3_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole3_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole3_sandy"))
  	})
	private HoleScore holeScore3;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole4_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole4_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole4_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole4_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole4_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole4_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole4_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole4_sandy"))
  	})
	private HoleScore holeScore4;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole5_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole5_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole5_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole5_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole5_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole5_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole5_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole5_sandy"))
  	})
	private HoleScore holeScore5;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole6_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole6_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole6_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole6_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole6_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole6_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole6_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole6_sandy"))
  	})
	private HoleScore holeScore6;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole7_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole7_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole7_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole7_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole7_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole7_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole7_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole7_sandy"))
  	})
	private HoleScore holeScore7;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole8_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole8_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole8_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole8_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole8_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole8_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole8_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole8_sandy"))
  	})
	private HoleScore holeScore8;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole9_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole9_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole9_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole9_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole9_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole9_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole9_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole9_sandy"))
  	})
	private HoleScore holeScore9;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole10_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole10_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole10_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole10_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole10_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole10_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole10_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole10_sandy"))
  	})
	private HoleScore holeScore10;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole11_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole11_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole11_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole11_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole11_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole11_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole11_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole11_sandy"))
  	})
	private HoleScore holeScore11;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole12_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole12_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole12_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole12_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole12_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole12_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole12_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole12_sandy"))
  	})
	private HoleScore holeScore12;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole13_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole13_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole13_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole13_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole13_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole13_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole13_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole13_sandy"))
  	})
	private HoleScore holeScore13;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole14_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole14_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole14_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole14_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole14_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole14_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole14_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole14_sandy"))
  	})
	private HoleScore holeScore14;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole15_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole15_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole15_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole15_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole15_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole15_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole15_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole15_sandy"))
  	})
	private HoleScore holeScore15;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole16_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole16_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole16_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole16_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole16_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole16_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole16_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole16_sandy"))
  	})
	private HoleScore holeScore16;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole17_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole17_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole17_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole17_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole17_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole17_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole17_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole17_sandy"))
  	})
	private HoleScore holeScore17;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole18_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole18_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole18_putts")),
		@AttributeOverride(name = "penalties", column = @Column(name = "hole18_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole18_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole18_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole18_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole18_sandy"))
  	})
	private HoleScore holeScore18;

	public Scorecard() {}

	public Scorecard(Golfer golfer, Tee tee) {
		this.golfer = golfer;
		this.tee = tee;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Scorecard))
			return false;
		Scorecard scorecard = (Scorecard) o;//TODO
		return Objects.equals(this.id, scorecard.id);// && Objects.equals(this.name, tee.name)
				//&& Objects.equals(this.slope, tee.slope) && Objects.equals(this.rating, tee.rating);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	@Override
	public String toString() {
		return "Scorecard{" + "id=" + this.id + "}";//TODO
	}

    public Tee getTee() {
        return tee;
    }

    public void setTee(Tee tee) {
        this.tee = tee;
    }

    public Golfer getGolfer() {
        return golfer;
    }

    public void setGolfer(Golfer golfer) {
        this.golfer = golfer;
    }

    public HoleScore getHoleScore1() {
        return holeScore1;
    }

    public void setHoleScore1(HoleScore holeScore1) {
        this.holeScore1 = holeScore1;
    }

    public HoleScore getHoleScore2() {
        return holeScore2;
    }

    public void setHoleScore2(HoleScore holeScore2) {
        this.holeScore2 = holeScore2;
    }

    public HoleScore getHoleScore3() {
        return holeScore3;
    }

    public void setHoleScore3(HoleScore holeScore3) {
        this.holeScore3 = holeScore3;
    }

    public HoleScore getHoleScore4() {
        return holeScore4;
    }

    public void setHoleScore4(HoleScore holeScore4) {
        this.holeScore4 = holeScore4;
    }

    public HoleScore getHoleScore5() {
        return holeScore5;
    }

    public void setHoleScore5(HoleScore holeScore5) {
        this.holeScore5 = holeScore5;
    }

    public HoleScore getHoleScore6() {
        return holeScore6;
    }

    public void setHoleScore6(HoleScore holeScore6) {
        this.holeScore6 = holeScore6;
    }

    public HoleScore getHoleScore7() {
        return holeScore7;
    }

    public void setHoleScore7(HoleScore holeScore7) {
        this.holeScore7 = holeScore7;
    }

    public HoleScore getHoleScore8() {
        return holeScore8;
    }

    public void setHoleScore8(HoleScore holeScore8) {
        this.holeScore8 = holeScore8;
    }

    public HoleScore getHoleScore9() {
        return holeScore9;
    }

    public void setHoleScore9(HoleScore holeScore9) {
        this.holeScore9 = holeScore9;
    }

    public HoleScore getHoleScore10() {
        return holeScore10;
    }

    public void setHoleScore10(HoleScore holeScore10) {
        this.holeScore10 = holeScore10;
    }

    public HoleScore getHoleScore11() {
        return holeScore11;
    }

    public void setHoleScore11(HoleScore holeScore11) {
        this.holeScore11 = holeScore11;
    }

    public HoleScore getHoleScore12() {
        return holeScore12;
    }

    public void setHoleScore12(HoleScore holeScore12) {
        this.holeScore12 = holeScore12;
    }

    public HoleScore getHoleScore14() {
        return holeScore14;
    }

    public void setHoleScore14(HoleScore holeScore14) {
        this.holeScore14 = holeScore14;
    }

    public HoleScore getHoleScore15() {
        return holeScore15;
    }

    public void setHoleScore15(HoleScore holeScore15) {
        this.holeScore15 = holeScore15;
    }

    public HoleScore getHoleScore16() {
        return holeScore16;
    }

    public void setHoleScore16(HoleScore holeScore16) {
        this.holeScore16 = holeScore16;
    }

    public HoleScore getHoleScore17() {
        return holeScore17;
    }

    public void setHoleScore17(HoleScore holeScore17) {
        this.holeScore17 = holeScore17;
    }

    public HoleScore getHoleScore18() {
        return holeScore18;
    }

    public void setHoleScore18(HoleScore holeScore18) {
        this.holeScore18 = holeScore18;
    }

    public HoleScore getHoleScore13() {
        return holeScore13;
    }

    public void setHoleScore13(HoleScore holeScore13) {
        this.holeScore13 = holeScore13;
    }

}
