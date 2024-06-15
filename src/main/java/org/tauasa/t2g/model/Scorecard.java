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
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
	})
	private HoleScore hole1;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole2;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole3;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole4;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole5;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole6;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole7;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole8;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole9;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole10;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole11;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole12;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole13;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole14;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole15;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole16;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
  	})
	private HoleScore hole17;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "strokes", column = @Column(name = "hole1_strokes")),
		@AttributeOverride(name = "drive", column = @Column(name = "hole1_drive")),
		@AttributeOverride(name = "putts", column = @Column(name = "hole1_putts")),
		@AttributeOverride(name = "penalities", column = @Column(name = "hole1_penalties")),
		@AttributeOverride(name = "mulligans", column = @Column(name = "hole1_mulligans")),
		@AttributeOverride(name = "fairway", column = @Column(name = "hole1_fairway")),
		@AttributeOverride(name = "gir", column = @Column(name = "hole1_gir")),
		@AttributeOverride(name = "sandy", column = @Column(name = "hole1_sandy"))
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
		Tee tee = (Tee) o;
		return Objects.equals(this.id, tee.id) && Objects.equals(this.name, tee.name)
				&& Objects.equals(this.slope, tee.slope) && Objects.equals(this.rating, tee.rating);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.slope, this.rating);
	}

	@Override
	public String toString() {
		return "Scorecard{" + "id=" + this.id + '\'' + ", name='" + this.name + '\''  + ", slope='" + this.slope + '\'' + ", rating='" + this.rating + "}'";
	}

}
