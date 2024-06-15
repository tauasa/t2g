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
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Tee tee;

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
	private HoleScore hole1;
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
	private HoleScore hole2;
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
	private HoleScore hole3;
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
	private HoleScore hole4;
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
	private HoleScore hole5;
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
	private HoleScore hole6;
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
	private HoleScore hole7;
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
	private HoleScore hole8;
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
	private HoleScore hole9;
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
	private HoleScore hole10;
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
	private HoleScore hole11;
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
	private HoleScore hole12;
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
	private HoleScore hole13;
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
	private HoleScore hole14;
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
	private HoleScore hole15;
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
	private HoleScore hole16;
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
	private HoleScore hole17;
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
	private HoleScore hole18;

	public Scorecard() {}

	public Scorecard(Tee tee) {
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
		if (!(o instanceof Tee))
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

    public HoleScore getHole18() {
        return hole18;
    }

    public void setHole18(HoleScore hole18) {
        this.hole18 = hole18;
    }

    public HoleScore getHole17() {
        return hole17;
    }

    public void setHole17(HoleScore hole17) {
        this.hole17 = hole17;
    }

    public HoleScore getHole16() {
        return hole16;
    }

    public void setHole16(HoleScore hole16) {
        this.hole16 = hole16;
    }

    public HoleScore getHole15() {
        return hole15;
    }

    public void setHole15(HoleScore hole15) {
        this.hole15 = hole15;
    }

    public HoleScore getHole14() {
        return hole14;
    }

    public void setHole14(HoleScore hole14) {
        this.hole14 = hole14;
    }

    public HoleScore getHole13() {
        return hole13;
    }

    public void setHole13(HoleScore hole13) {
        this.hole13 = hole13;
    }

    public HoleScore getHole12() {
        return hole12;
    }

    public void setHole12(HoleScore hole12) {
        this.hole12 = hole12;
    }

    public HoleScore getHole11() {
        return hole11;
    }

    public void setHole11(HoleScore hole11) {
        this.hole11 = hole11;
    }

    public HoleScore getHole10() {
        return hole10;
    }

    public void setHole10(HoleScore hole10) {
        this.hole10 = hole10;
    }

    public HoleScore getHole9() {
        return hole9;
    }

    public void setHole9(HoleScore hole9) {
        this.hole9 = hole9;
    }

    public HoleScore getHole8() {
        return hole8;
    }

    public void setHole8(HoleScore hole8) {
        this.hole8 = hole8;
    }

    public HoleScore getHole7() {
        return hole7;
    }

    public void setHole7(HoleScore hole7) {
        this.hole7 = hole7;
    }

    public HoleScore getHole6() {
        return hole6;
    }

    public void setHole6(HoleScore hole6) {
        this.hole6 = hole6;
    }

    public HoleScore getHole5() {
        return hole5;
    }

    public void setHole5(HoleScore hole5) {
        this.hole5 = hole5;
    }

    public HoleScore getHole4() {
        return hole4;
    }

    public void setHole4(HoleScore hole4) {
        this.hole4 = hole4;
    }

    public HoleScore getHole3() {
        return hole3;
    }

    public void setHole3(HoleScore hole3) {
        this.hole3 = hole3;
    }

    public HoleScore getHole2() {
        return hole2;
    }

    public void setHole2(HoleScore hole2) {
        this.hole2 = hole2;
    }

    public HoleScore getHole1() {
        return hole1;
    }

    public void setHole1(HoleScore hole1) {
        this.hole1 = hole1;
    }

    public Tee getTee() {
        return tee;
    }

    public void setTee(Tee tee) {
        this.tee = tee;
    }

}
