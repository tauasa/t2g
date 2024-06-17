package org.tauasa.t2g.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tee")
public class Tee{

	@Id 
	@GeneratedValue
	private Long id;
	@JsonSerialize
	@NotBlank
	private String name;//TODO - make this unique for the course
	@JsonSerialize
	@Min(55)
	@Max(155)
	private int slope = 113;//TODO - validate range 55-155
	@JsonSerialize
	@Min(60)
	@Max(80)
	private float rating = 70F;//TODO - what is the range?
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;

	@Embedded
	@AttributeOverrides({
  		@AttributeOverride(name = "par", column = @Column(name = "hole1_par")),
  		@AttributeOverride(name = "distance", column = @Column(name = "hole1_distance")),
  		@AttributeOverride(name = "hdcp", column = @Column(name = "hole1_hdcp"))
	})
	@NotNull
	private Hole hole1;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole2_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole2_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole2_hdcp"))
  	})
	@NotNull
	private Hole hole2;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole3_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole3_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole3_hdcp"))
  	})
	@NotNull
	private Hole hole3;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole4_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole4_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole4_hdcp"))
  	})
	@NotNull
	private Hole hole4;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole5_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole5_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole5_hdcp"))
  	})
	@NotNull
	private Hole hole5;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole6_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole6_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole6_hdcp"))
  	})
	@NotNull
	private Hole hole6;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole7_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole7_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole7_hdcp"))
  	})
	@NotNull
	private Hole hole7;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole8_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole8_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole8_hdcp"))
  	})
	@NotNull
	private Hole hole8;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole9_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole9_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole9_hdcp"))
  	})
	@NotNull
	private Hole hole9;

	@Embedded
	@AttributeOverrides({
  		@AttributeOverride(name = "par", column = @Column(name = "hole10_par")),
  		@AttributeOverride(name = "distance", column = @Column(name = "hole10_distance")),
  		@AttributeOverride(name = "hdcp", column = @Column(name = "hole10_hdcp"))
	})
	@NotNull
	private Hole hole10;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole11_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole11_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole11_hdcp"))
  	})
	@NotNull
	private Hole hole11;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole12_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole12_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole12_hdcp"))
  	})
	@NotNull
	private Hole hole12;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole13_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole13_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole13_hdcp"))
  	})
	@NotNull
	private Hole hole13;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole14_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole14_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole14_hdcp"))
  	})
	@NotNull
	private Hole hole14;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole15_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole15_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole15_hdcp"))
  	})
	@NotNull
	private Hole hole15;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole16_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole16_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole16_hdcp"))
  	})
	@NotNull
	private Hole hole16;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole17_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole17_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole17_hdcp"))
  	})
	@NotNull
	private Hole hole17;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole18_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole18_distance")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole18_hdcp"))
  	})
	@NotNull
	private Hole hole18;

	public Tee() {}

	public Tee(String name, int slope, float rating) {
		this.name = name;
		this.slope = slope;
		this.rating = rating;
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
		return "Tee{" + "id=" + this.id + '\'' + ", name='" + this.name + '\''  + ", slope='" + this.slope + '\'' + ", rating='" + this.rating + "}'";
	}

    public Hole getHole1() {
        return hole1;
    }

    public void setHole1(Hole hole1) {
        this.hole1 = hole1;
    }

    public Hole getHole2() {
        return hole2;
    }

    public void setHole2(Hole hole2) {
        this.hole2 = hole2;
    }

    public Hole getHole3() {
        return hole3;
    }

    public void setHole3(Hole hole3) {
        this.hole3 = hole3;
    }

    public Hole getHole4() {
        return hole4;
    }

    public void setHole4(Hole hole4) {
        this.hole4 = hole4;
    }

    public Hole getHole5() {
        return hole5;
    }

    public void setHole5(Hole hole5) {
        this.hole5 = hole5;
    }

    public Hole getHole6() {
        return hole6;
    }

    public void setHole6(Hole hole6) {
        this.hole6 = hole6;
    }

    public Hole getHole7() {
        return hole7;
    }

    public void setHole7(Hole hole7) {
        this.hole7 = hole7;
    }

    public Hole getHole8() {
        return hole8;
    }

    public void setHole8(Hole hole8) {
        this.hole8 = hole8;
    }

    public Hole getHole9() {
        return hole9;
    }

    public void setHole9(Hole hole9) {
        this.hole9 = hole9;
    }

    public Hole getHole10() {
        return hole10;
    }

    public void setHole10(Hole hole10) {
        this.hole10 = hole10;
    }

    public Hole getHole11() {
        return hole11;
    }

    public void setHole11(Hole hole11) {
        this.hole11 = hole11;
    }

    public Hole getHole12() {
        return hole12;
    }

    public void setHole12(Hole hole12) {
        this.hole12 = hole12;
    }

    public Hole getHole13() {
        return hole13;
    }

    public void setHole13(Hole hole13) {
        this.hole13 = hole13;
    }

    public Hole getHole14() {
        return hole14;
    }

    public void setHole14(Hole hole14) {
        this.hole14 = hole14;
    }

    public Hole getHole15() {
        return hole15;
    }

    public void setHole15(Hole hole15) {
        this.hole15 = hole15;
    }

    public Hole getHole16() {
        return hole16;
    }

    public void setHole16(Hole hole16) {
        this.hole16 = hole16;
    }

    public Hole getHole17() {
        return hole17;
    }

    public void setHole17(Hole hole17) {
        this.hole17 = hole17;
    }

    public Hole getHole18() {
        return hole18;
    }

    public void setHole18(Hole hole18) {
        this.hole18 = hole18;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

}
