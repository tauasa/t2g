package org.tauasa.t2g.model;

import java.io.Serializable;
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
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tee")
public class Tee implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonSerialize
	@NotBlank
	private String name;

	@JsonSerialize
	@Min(55)
	@Max(155)
	private int slope;

	@JsonSerialize
	@Min(60)
	@Max(80)
	private float rating;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_pk")
	private Course course;

	@Embedded
	@AttributeOverrides({
  		@AttributeOverride(name = "par", column = @Column(name = "hole1_par")),
  		@AttributeOverride(name = "distance", column = @Column(name = "hole1_dist")),
  		@AttributeOverride(name = "hdcp", column = @Column(name = "hole1_hdcp"))
	})
	@NotNull
	private Hole hole1;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole2_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole2_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole2_hdcp"))
  	})
	@NotNull
	private Hole hole2;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole3_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole3_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole3_hdcp"))
  	})
	@NotNull
	private Hole hole3;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole4_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole4_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole4_hdcp"))
  	})
	@NotNull
	private Hole hole4;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole5_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole5_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole5_hdcp"))
  	})
	@NotNull
	private Hole hole5;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole6_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole6_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole6_hdcp"))
  	})
	@NotNull
	private Hole hole6;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole7_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole7_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole7_hdcp"))
  	})
	@NotNull
	private Hole hole7;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole8_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole8_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole8_hdcp"))
  	})
	@NotNull
	private Hole hole8;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole9_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole9_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole9_hdcp"))
  	})
	@NotNull
	private Hole hole9;

	@Embedded
	@AttributeOverrides({
  		@AttributeOverride(name = "par", column = @Column(name = "hole10_par")),
  		@AttributeOverride(name = "distance", column = @Column(name = "hole10_dist")),
  		@AttributeOverride(name = "hdcp", column = @Column(name = "hole10_hdcp"))
	})
	@NotNull
	private Hole hole10;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole11_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole11_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole11_hdcp"))
  	})
	@NotNull
	private Hole hole11;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole12_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole12_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole12_hdcp"))
  	})
	@NotNull
	private Hole hole12;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole13_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole13_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole13_hdcp"))
  	})
	@NotNull
	private Hole hole13;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole14_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole14_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole14_hdcp"))
  	})
	@NotNull
	private Hole hole14;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole15_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole15_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole15_hdcp"))
  	})
	@NotNull
	private Hole hole15;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole16_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole16_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole16_hdcp"))
  	})
	@NotNull
	private Hole hole16;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole17_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole17_dist")),
		@AttributeOverride(name = "hdcp", column = @Column(name = "hole17_hdcp"))
  	})
	@NotNull
	private Hole hole17;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "par", column = @Column(name = "hole18_par")),
		@AttributeOverride(name = "distance", column = @Column(name = "hole18_dist")),
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
		return String.format("Tee{id: %d, name: %s, slope: %d, rating: %f}", this.id, this.name, this.slope, this.rating);
	}

}
